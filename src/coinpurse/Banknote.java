package coinpurse;

public class Banknote extends AbstractValuable {
	private long serialNumber;

	public Banknote(double value) {
		super(value);
	}

	public Banknote(double value, String currency) {
		super(value, currency);
	}

	public long getSerial() {
		return serialNumber;
	}

	@Override
	public String toString() {
		return super.toString() + " note [" + this.serialNumber + "]";
	}

	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}
}
