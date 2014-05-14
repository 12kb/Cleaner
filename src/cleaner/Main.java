package cleaner;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTree;

import cleaner.GUI.CheckBoxTreeNode;
import cleaner.GUI.CheckBoxTreeNodeRenderer;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8448897269097008357L;

	public Main() {

		super("Test");
		this.setSize(200, 200);

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
		
		/*JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));

		content.add(new ProductTreeNode("Hello", false));
		content.add(new ProductTreeNode("Loger line", true));
		content.add(new ProductTreeNode("The longggest line", true));
		content.add(new ProductTreeNode("short line", true));

		this.setContentPane(content);*/
		
		this.add(tree);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Main frame = new Main();
		//Main.setDefaultLookAndFeelDecorated(true);
	}

}
