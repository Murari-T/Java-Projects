package config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfig {

	private static final Properties properties=new Properties();
	private static final PropertiesConfig propertiesConfig=new PropertiesConfig();
	
	
	private PropertiesConfig()
	{
		try {
			FileReader fileReader1=new FileReader("D:\\java_projects\\Student Managment System\\src\\resources\\database.properties");
			properties.load(fileReader1);
		} catch (IOException e) {
			System.out.println("Error in File ");
		}
	}
	
	public static PropertiesConfig getInstance()
	{
		return propertiesConfig;
	}
	
	public String getProperty(String key)
	{
		return properties.getProperty(key);
	}

}
