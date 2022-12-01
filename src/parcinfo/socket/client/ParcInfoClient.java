package parcinfo.socket.client;

import java.net.Socket;
import java.util.Scanner;
import java.net.UnknownHostException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import parcinfo.util.SystemInfo;

public class ParcInfoClient extends Thread{
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
			setInputStream(new DataInputStream(getSocket().getInputStream()));
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
			String line = "";
			while(getInputStream().available()>0) {
				line = line.concat(getInputStream().readUTF());
			}
			return line;
		}
		
//		WRITE MESSAGE TO SERVER
		public void writeMessage(String message) throws IOException{
			getOutputStream().writeUTF(message);	
			getOutputStream().flush();
		}
		
		
//		REINIT MESSAGE
		
		
		
//	THREADING
//		THREAD TO SEND A MES SAGE
		public void run() {
			Scanner sc = new Scanner(System.in);
			try {
				ParcInfoClient pc = new ParcInfoClient();
				try {
					String m = "Tiavina";
					pc.connectServer("localhost", 4444);
					while (true) {
						System.out.print("----->");
						SystemInfo si = new SystemInfo();
						System.out.println(m+" "+si.getAllInfo());
						pc.writeMessage(m+" "+si.getAllInfo());
						Thread.sleep(2000);
					}
				} catch(IOException e) {
					pc.disconnectServer();
					e.printStackTrace();
				}
			} catch(Exception e) {
				sc.close();
				e.printStackTrace();
			}
		}
		
		
	public static void main(String[] args) {
		try {
			System.out.println("Sending message");
			ParcInfoClient pc = new ParcInfoClient();
			pc.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
