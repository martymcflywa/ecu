import javax.swing.*;

import WattBrown.LinkedList;

public class LinkedListModel extends AbstractListModel {

    private LinkedList baseList;

    public LinkedListModel (LinkedList baseList) {
    	super();
    	this.baseList = baseList;
    }

    public Object getElementAt (int index) {
	return baseList.get(index);
    }

    public int getSize () {
	return baseList.size();
    }

    public void listChanged () {
	fireContentsChanged(this, 0, baseList.size() - 1);
    }
}
