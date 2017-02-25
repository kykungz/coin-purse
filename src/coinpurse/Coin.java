package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Kongpon Charanwattanakit
 *
 */
public class Coin extends AbstractValuable {

	/**
	 * Constructs a coin with a specific value and currency.
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
	 * Constructs a coin with a specific value and currency of Baht. (Just for
	 * PurseTest).
	 * 
	 * @param value
	 *            is the value of coin
	 * @param curr
	 *            is the currency of coin
	 */
	public Coin(double value) {
		super(value, "Baht");
	}

	@Override
	public String toString() {
		return super.toString() + " coin";
	}

}
