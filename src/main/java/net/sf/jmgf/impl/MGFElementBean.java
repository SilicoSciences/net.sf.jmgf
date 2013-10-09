package net.sf.jmgf.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.bioutils.proteomics.peak.Peak;
import net.sf.jmgf.MGFElement;
import net.sf.kerner.utils.collections.impl.UtilCollection;
import net.sf.kerner.utils.impl.util.Util;

public class MGFElementBean implements MGFElement {

    private static final long serialVersionUID = 2630160345276985979L;

    private String charge;

    private List<Peak> peaks;

    private double pepMass;

    private int retentionTimeInSeconds;

    private String title;

    public MGFElementBean() {
    }

    public MGFElementBean(final String title, final String charge, final double pepMass, final int retTimeSecs,
            final List<? extends Peak> peaks) {
        this.title = title;
        this.charge = charge;
        this.peaks = new ArrayList<Peak>(peaks);
        this.retentionTimeInSeconds = retTimeSecs;
        this.pepMass = pepMass;
    }

    @Override
    public boolean equals(final Object obj) {
        return Util.equalsOnHashCode(this, obj);
    }

    public String getCharge() {
        return charge;
    }

    public List<Peak> getPeaks() {
        return peaks;
    }

    public double getPepMass() {
        return pepMass;
    }

    public int getRetentionTimeInSeconds() {
        return retentionTimeInSeconds;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((charge == null) ? 0 : charge.hashCode());
        result = prime * result + ((peaks == null) ? 0 : peaks.hashCode());
        long temp;
        temp = Double.doubleToLongBits(pepMass);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + retentionTimeInSeconds;
        return result;
    }

    public void setCharge(final String charge) {
        this.charge = charge;
    }

    public void setPeaks(final List<Peak> peaks) {
        this.peaks = peaks;
    }

    public void setPepMass(final double pepMass) {
        this.pepMass = pepMass;
    }

    public void setRetentionTimeInSeconds(final int retentionTimeInSeconds) {
        this.retentionTimeInSeconds = retentionTimeInSeconds;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return getTitle() + UtilCollection.toString(getPeaks());
    }

}
