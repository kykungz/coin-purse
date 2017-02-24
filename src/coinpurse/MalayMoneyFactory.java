package coinpurse;

/**
 * MalayMoneyFactory is a MoneyFactory that creates Malaysian money.
 * 
 * @author Kongpon Charanwattanakit
 *
 */
public class MalayMoneyFactory extends MoneyFactory {
	private static final String DEFAULT_CURRENCY = "Ringgit";
	private static final String SUB_CURRENCY = "Sen";

	public MalayMoneyFactory() {
		super(0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10, 20, 50, 100);
	}

	@Override
	public Valuable createMoney(double value) {
		if (!isValid(value))
			throw new IllegalArgumentException();
		Valuable money;
		if (value >= 1) {
			money = new Banknote(value, DEFAULT_CURRENCY, this.nextSerialNumber++);
		} else {
			money = new Coin(value, DEFAULT_CURRENCY, SUB_CURRENCY);
		}
		return money;
	}
}
