package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import coinpurse.gui.BalanceObserver;
import coinpurse.gui.ListObserver;
import coinpurse.gui.StatusObserver;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author Kongpon Charanwattanakit
 *
 */
public class Purse extends Observable {
    /** Collection of objects in the purse. */
    private List<Valuable> money;
    /**
     * Capacity is maximum number of coins the purse can hold. Capacity is set
     * when the purse is created and cannot be changed.
     */
    private int capacity;

    /**
     * Create an empty purse with a given capacity.
     * 
     * @param capacity
     *            is the maximum number of coins you can put in this purse
     */
    public Purse(int capacity) {
	this.capacity = capacity;
	this.money = new ArrayList<>();
	this.setChanged();
    }

    /**
     * Count and return the number of coins in the purse. This is the number of
     * coins, not their value.
     * 
     * @return the number of coins in the Purse
     */
    public int count() {
	return money.size();
    }

    /**
     * Get the total value of all items in the purse.
     * 
     * @return the total value of items in the purse.
     */

    public double getBalance() {
	double balance = 0;
	for (Valuable c : this.money) {
	    balance += c.getValue();
	}
	return balance;
    }

    /**
     * Return the capacity of the coin purse.
     * 
     * @return the capacity
     */
    public int getCapacity() {
	return capacity;
    }

    /**
     * Test whether the purse is full. The purse is full if number of items in
     * purse equals or greater than the purse capacity.
     * 
     * @return true if purse is full, false otherwise
     */
    public boolean isFull() {
	return money.size() >= capacity;
    }

    /**
     * Insert a coin into the purse. The coin is only inserted if the purse has
     * space for it and the coin has positive value. No worthless coins!
     * 
     * @param coin
     *            is a Coin object to insert into purse
     * @return true if coin inserted, false if can't insert
     */
    public boolean insert(Valuable coin) {
	if (coin.getValue() <= 0)
	    return false;
	if (!isFull()) {
	    this.money.add(coin);
	    Collections.sort(this.money, new Comparator<Valuable>() {
		@Override
		public int compare(Valuable o1, Valuable o2) {
		    return Double.compare(o1.getValue(), o2.getValue());
		}
	    });
	    this.setChanged();
	    this.notifyObservers(this.money);
	    return true;
	}
	return false;
    }

    /**
     * Withdraw the requested amount of money. Return an array of Coins
     * withdrawn from purse, or return null if cannot withdraw the amount
     * requested.
     * 
     * @param amount
     *            is the amount to withdraw
     * @return array of Coin objects for money withdrawn, or null if cannot
     *         withdraw requested amount.
     */
    public Valuable[] withdraw(double amount) {
	List<Valuable> templist = new ArrayList<>();
	for (int i = this.money.size() - 1; i >= 0; i--) {
	    Valuable c = this.money.get(i);
	    if (c.getValue() <= amount) {
		amount = amount - c.getValue();
		templist.add(c);
	    }
	}
	if (amount == 0) {
	    for (Valuable tempc : templist) {
		this.money.remove(tempc);
	    }
	    Valuable[] withdraw = new Valuable[templist.size()];
	    templist.toArray(withdraw);
	    setChanged();
	    notifyObservers(this.money);
	    return withdraw;
	}
	return null;
    }

    /**
     * Return a string description of the purse contents.
     */
    @Override
    public String toString() {
	return this.money.size() + " items with value " + this.getBalance();
    }

}
