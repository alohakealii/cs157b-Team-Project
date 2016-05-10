package swingSrcCode;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;


public class MainWindow {

	static JFrame frame2;
	private JTextField textField;
	private JTextField textField_3;
	private JComboBox menuDimension;
	private JComboBox menuAttributes;
	private JComboBox sliceDimensionOption;
	private JComboBox sliceConceptHeirarchyOption;
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
	private JTextField sliceValueTextField;
	//these two are for time array list
	private ArrayList<String> timeArrayList;
	private int timeArrayIndex;
	//**********************************

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
		timeArrayIndex = 2;
		timeArrayList = new ArrayList<String>();
		populateTimeArrayList();
	}
	
	public void populateTimeArrayList(){
		timeArrayList.add("day");
		timeArrayList.add("week");
		timeArrayList.add("month");
		timeArrayList.add("quarter");
		timeArrayList.add("year");
	}
	
	//when user chooses the rollup option
	public void rollUp(String str){
		try{
		String query = "select  store.name,store.store_state,time."+str+",sum(sales_fact.dollar_sales)"
				+ " from store,"
				+ "product,"
				+ "time,"
				+ "sales_fact"
				+ " where"
				+ " time.time_key = sales_fact.time_key AND"
				+ " sales_fact.time_key = time.time_key AND"
				+ " sales_fact.product_key = product.product_key AND"
				+ " sales_fact.store_key = store.store_key"
				+ " group by"
				+ " time."+str+","
				+ " store.store_state";
		qtm.setQuery(query);
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	
	//when user chooses the drill down option
	public void drillDown(String str){
		try{
		String query = "select  store.name,store.store_state,time."+str+",sum(sales_fact.dollar_sales)"
				+ " from store,"
				+ "product,"
				+ "time,"
				+ "sales_fact"
				+ " where"
				+ " time.time_key = sales_fact.time_key AND"
				+ " sales_fact.time_key = time.time_key AND"
				+ " sales_fact.product_key = product.product_key AND"
				+ " sales_fact.store_key = store.store_key"
				+ " group by"
				+ " time."+str+","
				+ " store.store_state";
		qtm.setQuery(query);
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	
	//slice the data model
	public void slice(String str, String heirarchy, String dimension){
		try{
			String query = "Select * from "+dimension+",sales_fact"
					+ " where " + dimension + "_" + heirarchy + " = " + "'"+str + "'" + " AND"
					+ " sales_fact."+dimension+"_key = "+dimension+"."+dimension+"_key"
					+ " group by"
					+ " " + dimension+"_" + heirarchy + "";
			qtm.setQuery(query);
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		
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
		
		JRadioButton sliceRadioButton = new JRadioButton("Slice");
		sliceRadioButton.setActionCommand("slice");
		sliceRadioButton.setBounds(495, 6, 71, 50);
		frame2.getContentPane().add(sliceRadioButton);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Dice");
		rdbtnNewRadioButton_3.setActionCommand("dice");
		rdbtnNewRadioButton_3.setBounds(693, 54, 75, 50);
		frame2.getContentPane().add(rdbtnNewRadioButton_3);
		
		groupRadio = new ButtonGroup();
		groupRadio.add(rdbtnNewRadioButton);
	    groupRadio.add(rdbtnNewRadioButton_1);
	    groupRadio.add(sliceRadioButton);
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
		sliceConceptHeirarchyOption = new JComboBox(cbModelStore2);
		sliceConceptHeirarchyOption.setBounds(484, 79, 153, 19);
		frame2.getContentPane().add(sliceConceptHeirarchyOption);
	    
	    sliceDimensionOption = new JComboBox(dimensions);
		sliceDimensionOption.setBounds(484, 48, 153, 19);
		frame2.getContentPane().add(sliceDimensionOption);
		sliceDimensionOption.addActionListener(new ActionListener()
		{
			  public void actionPerformed(final ActionEvent e){
			  EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							if(((String)((JComboBox)e.getSource()).getSelectedItem()).equals("Store")){
								sliceConceptHeirarchyOption.setModel(cbModelStore2);
								sliceConceptHeirarchyOption.repaint();
							}
							else if(((String)((JComboBox)e.getSource()).getSelectedItem()).equals("Time")){
								sliceConceptHeirarchyOption.setModel(cbModelTime2);
								sliceConceptHeirarchyOption.repaint();
							}	
							else if(((String)((JComboBox)e.getSource()).getSelectedItem()).equals("Product")){
								sliceConceptHeirarchyOption.setModel(cbModelProduct2);
								sliceConceptHeirarchyOption.repaint();
							}

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
			  });
			  }
			});
		
		sliceValueTextField = new JTextField();
		sliceValueTextField.setColumns(10);
		sliceValueTextField.setBounds(484, 101, 153, 28);
		frame2.getContentPane().add(sliceValueTextField);
		
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
		qtm.setQuery("select * from Product");
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
								//qtm.setQuery("select * from Promotion");
								//go to the next heirarchy in the time arraylist
								timeArrayIndex++;
								String str = timeArrayList.get(timeArrayIndex);
								rollUp(str);
							}
							else if(groupRadio.getSelection().getActionCommand().equals("drillDown")){
								if(timeArrayIndex >= 1){
									timeArrayIndex--;
									if(timeArrayIndex < 0){
										JOptionPane.showMessageDialog(null, "Cannot drill down anymore");
									}
									else{
										String str = timeArrayList.get(timeArrayIndex);
										drillDown(str);	
									}
								}
								else{
									JOptionPane.showMessageDialog(null,"DISABLE BUTTON");
								}
								
							}
							else if(groupRadio.getSelection().getActionCommand().equals("slice")){
								//qtm.setQuery("select * from Store");
								String valueOfSlice = sliceValueTextField.getText();
								String sHeirarchy = (String) sliceConceptHeirarchyOption.getSelectedItem();
								String sDimension = (String)sliceDimensionOption.getSelectedItem();
								slice(valueOfSlice, sHeirarchy, sDimension);
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
}