package me.sureshs.paintcalculator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * page object for Dimensions Page
 * 
 * @author suresh
 *
 */
public class DimensionsPage extends BasePage {

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement btnSubmit;

	@FindBy(name = "dimensions_table")
	private WebElement tblDimensionsTable;

	public DimensionsPage(WebDriver driver) {

		super(driver);
	}

	/**
	 * read value from an input field. this method can be used to read values for length, width or height
	 * 
	 * @param name	- name attribute for input field
	 * @return
	 */
	public String getValue(String name) {

		return readValue(By.name(name));
	}

	
	/**
	 * write to an input field. this method can be used to write values in length, width or height fields
	 * 
	 * @param name	- name attribute for input field	
	 * @param value
	 */
	public void setValue(String name, String value) {

		write(By.name(name), String.valueOf(value));
	}

	/**
	 * click on submit button
	 * 
	 */
	public void clickSubmit() {

		click(btnSubmit);

	}

	/**
	 * get row count of dimensions_table
	 * 
	 * @return
	 */
	public int getRowCount() {

		return getTableRowCount(tblDimensionsTable);
	}

}
