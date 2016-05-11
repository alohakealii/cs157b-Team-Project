

import java.awt.EventQueue;


public class Main {

	public static String storein = null;
	public static String timein = null;
	public static String productin = null;
	public static int STORE = 0;
	public static int PRODUCT = 1;
	public static int TIME = 2;
	public static int DIMENSIONS = 3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitialWindow window = new InitialWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
