package parcinfo.display.server;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import parcinfo.display.server.panel.SettingPanel;
import parcinfo.display.server.panel.TablePanelInfo;

import parcinfo.socket.server.ParcInfoServerBeta;

public class FrameServer extends JFrame {
	/**
	 * 
	 */
//	FIELDS
	ParcInfoServerBeta pisb;
	private static final long serialVersionUID = 1L;

//	CONSTRUCTOR
	public FrameServer(ParcInfoServerBeta pisb) {
		setPisb(pisb);
		getPisb().start();
		setSize(1000, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(new SettingPanel(), BorderLayout.WEST);
		add(new TablePanelInfo(getPisb()), BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		try{
			FrameServer fs = new FrameServer(new ParcInfoServerBeta(4444));
			fs.setVisible(true);
		} catch(Exception e) {
			
		}
	}
	
//	GETTER
	public ParcInfoServerBeta getPisb() {
		return pisb;
	}
	
//	SETTER
	public void setPisb(ParcInfoServerBeta pisb) {
		this.pisb = pisb;
	}
}
