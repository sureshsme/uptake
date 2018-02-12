package me.sureshs.paintcalculator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * base page extended by individual pages. if a new page is added in the app,
 * extend this class
 * 
 * @author suresh
 *
 */
public class BasePage extends PagesFactory {

	public BasePage(WebDriver driver) {
		super(driver);

	}

	/**
	 * write to an input field.
	 * 
	 * @param input
	 *            - can be a WebElement or a By
	 * @param text
	 */
	public <T> void write(T input, String text) {
		if (input.getClass().getName().contains("By")) {
			driver.findElement((By) input).sendKeys(text);
		} else {
			((WebElement) input).sendKeys(text);
		}
	}

	/**
	 * read text value of an html element (.getText())
	 * 
	 * @param element
	 *            - can be a WebElement or a By
	 * @return
	 */
	public <T> String readText(T element) {
		if (element.getClass().getName().contains("By")) {
			return driver.findElement((By) element).getText().trim();
		} else {
			return ((WebElement) element).getText().trim();
		}
	}

	/**
	 * read text value of an input element (.getAttribute("value"))
	 * 
	 * @param input
	 *            - can be a WebElement or a By
	 * @return
	 */
	public <T> String readValue(T input) {
		if (input.getClass().getName().contains("By")) {
			return driver.findElement((By) input).getAttribute("value");
		} else {
			return ((WebElement) input).getAttribute("value");
		}
	}

	/**
	 * click on a button
	 * 
	 * @param button
	 *            - can be a WebElement or a By
	 */
	public <T> void click(T button) {
		if (button.getClass().getName().contains("By")) {
			driver.findElement((By) button).click();
			;
		} else {
			((WebElement) button).click();
		}
	}

	/**
	 * get row count of an html table
	 * 
	 * @param table
	 *            - can be a WebElement or a By
	 * @return
	 */
	public <T> int getTableRowCount(T table) {
		if (table.getClass().getName().contains("By")) {
			return driver.findElement((By) table).findElements(By.tagName("tr")).size();
		} else {
			return ((WebElement) table).findElements(By.tagName("tr")).size();
		}
	}

}
