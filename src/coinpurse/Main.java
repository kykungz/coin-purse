package coinpurse;

import java.util.ResourceBundle;

import coinpurse.ui.BalanceObserver;
import coinpurse.ui.ConsoleDialog;
import coinpurse.ui.PurseListFrame;
import coinpurse.ui.PurseListModel;
import coinpurse.ui.StatusObserver;
import coinpurse.ui.TransactionObserver;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author Kongpon Charanwattanakit
 */
public class Main {
    /* purse's capacity. */
    private static int CAPACITY = 4;

    /**
     * Configure and start the application.
     * 
     * @param args
     *            not used
     */
    public static void main(String[] args) {
	ResourceBundle bundle = ResourceBundle.getBundle("purse");
	String factoryclass = bundle.getString("moneyFactory");
	MoneyFactory factory = null;
	try {
	    factory = (MoneyFactory) Class.forName(factoryclass).newInstance();
	} catch (ClassCastException e) {
	    System.out.println(factoryclass + " is not type MoneyFactory");
	    e.printStackTrace();
	} catch (Exception e) {
	    System.out.println("Error creating MoneyFactory " + e.getMessage());
	    e.printStackTrace();
	}
	if (factory == null)
	    System.exit(1);
	else
	    MoneyFactory.setMoneyFactory(factory);

	Purse purse = new Purse(CAPACITY);
	/* create observers */
	BalanceObserver balanceObserver = new BalanceObserver();
	StatusObserver statusObserver = new StatusObserver();
	TransactionObserver transactionObserver = new TransactionObserver();
	PurseListModel listModel = new PurseListModel(purse);
	/* add observers */
	purse.addObserver(statusObserver);
	purse.addObserver(balanceObserver);
	purse.addObserver(listModel);
	purse.addObserver(transactionObserver);
	/* initialize observer */
	purse.notifyObservers();
	/* create/display ui */

	PurseListFrame listFrame = new PurseListFrame(listModel);
	ConsoleDialog consoleDialog = new ConsoleDialog(purse);

	listFrame.run();
	transactionObserver.run();
	statusObserver.run();
	balanceObserver.run();
	consoleDialog.run();

    }
}
