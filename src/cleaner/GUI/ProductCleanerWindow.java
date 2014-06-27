package cleaner.GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import cleaner.ArrayListModel;
import cleaner.ArrayTableModel;
import cleaner.product.ProductRecord;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ProductCleanerWindow {

	private static JTable products_list;
	private static JTable install_list;
	
	public ProductCleanerWindow(ProductRecord[] prods, ProductRecord[] insts){
		JFrame window = new JFrame("Cleaner 0.01 beta");
		JPanel content = new JPanel(new BorderLayout(5, 5));
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//первый список
		products_list = createTable(prods);
		JScrollPane products_list_scrl = new JScrollPane(products_list);
		content.add(products_list_scrl, BorderLayout.WEST);
		
		products_list.setCellEditor(new ComponentTableCellEditor());
		
		// второй список
		install_list = createTable(insts);
		JScrollPane install_list_scrl = new JScrollPane(install_list);
		content.add(products_list_scrl, BorderLayout.WEST);
		
		// кнопки
		
		JButton toInstall = new JButton(">>");
		JButton toProducts = new JButton("<<");
		
		toInstall.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ProductCleanerWindow.moveSelectedProduct(ProductCleanerWindow.TO_INSTALL);
	        }
		});
		
		
		toProducts.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ProductCleanerWindow.moveSelectedProduct(ProductCleanerWindow.TO_PRODUCTS);
	        }
		});
		
		toInstall.setAlignmentX(Component.CENTER_ALIGNMENT);
		toInstall.setAlignmentY(Component.CENTER_ALIGNMENT);
		toProducts.setAlignmentX(Component.CENTER_ALIGNMENT);
		toProducts.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		JPanel buttonPanel = new JPanel();
		BoxLayout blay = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
		buttonPanel.setLayout(blay);
		buttonPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		buttonPanel.add(Box.createVerticalGlue());
		buttonPanel.add(toProducts);
		buttonPanel.add(toInstall);
		buttonPanel.add(Box.createVerticalGlue());
		
		// показываем
		content.add(install_list_scrl, BorderLayout.EAST);
		content.add(buttonPanel ,BorderLayout.CENTER);
		
		window.setContentPane(content);
		window.setSize(600,200);
		window.setVisible(true);	 
	}
	
	
	private static JTable createTable(ProductRecord products[]){
		ArrayTableModel tableModel = new ArrayTableModel();
		
		for(int i=0; i<products.length; i++){
			tableModel.add(products[i]);
		}
		
		JTable table = new JTable(tableModel);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setPreferredSize(new Dimension(150, 300));
		
		return table;
	}
	
	
	private static final int TO_INSTALL=1;
	private static final int TO_PRODUCTS=2;
	
	
	private static void moveSelectedProduct(int direction) {
		JTable from;
		JTable to;
		
		if (direction == TO_INSTALL){
			from = products_list;
			to = install_list;
		} else if (direction == TO_PRODUCTS) {
			from = install_list;
			to = products_list;
		} else {
			System.err.println("moveSelectedProduct: Ќеверное значение направлени€ перемещени€.");
			return;
		}
		
		
		ProductRecord value = (ProductRecord)(from.getValueAt(from.getSelectedRow(), from.getSelectedColumn()));
		if (value == null) {return;}
		removeFromList(from, value);
		addToList(to, value);
	}
	
	
	public static void addProduct(ProductRecord name){
		addToList(products_list, name);
	}
	
	
	public static void addInstall(ProductRecord name){
		addToList(install_list, name);
	}
	
	
	private static void addToList(JTable list, ProductRecord value){
		((ArrayListModel)list.getModel()).add(value);
	}
	
	
	private static void removeFromList(JTable list, ProductRecord value){
		((ArrayListModel)list.getModel()).remove(value);
	}
		
}
