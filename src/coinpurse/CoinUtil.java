package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 * 
 * @author Kongpon Charanwattanakit
 * 
 * 
 */
public class CoinUtil {

    public <E> E foo(E a) {
	return null;
    }

    /**
     * Return a larger of a and b, according to the natural ordering (defined by
     * compareTo).
     * 
     * @param a
     *            is first element
     * @param b
     *            is the second element
     * @return a larger element of these two
     */
    public static <E extends Comparable<? super E>> E max(E... elements) {
	if (elements.length <= 0)
	    throw new IllegalArgumentException();
	return Arrays.stream(elements).max((a, b) -> a.compareTo(b)).get();
    }

    /**
     * Method that examines all the coins in a List and returns only the coins
     * that have a currency that matches the parameter value.
     * 
     * @param coinlist
     *            is a List of Coin objects. This list is not modified.
     * @param currency
     *            is the currency we want. Must not be null.
     * @return a new List containing only the elements from coinlist that have
     *         the requested currency.
     */
    public static <E extends Valuable> List<E> filterByCurrency(List<E> coinlist, String currency) {
	if (currency == null)
	    throw new IllegalArgumentException();
	Predicate<E> sameCurrency = e -> e.getCurrency().equalsIgnoreCase(currency);
	return coinlist.stream().filter(sameCurrency).collect(Collectors.toList());
    }

    /**
     * Method to sort a list of coins by currency. On return, the list (coins)
     * will be ordered by currency.
     * 
     * @param coins
     *            is a List of Coin objects we want to sort.
     */
    public static void sortByCurrency(List<? extends Valuable> coins) {
	Collections.sort(coins, (c1, c2) -> c1.getCurrency().compareToIgnoreCase(c2.getCurrency()));
    }

    /**
     * Sum coins by currency and print the sum for each currency. Print one line
     * for the sum of each currency.
     * 
     * @param items
     *            is the List of Coin objects to find the sum
     */
    public static void sumByCurrency(List<? extends Valuable> items) {
	Map<String, Double> map = new HashMap<>();
	for (Valuable c : items) {
	    map.put(c.getCurrency(), map.getOrDefault(c.getCurrency(), 0.0) + c.getValue());
	}
	map.entrySet().stream().forEach(m -> System.out.println(m.getKey() + " " + m.getValue()));
    }

    /**
     * This method contains some code to test the above methods.
     * 
     * @param args
     *            not used
     */

    public static void main(String[] args) {
	String currency = "Rupee";
	System.out.println("Filter coins by currency of " + currency);
	List<Coin> coins = makeInternationalCoins();
	int size = coins.size();
	System.out.print(" INPUT: ");
	printList(coins, " ");
	List<Coin> rupees = filterByCurrency(coins, currency);
	System.out.print("RESULT: ");
	printList(rupees, " ");
	if (coins.size() != size)
	    System.out.println("Error: you changed the original list.");

	System.out.println("\nSort coins by currency");
	coins = makeInternationalCoins();
	System.out.print(" INPUT: ");
	printList(coins, " ");
	sortByCurrency(coins);
	System.out.print("RESULT: ");
	printList(coins, " ");

	System.out.println("\nSum coins by currency");
	coins = makeInternationalCoins();
	System.out.print("coins= ");
	printList(coins, " ");
	sumByCurrency(coins);

	Coin c1 = new Coin(5);
	Coin c2 = new Coin(10);
	Coin c3 = new Coin(0.5);
	Banknote n = new Banknote(20, "Baht");
	AbstractValuable maxValuable = max(c1, c2, c3, n);
	System.out.println(maxValuable);
	System.out.println(max(c1));

    }

    /** Make a list of coins containing different currencies. */
    public static List<Coin> makeInternationalCoins() {
	List<Coin> money = new ArrayList<Coin>();
	money.addAll(makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0));
	money.addAll(makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0));
	money.addAll(makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0));
	// randomize the elements
	Collections.shuffle(money);
	return money;
    }

    /** Make a list of coins using given values. */
    public static List<Coin> makeCoins(String currency, double... values) {
	List<Coin> list = new ArrayList<Coin>();
	for (double value : values)
	    list.add(new Coin(value, currency));
	return list;
    }

    /** Print the list on the console, on one line. */
    public static void printList(List items, String separator) {
	Iterator iter = items.iterator();
	while (iter.hasNext()) {
	    System.out.print(iter.next());
	    if (iter.hasNext())
		System.out.print(separator);

	}
	System.out.println(); // end the line
    }
}
