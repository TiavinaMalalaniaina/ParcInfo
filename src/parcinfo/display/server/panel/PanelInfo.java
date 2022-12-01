package parcinfo.display.server.panel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;

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
		this.setBackground(new Color(14,209,69));
		this.setLayout(new FlowLayout());
		this.add(insertImage("laptop.png"));
		this.paint(getGraphics());
	}
	
	public JLabel insertImage(String imgName) {
//		String imgURL = "../../../assets/".concat(imgName);
		String imgURL = "../../../assets/laptop.png";
		ImageIcon icon = new ImageIcon(imgURL);
		JLabel jlabel = new JLabel(icon, JLabel.CENTER);
		jlabel.setSize(200,200);
		jlabel.setBackground(Color.BLACK);
		return jlabel;
	}
	
	public void paint(Graphics2D g2d) {
		g2d.fillRect(50, 50, 700, 100);
	}
}
