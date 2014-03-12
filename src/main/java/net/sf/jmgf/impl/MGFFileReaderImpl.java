/**********************************************************************
Copyright (c) 2012-2014 Alexander Kerner. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 ***********************************************************************/

package net.sf.jmgf.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import net.sf.bioutils.proteomics.FactoryPeakImpl;
import net.sf.bioutils.proteomics.peak.FactoryPeak;
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
