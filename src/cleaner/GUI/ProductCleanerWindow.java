package cleaner.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ProductCleanerWindow {

	static JList products_list;
	static JList install_list;
	
	public ProductCleanerWindow(){
		JFrame window = new JFrame("Cleaner 0.01 beta");
		JPanel content = new JPanel(new BorderLayout(5, 5));
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//первый список
		DefaultListModel products = new DefaultListModel();
		
		products.addElement("NanoCAD 4.0");
		products.addElement("NanoCAD 4.5");
		products.addElement("NanoCAD 5.0");
		products.addElement("NanoCAD 5.1");
		products.addElement("NanoCAD 5.2");
		products.addElement("NanoCAD 5.3");
		
		products_list = new JList(products);
		
		products_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		products_list.setLayoutOrientation(JList.VERTICAL);
		products_list.setPreferredSize(new Dimension(150, 300));
		JScrollPane products_list_scrl = new JScrollPane(products_list);
		
		content.add(products_list_scrl, BorderLayout.WEST);
		 
		window.setContentPane(content);
		window.setSize(200,200);
		window.setVisible(true);	 
		
		// второй список
		DefaultListModel install = new DefaultListModel();
		
		install.addElement("MechaniCS 8.0");
		install.addElement("MechaniCS 8.1");
		install.addElement("MechaniCS 8.2");
		install.addElement("MechaniCS 8.3");
		install.addElement("MechaniCS 8.4");
		install.addElement("MechaniCS 8.5");
		
		install_list = new JList(install);
		
		install_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		install_list.setLayoutOrientation(JList.VERTICAL);
		install_list.setPreferredSize(new Dimension(150, 300));
		JScrollPane install_list_scrl = new JScrollPane(install_list);
		
		
		// кнопки
		
		JButton toRight = new JButton(">>");
		JButton toLeft = new JButton("<<");
		
		toRight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String value = (String)(products_list.getSelectedValue());
				if (value == null) {return;}
				DefaultListModel products = (DefaultListModel)(products_list.getModel());
				products.removeElement(value);
				
				DefaultListModel install = (DefaultListModel)(install_list.getModel());
				install.addElement(value);
	        }
		});
		
		
		toLeft.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String value = (String)(install_list.getSelectedValue());
				if (value == null) {return;}
				DefaultListModel install = (DefaultListModel)(install_list.getModel());
				install.removeElement(value);
				
				DefaultListModel products = (DefaultListModel)(products_list.getModel());
				products.addElement(value);
	        }
		});
		
		JPanel buttonPanel = new JPanel();
		BoxLayout blay = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
		buttonPanel.setLayout(blay);
		
		buttonPanel.add(toLeft);
		buttonPanel.add(toRight);
		
		// показываем
		content.add(install_list_scrl, BorderLayout.EAST);
		content.add(buttonPanel ,BorderLayout.CENTER);
		
		window.setContentPane(content);
		window.setSize(600,200);
		window.setVisible(true);	 
	}
	
}
