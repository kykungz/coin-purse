package coinpurse.gui;

import java.awt.Font;
import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import coinpurse.Purse;

public class BalanceObserver extends JFrame implements Observer {
    private JLabel balanceLabel;

    public BalanceObserver() {
	setTitle("Purse Balance");
	setAlwaysOnTop(true);
	initComponents();
	pack();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
	this.balanceLabel = new JLabel("Balance = ______ Baht");
	balanceLabel.setFont(new Font(Font.MONOSPACED, 0, 40));
	balanceLabel.setHorizontalAlignment(JLabel.CENTER);
	this.add(balanceLabel);
    }

    public void run() {
	setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
	DecimalFormat formatter = new DecimalFormat();
	balanceLabel.setText(String.format("Balance = %s Baht", formatter.format(((Purse) o).getBalance())));
    }

}
