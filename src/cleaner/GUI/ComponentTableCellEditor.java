package cleaner.GUI;

import java.awt.Component;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

import cleaner.ArrayListModel;
import cleaner.product.ProductRecord;

public class ComponentTableCellEditor implements TableCellEditor {

	ArrayList<CellEditorListener> listeners;
	
	
	
	public ComponentTableCellEditor() {
		listeners = new ArrayList<>();
	}
	
	
	
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int a, int b) {
		
		String name = ((ArrayListModel<ProductRecord>)table.getModel()).get(index).toString();
		
		return new ProductBanner(name);
	}
	
	
	
	
	@Override
	public void addCellEditorListener(CellEditorListener l) {
		listeners.add(l);
	}
	
	
	
	
	@Override
	public Object getCellEditorValue() {
		return new ProductBanner("Пися Камушкин");
	}
	
	
	
	
	@Override
	public void removeCellEditorListener(CellEditorListener l) {
		listeners.remove(l);
	}
	
	
	
	
	@Override
	public boolean shouldSelectCell(EventObject anEvent) {
		return false;
	}
	
	
	
	
	@Override
 	public void cancelCellEditing() {
		
	}
	
	
	
	
	@Override
	public boolean stopCellEditing() {
		return true;
	}
	
	
}
