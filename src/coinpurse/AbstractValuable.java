package coinpurse;

public class AbstractValuable implements Valuable {

	/** Value of the coin. */
	protected double value;
	/** Default currency. */
	protected String currency;

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
	public int compareTo(Valuable o) {
		int compareCurrency = this.getCurrency().compareToIgnoreCase(o.getCurrency());
		if (compareCurrency == 0) {
			return Double.compare(this.getValue(), o.getValue());
		}
		return compareCurrency;
	}

	/**
	 * Test whether two coins has the same {@code value} and {@code currency}.
	 * 
	 * @param obj
	 *            is the coin to compare
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

}