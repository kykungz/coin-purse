package coinpurse.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import coinpurse.Purse;

public class TransactionObserver extends JFrame implements Observer {
    private JTable table;
    private DefaultTableModel model;

    public TransactionObserver() {
	super("Purse Transactions");
	initComponents();
	this.pack();
	this.setAlwaysOnTop(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
	this.model = new DefaultTableModel();
	model.addColumn("Date/Time");
	model.addColumn("Description");
	model.addColumn("Balance");
	this.table = new JTable(model);
	table.setFont(new Font(Font.MONOSPACED, 0, 16));
	table.setAutoCreateRowSorter(true);
	table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	JScrollPane pane = new JScrollPane(table);
	pane.setPreferredSize(new Dimension(500, 200));
	this.add(pane);
    }

    public void run() {
	this.setLocationRelativeTo(null);
	this.setVisible(true);
    }

    @Override
    public void update(Observable subject, Object arg) {
	if (subject instanceof Purse && arg instanceof String) {
	    Purse p = (Purse) subject;
	    String info = (String) arg;
	    LocalDate now = LocalDate.now();
	    String[] data = { now.toString(), info, p.getBalance() + "" };
	    model.addRow(data);
	}
    }

}
