package coinpurse;

public class Main {
	private static int CAPACITY = 10;

	public static void main(String[] args) {
		Purse purse = new Purse(CAPACITY);
		ConsoleDialog consoleDialog = new ConsoleDialog(purse);
		consoleDialog.run();
	}
}
