package com.ganeshkumar.automation.SeleniumLoginFramework.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static void initDriver(String browserName) {
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			driver.set(new ChromeDriver(options));
		} else if(browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if(browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		} else {
			throw new IllegalArgumentException("Browser not supported: " + browserName);
		}
		
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void quitDriver() {
		if(driver.get()!=null) {
			driver.get().quit();
			driver.remove();
		}
	}
	
	public static void initDriver() throws IOException{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		initDriver(browserName);
		
	}
	
	public static void main(String[] args) throws IOException, InterruptedException{
		
		initDriver();
		getDriver().get("https://rahulshettyacademy.com/loginpagePractise/");
		Thread.sleep(3000);
		quitDriver();
		
	}

}
