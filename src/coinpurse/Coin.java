package coinpurse;

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

	@Override
	public String toString() {
		return super.toString() + " coin";
	}

}
