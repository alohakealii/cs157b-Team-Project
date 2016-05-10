

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;


public class MainWindow {

	final int STORE = Mainold.STORE;
	final int PRODUCT = Mainold.PRODUCT;
	final int TIME = Mainold.TIME;
	final int DIMENSIONS = Mainold.DIMENSIONS;
	
	static JFrame frame2;
	private JTextField textField;
	private JTextField textField_3;
	private JComboBox menuDimension;
	private JComboBox menuDimension2;
	ButtonGroup groupRadio;
	private JTable table;
	JScrollPane scrollpane;
	private QueryTableModel qtm;
	private JSeparator separator_2;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_7;
	private JTextField textField_8;
	private JLabel label_2;
	private JTextField textField_9;
	
	private String chosenDimension;
	private String sliceValue;
	private String diceStoreValue1;
	private String diceStoreValue2;
	private String diceTimeValue1;
	private String diceTimeValue2;
	private String diceProductValue1;
	private String diceProductValue2;

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
		//-------------------------------------Main Frame
		frame2 = new JFrame();
		frame2.setBounds(0, 0, 1440, 900);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		//-------------------------------------All Radio Buttons
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Roll UP by Climbing Up");
		rdbtnNewRadioButton.setActionCommand("rollUpClimb");
		rdbtnNewRadioButton.setBounds(24, 6, 177, 50);
		frame2.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Drill Down by Climbing Down");
		rdbtnNewRadioButton_1.setActionCommand("drillDownClimb");
		rdbtnNewRadioButton_1.setBounds(206, 6, 219, 50);
		frame2.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnDrillDownBy = new JRadioButton("Drill Down by Adding");
		rdbtnDrillDownBy.setActionCommand("drillDownAdd");
		rdbtnDrillDownBy.setBounds(206, 46, 219, 50);
		frame2.getContentPane().add(rdbtnDrillDownBy);
		
		JRadioButton rdbtnRollUpBy = new JRadioButton("Roll UP by Reducing");
		rdbtnRollUpBy.setActionCommand("rollUpReduce");
		rdbtnRollUpBy.setBounds(24, 46, 177, 50);
		frame2.getContentPane().add(rdbtnRollUpBy);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Slice");
		rdbtnNewRadioButton_2.setActionCommand("slice");
		rdbtnNewRadioButton_2.setBounds(542, 5, 71, 50);
		frame2.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Dice");
		rdbtnNewRadioButton_3.setActionCommand("dice");
		rdbtnNewRadioButton_3.setBounds(738, 45, 75, 50);
		frame2.getContentPane().add(rdbtnNewRadioButton_3);
		
		groupRadio = new ButtonGroup();
		groupRadio.add(rdbtnNewRadioButton);
	    groupRadio.add(rdbtnNewRadioButton_1);
	    groupRadio.add(rdbtnNewRadioButton_2);
	    groupRadio.add(rdbtnNewRadioButton_3);
	    groupRadio.add(rdbtnRollUpBy);
	    groupRadio.add(rdbtnDrillDownBy);
	    
	    //-------------------------------------Roll Up and Drill Down 
	    //-------------------------------------Dimension and Concept Hierarchy Menu (top left corner)
	    String[] attributesStore = {"street", "city", "county", "state", "region"};
		String[] attributesTime = {"day", "week", "month", "quarter", "year"};
		String[] attributesProduct = {"brand", "subcategory", "category", "department"};
		
		final DefaultComboBoxModel cbModelStore = new DefaultComboBoxModel(attributesStore);
		final DefaultComboBoxModel cbModelTime = new DefaultComboBoxModel(attributesTime);
		final DefaultComboBoxModel cbModelProduct = new DefaultComboBoxModel(attributesProduct);
	    
	    String[] dimensions = {"Store", "Time", "Product"};
	    menuDimension = new JComboBox (dimensions);
		menuDimension.setBounds(151, 97, 153, 19);
		frame2.getContentPane().add(menuDimension);
		
		JLabel lblDimension = new JLabel("Dimension");
		lblDimension.setBounds(80, 86, 71, 38);
		frame2.getContentPane().add(lblDimension);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(436, 18, 12, 109);
		frame2.getContentPane().add(separator);
		
	    //-------------------------------------Slice 
	    //-------------------------------------Dimension and Concept Hierarchy Menu (top Center)
		final DefaultComboBoxModel cbModelStore2 = new DefaultComboBoxModel(attributesStore);
		final DefaultComboBoxModel cbModelTime2 = new DefaultComboBoxModel(attributesTime);
		final DefaultComboBoxModel cbModelProduct2 = new DefaultComboBoxModel(attributesProduct);
	    
	    menuDimension2 = new JComboBox(dimensions);
		menuDimension2.setBounds(531, 47, 153, 19);
		frame2.getContentPane().add(menuDimension2);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(531, 78, 153, 28);
		frame2.getContentPane().add(textField_9);
		
		JLabel label = new JLabel("Dimension");
		label.setBounds(460, 36, 71, 38);
		frame2.getContentPane().add(label);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(711, 18, 13, 107);
		frame2.getContentPane().add(separator_2);
		
		label_2 = new JLabel("Value");
		label_2.setBounds(489, 73, 41, 38);
		frame2.getContentPane().add(label_2);
		
	    //-------------------------------------Dice
	    //-------------------------------------Attributes and Values (top right corner)
		JLabel lblAttributesFor = new JLabel("Store Dimension");
		lblAttributesFor.setBounds(851, 14, 109, 38);
		frame2.getContentPane().add(lblAttributesFor);
		
		textField = new JTextField();
		textField.setBounds(838, 66, 134, 28);
		frame2.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(838, 98, 134, 28);
		frame2.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblValues = new JLabel("Values");
		lblValues.setBounds(883, 42, 46, 38);
		frame2.getContentPane().add(lblValues);
		
		
		JLabel lblAttributeForTime = new JLabel("Time Dimension");
		lblAttributeForTime.setBounds(1008, 15, 103, 38);
		frame2.getContentPane().add(lblAttributeForTime);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(992, 66, 134, 28);
		frame2.getContentPane().add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(992, 98, 134, 28);
		frame2.getContentPane().add(textField_4);
		
		JLabel label_3 = new JLabel("Values");
		label_3.setBounds(1037, 42, 46, 38);
		frame2.getContentPane().add(label_3);
		
		
		JLabel lblAttributeForProduct = new JLabel("Product Dimension");
		lblAttributeForProduct.setBounds(1156, 15, 120, 38);
		frame2.getContentPane().add(lblAttributeForProduct);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(1148, 66, 134, 28);
		frame2.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(1148, 98, 134, 28);
		frame2.getContentPane().add(textField_8);
		
		JLabel label_5 = new JLabel("Values");
		label_5.setBounds(1193, 42, 46, 38);
		frame2.getContentPane().add(label_5);
		
		//-------------------------------------Table
		qtm = new QueryTableModel();
		table = new JTable(qtm);
		scrollpane = new JScrollPane(table);
		scrollpane.setBounds(10, 150, 1420, 680);
		qtm.setQuery(getQueryString());
		frame2.getContentPane().add(scrollpane);
		
		//-------------------------------------Submit Button
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e){
			  EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							if(groupRadio.getSelection().getActionCommand().equals("rollUpClimb")){
								chosenDimension = (String) menuDimension.getSelectedItem();
								
								qtm.setQuery("select * from Promotion");
							}
							else if(groupRadio.getSelection().getActionCommand().equals("drillDownClimb")){
								chosenDimension = (String) menuDimension.getSelectedItem();
								
								qtm.setQuery("select * from Sales_Fact");
							}
							else if(groupRadio.getSelection().getActionCommand().equals("rollUpReduce")){
								chosenDimension = (String) menuDimension.getSelectedItem();
								
								qtm.setQuery("select * from Time");
							}
							else if(groupRadio.getSelection().getActionCommand().equals("drillDownAdd")){
								chosenDimension = (String) menuDimension.getSelectedItem();
								
								qtm.setQuery("select * from Product");
							}
							else if(groupRadio.getSelection().getActionCommand().equals("slice")){
								chosenDimension = (String) menuDimension2.getSelectedItem();
								sliceValue = textField_9.getText();
								
								qtm.setQuery("select * from Store");
							}
							else if(groupRadio.getSelection().getActionCommand().equals("dice")){
								diceStoreValue1 = textField.getText();
								diceStoreValue2 = textField_3.getText();
								diceTimeValue1 = textField_2.getText();
								diceTimeValue2 = textField_4.getText();
								diceProductValue1 = textField_7.getText();
								diceProductValue2 = textField_8.getText();
								
								qtm.setQuery("select * from Time");
							}
							table.setModel(qtm);
							table.repaint();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
			  });
			  }
			});
		btnSubmit.setBounds(1313, 20, 117, 114);
		frame2.getContentPane().add(btnSubmit);
	}
	
	public String getQueryString() {
		String[] dimensions = new String[DIMENSIONS];
		dimensions[STORE] = Main.storein;
		dimensions[PRODUCT] = Main.productin;
		dimensions[TIME] = Main.timein;
		boolean store = dimensions[STORE] != null ? true : false;
		boolean product = dimensions[PRODUCT] != null ? true : false;
		boolean time = dimensions[TIME] != null ? true : false;
		
		// Build pieces for SQL string
		String attributes = "";
		String tables = "";
		if (store) {
			attributes += dimensions[STORE];
			tables += "store";
		}
		if (product) {
			if (tables.length() == 0) {
				attributes += dimensions[PRODUCT];
				tables += "product";
			}
			else {
				attributes += ", " + dimensions[PRODUCT];
				tables += ", product";
			}
		}
		if (time) {
			if (tables.length() == 0) {
				attributes += dimensions[TIME];
				tables += "time";
			}
			else {
				attributes += ", " + dimensions[TIME];
				tables += ", time";
			}
		}
		
		// Build SQL string
		String sql = "SELECT sum(dollar_sales)";
		if (tables.length() > 0) {
			sql += ", " + attributes;
		}
		sql += " FROM sales_fact";
		if (tables.length() > 0) {
			sql += ", " + tables;
			sql += " WHERE ";
			if (store) {
				sql += "sales_fact.store_key=store.store_key";
			}
			if (product) {
				if (store) {
					sql += " AND";
				}
				sql += " sales_fact.product_key=product.product_key";
			}
			if (time) {
				if (store || product) {
					sql += " AND";
				}
				sql += " sales_fact.time_key=time.time_key";
			}
			sql += " GROUP BY " + attributes;
			sql += " ORDER BY " + attributes;
		}
		
		// debugging info
		System.out.println("SQL string is:\n" + sql);
		
		return sql;
	}
}