package coinpurse;

/**
 * ThaiMoneyFactory is a MoneyFactory that creates Thai money.
 * 
 * @author Kongpon Charanwattanakit
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {
	private static final String DEFAULT_CURRENCY = "Baht";
	private static final String SUB_CURRENCY = "Satang";

	public ThaiMoneyFactory() {
		super(0.25, 0.5, 1, 2, 5, 10, 20, 50, 100, 500, 1000);
	}

	@Override
	public Valuable createMoney(double value) {
		if (!isValid(value))
			throw new IllegalArgumentException();
		Valuable money;
		if (value >= 20) {
			money = new Banknote(value, DEFAULT_CURRENCY, this.nextSerialNumber++);
		} else {
			money = new Coin(value, DEFAULT_CURRENCY, SUB_CURRENCY);
		}
		return money;
	}
}
