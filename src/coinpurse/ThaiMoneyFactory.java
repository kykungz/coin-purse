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

	ThaiMoneyFactory() {
		super(0.25, 0.5, 1, 2, 5, 10, 20, 50, 100, 500, 1000);
	}

	@Override
	public Valuable createMoney(double value) {
		if (!isValid(value))
			throw new IllegalArgumentException();
		if (value >= 20)
			return new Banknote(value, DEFAULT_CURRENCY, this.nextSerialNumber++);
		else {
			Coin money = new Coin(value, DEFAULT_CURRENCY);
			if (money.getValue() < 1) {
				money.displayValue *= 100;
				money.displayCurrency = SUB_CURRENCY;
			}
			return money;
		}
	}
}
