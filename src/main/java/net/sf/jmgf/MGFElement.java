package net.sf.jmgf;

import java.util.List;

import net.sf.bioutils.proteomics.Peak;

/**
 * 
 * TODO description
 * 
 * <p>
 * <b>Example:</b><br>
 * 
 * </p>
 * <p>
 * 
 * <pre>
 * TODO example
 * </pre>
 * 
 * </p>
 * <p>
 * last reviewed: 2013-08-12
 * </p>
 * 
 * @author <a href="mailto:alexanderkerner24@gmail.com">Alexander Kerner</a>
 * @version 2013-08-12
 * 
 */
public interface MGFElement {

    String getCharge();

    List<Peak> getPeaks();

    double getPepMass();

    int getRetentionTimeInSeconds();

    String getTitle();

}
