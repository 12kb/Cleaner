package cleaner.GUI;

import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CheckBoxTreeLeaf extends JPanel {
	private JCheckBox box;
	private JLabel label;
	
	
	public boolean isSelected(){
		return box.isSelected();
	}
	public void setSelected(boolean s){
		box.setSelected(s);
	}
	
	
	public String getText(){
		return label.getText();
	}
	public void setText(String txt){
		label.setText(txt);
	}
	
	
	@Override
	public Dimension getMaximumSize(){
		Dimension label_max_dim = label.getMaximumSize();
		return new Dimension(label_max_dim.width + box.getMaximumSize().width, label_max_dim.height);
	}
	@Override
	public void setMaximumSize(Dimension dim){
		Dimension box_max_dim = box.getMaximumSize();
		box.setMaximumSize(new Dimension(box_max_dim.width, dim.height));
		label.setMaximumSize(new Dimension((dim.width - box_max_dim.width), dim.height));
	}
	
	
	@Override
	public String toString(){
		return label.getText();
	}
	
	public CheckBoxTreeLeaf(String name, boolean isSelected){
		label = new JLabel(name);
		box = new JCheckBox();
		box.setSelected(isSelected);
		
		LayoutManager lm = new BoxLayout(this, BoxLayout.LINE_AXIS);
		
		setLayout(lm);
		
		add(label);
		add(box);
	}
	
	
	public CheckBoxTreeLeaf(){
		this("",false);
	}
}
