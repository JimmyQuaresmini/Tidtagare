package mainPkg;

import controllerPkg.TimeController;
import modelPkg.TimeModel;
import modelPkg.TimeValueModel;
import viewPkg.TimeView;
import viewPkg.BaseTimeView;

import javax.swing.*;
import java.awt.*;

public class TimeMain extends JFrame {
    public TimeMain() {
        setTitle("Timekeeper");
        TimeValueModel m = new TimeModel();
        BaseTimeView v = new TimeView(m);
        TimeController c = new TimeController(m);
        setLayout(new FlowLayout());
        add(c);
        add(v);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] arg) {
        TimeMain tid = new TimeMain();
    }
}
