package coinpurse;

import java.text.DecimalFormat;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Kongpon Charanwattanakit
 *
 */
public class Coin implements Valuable {
	/** Value of the coin. */
	private double value;
	/** Default currency. */
	private String currency = "Baht";

	/**
	 * Initialize the Coin with a specific value and a default currency of
	 * {@code Baht}
	 * 
	 * @param value
	 *            is the value of coin
	 */
	public Coin(double value) {
		this.value = value;
	}

	/**
	 * Initialize the Coin with a specific value and currency.
	 * 
	 * @param value
	 *            is the value of coin
	 * @param curr
	 *            is the currency of coin
	 */
	public Coin(double value, String curr) {
		this.value = value;
		this.currency = curr;
	}

	/**
	 * Return the {@code value} of this coin.
	 * 
	 * @return this coin {@code value}
	 */
	@Override
	public double getValue() {
		return value;
	}

	/**
	 * Return the {@code currency} of this coin.
	 * 
	 * @return this coin {@code currency}
	 */
	@Override
	public String getCurrency() {
		return currency;
	}

	/**
	 * Test whether two coins has the same {@code value} and {@code currency}.
	 * 
	 * @param obj
	 *            is the coin to compare
	 * @return true if it has same {@code value} and {@code currency}, false
	 *         otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Coin other = (Coin) obj;
		return this.value == other.value && this.currency == other.currency;
	}

	/**
	 * Return a String describe the coin {@code value} and {@code currency}
	 * 
	 * @return string that describes the coin
	 */
	@Override
	public String toString() {
		DecimalFormat decimalFormat = new DecimalFormat();
		return decimalFormat.format(this.value) + "-" + this.currency;
	}

}
