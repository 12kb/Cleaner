package cleaner;

import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;


public class ArrayListModel<E> extends ArrayList<E> implements ListModel<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5904244312250149464L;
	
	private ArrayList<ListDataListener> ListDataListeners;
	
	
	
	
	
	public ArrayListModel() {
		super();
		ListDataListeners = new ArrayList<ListDataListener>();
	}
	
	
	
	
	
	@Override
	public int getSize() {
		return this.size();
	}
	
	
	
	
	
	@Override
	public E getElementAt(int index) {
		return this.get(index);
	}


	
	
	
	@Override
	public void addListDataListener(ListDataListener l) {
		ListDataListeners.add(l);
	}
	
	
	
	
	
	@Override
	public void removeListDataListener(ListDataListener l) {
		ListDataListeners.remove(l);
	}

	
	
	
	
	@Override
	public boolean add(E str) {
		
		if (str == null){
			return false;
		}
		
		boolean result = super.add(str);
		
		for (int i=0; i<ListDataListeners.size(); i++) {
			ListDataListeners.get(i).intervalAdded(new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, this.size()-1, this.size()));
		}
		
		return result;
	}
	
	
	
	
	
	
	@Override 
	public void add(int index, E str) {
		
		if (str == null) {
			System.err.println("Index out of bounds");
			return;
		}
		
		if ((index < 0) || (index >= this.size())) {
			System.err.println("Index out of bounds");
			return;
		}
		
		super.add(index, str);
		
		for (int i=0; i<ListDataListeners.size(); i++) {
			ListDataListeners.get(i).intervalAdded(new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, index, index+1));
		}
	}
	
	
	
	public void add(E[] strs) {
		if((strs == null) || (strs.length == 0)){
			return;
		}
		
		int start_index = super.size(); 
		
		for (E str : strs) {
			super.add(str);
		}
		
		for (int i=0; i<ListDataListeners.size(); i++) {
			ListDataListeners.get(i).intervalAdded(new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, start_index, super.size()));
		}
		
	}
	
	
	
	
	@Override
	public E remove(int index) {
		
		if ((index < 0) || (index >= this.size())) {
			System.err.println("Index out of bounds");
			return null;
		}
		
		E result = super.remove(index);
		
		for (int i=0; i<ListDataListeners.size(); i++) {
			ListDataListeners.get(i).intervalRemoved(new ListDataEvent(this, ListDataEvent.INTERVAL_REMOVED, index, index+1));
		}
		
		return result;
	}
	
	
	
	
	
	@Override
	public boolean remove(Object o) {
		
		if (o == null) {
			return false;
		}
		
		int index = super.indexOf(o);
		
		boolean result = super.remove(o);
		
		for (int i=0; i<ListDataListeners.size(); i++) {
			ListDataListeners.get(i).intervalRemoved(new ListDataEvent(this, ListDataEvent.INTERVAL_REMOVED, index, index+1));
		}
		
		return result;
	
	}
	
	
	
	
	
	@Override
	public void clear() {
		
		int index = super.size();
		
		super.clear();
		
		for (int i=0; i<ListDataListeners.size(); i++) {
			ListDataListeners.get(i).intervalRemoved(new ListDataEvent(this, ListDataEvent.INTERVAL_REMOVED, 0, index));
		}
		
	}
	




	public void remove(int start, int end) {
		if ( (start < 0) || (start >= this.size()) || (end < 0) || (end >= this.size()) || (start >= end) ) {
			System.err.println("Wrong indexes. Removing is aborted.");
			return;
		}
		
		for(int i=start; i<end; i++) {
			super.remove(start);
		}
		
		for (int i=0; i<ListDataListeners.size(); i++) {
			ListDataListeners.get(i).intervalRemoved(new ListDataEvent(this, ListDataEvent.INTERVAL_REMOVED, start, end));
		}
	}




	public void remove(E[] strs) {
		if((strs == null) || (strs.length == 0)){
			return;
		}
		
		int end = super.size();
		
		for(E str : strs) {
			super.remove(str);
		}
		
		for (int i=0; i<ListDataListeners.size(); i++) {
			ListDataListeners.get(i).contentsChanged(new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, end));
		}
	}
	
	
}
