package viewPkg;

import modelPkg.TimeValueModel;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Base class of a view that allows
 * inherited classes to listen to updates
 * of values. Could come from the view itself,
 * but here it's from the model(called from
 * the controller).
 * */

public abstract class BaseTimeView extends JPanel implements PropertyChangeListener {
    protected TimeValueModel model;

    public void setModel(TimeValueModel m) {
        if (model != null)
            model.removePropertyChangeListener(this);
        model = m;
        if (model != null)
            model.addPropertyChangeListener(this);

    }

    public void propertyChange(PropertyChangeEvent e) {
        repaint();
    }
}
