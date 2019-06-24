package modelPkg;

import java.time.LocalTime;

/**
 * Model for a LocalTime value with
 * methods for increasing and
 * resetting time and show lap time.
 * */

public interface TimeValueModel extends Model {
    LocalTime getTime();
    void setTime(LocalTime lt);
    void increaseTime();
    void resetTime();
    void showLapTime(boolean showLap);
}
