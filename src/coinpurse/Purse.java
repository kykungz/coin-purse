package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;

import coinpurse.strategy.GreedyWithdraw;
import coinpurse.strategy.RecursiveTest;
import coinpurse.strategy.RecursiveWithdraw;
import coinpurse.strategy.WithdrawStrategy;

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
    private WithdrawStrategy strategy;
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
	setWithdrawStrategy(new RecursiveWithdraw());
	this.setChanged();
    }

    /**
     * Set the WithdrawStrategy of the Purse.
     * 
     * @param strategy
     *            is the WithdrawStrategy to set to
     */
    public void setWithdrawStrategy(WithdrawStrategy strategy) {
	this.strategy = strategy;
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
     * Return an unmodifiable List of Valuable items in the purse.
     * 
     * @return an unmodifiable List of money
     */
    public List<Valuable> getMoney() {
	return Collections.unmodifiableList(money);
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
	    this.notifyObservers("Deposited " + coin);
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
	List<Valuable> suggestion = strategy.withdraw(amount, money);
	if (suggestion == null)
	    return null;
	money.removeAll(suggestion);
	setChanged();
	notifyObservers("Withdraw " + amount + " " + suggestion.get(0).getCurrency());
	return suggestion.toArray(new Valuable[suggestion.size()]);
    }

    /**
     * Return a string description of the purse contents.
     */
    @Override
    public String toString() {
	return this.money.size() + " items with value " + this.getBalance();
    }

}
