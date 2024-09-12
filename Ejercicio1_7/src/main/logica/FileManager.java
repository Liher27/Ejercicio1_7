package main.logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import main.pojo.Message;

public class FileManager extends AbstractFileManager implements FileManagerInterface {

	public ArrayList<Message> loadMessages() throws IOException {
		ArrayList<Message> messages = new ArrayList<Message>();
		File fichero = new File(fileName);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fichero));
		String line = null;

		while ((line = bufferedReader.readLine()) != null) {
			if (line.startsWith("de ")) {
				String fromText = line.substring(3).trim();
				bufferedReader.readLine();
				String toText = bufferedReader.readLine().substring(5).trim();
				bufferedReader.readLine();
				String dateText = bufferedReader.readLine().substring(6).trim();
				bufferedReader.readLine();
				String hourText = bufferedReader.readLine().substring(5).trim();
				bufferedReader.readLine();
				String themeText = bufferedReader.readLine().substring(7).trim();
				bufferedReader.readLine();
				String contentText = bufferedReader.readLine().substring(10).trim();
				bufferedReader.readLine();

				line = bufferedReader.readLine();

				if (line.startsWith("****************** \n ")) {
					Message message = new Message(fromText, toText, dateText, hourText, themeText, contentText);
					messages.add(message);
				}
			}
		}
		bufferedReader.close();
		return messages;
	}

	public void writeMessage(ArrayList<Message> menssages) throws FileNotFoundException, IOException {
		FileWriter fileWriter = new FileWriter(new File(fileName));

		for (Message message : menssages) {
			fileWriter.write("de " + message.getFromText() + "\n" + "\n" + "para " + message.getToText() + "\n" + "\n"
					+ "fecha " + message.getDateText() + "\n" + "\n" + "hora " + message.getHourText() + "\n" + "\n"
					+ "asunto " + message.getThemeText() + "\n" + "\n" + "contenido " + message.getContentText() + "\n"
					+ "\n" + "****************** \n");
		}

		fileWriter.close();
	}

	public Message readMessages(ArrayList<Message> messages) throws IOException {
		return null;

	}

}
