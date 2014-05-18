package cleaner;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import cleaner.GUI.CheckBoxTreeCellEditor;
import cleaner.GUI.CheckBoxTreeNode;
import cleaner.GUI.CheckBoxTreeNodeRenderer;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8448897269097008357L;

	public Main() {

		super("Test");
		this.setSize(500, 200);

		Object[] obj = { new CheckBoxTreeNode("Hello", false),
				new CheckBoxTreeNode("Loger line", true),
				new CheckBoxTreeNode("The longggest line", true),
				new CheckBoxTreeNode("short line", true) };
		
		Vector<Object> elements = new Vector<Object>();
		for (int i = 0; i < obj.length; i++) {
		      elements.add(obj[i]);
		}
		
		Vector<Object> root = new Vector<>();
		root.add(elements);
		
		JTree tree = new JTree(root);
		tree.setCellRenderer(new CheckBoxTreeNodeRenderer());
		tree.setCellEditor(new CheckBoxTreeCellEditor(tree));
		tree.setEditable(true);
		
		/*JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));

		content.add(new ProductTreeNode("Hello", false));
		content.add(new ProductTreeNode("Loger line", true));
		content.add(new ProductTreeNode("The longggest line", true));
		content.add(new ProductTreeNode("short line", true));

		this.setContentPane(content);*/
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout(5,5));
		content.add(tree, BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane(tree);
		content.add(scrollPane, BorderLayout.CENTER);
		content.add(new JButton("Hello"),BorderLayout.EAST);
		this.setContentPane(content);
	}

	public static void main(String[] args) {
		Main frame = new Main();
		Main.setDefaultLookAndFeelDecorated(true);
		frame.setVisible(true);
	}

}
