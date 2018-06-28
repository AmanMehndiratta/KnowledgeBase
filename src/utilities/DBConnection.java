package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {

	public static Connection connObj;
	static Properties prop = new Properties();

	public static String getDbConnection(String query) throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/utilities/OR.properties");
		prop.load(fis);

		try {
			String dbString = prop.getProperty("dbConnectionString");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connObj = DriverManager.getConnection("jdbc:sqlserver://qa2012r2-am3.inqa.soti.net\\sqlexpress:1433;databasename=DiscussionForum","sa","Welcome1234");
			Statement stmt = connObj.createStatement();
			if (connObj != null) {
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					String count = rs.getString(1);
					System.out.println(count);
					return count;
				}
			}
			connObj.close();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

		}
		return null;

	}

}
