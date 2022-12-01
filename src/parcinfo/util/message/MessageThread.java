package parcinfo.util.message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class MessageThread extends Thread {
//	FIELDS
	DataInputStream in;
	DataOutputStream out;
	
//	CONSTRUCTOR
	public MessageThread(DataInputStream in, DataOutputStream out) {
		setIn(in);
		setOut(out);
	}
	
	
//	GETTER
	public DataInputStream getIn() {
		return in;
	}
	public DataOutputStream getOut() {
		return out;
	}
	
	
//	SETTER
	public void setIn(DataInputStream in) {
		this.in = in;
	}
	public void setOut(DataOutputStream out) {
		this.out = out;
	}
	
	
//	MESSAGE
//		WRITE	
		public void writeMessage(String message) throws IOException{
			this.getOut().writeUTF(message);
		}
		
//		READ
		public String ReadMessage() throws IOException {
			String message = "";
			while(getIn().available()>0) {
				message = message.concat(getIn().readUTF());
			}
			return message;
		}
		
		
		
	public void run() {
		 
	}
	
	
}
