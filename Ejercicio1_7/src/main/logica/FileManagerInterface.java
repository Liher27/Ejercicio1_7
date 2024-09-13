package main.logica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import main.pojo.Message;

public interface FileManagerInterface {
	public ArrayList<Message> loadMessages() throws IOException;
	
	public void writeMessage(ArrayList<Message> messages) throws FileNotFoundException, IOException;
	
}
