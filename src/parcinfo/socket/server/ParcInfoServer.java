
package parcinfo.socket.server;


import java.net.Socket;
import java.net.ServerSocket;

import java.io.IOException;
import java.io.DataInputStream;
import java.io.BufferedInputStream;
/*
 * The server class
 */
public class ParcInfoServer {
// FIELDS
	int port;
	Socket socket 				= null;
	ServerSocket server 		= null;
	DataInputStream inputStream = null;

// CONSTRUCTORS
	public ParcInfoServer(int port) throws IOException{
		setPort(port);
		setServer(new ServerSocket(port));
	}
	
	
// GETTER
	public int getPort() {
		return port;
	}
	public Socket getSocket() {
		return socket;
	}
	public ServerSocket getServer() {
		return server;
	}
	public DataInputStream getInputStream() {
		return inputStream;
	}
	
	
// SETTER
	public void setPort(int port) {
		this.port = port;
	}
	public void setSocket(Socket socket) {
		this.socket=socket;
	}
	public void setServer(ServerSocket server) {
		this.server = server;
	}
	public void setInputStream(DataInputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	
// 	SERVER
// 		OPEN THE SERVER
		public void openServer() throws IOException{
			setSocket(getServer().accept());
			setInputStream(
				new DataInputStream(
					new BufferedInputStream(getSocket().getInputStream())
			));
		}
		
	
// 		CLOSE THE SERVER
		public void closeServer() throws IOException{
			getSocket().close();
			getInputStream().close();
		}
	
	
		
//	MESSAGE
//		READ MESSAGE FROM CLIENT
		public String readMessage() throws IOException {
			String line = getInputStream().readUTF();
			return line;
		}
	

	
	public static void main(String[] args) {
		try {
			ParcInfoServer ss = new ParcInfoServer(1236);
			try {
				System.out.println("Waiting for client:");
				while (true) {
					ss.openServer();
					System.out.println(ss.readMessage());
					ss.closeServer();
					Thread.sleep(5000);
					System.out.println();
					System.out.println();
				}
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
