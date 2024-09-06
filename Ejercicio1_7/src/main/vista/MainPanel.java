package main.vista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.logica.FileManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPanel {
	private JPanel panel = null;

	public MainPanel(ArrayList<JPanel> paneles) {

		panel = new JPanel();
		panel.setBounds(0, 0, 450, 300);

		JButton btnNewButton = new JButton("Cargar mensajes");
		btnNewButton.setBounds(10, 41, 144, 46);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FileManager messagesController = new FileManager();
				messagesController.loadMessages();
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Añadir mensajes");
		btnNewButton_1.setBounds(10, 116, 144, 46);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				paneles.get(0).setVisible(false);
				paneles.get(1).setVisible(false);
				paneles.get(2).setVisible(true);
			}
		});
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Guardar mensajes");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(242, 41, 144, 46);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FileManager messagesController = new FileManager();
				messagesController.saveMessages();
			}
		});
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Imprimir mensajes");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(242, 116, 144, 46);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				paneles.get(0).setVisible(false);
				paneles.get(1).setVisible(true);
				paneles.get(2).setVisible(false);
			}
		});
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Salir");
		btnNewButton_4.setBounds(310, 227, 98, 23);
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
