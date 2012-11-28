package net.sf.jmgf.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import net.sf.jmgf.MGFElement;
import net.sf.jmgf.MGFFile;
import net.sf.jmgf.MGFFileReader;
import net.sf.jmgf.exception.ExceptionMGFIO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMGFFileReaderImpl {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test01() throws Exception {
        final MGFFileReader reader = new MGFFileReaderImpl(new File("src/test/resources/singleElement.mgf"));
        final MGFFile file = reader.read();
        reader.close();
        assertNotNull(file);
        assertEquals(1, file.getElements().size());
        final MGFElement element = file.getElements().iterator().next();
        assertEquals("1+", element.getCharge());
    }

    @Test
    public void test02() throws Exception {
        final MGFFileReader reader = new MGFFileReaderImpl(new File("src/test/resources/manyElements.mgf"));
        final MGFFile file = reader.read();
        reader.close();
        assertNotNull(file);
        assertEquals(7532, file.getElements().size());
    }

    @Test(expected = ExceptionMGFIO.class)
    public void test03() throws Exception {
        final MGFFileReader reader = new MGFFileReaderImpl(new File("src/test/resources/manyElementsUnexpectedEnd.mgf"));
        reader.read();

    }

    @Test(expected = ExceptionMGFIO.class)
    public void test04() throws Exception {
        final MGFFileReader reader = new MGFFileReaderImpl(new File(
                "src/test/resources/manyElementsInvalidPeakLine.mgf"));
        reader.read();

    }

    @Test(expected = ExceptionMGFIO.class)
    public void test05() throws Exception {
        final MGFFileReader reader = new MGFFileReaderImpl(new File(
                "src/test/resources/manyElementsInvalidMissingChargeLine.mgf"));
        reader.read();

    }

}
