package coinpurse;

public class ThaiMoneyFactory extends MoneyFactory {
	private static final String DEFAULT_CURRENCY = "Baht";
	private static final String SECONDARY_CURRENCY = "Satang";
	private static final double[] valid = { 0.25, 0.5, 1, 2, 5, 10, 20, 50, 100, 500, 1000 };

	public ThaiMoneyFactory() {
		super(valid);
	}

	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException {
		if (!isValid(value))
			throw new IllegalArgumentException();
		Valuable money;
		if (value >= 20) {
			money = new Banknote(value, DEFAULT_CURRENCY);
			((Banknote) money).setSerialNumber(this.nextSerialNumber++);
		} else {
			money = new Coin(value, DEFAULT_CURRENCY);
			money.setSecondCurrency(SECONDARY_CURRENCY);
		}
		return money;
	}
}
