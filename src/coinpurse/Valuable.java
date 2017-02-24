package coinpurse;

public interface Valuable extends Comparable<Valuable> {

	public static final String DEFAULT_CURRENCY = "Baht";

	/**
	 * Get value of this item.
	 * 
	 * @return value of the item
	 */
	public double getValue();

	/**
	 * Get the currency of this item.
	 * 
	 * @return currency of the item
	 */
	public String getCurrency();

	public void setSecondCurrency(String secondCurrency);
}
