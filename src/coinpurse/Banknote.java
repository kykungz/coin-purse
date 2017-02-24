package coinpurse;

import java.text.DecimalFormat;

public class Banknote extends AbstractValuable {
	private static long nextSerialNumber = 1000000;
	private long serialNumber;

	public Banknote(double value) {
		super(value);
		this.serialNumber = Banknote.nextSerialNumber;
		Banknote.nextSerialNumber++;
	}

	public Banknote(double value, String currency) {
		super(value, currency);
		this.serialNumber = Banknote.nextSerialNumber;
		Banknote.nextSerialNumber++;
	}

	public long getSerial() {
		return serialNumber;
	}

	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat();
		return String.format("%s-%s note [%s]", df.format(this.value), this.currency, this.serialNumber);
	}

}
