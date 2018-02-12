package me.sureshs.paintcalculator.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	static WebDriver driver;

	@Before
	public void setup() {
		String browserName = System.getProperty("Browser");
		if (browserName.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else
			driver = new ChromeDriver();

	}

	/**
	 * close browser after each scenario in feature file
	 */
	@After
	/**
	 * Embed a screenshot in test report if test is marked as failed
	 */
	public void embedScreenshot(Scenario scenario) {

		driver.quit();

	}

}
