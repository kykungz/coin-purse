package coinpurse.ui;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import coinpurse.Valuable;

public class PurseListFrame extends JFrame {
    private JList<Valuable> jlist;
    private ListModel<Valuable> model;

    public PurseListFrame(ListModel<Valuable> model) {
	super("Purse Items");
	this.model = model;
	initComponents();
	this.setAlwaysOnTop(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.pack();
    }

    public void run() {
	setVisible(true);
    }

    private void initComponents() {
	this.jlist = new JList<>(model);
	jlist.setFont(new Font(Font.MONOSPACED, 0, 15));
	this.add(new JScrollPane(jlist));
    }
}
