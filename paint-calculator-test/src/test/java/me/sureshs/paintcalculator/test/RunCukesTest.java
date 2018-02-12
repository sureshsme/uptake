package me.sureshs.paintcalculator.test;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * junit runner for triggering execution
 * 
 * @author suresh
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "com.cucumber.listener.ExtentCucumberFormatter:" }, features = { "resources" }, glue = {
		"me.sureshs.paintcalculator.test" })
public class RunCukesTest {

	/**
	 * setup for ExtentReports. Report is created at output/test_report.html
	 * 
	 */
	@BeforeClass
	public static void setup() {

		ExtentProperties extentProperties = ExtentProperties.INSTANCE;

		extentProperties.setReportPath("output/test_report.html");

	}

}
