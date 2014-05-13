package cleaner.GUI;

import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ProductTreeNode extends JComponent {
	
//data
	private String name;
	public String getName(){
		return this.name;
	}
	
	
	private boolean selected;
	public boolean isSelected(){
		return selected;
	}
	
	
	protected static Dimension size = new Dimension(0,0);	
	
	JCheckBox box;
	
//constructors
	public ProductTreeNode(String _name, boolean _selected){
		super();
		
		LayoutManager lm = new BoxLayout(this, BoxLayout.LINE_AXIS);
		setLayout(lm);
		
		this.name = _name;
		this.selected = _selected;
		
		JLabel label = new JLabel(name, JLabel.LEFT);

		if (label.getMaximumSize().width > size.width){
			size = label.getMaximumSize();
		} else {
			label.setMaximumSize(size);
		}
		label.setMinimumSize(size);
		label.setSize(size);
		this.add(label);
		
		box = new JCheckBox();
		box.setSelected(_selected);
		this.add(box);
	}
	
	
	
//methods	
	@Override
	public String toString(){
		return name;
	}
	
}
