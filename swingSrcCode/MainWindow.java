import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;


public class MainWindow {

	static JFrame frame2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	JScrollPane scrollpane;
	QueryTableModel qtm;
	private JSeparator separator_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame2 = new JFrame();
		frame2.setBounds(0, 0, 1440, 900);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Roll UP");
		rdbtnNewRadioButton.setBounds(24, 6, 87, 50);
		frame2.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Drill Down");
		rdbtnNewRadioButton_1.setBounds(24, 50, 109, 50);
		frame2.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Slice");
		rdbtnNewRadioButton_2.setBounds(336, 6, 71, 50);
		frame2.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Dice");
		rdbtnNewRadioButton_3.setBounds(333, 50, 75, 50);
		frame2.getContentPane().add(rdbtnNewRadioButton_3);
		
		JMenuItem mntmStore = new JMenuItem("Dimension");
		mntmStore.setBounds(153, 19, 153, 19);
		frame2.getContentPane().add(mntmStore);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Concept Hierarchy");
		mntmNewMenuItem.setBounds(153, 68, 153, 19);
		frame2.getContentPane().add(mntmNewMenuItem);
		
		textField = new JTextField();
		textField.setBounds(488, 50, 134, 28);
		frame2.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(631, 50, 134, 28);
		frame2.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(833, 51, 134, 28);
		frame2.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(489, 79, 134, 28);
		frame2.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(631, 79, 134, 28);
		frame2.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(833, 80, 134, 28);
		frame2.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(1255, 14, 117, 67);
		frame2.getContentPane().add(btnSubmit);
		
		JMenuItem mntmDimension = new JMenuItem("Dimension");
		mntmDimension.setBounds(466, 20, 153, 19);
		frame2.getContentPane().add(mntmDimension);
		
		JMenuItem mntmConceptHierarchy = new JMenuItem("Concept Hierarchy");
		mntmConceptHierarchy.setBounds(635, 20, 153, 19);
		frame2.getContentPane().add(mntmConceptHierarchy);
		
		textField_6 = new JTextField();
		textField_6.setBounds(835, 18, 134, 28);
		frame2.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		qtm = new QueryTableModel();
		table = new JTable(qtm);
		scrollpane = new JScrollPane(table);
		scrollpane.setBounds(10, 150, 1420, 680);
		qtm.setQuery("select * from Product");
		frame2.getContentPane().add(scrollpane);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(316, 2, 12, 109);
		frame2.getContentPane().add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(352, 39, 543, 12);
		frame2.getContentPane().add(separator_1);
	}
}
