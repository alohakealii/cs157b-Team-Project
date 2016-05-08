import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Chris on 4/30/2016.
 */
public class SQLConnectionFactory {

    static  final String database = "OLAP";
    static final String driver = "com.mysql.jdbc.Driver";
    static final String dburl = "jdbc:mysql://localhost/OLAP";

    static final String username = "root";
    static final String password = "default$";


    private static SQLConnectionFactory ourInstance = new SQLConnectionFactory();

    public static SQLConnectionFactory getInstance() {
        return ourInstance;
    }

    private SQLConnectionFactory() {


    }

    public Connection createConnection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(dburl, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return  null;
        } catch (SQLException e)
        {
            e.printStackTrace();
            return  null;
        }
    }
}
