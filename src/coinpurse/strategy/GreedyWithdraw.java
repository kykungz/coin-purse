package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;

/**
 * GreedyWithdraw Strategy. The Valuable List must be sorted from smallest to
 * largerst inorder to make this strategy functional.
 * 
 * @author Kongpon Charanwattanakit
 *
 */
public class GreedyWithdraw implements WithdrawStrategy {

    @Override
    public List<Valuable> withdraw(double amount, List<Valuable> money) {
	List<Valuable> suggestion = new ArrayList<>();
	for (int i = money.size() - 1; i >= 0; i--) {
	    Valuable valuable = money.get(i);
	    if (valuable.getValue() <= amount) {
		amount = amount - valuable.getValue();
		suggestion.add(valuable);
	    }
	}
	return amount <= 0 ? suggestion : null;
    }

}
