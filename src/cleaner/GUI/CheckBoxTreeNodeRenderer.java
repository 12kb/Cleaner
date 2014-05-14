package cleaner.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;


public class CheckBoxTreeNodeRenderer implements TreeCellRenderer {
		
	private CheckBoxTreeLeaf leafRenderer;
	
	private DefaultTreeCellRenderer nonLeafRenderer = new DefaultTreeCellRenderer();

	Color selectionBorderColor, selectionForeground, selectionBackground,
			textForeground, textBackground;


	public CheckBoxTreeNodeRenderer() {
		leafRenderer = new CheckBoxTreeLeaf();
		
		Font fontValue;
		fontValue = UIManager.getFont("Tree.font");
		if (fontValue != null) {
			leafRenderer.setFont(fontValue);
		}

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
		
		if (leaf) {
			
			Object d = ((DefaultMutableTreeNode)value).getUserObject();
			CheckBoxTreeNode node = (CheckBoxTreeNode) d;
			
			if (selected) {
				leafRenderer.setForeground(selectionForeground);
				leafRenderer.setBackground(selectionBackground);
			} else {
				leafRenderer.setForeground(textForeground);
				leafRenderer.setBackground(textBackground);
			}
			
			leafRenderer.setText(node.name);
			leafRenderer.setSelected(node.checked);
			
			leafRenderer.setMaximumSize(new Dimension(200,leafRenderer.getMaximumSize().height));
			leafRenderer.setSize(new Dimension(200,leafRenderer.getMaximumSize().height));
			
			leafRenderer.toString();
			
			return leafRenderer;	
		}
			return nonLeafRenderer.getTreeCellRendererComponent(tree,
					value, selected, expanded, leaf, row, hasFocus);
	}
}
