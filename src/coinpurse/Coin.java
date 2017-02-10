package coinpurse;

import java.text.DecimalFormat;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Kongpon Charanwattanakit
 *
 */
public class Coin implements Comparable<Coin> {
	private double value;
	private String currency = "Baht";

	public Coin(double value) {
		this.value = value;
	}

	public Coin(double value, String curr) {
		this.value = value;
		this.currency = curr;
	}

	public double getValue() {
		return value;
	}

	public String getCurrency() {
		return currency;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Coin other = (Coin) obj;
		return this.value == other.value && this.currency == other.currency;
	}

	@Override
	public int compareTo(Coin o) {
		return (int) Math.signum(this.value - o.value);
	}

	@Override
	public String toString() {
		DecimalFormat decimalFormat = new DecimalFormat();
		return decimalFormat.format(this.value) + "-" + this.currency;
	}

}
