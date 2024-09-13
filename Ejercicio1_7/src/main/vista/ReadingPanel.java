package main.vista;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.pojo.Message;

public class ReadingPanel {
	private JPanel panel = null;
	private DefaultTableModel tableModel = null;
	public JTable messageTable = null;

	public ReadingPanel(ArrayList<JPanel> pannels, ArrayList<Message> messages) {
		panel = new JPanel();
		panel.setBounds(0, 0, 700, 300);
		panel.setLayout(null);

		tableModel = new DefaultTableModel();
		tableModel.addColumn("De");
		tableModel.addColumn("Para");
		tableModel.addColumn("Fecha");
		tableModel.addColumn("Hora");
		tableModel.addColumn("Asunto");
		tableModel.addColumn("Contenido");
		messageTable = new JTable(tableModel);
		messageTable.setBounds(0, 0, 690, 220);
		messageTable.getColumnModel().getColumn(3).setPreferredWidth(90); 
		messageTable.getColumnModel().getColumn(2).setPreferredWidth(150);
		panel.add(messageTable);
		
		JScrollPane scrollPane = new JScrollPane(messageTable);
		scrollPane.setSize(690, 220);
		panel.add(scrollPane);

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

		panel.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				tableModel.setRowCount(0);
				readMessages(messages, tableModel);
			}
		});
	}

	public JPanel getPanel() {
		return panel;
	}

	private void readMessages(ArrayList<Message> messages, DefaultTableModel model) {
		if (messages != null) {
			for (Message message : messages) {
				Object[] row = { message.getFromText(), message.getToText(), message.getDateText(),
						message.getHourText(), message.getThemeText(), message.getContentText() };
				model.addRow(row);
			}
		}
	}
}