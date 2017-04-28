package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;

public class RecursiveWithdraw implements WithdrawStrategy {

    @Override
    public List<Valuable> withdraw(double amount, List<Valuable> money) {
	if (amount == 0) // success! return empty array for others to use.
	    return new ArrayList<>();
	if (money.isEmpty())
	    return null;
	Valuable v = money.get(0);
	// case 1: use
	List<Valuable> list = withdraw(amount - v.getValue(), money.subList(1, money.size()));
	if (list != null) {
	    list.add(v);
	    return list;
	}
	// case 2: skip
	return withdraw(amount, money.subList(1, money.size()));
    }

}
