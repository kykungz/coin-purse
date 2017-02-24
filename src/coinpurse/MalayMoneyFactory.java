package coinpurse;

public class MalayMoneyFactory extends MoneyFactory {
	private static final String DEFAULT_CURRENCY = "Ringgit";
	private static final String SECONDARY_CURRENCY = "Sen";
	private static final double[] valid = { 0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10, 20, 50, 100 };

	public MalayMoneyFactory() {
		super(valid);
	}

	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException {
		if (!isValid(value))
			throw new IllegalArgumentException();
		Valuable money;
		if (value >= 1) {
			money = new Banknote(value, DEFAULT_CURRENCY);
			((Banknote) money).setSerialNumber(this.nextSerialNumber++);
		} else {
			money = new Coin(value, DEFAULT_CURRENCY);
			money.setSecondCurrency(SECONDARY_CURRENCY);
		}
		return money;
	}
}
