package coinpurse;

/**
 * This class provides a skeletal implementation of the {@link Valuable}
 * interface to minimize the effort required to implement this interface.
 * 
 * @author Kongpon Charanwattanakit
 *
 */
public class AbstractValuable implements Valuable {
	/** Default currency. */
	protected String currency;

	/** Value of the item. */
	protected double value;

	/** Currency to be displayed. */
	protected String displayCurrency;

	/** Value to be displayed. */
	protected double displayValue;

	/**
	 * Constructs a AbstractValuable with a value and currency;
	 * 
	 * @param value
	 *            is the value of this item
	 * @param currency
	 *            is the currency of this item
	 */
	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.displayValue = value;
		this.displayCurrency = currency;
	}

	@Override
	public double getValue() {
		return value;
	}

	@Override
	public String getCurrency() {
		return currency;
	}

	/**
	 * Compare this Valuable to another by its currency and value.
	 * 
	 * @param o
	 *            is a Valuable object to compare to
	 * @returna negative integer, zero, or a positive integer as this object is
	 *          less than, equal to, or greater than the specified object.
	 */
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

	/**
	 * Returns a string described this Valuable item.
	 * 
	 * @return description of the item
	 */
	@Override
	public String toString() {
		return Valuable.FORMATTER.format(this.displayValue) + " " + this.displayCurrency;
	}

}