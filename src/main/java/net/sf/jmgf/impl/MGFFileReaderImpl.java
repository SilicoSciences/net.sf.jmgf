package net.sf.jmgf.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import net.sf.bioutils.proteomics.factory.FactoryPeak;
import net.sf.bioutils.proteomics.impl.FactoryPeakImpl;
import net.sf.jmgf.MGFElement;
import net.sf.jmgf.MGFFile;
import net.sf.jmgf.MGFFileReader;
import net.sf.kerner.utils.io.buffered.AbstractBufferedReader;

public class MGFFileReaderImpl extends AbstractBufferedReader implements MGFFileReader {

    private FactoryPeak factoryPeak;

    public MGFFileReaderImpl(final BufferedReader reader) {
        super(reader);

    }

    public MGFFileReaderImpl(final File file) throws FileNotFoundException {
        super(file);

    }

    public MGFFileReaderImpl(final InputStream stream) {
        super(stream);

    }

    public MGFFileReaderImpl(final Reader reader) {
        super(reader);

    }

    protected MGFFile buildNewMGFFile(final List<? extends MGFElement> elements) {
        return new MGFFileBean(elements);
    }

    public FactoryPeak getFactoryPeak() {
        return factoryPeak;
    }

    public MGFElementIterator getIterator() throws IOException {
        return new MGFElementIterator(super.reader);
    }

    public MGFFile read() throws IOException {
        final List<MGFElement> result = new ArrayList<MGFElement>();
        final MGFElementIterator it = getIterator();
        if (getFactoryPeak() == null) {
            it.setFactoryPeak(new FactoryPeakImpl());
        }
        while (it.hasNext()) {
            result.add(it.next());
        }
        it.close();
        return buildNewMGFFile(result);
    }

    public void setFactoryPeak(final FactoryPeak factoryPeak) {
        this.factoryPeak = factoryPeak;

    }
}
