package coinpurse;

import java.util.ResourceBundle;

public abstract class MoneyFactory {
	private static MoneyFactory factory;
	protected final double[] valid;
	protected long nextSerialNumber = 1000000;

	protected MoneyFactory(double[] valid) {
		this.valid = valid;
	}

	public static MoneyFactory getInstance() {
		setMoneyFactory();
		return factory;
	}

	public abstract Valuable createMoney(double value);

	public Valuable createMoney(String value) {
		try {
			return createMoney(Double.parseDouble(value));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void setMoneyFactory() {
		if (factory == null) {
			ResourceBundle bundle = ResourceBundle.getBundle("purse");
			String factoryclass = bundle.getString("moneyFactory");
			try {
				factory = (MoneyFactory) Class.forName(factoryclass).newInstance();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error creating MoneyFactory: " + e.getMessage());
			}
		}
	}

	public boolean isValid(double value) {
		for (double d : valid) {
			if (d == value) {
				return true;
			}
		}
		return false;
	}

}
