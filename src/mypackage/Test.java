package mypackage;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;



class DBConnection {

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "amarjeet";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}


public class Test {

	
    public static void main(String[] args) {
    	DBConnection db = new DBConnection();
    	
    	Connection conn = db.getConnection();
    	
    	
    	
    	
    	
    
}
}