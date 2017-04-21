package coinpurse;

import java.util.ResourceBundle;

import coinpurse.gui.BalanceObserver;
import coinpurse.gui.ListObserver;
import coinpurse.gui.StatusObserver;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author Kongpon Charanwattanakit
 */
public class Main {
    /* purse's capacity. */
    private static int CAPACITY = 20;

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
	BalanceObserver balanceObserver = new BalanceObserver();
	StatusObserver statusObserver = new StatusObserver();
	ListObserver listObserver = new ListObserver();
	purse.addObserver(statusObserver);
	purse.addObserver(balanceObserver);
	purse.addObserver(listObserver);
	balanceObserver.run();
	statusObserver.run();
	listObserver.run();
	purse.notifyObservers();
	
	ConsoleDialog consoleDialog = new ConsoleDialog(purse);
	consoleDialog.run();
    }
}
