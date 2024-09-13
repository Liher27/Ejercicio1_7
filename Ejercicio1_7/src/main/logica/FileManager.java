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
		String fromText = null;
		String toText = null;
		String dateText = null;
		String hourText = null;
		String themeText = null;
		String contentText = null;

		while ((line = bufferedReader.readLine()) != null) {

			if (line.startsWith("de ")) {
				fromText = line.substring(3).trim();
			}

			if (line.startsWith("para ")) {
				toText = line.substring(5).trim();
			}

			if (line.startsWith("fecha ")) {
				dateText = line.substring(6).trim();
			}

			if (line.startsWith("hora ")) {
				hourText = line.substring(5).trim();
			}

			if (line.startsWith("asunto ")) {
				themeText = line.substring(7).trim();
			}

			if (line.startsWith("contenido ")) {
				contentText = line.substring(10).trim();
			}

			if (line.startsWith("******************")) {
				Message message = new Message(fromText, toText, dateText, hourText, themeText, contentText);
				messages.add(message);
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
}