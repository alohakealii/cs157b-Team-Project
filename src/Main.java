import java.util.ArrayList;

import com.mysql.jdbc.Connection;

public class Main {
	
	static final int STORE = 0;
	static final int PRODUCT = 1;
	static final int TIME = 2;
	static final int DIMENSIONS = 3;
	
	public static void main(String[] args) {
		Connection connection = ConnectionFactory.getMYSQLConnection();
	    Operation operation = new Operation(connection);
	    
	    String[] dimensions = new String[DIMENSIONS];
	    dimensions[STORE] = "store_state";
	    dimensions[PRODUCT] = "brand";
	    dimensions[TIME] = "year";
	    
	    System.out.println("dimensions set\n\n" + dimensions);
	    System.out.println("Getting data");
	    ArrayList<LineItem> table = operation.getData(dimensions);
	    System.out.println("Got data:");
	    System.out.println(table);
	    System.out.println("\nPrinted");
	}
}
