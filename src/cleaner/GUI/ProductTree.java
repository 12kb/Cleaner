package cleaner.GUI;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class ProductTree extends Box {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4056079862863534806L;


	public ProductTree(String lable){
		super(BoxLayout.X_AXIS);
		setOpaque(true);
		this.add(new JButton(lable));
	}

	
}
