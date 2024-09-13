package main.vista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.logica.FileManager;
import main.pojo.Message;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPanel {

	private JPanel panel = null;
	private FileManager fileManager = null;
	ArrayList<Message> loadedMessages = null;

	public MainPanel(ArrayList<JPanel> pannels, ArrayList<Message> messages) {

		panel = new JPanel();
		panel.setBounds(0, 0, 700, 300);

		fileManager = new FileManager();

		JButton btnNewButton = new JButton("Cargar mensajes");
		btnNewButton.setBounds(115, 55, 144, 46);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FileManager messagesController = new FileManager();
				try {
					loadedMessages = messagesController.loadMessages();
					messages.addAll(loadedMessages);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar guardar los mensajes.",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane.showMessageDialog(null, "Se han cargado " + messages.size() + " mensajes.",
						"Mensajes cargados.", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Añadir mensajes");
		btnNewButton_1.setBounds(115, 130, 144, 46);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pannels.get(0).setVisible(false);
				pannels.get(1).setVisible(false);
				pannels.get(2).setVisible(true);
			}
		});
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Guardar mensajes");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fileManager.writeMessage(messages);
					JOptionPane.showMessageDialog(null, "Se han guardado los mensajes.", "OK!",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "No se ha encontrado el fichero para escribir los mensajes.",
							"Error", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar guardar los mensajes.",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(423, 55, 144, 46);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Imprimir mensajes");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pannels.get(0).setVisible(false);
				pannels.get(1).setVisible(true);
				pannels.get(2).setVisible(false);
			}
		});
		btnNewButton_3.setBounds(423, 130, 144, 46);
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Salir");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(546, 223, 98, 23);
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame parentFrame = (JFrame) btnNewButton_4.getTopLevelAncestor();
				parentFrame.dispose();
			}
		});
		panel.add(btnNewButton_4);
	}

	public JPanel getPanel() {
		return panel;
	}
	
}
