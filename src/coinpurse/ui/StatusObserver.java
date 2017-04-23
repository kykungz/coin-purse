package coinpurse.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

import coinpurse.Purse;

public class StatusObserver extends JFrame implements Observer {
    private JLabel status;
    private JProgressBar capacityBar;

    public StatusObserver() {
	setTitle("Purse Status");
	setAlwaysOnTop(true);
	initComponents();
	pack();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
	this.status = new JLabel(String.format("%10s", ""));
	status.setFont(new Font(Font.MONOSPACED, 0, 40));
	this.capacityBar = new JProgressBar();
	this.add(status, BorderLayout.CENTER);
	this.add(capacityBar, BorderLayout.SOUTH);
    }

    public void run() {
	setLocationRelativeTo(null);
	setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
	if (o instanceof Purse) {
	    Purse p = (Purse) o;
	    SwingUtilities.invokeLater(() -> {
		if (p.isFull()) {
		    status.setText("FULL");
		} else if (p.count() <= 0) {
		    status.setText("EMPTY");
		} else {
		    status.setText(p.count() + " Items");
		}
		capacityBar.setMaximum(p.getCapacity());
		capacityBar.setValue((int) p.count());
	    });
	}
    }

}
