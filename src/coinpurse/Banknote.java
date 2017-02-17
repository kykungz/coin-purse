package coinpurse;

import java.text.DecimalFormat;

public class Banknote implements Valuable {
	private static long nextSerialNumber = 1000000;
	private double value;
	private String currency = "Baht";
	private long serialNumber;

	public Banknote(double value) {
		this.value = value;
		this.serialNumber = Banknote.nextSerialNumber;
		Banknote.nextSerialNumber++;
	}

	public Banknote(double value, String currency) {
		this.value = value;
		this.currency = currency;
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
	public double getValue() {
		return this.value;
	}

	@Override
	public String getCurrency() {
		return this.currency;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Banknote other = (Banknote) obj;
		return this.value == other.value && this.currency == other.currency;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat();
		return String.format("%s-%s note [%s]", df.format(this.value), this.currency, this.serialNumber);
	}

}
