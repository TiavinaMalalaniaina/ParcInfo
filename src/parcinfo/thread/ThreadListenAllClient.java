package parcinfo.thread;

import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.util.Vector;

import parcinfo.socket.server.*;

public class ThreadListenAllClient extends Thread {
//	FIELDS
	ParcInfoServerBeta pisb;
	
	
//	CONSTRUCTOR
	public ThreadListenAllClient(ParcInfoServerBeta pisb) {
		setPisb(pisb);
	}
	
	
//	GETTER
	public ParcInfoServerBeta getPisb() {
		return pisb;
	}
	
//	SETTER
	public void setPisb(ParcInfoServerBeta pisb) {
		this.pisb = pisb;
	}
	 
//	THREAD
	public void run() {
		try {
			while(true) {
				for(String message : readAllMessage()) {
					System.out.println(message);
				}
				System.out.println(pisb.getIns().size()+" personne connecté");
				Thread.sleep(5000);
			}
		} catch(IOException | InterruptedException e) {
			
		}
	}
	
	
//	UTIL
//	MESSAGE
//		READ MESSAGE FROM CLIENT
		
	
		public String readMessage(DataInputStream in, DataOutputStream out) throws IOException {
			String line = "nbOctet:"+out.size()+";;m:";
			while(in.available()>0) {
				line = line.concat(in.readUTF());
			}
			return line;
		}
		
	//	READ MESSAGE FROM All CLIENT
		public String[] readAllMessage() throws IOException {
			Vector<DataInputStream> ins = pisb.getIns();
			Vector<DataOutputStream> outs = pisb.getOuts();
			String[] line = new String[ins.size()];
			for (int i=0 ; i < line.length ; i++) {
				line[i] = readMessage(ins.get(i), outs.get(i));
			}
			return line;
		}

	
	
}
