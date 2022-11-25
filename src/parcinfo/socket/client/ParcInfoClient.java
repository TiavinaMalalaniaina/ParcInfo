package parcinfo.socket.client;

import java.net.Socket;
import java.net.UnknownHostException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import parcinfo.util.SystemInfo;

public class ParcInfoClient {
//  FIELDS
	Socket socket 					= null;
	DataInputStream inputStream 	= null;
	DataOutputStream outputStream 	= null;
	
//  CONSTRUCTORS
	public ParcInfoClient() {}
	
	
//	GETTER
	public Socket getSocket() {
		return socket;
	}
	public DataInputStream getInputStream() {
		return inputStream;
	}
	public DataOutputStream getOutputStream() {
		return outputStream;
	}
	
	
//	SETTER
	public void setSocket(Socket socket) {
		this.socket=socket;
	}
	public void setInputStream(DataInputStream inputStream) {
		this.inputStream = inputStream;
	}
	public void setOutputStream(DataOutputStream outputStream) {
		this.outputStream = outputStream;
	}


//  CONNECTION TO SERVER
//		CONNECT TO SERVER
		public void connectServer(String address, int port) throws IOException, UnknownHostException{
			setSocket(new Socket(address, port));
			setInputStream(new DataInputStream(System.in));
			setOutputStream(new DataOutputStream(getSocket().getOutputStream()));
		}
		
//		DISCONNECT FROM SERVER
		public void disconnectServer() throws IOException{
			getSocket().close();
			getInputStream().close();
			getOutputStream().close();
		}
	
	
//	MESSAGE
//		READ MESSAGE FROM SERVER
		public String readMessage() throws IOException {
			String line = getInputStream().readUTF();
			return line;
		}
		
//		WRITE MESSAGE TO SERVER
		public void writeMessage(String message) throws IOException{
			getOutputStream().writeUTF(message);	
		}
		
		
	public static void main(String[] args) {
		try {
			ParcInfoClient pc = new ParcInfoClient();
			pc.connectServer("localhost", 1236);
			System.out.println("Sending message");
			SystemInfo si = new SystemInfo();
			pc.writeMessage(si.getAllInfo());
			pc.disconnectServer();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
