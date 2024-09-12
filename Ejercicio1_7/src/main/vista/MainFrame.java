package main.vista;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.pojo.Message;


public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public JFrame frame = null;
	
	private ArrayList<JPanel> pannels = null;
	
	private ArrayList<Message> messages = null;

	public void inicializar() throws ClassNotFoundException {

		frame = new JFrame();
		frame.setBounds(0, 0, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		pannels = new ArrayList<JPanel>();
		
		messages = new ArrayList<Message>();
		
		MainPanel mainPanel = new MainPanel(pannels, messages);
		JPanel panel1 = mainPanel.getPanel();
		panel1.setVisible(true);
		pannels.add(panel1);
		frame.getContentPane().add(panel1);
		
		ReadingPanel readingPanel = new ReadingPanel(pannels, messages);
		JPanel panel2 = readingPanel.getPanel();
		pannels.add(panel2);
		panel2.setVisible(false);
		frame.getContentPane().add(panel2);
		
		WritingPanel writingPanel = new WritingPanel(pannels, messages);
		JPanel panel3 = writingPanel.getPanel();
		pannels.add(panel3);
		panel3.setVisible(false);
		frame.getContentPane().add(panel3);
		
		frame.setVisible(true);
	}
}
