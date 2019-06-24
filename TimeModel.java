package modelPkg;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalTime;

/**
 * Implementation of TimeValueModel.
 * Model of time with implemented methods
 * for setting, getting, increasing
 * and resetting time. Also shows lap times.
 * */

public class TimeModel implements TimeValueModel {
    LocalTime theTime;
    boolean showLapT = false; //shows only lap times, but lets the timer continue

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener l) {
        pcs.addPropertyChangeListener(propertyName, l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        pcs.removePropertyChangeListener(l);
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener l) {
        pcs.removePropertyChangeListener(propertyName, l);
    }

    public TimeModel() {
        theTime = LocalTime.MIDNIGHT;
    }

    public LocalTime getTime() {
        return theTime;
    }

    public void setTime(LocalTime theTime) {
        LocalTime oldTime = getTime();
        this.theTime = theTime;
        LocalTime newTime = this.theTime;
        if (showLapT == false)
            pcs.firePropertyChange("theTime", oldTime, newTime);
    }

    public void increaseTime() {
        LocalTime newTime = theTime.plusNanos(10000000); //1 ms = 1,000,000 ns //this is 10 ms
        setTime(newTime);
    }

    public void resetTime() {
        setTime(LocalTime.MIDNIGHT);
    }

    public void showLapTime(boolean showLap) {
        increaseTime();
        showLapT = showLap;
    }
}
