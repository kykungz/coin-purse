package coinpurse.strategy;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import coinpurse.Coin;
import coinpurse.Purse;
import coinpurse.Valuable;

public class GreedyTest {
    private GreedyWithdraw greedy;
    private Purse purse;

    @Before
    public void setup() {
	this.purse = new Purse(6);
	greedy = new GreedyWithdraw();
    }

    @Test
    public void testSortedList() {
	List<Valuable> val = intArrayToList(new Integer[] { 20, 20, 20, 20, 50 });
	insert(val);
	List<Valuable> suggestion = greedy.withdraw(80, purse.getMoney());
	assertNull(suggestion);
    }
  

    private void insert(List<Valuable> list) {
	list.forEach(valuable -> {
	    purse.insert(valuable);
	});
    }

    private List<Valuable> intArrayToList(Integer[] array) {
	return Arrays.asList(array).stream().map(element -> {
	    return new Coin(element);
	}).collect(Collectors.toList());
    }
}
