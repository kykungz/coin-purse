package coinpurse;

import java.text.DecimalFormat;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Kongpon Charanwattanakit
 *
 */
public class Coin extends AbstractValuable {
	/**
	 * Initialize the Coin with a specific value and a default currency of
	 * {@code Baht}
	 * 
	 * @param value
	 *            is the value of coin
	 */
	public Coin(double value) {
		super(value);
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
		super(value, curr);
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
