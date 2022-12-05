package parcinfo.thread;

import java.io.IOException;
import java.io.DataOutputStream;
import java.io.DataInputStream;

import java.net.*;

import parcinfo.socket.server.*;


public class ThreadSearchClient extends Thread {
//	FIELDS
	ParcInfoServerBeta parcInfoServer;
	
	
//	CONSTRUCTOR
	public ThreadSearchClient(ParcInfoServerBeta parcInfoServer) {
		setParcInfoServer(parcInfoServer);
	}
	
	
//	GETTER
	public ParcInfoServerBeta getParcInfoServer() {
		return parcInfoServer;
	}
	
//	SETTER
	public void setParcInfoServer(ParcInfoServerBeta parcInfoServer) {
		this.parcInfoServer = parcInfoServer;
	}
	
	
//	THREADING
	public void run() {
		try {
//			while(true) {
				ParcInfoServerBeta pisb = getParcInfoServer();
				System.out.println("Searching...");
				Socket socket= pisb.getServer().accept();
				DataInputStream in = new DataInputStream(socket.getInputStream());
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				pisb.getSockets().add(socket);
				pisb.getIns().add(in);
				pisb.getOuts().add(out);
				System.out.println("Connected");
				ThreadListenOneClient tloc = new ThreadListenOneClient(socket, out, in);
				tloc.start();
				ThreadSearchClient tsc = new ThreadSearchClient(pisb);
				tsc.start();
//			}
		} catch (IOException e) {
			
		}
	}
}
