

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
import javax.swing.JOptionPane;
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
		storeAttributes = new ArrayList<>(Arrays.asList("store_street_address","city",
				"store_county","store_state","sales_region"));
		timeAttributes = new ArrayList<>(Arrays.asList("day_number_in_month",
				"week_number_in_year","Month","quarter","year"));
		productAttributes = new ArrayList<>(Arrays.asList("brand","subcategory",
				"category","department"));
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
							if(table.getSelectionModel().isSelectionEmpty() || 
									table_1.getSelectionModel().isSelectionEmpty() || 
									table_2.getSelectionModel().isSelectionEmpty()){
								JOptionPane.showMessageDialog(frame, "Select at least 2 attributes to start the simulation");
							}
							
							Main.storein = storeAttributes.get(table.getSelectedRow());
							Main.timein = timeAttributes.get(table_1.getSelectedRow());
							Main.productin = productAttributes.get(table_2.getSelectedRow());
							
							MainWindow window = new MainWindow();
							frame.dispose();
							window.frame2.setVisible(true);
							System.out.println(Main.storein + " " + Main.timein + " " + Main.productin);
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
