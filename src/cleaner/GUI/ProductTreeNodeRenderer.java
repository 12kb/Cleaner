package cleaner.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;


public class ProductTreeNodeRenderer implements TreeCellRenderer {
		
	private CheckBoxTreeLeaf leafRenderer;
	protected JPanel getLeafRenderer() {
		return leafRenderer;
	}
	
	private DefaultTreeCellRenderer nonLeafRenderer = new DefaultTreeCellRenderer();

	Color selectionBorderColor, selectionForeground, selectionBackground,
			textForeground, textBackground;


	public ProductTreeNodeRenderer() {
		leafRenderer = new CheckBoxTreeLeaf();
		
		
		
		Font fontValue;
		fontValue = UIManager.getFont("Tree.font");
		if (fontValue != null) {
			leafRenderer.setFont(fontValue);
		}
		
		Boolean booleanValue = (Boolean) UIManager
				.get("Tree.drawsFocusBorderAroundIcon");
		leafRenderer.setFocusPainted((booleanValue != null)
				&& (booleanValue.booleanValue()));

		selectionBorderColor = UIManager.getColor("Tree.selectionBorderColor");
		selectionForeground = UIManager.getColor("Tree.selectionForeground");
		selectionBackground = UIManager.getColor("Tree.selectionBackground");
		textForeground = UIManager.getColor("Tree.textForeground");
		textBackground = UIManager.getColor("Tree.textBackground");
	}

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean selected, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		
		Component returnValue;
		if (leaf) {
			
			Object d = ((DefaultMutableTreeNode)value).getUserObject();
			CheckBoxTreeNode node = (CheckBoxTreeNode) d;
			
			if (selected) {
				node.setForeground(selectionForeground);
				node.setBackground(selectionBackground);
			} else {
				node.setForeground(textForeground);
				node.setBackground(textBackground);
			}
			
			node.label.setMaximumSize(CheckBoxTreeNode.size);

			returnValue = node;	
		} else {
			returnValue = nonLeafRenderer.getTreeCellRendererComponent(tree,
					value, selected, expanded, leaf, row, hasFocus);
		}
		return returnValue;
	}
}
