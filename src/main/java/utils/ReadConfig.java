package utils;

import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	private Properties properties;

	public ReadConfig() {
		properties = new Properties();
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream("enviroment.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String get(String key) {
		return properties.getProperty(key);
	}

	public static void main(String[] args) {
		ReadConfig readConfig = new ReadConfig();
		System.out.println(readConfig.get("baseUrl"));
	}
}
