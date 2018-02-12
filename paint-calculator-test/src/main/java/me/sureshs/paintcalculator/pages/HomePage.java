package me.sureshs.paintcalculator.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * page object for Home page
 * 
 * @author suresh
 *
 */
public class HomePage extends BasePage {

	@FindBy(name = "rooms")
	private WebElement txtRoomCount;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement btnSubmit;

	public HomePage(WebDriver driver) {

		super(driver);
	}

	/**
	 * read value of rooms input field
	 * 
	 * @return
	 */
	public String getNumRoons() {

		return readValue(txtRoomCount);

	}

	/**
	 * write to rooms input field
	 * 
	 * @param num
	 */
	public void setRoomCount(String num) {

		write(txtRoomCount, num);

	}

	/**
	 * click on submit button
	 * 
	 */
	public void clickSubmit() {

		click(btnSubmit);

	}

	/**
	 * write to rooms input field and click on submit button
	 * 
	 * @param num
	 */
	public void submitRoomCount(String num) {
		setRoomCount(num);

		clickSubmit();
	}

}
