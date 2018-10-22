package com.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class WebDriverFactory {

	public static WebDriver createWebDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\juan.feuillet.BABEL-SI\\Documents\\Proyectos\\chromedriver\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(chromeOptions);
				
		return driver;
	}
}
