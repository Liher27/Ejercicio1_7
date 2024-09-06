package main.vista;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public JFrame frame = null;
	
	private ArrayList<JPanel> pannels = null;

	public void inicializar() throws ClassNotFoundException {

		frame = new JFrame();
		frame.setBounds(0, 0, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		pannels = new ArrayList<JPanel>();
		
		MainPanel mainPanel = new MainPanel(pannels);
		JPanel panel1 = mainPanel.getPanel();
		panel1.setVisible(true);
		pannels.add(panel1);
		frame.getContentPane().add(panel1);
		
		ImpressWindow impressWindow = new ImpressWindow(pannels);
		JPanel panel2 = impressWindow.getPanel();
		pannels.add(panel2);
		frame.getContentPane().add(panel2);
		
		WritingWindow writingWindow = new WritingWindow(pannels);
		JPanel panel3 = writingWindow.getPanel();
		pannels.add(panel3);
		frame.getContentPane().add(panel3);
		
		frame.setVisible(true);
	}
}
