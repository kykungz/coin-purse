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

public class RecursiveTest {
    private WithdrawStrategy recur;
    private Purse purse;

    @Before
    public void setup() {
	this.purse = new Purse(6);
	recur = new RecursiveWithdraw();
    }

    @Test
    public void testSortedList() {
	List<Valuable> val = intArrayToList(new Integer[] { 2, 2, 2, 5, 10 });
	insert(val);
	List<Valuable> suggestion = recur.withdraw(16, purse.getMoney());
	List<Valuable> expected = intArrayToList(new Integer[] { 10, 2, 2, 2 });
	System.out.println(suggestion);
	assertEquals(expected, suggestion);
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
