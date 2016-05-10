

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class InitialWindow {

	static JFrame frame;
	private JTable table;
	private List<String> storeAttributes;
	private List<String> timeAttributes;
	private List<String> productAttributes;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Create the application.
	 */
	public InitialWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		storeAttributes = new ArrayList<>(Arrays.asList("name","store_number","store_street_address","city",
				"store_county","store_state","store_zip","sales_district","sales_region","store_manager",
				"store_phone","store_FAX","floor_plan_type","photo_processing_type","finance_services_type",
				"first_opened_date","last_remodel_date","store_sqft","grocery_sqft","frozen_sqft","meat_sqft"));
		timeAttributes = new ArrayList<>(Arrays.asList("date","day_of_week","day_number_in_month",
				"day_number_overall","week_number_in_year","week_number_overall","Month","quarter",
				"fiscal_period","year","holiday_flag"));
		productAttributes = new ArrayList<>(Arrays.asList("description","full_description","SKU_number",
				"package_size","brand","subcategory","category","department","package_type","diet_type",
				"weight","weight_unit_of_measure","units_per_retail_case","units_per_shipping_case",
				"cases_per_pallet","shelf_width_cm","shelf_height_cm","shelf_depth_cm"));
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblChooseDimensions = new JLabel("Choose 2 dimensions with a corresponding attribute for each to start the simulation!", SwingConstants.CENTER);
		lblChooseDimensions.setBounds(340, 10, 600, 50);
		frame.getContentPane().add(lblChooseDimensions);
		
		DefaultTableModel model = new DefaultTableModel();
		DefaultTableModel model_1 = new DefaultTableModel();
		DefaultTableModel model_2 = new DefaultTableModel();
        
		table = new JTable(model);		
		// Create a a column
		model.addColumn("Store"); 
		// Append rows
		for(String s: storeAttributes)
			model.addRow(new Object[]{s});
		table.setBackground(Color.LIGHT_GRAY);
		table.setBounds(50, 100, 350, 500);
		frame.getContentPane().add(table);
		
		table_1 = new JTable(model_1);
		// Create a a column
		model_1.addColumn("Store"); 
		// Append rows
		for(String s: timeAttributes)
			model_1.addRow(new Object[]{s});
		table_1.setBackground(Color.LIGHT_GRAY);
		table_1.setBounds(457, 100, 350, 500);
		frame.getContentPane().add(table_1);
		
		table_2 = new JTable(model_2);
		// Create a a column
		model_2.addColumn("Store"); 
		// Append rows
		for(String s: productAttributes)
			model_2.addRow(new Object[]{s});
		table_2.setBackground(Color.LIGHT_GRAY);
		table_2.setBounds(865, 100, 350, 500);
		frame.getContentPane().add(table_2);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e){
			  EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							MainWindow window = new MainWindow();
							frame.dispose();
							window.frame2.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
			  });
			  }
			});
		btnNewButton.setBounds(585, 650, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		frame.setBounds(50, 50, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
