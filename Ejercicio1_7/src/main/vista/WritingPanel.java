package main.vista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;

import main.logica.FileManager;
import main.pojo.Message;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class WritingPanel {
	private JPanel panel = null;
	private JTextField dayTextField;
	private JTextField fromTextField;
	private JTextField toTextField;
	private JTextField themeTextField;
	private JTextField contentTextField;
	private String hour = null;
	private String date = null;

	public WritingPanel(ArrayList<JPanel> pannels) {

		panel = new JPanel();
		panel.setBounds(0, 0, 450, 300);
		panel.setLayout(null);
		
		String months[] = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };

		JLabel dateLbl = new JLabel("Fecha");
		dateLbl.setBounds(8, 6, 46, 14);
		panel.add(dateLbl);

		dayTextField = new JTextField();
		dayTextField.setBounds(54, 3, 86, 20);
		panel.add(dayTextField);
		dayTextField.setColumns(10);

		DefaultComboBoxModel<String> monthComboBoxModel = new DefaultComboBoxModel<String>();
		for (int i = 0; i < months.length; i++) {
			monthComboBoxModel.addElement(months[i]);
		}

		JComboBox<String> monthComboBox = new JComboBox<>();
		monthComboBox.setModel(monthComboBoxModel);
		monthComboBox.setBounds(161, 2, 117, 22);
		panel.add(monthComboBox);

		JComboBox<Integer> yearComboBox = new JComboBox<>();
		for (int year = 2000; year <= 2024; year++) {
			yearComboBox.addItem(year);
		}
		yearComboBox.setBounds(303, 2, 54, 22);
		panel.add(yearComboBox);

		JLabel timeLbl = new JLabel("Hora");
		timeLbl.setBounds(8, 35, 46, 14);
		panel.add(timeLbl);

		JComboBox<Integer> hourComboBox = new JComboBox<>();
		for (int hour = 00; hour <= 23; hour++) {
			hourComboBox.addItem(hour);
		}
		hourComboBox.setBounds(54, 31, 54, 22);
		panel.add(hourComboBox);

		JComboBox<Integer> minuteComboBox = new JComboBox<>();
		for (int minute = 00; minute <= 59; minute++) {
			minuteComboBox.addItem(minute);
		}
		minuteComboBox.setBounds(125, 31, 54, 22);
		panel.add(minuteComboBox);

		JLabel lblNewLabel = new JLabel(":");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(94, 35, 46, 14);
		panel.add(lblNewLabel);

		JLabel fromLbl = new JLabel("De");
		fromLbl.setBounds(8, 79, 46, 14);
		panel.add(fromLbl);

		JLabel toLbl = new JLabel("Para");
		toLbl.setBounds(8, 109, 46, 14);
		panel.add(toLbl);

		JLabel themeLbl = new JLabel("Asunto");
		themeLbl.setBounds(8, 134, 46, 14);
		panel.add(themeLbl);

		JLabel contentLbl = new JLabel("Contenido");
		contentLbl.setBounds(8, 159, 53, 14);
		panel.add(contentLbl);

		fromTextField = new JTextField();
		fromTextField.setBounds(71, 76, 226, 20);
		panel.add(fromTextField);
		fromTextField.setColumns(10);

		toTextField = new JTextField();
		toTextField.setColumns(10);
		toTextField.setBounds(71, 104, 226, 20);
		panel.add(toTextField);

		themeTextField = new JTextField();
		themeTextField.setColumns(10);
		themeTextField.setBounds(71, 131, 226, 20);
		panel.add(themeTextField);

		contentTextField = new JTextField();
		contentTextField.setColumns(10);
		contentTextField.setBounds(71, 158, 227, 68);
		panel.add(contentTextField);

		JButton okBtn = new JButton("OK");
		okBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hour = (hourComboBox.getSelectedIndex() + ":" + minuteComboBox.getSelectedIndex());
				date = (dayTextField.getText() + "de" + monthComboBox.getSelectedObjects().toString() + "del"
						+ yearComboBox.getSelectedObjects().toString());
				Message message = new Message(fromTextField.getText(), toTextField.getText(), hour, date,
						themeTextField.getText(), contentTextField.getText());
				FileManager fileManager = new FileManager();
				try {
					fileManager.writeMessage(message, true);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		okBtn.setBounds(248, 231, 69, 23);
		panel.add(okBtn);

		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pannels.get(0).setVisible(true);
				pannels.get(1).setVisible(false);
				pannels.get(2).setVisible(false);
			}
		});
		cancelBtn.setBounds(327, 231, 80, 23);
		panel.add(cancelBtn);

	}

	public JPanel getPanel() {
		return panel;
	}
}
