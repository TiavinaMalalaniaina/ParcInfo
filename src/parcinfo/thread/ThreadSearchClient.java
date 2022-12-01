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
			while(true) {
				ParcInfoServerBeta pisb = getParcInfoServer();
				System.out.println("Searching...");
				Socket socket= pisb.getServer().accept();
				ThreadListenOneClient tloc = new ThreadListenOneClient(socket);
				pisb.getSockets().add(socket);
				tloc.run();
				System.out.println("Connected");
			}
		} catch (IOException e) {
			
		}
	}
}
