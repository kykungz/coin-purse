package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Kongpon Charanwattanakit
 *
 */
public class Coin extends AbstractValuable {
	/** Currency for the value less than 1. */
	protected String subCurrency;

	/**
	 * Constructs a coin with a specific value, currency and a special
	 * currency for displaying value less than 1.
	 * 
	 * @param value
	 *            is the value of coin
	 * @param curr
	 *            is the currency of coin
	 * @param subCurrency
	 *            is the sub currency of coin
	 */
	public Coin(double value, String curr, String subCurrency) {
		super(value, curr);
		this.subCurrency = subCurrency;
	}

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
		this.subCurrency = curr;
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
		if (this.getValue() < 1)
			return Valuable.FORMATTER.format(this.getValue() * 100) + " " + this.subCurrency + " coin";
		return super.toString() + " coin";
	}

}
