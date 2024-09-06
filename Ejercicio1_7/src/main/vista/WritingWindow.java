package main.vista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.logica.FileManager;

public class WritingWindow {
	private JPanel panel = null;
	
	public WritingWindow (ArrayList<JPanel> paneles) {
		
		panel = new JPanel();
		panel.setBounds(0,0,450,300);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Panel escribir");
		btnNewButton.setBounds(10, 41, 144, 46);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FileManager messagesController = new FileManager();
				messagesController.loadMessages();
			}
		});
		panel.add(btnNewButton);
	}

	public JPanel getPanel() {
		return panel;
	}
}
