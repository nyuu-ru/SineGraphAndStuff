package graphpaint.app;

import javax.swing.UIManager;

import graphpaint.ui.MainWindow;

public class MainClass {

	public static void main(String[] args) {
		try {
//			UIManager.setLookAndFeel(javax.swing.plaf.metal.MetalLookAndFeel.class.getName());
			UIManager.setLookAndFeel(javax.swing.plaf.nimbus.NimbusLookAndFeel.class.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Хотим создать окно
		MainWindow mainWindow = new MainWindow();
		// Хотим его показать
		mainWindow.setVisible(true);
	}

}
