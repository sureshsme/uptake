package me.sureshs.paintcalculator.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * page object for Results page
 * 
 * @author suresh
 *
 */
public class ResultsPage extends BasePage {

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement btnSubmit;

	@FindBy(xpath = "//h5")
	private WebElement totalGallons;

	@FindBy(xpath = "//table[@name='Results']")
	private WebElement tblResults;

	@FindBy(xpath = "//table[@name='Results']//td[2]")
	private List<WebElement> surfaceAreaList;

	@FindBy(xpath = "//table[@name='Results']//td[3]")
	private List<WebElement> gallonsRequiredList;

	public ResultsPage(WebDriver driver) {
		
		super(driver);
	}

	/**
	 * get row count of results table
	 * 
	 * @return
	 */
	public int getRowCount() {

		return getTableRowCount(tblResults);
	}

	/**
	 * get surface area for each room as a list from the results table
	 * 
	 * @return
	 */
	public List<String> getSurfaceArea() {
		List<String> area = new ArrayList<String>();

		for (WebElement ft : surfaceAreaList) {
			area.add(readText(ft));
		}

		return area;
	}

	/**
	 * get gallons required for each room as a list from the results table
	 * 
	 * @return
	 */
	public List<String> getGallonsRequired() {
		List<String> gallons = new ArrayList<String>();

		for (WebElement gallon : gallonsRequiredList) {
			gallons.add(readText(gallon));
		}

		return gallons;
	}

	/**
	 * click on Home button
	 * 
	 */
	public void clickSubmit() {
		click(btnSubmit);

	}

	/**
	 * read the total gallons required value
	 * 
	 * @return
	 */
	public String getTotalGallons() {

		return readText(totalGallons).replaceAll("[\\D.]", "");
	}
}
