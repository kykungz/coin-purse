package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Purse {
	private List<Coin> money;
	private int capacity;

	/**
	 * A constructor that creates an empty purse with a given capacity.
	 * {@code new Purse(6)} creates a Purse with capacity 6 coins.
	 * 
	 * @param capacity
	 *            is the capacity to be set
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		this.money = new ArrayList<>();
	}

	/**
	 * Returns number of coins in the Purse.
	 * 
	 * @return the {@code number} of coins in the Purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Returns the {@code value} of all the coins in the Purse. If Purse has two
	 * 10-Baht and three 1-Baht coins then {@code getBalance()} is 23.
	 * 
	 * @return total money in the purse
	 */
	public double getBalance() {
		double balance = 0;
		for (Coin c : this.money) {
			balance += c.getValue();
		}
		return balance;
	}

	/**
	 * Returns the capacity of the Purse.
	 * 
	 * @return the {@code capacity} of the Purse
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Returns whether the purse is full (cannot insert more coins).
	 * 
	 * @return true if the purse is full, false otherwise.
	 */
	public boolean isFull() {
		return money.size() >= capacity;
	}

	/**
	 * Insert a coin in Purse, Returns {@code true} if insert OK, {@code false}
	 * if the Purse is full or the Coin is not valud (value <= 0).
	 * 
	 * @param coin
	 * @return
	 */
	public boolean insert(Coin coin) {
		if (coin.getValue() <= 0)
			return false;
		if (!isFull()) {
			this.money.add(coin);
			Collections.sort(this.money);
			return true;
		}
		return false;
	}

	/**
	 * Try to withdraw money. Return an array of the Coins withdrawn. If purse
	 * can't withdraw the exact amount, then return {@code null}.
	 * 
	 * @param amount
	 *            is the money to be withdrawn
	 * @return array of Coin withdrawn. null if cannot with draw exact amount of
	 *         money
	 */
	public Coin[] withdraw(double amount) {
		List<Coin> templist = new ArrayList<>();
		for (int i = this.money.size() - 1; i >= 0; i--) {
			Coin c = this.money.get(i);
			if (c.getValue() <= amount) {
				amount = amount - c.getValue();
				templist.add(c);
			}
		}
		if (amount == 0) {
			for (Coin tempc : templist) {
				this.money.remove(tempc);
			}
			Coin[] withdraw = new Coin[templist.size()];
			templist.toArray(withdraw);
			return withdraw;
		}
		return null;
	}

	@Override
	public String toString() {
		return this.money.size() + " coins with value " + this.getBalance();
	}

}
