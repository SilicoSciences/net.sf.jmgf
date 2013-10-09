package net.sf.jmgf;

import java.io.IOException;

import net.sf.bioutils.proteomics.peak.FactoryPeak;
import net.sf.jmgf.impl.MGFElementIterator;
import net.sf.kerner.utils.io.buffered.IOIterable;

public interface MGFFileReader extends IOIterable<MGFElement> {

    FactoryPeak getFactoryPeak();

    MGFElementIterator getIterator() throws IOException;

    MGFFile read() throws IOException;

    void setFactoryPeak(FactoryPeak factoryPeak);

}
