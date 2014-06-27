package cleaner.GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ProductBanner extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8468608100680861626L;
	
	
	ProductBanner(String name) {
		JButton button = new JButton(name);
		button.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("beeep");
			}
		});
		
		//button.setMinimumSize(new Dimension (120, 40));
		//button.setPreferredSize(new Dimension (120, 40));
		
		this.setMinimumSize(new Dimension (120, 40));
		this.setPreferredSize(new Dimension (120, 40));
		
		this.add(button);
	}
	
}
