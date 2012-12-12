package net.sf.jmgf;

import java.io.Serializable;
import java.util.List;

import net.sf.bioutils.proteomics.Peak;

public interface MGFElement extends Serializable {

    String getCharge();

    List<Peak> getPeaks();

    double getPepMass();

    int getRetentionTimeInSeconds();

    String getTitle();

}
