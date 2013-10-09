package net.sf.jmgf.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import net.sf.bioutils.proteomics.impl.FactoryPeakImpl;
import net.sf.bioutils.proteomics.peak.FactoryPeak;
import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.jmgf.MGFElement;
import net.sf.jmgf.exception.ExceptionFileFormat;
import net.sf.kerner.utils.io.buffered.AbstractIOIterator;

public class MGFElementIterator extends AbstractIOIterator<MGFElement> {

    public final static String FIFTH_LINE_START = "RTINSECONDS=";
    public final static String FIRST_LINE = "BEGIN IONS";
    public final static String FOURTH_LINE_START = "PEPMASS=";
    public final static String LAST_LINE = "END IONS";
    public final static String SECOND_LINE_START = "TITLE=";
    public final static String THIRD_LINE_START = "CHARGE=";

    private FactoryPeak factoryPeak;

    public MGFElementIterator(final BufferedReader reader) throws IOException {
        super(reader);

    }

    public MGFElementIterator(final File file) throws IOException {
        super(file);

    }

    public MGFElementIterator(final InputStream stream) throws IOException {
        super(stream);

    }

    public MGFElementIterator(final Reader reader) throws IOException {
        super(reader);

    }

    @Override
    protected MGFElement doRead() throws IOException {
        final String firstLine = reader.readLine();
        if (firstLine == null) {
            // nothing left to read
            return null;
        }
        if (firstLine.equals(FIRST_LINE)) {
            final String secondLine = reader.readLine();
            if (secondLine.startsWith(SECOND_LINE_START)) {
                final String thirdLine = reader.readLine();
                if (thirdLine.startsWith(THIRD_LINE_START)) {
                    final String fourthLine = reader.readLine();
                    if (fourthLine.startsWith(FOURTH_LINE_START)) {
                        final String fivthLine = reader.readLine();
                        if (fivthLine.startsWith(FIFTH_LINE_START)) {
                            final List<Peak> peaks = readPeaks();
                            return getNewElement(secondLine.split("=")[1], thirdLine.split("=")[1],
                                    Double.parseDouble(fourthLine.split("=")[1]),
                                    Integer.parseInt(fivthLine.split("=")[1]), peaks);
                        }
                    }
                }
            }
        }
        throw new ExceptionFileFormat("unexpected line");
    }

    public FactoryPeak getFactoryPeak() {
        return factoryPeak;
    }

    protected MGFElement getNewElement(final String title, final String charge, final double pepMass,
            final int retTimeSecs, final List<? extends Peak> peaks) {
        return new MGFElementBean(title, charge, pepMass, retTimeSecs, peaks);
    }

    private List<Peak> readPeaks() throws IOException {
        if (getFactoryPeak() == null) {
            setFactoryPeak(new FactoryPeakImpl());
        }
        final List<Peak> peaks = new ArrayList<Peak>();
        String nextLine = null;
        do {
            nextLine = reader.readLine();
            if (nextLine == null) {
                throw new ExceptionFileFormat("unexpected end of file");
            }
            if (nextLine.equals(LAST_LINE)) {
                return peaks;
            }
            final String[] arr = nextLine.split("\\s");
            if (arr.length != 3) {
                throw new ExceptionFileFormat("invalid peak line " + nextLine);
            }
            peaks.add(getFactoryPeak().create(null, Double.parseDouble(arr[0]), Double.parseDouble(arr[1]), -1));
        } while (!nextLine.equals(LAST_LINE));
        throw new RuntimeException();
    }

    public void setFactoryPeak(final FactoryPeak factoryPeak) {
        this.factoryPeak = factoryPeak;
    }
}
