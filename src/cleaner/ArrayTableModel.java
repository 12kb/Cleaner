package cleaner;

import java.util.ArrayList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class ArrayTableModel<E> extends ArrayList<E> implements TableModel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 890948145236404619L;
	
	
	
	
	
	private ArrayList<TableModelListener> tableModelListeners;
	
	
	
	
	public boolean isCellEditable(int a, int b) {
		return true;
	}
	
	
	
	
	public ArrayTableModel() {
		super();
		tableModelListeners = new ArrayList<TableModelListener>();
	}
	
	
	
	
	
	@Override
	public int getColumnCount() {
		return 1;
	}
	
	
	
	
	
	@Override
	public int getRowCount() {
		return this.size();
	}
	
	
	
	
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return this.get(0).getClass();
	}
	
	
	
	
	
	@Override
	public String getColumnName(int columnIndex) {
		return "123";
	}
	
	
	
	
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		if (columnIndex != 0) {
			System.err.println("There is only one column");
		}
		
		return this.get(rowIndex);
	
	}


	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void setValueAt(Object value ,int rowIndex, int columnIndex) {
		
		if (columnIndex != 0) {
			System.err.println("There is only one column");
		}
		
		this.set(rowIndex, (E)value);
		
	}
	
	
	
	
	
	@Override
	public void addTableModelListener(TableModelListener l) {
		tableModelListeners.add(l);
	}
	
	
	
	
	
	@Override
	public void removeTableModelListener(TableModelListener l) {
		tableModelListeners.remove(l);
	}

	
	
	
	
	
	@Override
	public boolean add(E obj) {
		
		if (obj == null){
			return false;
		}
		
		boolean result = super.add(obj);
		
		for (int i=0; i<tableModelListeners.size(); i++) {
			tableModelListeners.get(i).tableChanged(new TableModelEvent(this, this.size()-1,
											this.size(), 0, TableModelEvent.INSERT));
		}
		
		return result;
	}
	
	
	
	
	
	
	@Override 
	public void add(int index, E obj) {
		
		if (obj == null) {
			System.err.println("Index out of bounds");
			return;
		}
		
		if ((index < 0) || (index >= this.size())) {
			System.err.println("Index out of bounds");
			return;
		}
		
		super.add(index, obj);
		// TODO: Add more specific Table Model Events
		for (int i=0; i<tableModelListeners.size(); i++) {
			tableModelListeners.get(i).tableChanged(new TableModelEvent(this));
		}
	}
	
	
	
	public void add(E[] objs) {
		if((objs == null) || (objs.length == 0)){
			return;
		}
		// TODO: Add more specific Table Model Events
		//int start_index = super.size(); 
		
		for (E obj : objs) {
			super.add(obj);
		}
		
		for (int i=0; i<tableModelListeners.size(); i++) {
			tableModelListeners.get(i).tableChanged(new TableModelEvent(this));
		}
		
	}
	
	
	
	
	@Override
	public E remove(int index) {
		
		if ((index < 0) || (index >= this.size())) {
			System.err.println("Index out of bounds");
			return null;
		}
		// TODO: Add more specific Table Model Events
		E result = super.remove(index);
		
		for (int i=0; i<tableModelListeners.size(); i++) {
			tableModelListeners.get(i).tableChanged(new TableModelEvent(this));
		}
		
		return result;
	}
	
	
	
	
	
	@Override
	public boolean remove(Object o) {
		
		if (o == null) {
			return false;
		}
		// TODO: Add more specific Table Model Events
		//int index = super.indexOf(o);
		
		boolean result = super.remove(o);
		
		for (int i=0; i<tableModelListeners.size(); i++) {
			tableModelListeners.get(i).tableChanged(new TableModelEvent(this));
		}
		
		return result;
	
	}
	
	
	
	
	
	@Override
	public void clear() {
		// TODO: Add more specific Table Model Events
		int index = super.size();
		
		super.clear();
		
		for (int i=0; i<tableModelListeners.size(); i++) {
			tableModelListeners.get(i).tableChanged(new TableModelEvent(this));
		}
		
	}
	




	public void remove(int start, int end) {
		if ( (start < 0) || (start >= this.size()) || (end < 0) || (end >= this.size()) || (start >= end) ) {
			System.err.println("Wrong indexes. Removing is aborted.");
			return;
		}
		// TODO: Add more specific Table Model Events
		for(int i=start; i<end; i++) {
			super.remove(start);
		}
		
		for (int i=0; i<tableModelListeners.size(); i++) {
			tableModelListeners.get(i).tableChanged(new TableModelEvent(this));
		}
	}




	public void remove(E[] strs) {
		if((strs == null) || (strs.length == 0)){
			return;
		}
		// TODO: Add more specific Table Model Events
		//int end = super.size();
		
		for(E str : strs) {
			super.remove(str);
		}
		
		for (int i=0; i<tableModelListeners.size(); i++) {
			tableModelListeners.get(i).tableChanged(new TableModelEvent(this));
		}
	}
	
}
