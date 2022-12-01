package parcinfo.display.server;

import java.awt.GridLayout;

import javax.swing.JFrame;


public class SettingFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SettingFrame(int width, int height) {
		super();
		this.setSize(width,height);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	
	public void addGridLayout(int rows, int cols, int hgap, int vgap) {
		GridLayout gl = new GridLayout(rows, cols, hgap, vgap);
		this.setLayout(gl);
	}
	
}
