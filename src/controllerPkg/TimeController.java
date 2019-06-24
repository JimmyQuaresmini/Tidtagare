package controllerPkg;

import modelPkg.TimeValueModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TimeController extends JPanel implements ActionListener {
    private TimeValueModel model;
    private JButton btnStart = new JButton("Start");
    private JButton btnStop = new JButton("Stop");
    private Timer timer;
    private JPanel startStop = new JPanel();
    private JButton btnReset = new JButton("Reset");
    private JButton btnLap = new JButton("Lap");
    private JPanel resetLap = new JPanel();

    public TimeController() {
        setPreferredSize(new Dimension(170, 70));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        startStop.setPreferredSize(new Dimension(165, 33));
        startStop.add(btnStart);
        startStop.add(btnStop);
        add(startStop);
        btnStart.addActionListener(this);
        btnStart.setToolTipText("Press to start/continue");
        btnStop.addActionListener(this);
        btnStop.setToolTipText("Stop the timer");
        timer = new Timer(10, this);

        resetLap.setPreferredSize(new Dimension(165, 33));
        resetLap.add(btnReset);
        btnLap.setPreferredSize(new Dimension(81, 28));
        resetLap.add(btnLap);
        add(resetLap);
        btnReset.addActionListener(this);
        btnReset.setToolTipText("Reset all to 0 (zero)");
        btnLap.addActionListener(this);
        btnLap.setToolTipText("Show lap time while timer runs. Press again to resume");
    }

    public TimeController(TimeValueModel m) {
        this();
        setModel(m);
    }

    public void setModel(TimeValueModel m) { model = m; }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStart) {
            timer.start();
        }
        else if (e.getSource() == btnStop) {
            timer.stop();
        }
        else if (e.getSource() == timer) {
            if (model != null)
                model.increaseTime();
        }
        else if (e.getSource() == btnReset) {
            if (model != null)
                model.resetTime();
        }
        else if (e.getSource() == btnLap) {
            if (btnLap.getText().equals("Lap")) {
                model.showLapTime(true);
                btnLap.setText("Resume");
            }
            else if (btnLap.getText().equals("Resume")) {
                model.showLapTime(false);
                btnLap.setText("Lap");
            }
        }
    }
}
