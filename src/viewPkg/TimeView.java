package viewPkg;

import modelPkg.TimeValueModel;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;

public class TimeView extends BaseTimeView {
    JLabel timeDisplayer = new JLabel();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("mm:ss.SS");

    public TimeView() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(200,70));
        setOpaque(true);
        timeDisplayer.setFont(new Font("Century", Font.BOLD, 40));
        timeDisplayer.setForeground(Color.CYAN);
        add(timeDisplayer);
        setVisible(true);
    }

    public TimeView(TimeValueModel m) {
        this();
        setModel(m);
        timeDisplayer.setText(model.getTime().format(dtf));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getForeground());
        if (model == null)
            return;
        timeDisplayer.setText(model.getTime().format(dtf));
    }
}
