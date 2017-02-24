package coinpurse;

import java.text.DecimalFormat;

/**
 * An interface for a money that has value and currency.
 * 
 * @author Kongpon Charanwattanakit
 *
 */
public interface Valuable extends Comparable<Valuable> {
	/** Decimal formatter for removing extra 0s. */
	public static final DecimalFormat FORMATTER = new DecimalFormat();

	/**
	 * Return the value of this item.
	 * 
	 * @return value of the item
	 */
	public double getValue();

	/**
	 * Return the currency of this item.
	 * 
	 * @return currency of the item
	 */
	public String getCurrency();

}
