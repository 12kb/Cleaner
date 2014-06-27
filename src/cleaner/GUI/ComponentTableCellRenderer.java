package cleaner.GUI;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import cleaner.ArrayListModel;
import cleaner.product.ProductRecord;

public class ComponentTableCellRenderer implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean cellHasFocus, int a, int b) {
		
		String name = ((ArrayListModel<ProductRecord>)table.getModel()).get(index).toString();
		
		return new ProductBanner(name);
	}
	
	
}
