package main;

import main.vista.MainFrame;

public class Ejercicio1_7 {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		try {
			mainFrame.inicializar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
