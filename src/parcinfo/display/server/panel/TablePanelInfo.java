package parcinfo.display.server.panel;

import java.awt.Color;

import java.util.Vector;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import parcinfo.socket.server.ParcInfoServerBeta;

public class TablePanelInfo extends JScrollPane {
//	FIELDS
	ParcInfoServerBeta pisb;
	JTable tableInfo;

//	CONSTRUCTOR
	public TablePanelInfo(ParcInfoServerBeta pisb) {
		setSize(800,800);
		String[] colNames = {"OS", "MaxMemory", "FreeMemory", "UsingMemory"};
		setPisb(pisb);
		try {
			String[][] data = getPisb().getAllDonne();
			JTable tableInfo = new JTable(data, colNames);
			tableInfo.setBackground(Color.RED);
			setTableInfo(tableInfo);
			this.setViewportView(tableInfo);
		} catch(IOException e) { 
			e.printStackTrace();
		}
	}
	
//	GETTER
	public JTable getTableInfo() {
		return tableInfo;
	}
	public ParcInfoServerBeta getPisb() {
		return pisb;
	}
	
//	SETTER
	public void setTableInfo(JTable tableInfo) {
		this.tableInfo = tableInfo;
	}
	public void setPisb(ParcInfoServerBeta pisb) {
		this.pisb = pisb;
	}
	
}
 