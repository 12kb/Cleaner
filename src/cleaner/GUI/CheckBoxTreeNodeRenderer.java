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
	public CheckBoxTreeLeaf getLeafRenderer(){
		return leafRenderer;
	}
	
	
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
			
			CheckBoxTreeNode node = null;
			
			if (value != null){
				Object d = ((DefaultMutableTreeNode)value).getUserObject();
				node = (CheckBoxTreeNode) d;
			}else{
				System.out.println("CheckBoxTreeNodeRenderer.getTreeCellRendererComponent : Object arg is null");
			}
				
			if (selected) {
				leafRenderer.setForeground(selectionForeground);
				leafRenderer.setBackground(selectionBackground);
				//leafRenderer.setBorder(new Border());
			} else {
				leafRenderer.setForeground(textForeground);
				leafRenderer.setBackground(textBackground);
			}
			
			leafRenderer.setText(node.name);
			leafRenderer.setSelected(node.checked);
			//TODO протащить размер из дерева
			leafRenderer.setPreferredSize(new Dimension(200, leafRenderer.getPreferredSize().height));
			
			leafRenderer.toString();
			
			return leafRenderer;	
		}
			return nonLeafRenderer.getTreeCellRendererComponent(tree,
					value, selected, expanded, leaf, row, hasFocus);
	}
}
