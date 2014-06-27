package cleaner.GUI;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

import cleaner.ArrayListModel;
import cleaner.product.ProductRecord;

public class MyListCellRenderer implements ListCellRenderer {
	
	public Component getListCellRendererComponent(JList list, Object value, int index,
		      boolean isSelected, boolean cellHasFocus) {
		
		String name = ((ArrayListModel<ProductRecord>)list.getModel()).get(index).toString();
		
		return new ProductBanner(name);
	}
	
}
