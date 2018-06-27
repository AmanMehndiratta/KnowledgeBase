package testData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection con = null;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 con = DriverManager.getConnection("jdbc:sqlserver://kbperfnew.cwes0ku6hria.us-east-2.rds.amazonaws.com,1433","sa","Welcome1234");
		
		Statement stmt = con.createStatement();			
		stmt.executeQuery("select * from topic");
		
	}

}
