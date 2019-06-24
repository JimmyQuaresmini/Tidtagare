package modelPkg;

import java.beans.PropertyChangeListener;
import java.io.Serializable;

/**
 * Följt Java-boken, s. 462
 * */

public interface Model extends Serializable {
    void addPropertyChangeListener(PropertyChangeListener l);
    void addPropertyChangeListener(String propertyName, PropertyChangeListener l);
    void removePropertyChangeListener(PropertyChangeListener l);
    void removePropertyChangeListener(String propertyName, PropertyChangeListener l);
}
