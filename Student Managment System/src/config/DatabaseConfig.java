package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig 
{
	
	private static final String Database_url="database.url";
	private static final String Database_user_name="database.user.name";
	private static final String Database_password="database.password";
	private static final PropertiesConfig propertiesConfig=PropertiesConfig.getInstance();
	
	private DatabaseConfig() { }
	
	public static Connection getConnection() throws SQLException
	{
		String url=propertiesConfig.getProperty(Database_url);
		String user_name=propertiesConfig.getProperty(Database_user_name);
		String password=propertiesConfig.getProperty(Database_password);
		return DriverManager.getConnection(url, user_name, password);
	}

}
