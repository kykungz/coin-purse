package coinpurse.ui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractListModel;

import coinpurse.Purse;
import coinpurse.Valuable;

/**
 * This class provides a ListModel interface for querying the contents of the
 * purse. It is a kind of adapter.
 * 
 * @author Kongpon Charanwattanakit
 */
public class PurseListModel extends AbstractListModel<Valuable> implements Observer {
    private Purse purse;

    public PurseListModel(Purse purse) {
	this.purse = purse;
    }

    @Override
    public int getSize() {
	return purse.count();
    }

    @Override
    public Valuable getElementAt(int index) {
	return purse.getMoney().get(index);
    }

    @Override
    public void update(Observable o, Object arg) {
	this.fireContentsChanged(this, 0, getSize() - 1);
    }

}
