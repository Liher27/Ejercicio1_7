package main.logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import main.pojo.Message;

public class FileManager extends AbstractFileManager implements FileManagerInterface {

	public ArrayList <Message> loadMessages() throws IOException {
		ArrayList <Message> messages = new ArrayList<Message>();
		File fichero = new File("Messages.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fichero));
		String line = null;

//		while ((line = bufferedReader.readLine()) != null) {
//			returnMessage.setFromText(line);
//			returnMessage.setToText(line);
//			returnMessage.setHourText(line);
//			returnMessage.setDateText(line);
//			returnMessage.setThemeText(line);
//			returnMessage.setContentText(line);
//		}
		bufferedReader.close();
		return messages;
	}

	public void saveMessages(Message message)throws FileNotFoundException, IOException {
		writeMessage(message, true);
		
	}

	public void writeMessage(Message message, boolean append) throws FileNotFoundException, IOException {
		BufferedWriter fichero = new BufferedWriter(new FileWriter("Messages.txt"));
		String[] messageParts = { message.getFromText(), message.getToText(), message.getHourText(),
				message.getDateText(), message.getThemeText(), message.getContentText()

		};
		for (int i = 0; i < 5; i++) {
			fichero.write(messageParts[i]);
		}
		fichero.write("**************************");
		fichero.close();
	}

	public Message readMessages(ArrayList<Message> messages) throws IOException {
		return null;

	}

}
