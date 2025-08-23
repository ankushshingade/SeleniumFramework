package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static Properties properties;

	static {
		try {
			FileInputStream fs = new FileInputStream("src/main/resources/config.properties");
			properties = new Properties();
			properties.load(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String get(String key)
	{
		return properties.getProperty(key);
	}
	
	
}
