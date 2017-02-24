package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author Kongpon Charanwattanakit
 */
public class Main {
	/* purse's capacity. */
	private static int CAPACITY = 10;

	/**
	 * Configure and start the application.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		MoneyFactory factory = MoneyFactory.getInstance();
		try {
			List<Valuable> purse = new ArrayList<>();
			purse.add(factory.createMoney(10));
			purse.add(factory.createMoney(5));
			purse.add(factory.createMoney(20));
			purse.add(factory.createMoney(50));
			purse.add(factory.createMoney(100));
			purse.add(factory.createMoney(0.1));
			purse.add(factory.createMoney(0.2));

			for (Valuable v : purse) {
				System.out.println(v);
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("exception");
		}

//		 Purse purse = new Purse(CAPACITY);
//		 ConsoleDialog consoleDialog = new ConsoleDialog(purse);
//		 consoleDialog.run();
	}
}
