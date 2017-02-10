package coinpurse;

import java.util.Arrays;

public class ConsoleDialog {
	public static void main(String[] args) {
		Purse purse = new Purse(3);
		System.out.println(purse.getBalance());
		System.out.println(purse.count());
		System.out.println(purse.isFull());
		System.out.println(purse.insert(new Coin(5)));
		System.out.println(purse.insert(new Coin(10)));
		System.out.println(purse.insert(new Coin(0)));
		System.out.println(purse.insert(new Coin(1)));
		System.out.println(purse.insert(new Coin(5)));
		System.out.println(purse.count());
		System.out.println(purse.isFull());
		System.out.println(purse.getBalance());
		System.out.println(purse.toString());
		System.out.println(Arrays.toString(purse.withdraw(12)));
		System.out.println(Arrays.toString(purse.withdraw(11)));
		System.out.println(purse.toString());
	}
}
