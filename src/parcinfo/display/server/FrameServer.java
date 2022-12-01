package parcinfo.display.server;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.GridLayout;

import parcinfo.display.server.panel.PanelInfo;

public class FrameServer extends SettingFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameServer() {
		super(1000,800);
		GridLayout gl = new GridLayout(6,1);
		gl.setVgap(10);
		this.setLayout(gl);
		this.add(new PanelInfo());
		this.add(new PanelInfo());
	}
	public static void main(String[] args) {
		new FrameServer();
	}
	
}
