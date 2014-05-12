package cleaner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cleaner.GUI.*;

public class Main extends JFrame {
	
	public Main(){
		super ("Test");
		this.setSize(200, 200);
		JPanel content = new JPanel();
		content.add(new JButton());
		this.setContentPane(content);
	}
	
	public static void main(String[] args){
		Main frame = new Main();
		frame.setDefaultLookAndFeelDecorated(true);
		frame.setVisible(true);
	}
	
}
