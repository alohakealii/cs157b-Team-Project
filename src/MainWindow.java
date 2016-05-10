

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
	private JComboBox menuAttributes;
	private JComboBox menuDimension2;
	private JComboBox menuAttributes2;
	ButtonGroup groupRadio;
	private JTable table;
	JScrollPane scrollpane;
	private QueryTableModel qtm;
	private JLabel lblConceptHierarchy;
	private JSeparator separator_2;
	private JTextField textField_6;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;
	private JLabel label_2;
	private JTextField textField_9;

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
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Roll UP");
		rdbtnNewRadioButton.setActionCommand("rollUp");
		rdbtnNewRadioButton.setBounds(24, 6, 87, 50);
		frame2.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Drill Down");
		rdbtnNewRadioButton_1.setActionCommand("drillDown");
		rdbtnNewRadioButton_1.setBounds(195, 6, 109, 50);
		frame2.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Slice");
		rdbtnNewRadioButton_2.setActionCommand("slice");
		rdbtnNewRadioButton_2.setBounds(495, 6, 71, 50);
		frame2.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Dice");
		rdbtnNewRadioButton_3.setActionCommand("dice");
		rdbtnNewRadioButton_3.setBounds(693, 54, 75, 50);
		frame2.getContentPane().add(rdbtnNewRadioButton_3);
		
		groupRadio = new ButtonGroup();
		groupRadio.add(rdbtnNewRadioButton);
	    groupRadio.add(rdbtnNewRadioButton_1);
	    groupRadio.add(rdbtnNewRadioButton_2);
	    groupRadio.add(rdbtnNewRadioButton_3);
	    
	    //-------------------------------------Roll Up and Drill Down 
	    //-------------------------------------Dimension and Concept Hierarchy Menu (top left corner)
	    String[] attributesStore = {"street", "city", "county", "state", "region"};
		String[] attributesTime = {"day", "week", "month", "quarter", "year"};
		String[] attributesProduct = {"brand", "subcategory", "category", "department"};
		
		final DefaultComboBoxModel cbModelStore = new DefaultComboBoxModel(attributesStore);
		final DefaultComboBoxModel cbModelTime = new DefaultComboBoxModel(attributesTime);
		final DefaultComboBoxModel cbModelProduct = new DefaultComboBoxModel(attributesProduct);
	    menuAttributes = new JComboBox (cbModelStore);
		menuAttributes.setBounds(151, 81, 153, 19);
		frame2.getContentPane().add(menuAttributes);
	    
	    String[] dimensions = {"Store", "Time", "Product"};
	    menuDimension = new JComboBox (dimensions);
		menuDimension.setBounds(151, 50, 153, 19);
		frame2.getContentPane().add(menuDimension);
		menuDimension.addActionListener(new ActionListener()
		{
			  public void actionPerformed(final ActionEvent e){
			  EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							if(((String)((JComboBox)e.getSource()).getSelectedItem()).equals("Store")){
								menuAttributes.setModel(cbModelStore);
								menuAttributes.repaint();
							}
							else if(((String)((JComboBox)e.getSource()).getSelectedItem()).equals("Time")){
								menuAttributes.setModel(cbModelTime);
								menuAttributes.repaint();
							}	
							else if(((String)((JComboBox)e.getSource()).getSelectedItem()).equals("Product")){
								menuAttributes.setModel(cbModelProduct);
								menuAttributes.repaint();
							}

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
			  });
			  }
			});
		
		JLabel lblDimension = new JLabel("Dimension");
		lblDimension.setBounds(80, 39, 71, 38);
		frame2.getContentPane().add(lblDimension);
		
		lblConceptHierarchy = new JLabel("Concept Hierarchy");
		lblConceptHierarchy.setBounds(34, 70, 117, 38);
		frame2.getContentPane().add(lblConceptHierarchy);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(327, 14, 12, 109);
		frame2.getContentPane().add(separator);
		
	    //-------------------------------------Slice 
	    //-------------------------------------Dimension and Concept Hierarchy Menu (top Center)
		final DefaultComboBoxModel cbModelStore2 = new DefaultComboBoxModel(attributesStore);
		final DefaultComboBoxModel cbModelTime2 = new DefaultComboBoxModel(attributesTime);
		final DefaultComboBoxModel cbModelProduct2 = new DefaultComboBoxModel(attributesProduct);
		menuAttributes2 = new JComboBox(cbModelStore2);
		menuAttributes2.setBounds(484, 79, 153, 19);
		frame2.getContentPane().add(menuAttributes2);
	    
	    menuDimension2 = new JComboBox(dimensions);
		menuDimension2.setBounds(484, 48, 153, 19);
		frame2.getContentPane().add(menuDimension2);
		menuDimension2.addActionListener(new ActionListener()
		{
			  public void actionPerformed(final ActionEvent e){
			  EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							if(((String)((JComboBox)e.getSource()).getSelectedItem()).equals("Store")){
								menuAttributes2.setModel(cbModelStore2);
								menuAttributes2.repaint();
							}
							else if(((String)((JComboBox)e.getSource()).getSelectedItem()).equals("Time")){
								menuAttributes2.setModel(cbModelTime2);
								menuAttributes2.repaint();
							}	
							else if(((String)((JComboBox)e.getSource()).getSelectedItem()).equals("Product")){
								menuAttributes2.setModel(cbModelProduct2);
								menuAttributes2.repaint();
							}

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
			  });
			  }
			});
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(484, 101, 153, 28);
		frame2.getContentPane().add(textField_9);
		
		JLabel label = new JLabel("Dimension");
		label.setBounds(413, 37, 71, 38);
		frame2.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Concept Hierarchy");
		label_1.setBounds(367, 68, 117, 38);
		frame2.getContentPane().add(label_1);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(664, 19, 13, 107);
		frame2.getContentPane().add(separator_2);
		
		label_2 = new JLabel("Values");
		label_2.setBounds(442, 96, 41, 38);
		frame2.getContentPane().add(label_2);
		
	    //-------------------------------------Dice
	    //-------------------------------------Attributes and Values (top right corner)
		JLabel lblAttributesFor = new JLabel("Attribute for Store");
		lblAttributesFor.setBounds(803, 3, 123, 38);
		frame2.getContentPane().add(lblAttributesFor);
		
		textField = new JTextField();
		textField.setBounds(791, 78, 134, 28);
		frame2.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(791, 110, 134, 28);
		frame2.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(792, 30, 134, 28);
		frame2.getContentPane().add(textField_6);
		
		JLabel lblValues = new JLabel("Values");
		lblValues.setBounds(836, 54, 46, 38);
		frame2.getContentPane().add(lblValues);
		
		
		JLabel lblAttributeForTime = new JLabel("Attribute for Time");
		lblAttributeForTime.setBounds(957, 3, 123, 38);
		frame2.getContentPane().add(lblAttributeForTime);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(946, 30, 134, 28);
		frame2.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(945, 78, 134, 28);
		frame2.getContentPane().add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(945, 110, 134, 28);
		frame2.getContentPane().add(textField_4);
		
		JLabel label_3 = new JLabel("Values");
		label_3.setBounds(990, 54, 46, 38);
		frame2.getContentPane().add(label_3);
		
		
		JLabel lblAttributeForProduct = new JLabel("Attribute for Product");
		lblAttributeForProduct.setBounds(1102, 3, 134, 38);
		frame2.getContentPane().add(lblAttributeForProduct);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(1102, 30, 134, 28);
		frame2.getContentPane().add(textField_5);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(1101, 78, 134, 28);
		frame2.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(1101, 110, 134, 28);
		frame2.getContentPane().add(textField_8);
		
		JLabel label_5 = new JLabel("Values");
		label_5.setBounds(1146, 54, 46, 38);
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
							if(groupRadio.getSelection().getActionCommand().equals("rollUp")){
								qtm.setQuery("select * from Promotion");
							}
							else if(groupRadio.getSelection().getActionCommand().equals("drillDown")){
								qtm.setQuery("select * from Sales_Fact");
							}
							else if(groupRadio.getSelection().getActionCommand().equals("slice")){
								qtm.setQuery("select * from Store");
							}
							else if(groupRadio.getSelection().getActionCommand().equals("dice")){
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