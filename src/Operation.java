import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Operation {
	
	final int STORE = Main.STORE;
	final int PRODUCT = Main.PRODUCT;
	final int TIME = Main.TIME;
	final int DIMENSIONS = Main.DIMENSIONS;
	
	private Connection con;
	
	public Operation(Connection connection) {
		this.con = connection;
	}
	
	/**
	 * Retrieve data from the database
	 * @param dimensions The attributes for store, product, time dimensions (in that order)
	 * @return An array list of LineItems
	 */
	public ArrayList<LineItem> getData(String[] dimensions) {
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
		
		try {
			// Retrieve data from database
			Statement statement = (Statement) con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			// Put results from rs into list
			ArrayList<LineItem> tuples = new ArrayList<LineItem>();
			while (rs.next()) {
				double value = rs.getDouble("sum(dollar_sales)");
				HashMap<String, String> tupleAttributes = new HashMap<String, String>();
				if (store) {
					tupleAttributes.put(dimensions[STORE], rs.getString(dimensions[STORE]));
				}
				if (product) {
					tupleAttributes.put(dimensions[PRODUCT], rs.getString(dimensions[PRODUCT]));
				}
				if (time) {
					tupleAttributes.put(dimensions[TIME], rs.getString(dimensions[TIME]));
				}
				tuples.add(new LineItem(value, tupleAttributes));
			}
			rs.close();
			statement.close();
			return tuples;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
