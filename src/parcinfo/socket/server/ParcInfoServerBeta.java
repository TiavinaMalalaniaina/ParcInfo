package parcinfo.socket.server;

import java.net.Socket;
import java.net.ServerSocket;

import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.util.Vector;

import parcinfo.thread.ThreadSearchClient;
import parcinfo.thread.ThreadListenAllClient;

public class ParcInfoServerBeta {
//	FIELDS
	int port;
	ServerSocket server;
	Vector<Socket> sockets;
	Vector<DataInputStream> ins;
	Vector<DataOutputStream> outs;
	
//	CONSTRUCTOR
	public ParcInfoServerBeta(int port) throws IOException{
		setPort(port);
		setSockets(new Vector<Socket>());
		setServer(new ServerSocket(port));
		setIns(new Vector<DataInputStream>());
		setOuts(new Vector<DataOutputStream>());
	}
	
	
//	GETTER
	public int getPort() {
		return port;
	}
	public ServerSocket getServer() {
		return server;
	}
	public Vector<Socket> getSockets() {
		return sockets;
	}
	public Vector<DataInputStream> getIns() {
		return ins;
	}
	public Vector<DataOutputStream> getOuts() {
		return outs;
	}
	
//	SETTER
	public void setPort(int port) {
		this.port = port;
	}
	public void setServer(ServerSocket server) {
		this.server = server;
	}
	public void setSockets(Vector<Socket> sockets) {
		this.sockets = sockets;
	}
	public void setIns(Vector<DataInputStream> ins) {
		this.ins = ins;
	}
	public void setOuts(Vector<DataOutputStream> outs) {
		this.outs = outs;
	}
	
	
//	CONNECTION SERVER TO CLIENT
	public void openConnection() throws IOException{
		Socket socket = getServer().accept();
		getSockets().add(socket);
		getIns().add(new DataInputStream(socket.getInputStream()));
		getOuts().add(new DataOutputStream(socket.getOutputStream()));
	}
	
	public void closeConnection() throws IOException {
		
	}
	
	
	
	
	
//	MAIN
	public static void main(String[] args) {
		try {
			ParcInfoServerBeta pisb = new ParcInfoServerBeta(4444);
			System.out.println(pisb.getServer());
			ThreadSearchClient tsc = new ThreadSearchClient(pisb);
			ThreadListenAllClient tlc = new ThreadListenAllClient(pisb);
			tsc.start();
			tlc.start();
		} catch(Exception e) {
			
		}
	}
 	
}
