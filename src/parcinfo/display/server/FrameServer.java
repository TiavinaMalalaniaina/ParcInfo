package parcinfo.display.server;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import parcinfo.display.server.panel.PanelInfo;

public class FrameServer extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameServer() {
		super("Le Server");
		this.setSize(1000,800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.add(new PanelInfo(), BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new FrameServer();
	}
}
