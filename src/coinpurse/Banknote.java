package coinpurse;

/**
 * Banknote represents a paper banknote with a fixed value, currency and a
 * serial number.
 * 
 * @author Kongpon Charanwattanakit
 *
 */
public class Banknote extends AbstractValuable {
	/** Serial number */
	private long serialNumber;

	/**
	 * Constructs a banknote with a specific value, currency and a serial
	 * number.
	 * 
	 * @param value
	 *            is the value of banknote
	 * @param currency
	 *            is the currency of banknote
	 * @param serialNumber
	 *            is the serial number of banknote
	 */
	public Banknote(double value, String currency, long serialNumber) {
		super(value, currency);
		this.serialNumber = serialNumber;
	}

	/**
	 * Constructs a banknote with a specific value and currency.
	 * 
	 * @param value
	 *            is the value of banknote
	 * @param currency
	 *            is the currency of banknote
	 */
	public Banknote(double value, String currency) {
		super(value, currency);
	}

	/**
	 * Return the serial number of the banknote.
	 * 
	 * @return {@code serialNumber} of the banknote
	 */
	public long getSerialNumber() {
		return serialNumber;
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" note [%s]", serialNumber);
	}

}
