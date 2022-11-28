package parcinfo.display.server.panel;

import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;


public class PanelInfo extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelInfo() {
		super();
		this.setBackground(Color.RED);
		this.setLayout(new BorderLayout());
		this.add(insertImage("laptop.png"), BorderLayout.WEST);
	}
	
	public JLabel insertImage(String imgName) {
		String imgURL = "../../../assets/".concat(imgName);
		ImageIcon icon = new ImageIcon(imgURL);
		JLabel jlabel = new JLabel(icon, JLabel.CENTER);
		return jlabel;
	}
}
