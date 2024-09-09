package main.logica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import main.pojo.Message;

public interface FileManagerInterface {
	public ArrayList<Message> loadMessages() throws IOException;
	
	public void saveMessages(Message message)throws FileNotFoundException, IOException;
	
	public void writeMessage(Message message, boolean append) throws FileNotFoundException, IOException;
	
	public Message readMessages(ArrayList<Message> messages) throws IOException;
}
