package main.vista;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ReadingPanel {
	private JPanel panel = null;
	private DefaultTableModel tableModel = null;
	public JTable messageTable = null;

	public ReadingPanel(ArrayList<JPanel> paneles) {

		panel = new JPanel();
		panel.setBounds(0, 0, 450, 300);
		panel.setLayout(null);

		tableModel = new DefaultTableModel();
		tableModel.addColumn("De");
		tableModel.addColumn("Para");
		tableModel.addColumn("Fecha");
		tableModel.addColumn("Hora");
		tableModel.addColumn("Asunto");
		tableModel.addColumn("Contenido");

		messageTable = new JTable(tableModel);
		messageTable.setBounds(0, 0, 400,250);

		panel.add(messageTable);

	}

	public JPanel getPanel() {
		return panel;
	}
}
