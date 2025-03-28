package main.vista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;

import main.pojo.Message;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

	public WritingPanel(ArrayList<JPanel> pannels, ArrayList<Message> messages) {

		panel = new JPanel();
		panel.setBounds(0, 0, 700, 300);
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
		timeLbl.setBounds(416, 10, 46, 14);
		panel.add(timeLbl);

		JComboBox<Integer> hourComboBox = new JComboBox<>();
		for (int hour = 00; hour <= 23; hour++) {
			hourComboBox.addItem(hour);
		}
		hourComboBox.setBounds(462, 6, 54, 22);
		panel.add(hourComboBox);

		JComboBox<Integer> minuteComboBox = new JComboBox<>();
		for (int minute = 00; minute <= 59; minute++) {
			minuteComboBox.addItem(minute);
		}
		minuteComboBox.setBounds(533, 6, 54, 22);
		panel.add(minuteComboBox);

		JLabel lblNewLabel = new JLabel(":");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(502, 10, 46, 14);
		panel.add(lblNewLabel);

		JLabel fromLbl = new JLabel("De");
		fromLbl.setBounds(8, 44, 46, 14);
		panel.add(fromLbl);

		JLabel toLbl = new JLabel("Para");
		toLbl.setBounds(8, 74, 46, 14);
		panel.add(toLbl);

		JLabel themeLbl = new JLabel("Asunto");
		themeLbl.setBounds(8, 99, 46, 14);
		panel.add(themeLbl);

		JLabel contentLbl = new JLabel("Contenido");
		contentLbl.setBounds(8, 124, 53, 14);
		panel.add(contentLbl);

		fromTextField = new JTextField();
		fromTextField.setBounds(71, 41, 337, 20);
		panel.add(fromTextField);
		fromTextField.setColumns(10);

		toTextField = new JTextField();
		toTextField.setColumns(10);
		toTextField.setBounds(71, 69, 337, 20);
		panel.add(toTextField);

		themeTextField = new JTextField();
		themeTextField.setColumns(10);
		themeTextField.setBounds(71, 96, 337, 20);
		panel.add(themeTextField);

		contentTextField = new JTextField();
		contentTextField.setColumns(10);
		contentTextField.setBounds(71, 124, 337, 118);
		panel.add(contentTextField);

		JButton okBtn = new JButton("OK");
		okBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hour = (hourComboBox.getSelectedIndex() + ":" + minuteComboBox.getSelectedIndex());
				date = (dayTextField.getText() + " de " + monthComboBox.getSelectedItem().toString() + " del "
						+ yearComboBox.getSelectedItem().toString());

				Message message = new Message(fromTextField.getText(), toTextField.getText(), hour, date,
						themeTextField.getText(), contentTextField.getText());
				messages.add(message);

				JOptionPane.showMessageDialog(null,
						"Se ha guardado la informacion del mensaje. Por favor, pulse guardar mensaje en la siguiente ventana.",
						"OK!", JOptionPane.INFORMATION_MESSAGE);

				pannels.get(0).setVisible(true);
				pannels.get(1).setVisible(false);
				pannels.get(2).setVisible(false);
			}
		});
		okBtn.setBounds(489, 236, 69, 23);
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
		cancelBtn.setBounds(578, 236, 80, 23);
		panel.add(cancelBtn);

	}

	public JPanel getPanel() {
		return panel;
	}
}
