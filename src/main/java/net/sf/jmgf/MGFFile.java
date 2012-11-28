package net.sf.jmgf;

import java.io.Serializable;
import java.util.List;

public interface MGFFile extends Iterable<MGFElement>, Serializable {

    List<MGFElement> getElements();

}
