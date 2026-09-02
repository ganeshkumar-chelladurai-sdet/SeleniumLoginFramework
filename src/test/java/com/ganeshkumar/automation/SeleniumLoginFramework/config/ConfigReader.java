package com.ganeshkumar.automation.SeleniumLoginFramework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop;
	
	static {
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch(IOException e) {
			throw new RuntimeException("config.properties not found or unreadable", e);
		}
	}
	
	public static String getBrowser() {
		return prop.getProperty("browser");
	}
	
	public static String getUrl() {
		return prop.getProperty("url");
	}

}
