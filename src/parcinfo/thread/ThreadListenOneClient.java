package parcinfo.thread;

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

import java.net.Socket;


public class ThreadListenOneClient extends Thread {

//	FIELDS
	Socket socket;
	DataOutputStream out;
	DataInputStream in;
	
//	CONSTRUCTOR
	public ThreadListenOneClient(Socket socket, DataOutputStream out, DataInputStream in) throws IOException{
		setSocket(socket);
		setOut(out);
		setIn(in);
	}
	

//	GETTER
	public Socket getSocket() {
		return socket;
	}
	public DataOutputStream getOut() {
		return out;
	}
	public DataInputStream getIn() {
		return in;
	}
	
//	SETTER
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public void setOut(DataOutputStream out) {
		this.out = out;
	}
	public void setIn(DataInputStream in) {
		this.in = in;
	}
	
//	MESSAGE 
	public String readMessage() throws IOException {
		String line = getIn().readUTF();
		return line;
	}
	public void writeMessage(String message) throws IOException {
		getOut().writeUTF(message);
	}
	
//	THREAD
	public void run() {
		try {
			while (true) {
				String message = readMessage();
				writeMessage(message);
//				System.out.println("Message:"+message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
