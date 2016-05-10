import java.util.ArrayList;

import com.mysql.jdbc.Connection;

public class Mainold {
	
	static final int STORE = 0;
	static final int PRODUCT = 1;
	static final int TIME = 2;
	static final int DIMENSIONS = 3;
	
	public static void main(String[] args) {
		Connection connection = ConnectionFactory.getMYSQLConnection();
	    Operation operation = new Operation(connection);
	    
	    // dimensions is the attributes for each dimension
	    // if don't want a dimension then use null
	    String[] dimensions = new String[DIMENSIONS];
	    dimensions[STORE] = "store_state";
	    dimensions[PRODUCT] = "brand";
	    dimensions[TIME] = "year";
	    
	    System.out.println("\ndimensions set:");
	    System.out.println(dimensions[STORE] + ", " + dimensions[PRODUCT] + ", " + dimensions[TIME]);
	    ArrayList<LineItem> table = operation.getData(dimensions);
	    System.out.println("\nData:");
	    for (LineItem item : table) {
	    	System.out.println(item.getValue() + "  " + item.getAttributes());
	    }
	}
}
