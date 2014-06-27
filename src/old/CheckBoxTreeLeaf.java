package old;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ItemListener;

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
	
	
	public void addItemListener(ItemListener listener){
		box.addItemListener(listener);
	}
	
	
	@Override
	public String toString(){
		//System.out.println(getComponent(0).toString() + "\n" + getComponent(1).toString());
		return label.getText();
	}
	
	public void setSize(Dimension d){
		this.getComponent(0).setSize(d);
	}
	
	
	@Override
	public void setBackground(Color bg){
		super.setBackground(bg);
		if (label != null) label.setBackground(bg);
		if (box != null) box.setBackground(bg);
	}
	
	
	public CheckBoxTreeLeaf(String name, boolean isSelected){
		super();
		label = new JLabel(name);
		box = new JCheckBox();
		box.setSelected(isSelected);
		
		LayoutManager lm = new BorderLayout();
		
		setLayout(lm);
		
		label.setOpaque(true);
		box.setOpaque(true);
		
		add(label,BorderLayout.WEST);
		add(box,BorderLayout.EAST);
	}

	
	public CheckBoxTreeLeaf(){
		this("",false);
	}
}
