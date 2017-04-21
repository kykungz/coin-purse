package coinpurse.gui;

import java.awt.Font;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import coinpurse.Valuable;

public class ListObserver extends JFrame implements Observer {
    private JList<Valuable> jlist;
    private DefaultListModel<Valuable> model;

    public ListObserver() {
	setTitle("Purse View");
	setAlwaysOnTop(true);
	initComponents();
	pack();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
	model = new DefaultListModel<>();
	jlist = new JList<>(model);
	jlist.setFont(new Font(Font.MONOSPACED, 0, 15));
	JScrollPane pane = new JScrollPane(jlist);
	this.add(pane);
    }

    public void run() {
	setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
	if (arg instanceof List) {
	    List<Valuable> money = (List<Valuable>) arg;
	    SwingUtilities.invokeLater(() -> model.clear());
	    money.forEach((v) -> {
		SwingUtilities.invokeLater(() -> {
		    model.addElement(v);
		});
	    });
	    System.out.println("model------------------" + model.size());
	}
    }

}
