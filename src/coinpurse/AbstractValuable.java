package coinpurse;

import java.text.DecimalFormat;

public class AbstractValuable implements Valuable {

	/** Value of the coin. */
	protected double value;
	/** Default currency. */
	protected String currency;
	private String secondCurrency;

	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	public AbstractValuable(double value) {
		this.value = value;
		this.currency = Valuable.DEFAULT_CURRENCY;
	}

	/**
	 * Return the {@code value} of this coin.
	 * 
	 * @return this coin {@code value}
	 */
	@Override
	public double getValue() {
		return value;
	}

	/**
	 * Return the {@code currency} of this coin.
	 * 
	 * @return this coin {@code currency}
	 */
	@Override
	public String getCurrency() {
		return currency;
	}

	@Override
	public void setSecondCurrency(String secondCurrency) {
		this.secondCurrency = secondCurrency;
	}

	@Override
	public int compareTo(Valuable o) {
		if (this.getCurrency().equalsIgnoreCase(o.getCurrency()))
			return Double.compare(this.getValue(), o.getValue());
		return this.getCurrency().compareToIgnoreCase(o.getCurrency());
	}

	/**
	 * Test whether two items has the same {@code value} and {@code currency}.
	 * 
	 * @param obj
	 *            is the item to compare
	 * @return true if it has same {@code value} and {@code currency}, false
	 *         otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Valuable other = (Valuable) obj;
		return this.getValue() == other.getValue() && this.getCurrency() == other.getCurrency();
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat();
		return value < 1 ? df.format(value * 100) + " " + secondCurrency : df.format(value) + " " + currency;
	}

}