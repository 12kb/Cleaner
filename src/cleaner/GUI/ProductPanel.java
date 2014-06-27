package cleaner.GUI;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import cleaner.product.ProductRecord;

@SuppressWarnings("serial")
public class ProductPanel extends JPanel implements Observer {
	
	private ProductRecord product;
	
	private JCheckBox checkbox;
	private JLabel label;
	private JTextArea txt;
	
	public ProductPanel(ProductRecord product){
		if (product != null){
			this.product = product;
			this.update(product, null);
		}
		//TODO: расположить все на панели
	}
	
	public void update(Observable o, Object arg){
		if (checkbox == null){
			checkbox = new JCheckBox();
		}
		
		if (label == null){
			label = new JLabel();
		}
		label.setText("abc"/*TODO product.getName()*/);
		label.setIcon(null /*TODO product.getIcon()*/);
		
		if (txt == null){
			txt = new JTextArea();
		}
		txt.setText(null /*TODO product.getInfo*/);
	}
	
	
}
