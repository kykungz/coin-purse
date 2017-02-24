package coinpurse;

/**
 * Money Factory is a factory class for creating Valuable items.
 * 
 * @author Kongpon Charanwattanakit
 *
 */
public abstract class MoneyFactory {
	protected long nextSerialNumber = 10000;
	protected final double[] valid;
	private static MoneyFactory factory;

	/**
	 * Constructs a MoneyFactory with a sequence of a valid values of money.
	 * 
	 * @param valid
	 *            is a value that is valid for creating
	 */
	protected MoneyFactory(double... valid) {
		this.valid = valid;
	}

	/**
	 * Returns a MoneyFactory depending on the properties file.
	 * 
	 * @return MoneyFactory instance
	 */
	public static MoneyFactory getInstance() {
		return factory;
	}

	/**
	 * Create money by its value.
	 * 
	 * @param value
	 *            is the amount of money to be created
	 * @return a Valuable object of the specified amount
	 * @throws IllegalArgumentException
	 *             if the value is not a valid amount of money
	 */
	public abstract Valuable createMoney(double value) throws IllegalArgumentException;

	/**
	 * Create money by its value in String.
	 * 
	 * @param value
	 *            is the amount of money to be created
	 * @return a Valuable object of the specified amount
	 * @throws IllegalArgumentException
	 *             if the value is not a valid amount of money
	 */
	public Valuable createMoney(String value) throws IllegalArgumentException {
		try {
			return createMoney(Double.parseDouble(value));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Set the MoneyFactory depending on the properties file.
	 */
	public static void setMoneyFactory(MoneyFactory factory) {
		MoneyFactory.factory = factory;
	}

	/**
	 * Check if a value is available for creating.
	 * 
	 * @param value
	 *            is the value to check for
	 * @return true if it is available, false otherwise
	 */
	protected boolean isValid(double value) {
		for (double d : valid) {
			if (d == value) {
				return true;
			}
		}
		return false;
	}
}
