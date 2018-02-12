package me.sureshs.paintcalculator.actions;

import java.util.List;

import org.openqa.selenium.WebDriver;

import me.sureshs.paintcalculator.pages.DimensionsPage;
import me.sureshs.paintcalculator.pages.HomePage;
import me.sureshs.paintcalculator.pages.PagesFactory;
import me.sureshs.paintcalculator.pages.ResultsPage;
import me.sureshs.paintcalculator.util.Room;
import me.sureshs.paintcalculator.util.TestData;

/**
 * single class as an actions layer between step definitions and page objects
 *   
 * @author suresh
 *
 */
public class PaintCalculatorActions {

	private WebDriver driver;

	private PagesFactory page;

	public PaintCalculatorActions(WebDriver driver) {

		this.driver = driver;

		page = new PagesFactory(driver);

	}

	/**
	 * enter number of rooms in home page and click submit button
	 * 
	 * @param num
	 */
	public void submitNumRooms(String num) {
		if (num.isEmpty())
			page.getInstanceOf(HomePage.class).clickSubmit();
		else
			page.getInstanceOf(HomePage.class).submitRoomCount(num);

	}

	/**
	 * enter value for a single length, width or height for a given room
	 * 
	 * @param dimension
	 *            - specifies which dimension needs to be set (length / width /
	 *            height)
	 * @param row
	 *            - specifies row number in table (room 1, room 2 etc)
	 * @param value
	 *            - value for length / width / height which needs to be set
	 */
	public void setSingleDimensionForRoom(TestData dimension, int row, String value) {

		page.getInstanceOf(DimensionsPage.class).setValue(dimension.getValue() + row, value);

	}

	/**
	 * enter all dimensions for all rooms and click submit
	 * 
	 * @param rooms
	 *            - list of Room objects which holds all dimension values for all
	 *            rooms
	 */
	public void submitRoomDimensions(List<Room> rooms) {

		for (Room room : rooms) {

			int i = rooms.indexOf(room);

			setSingleDimensionForRoom(TestData.Length, i, room.getLength());
			setSingleDimensionForRoom(TestData.Width, i, room.getWidth());
			setSingleDimensionForRoom(TestData.Height, i, room.getHeight());

		}

		page.getInstanceOf(DimensionsPage.class).clickSubmit();
	}

	/**
	 * get table row count for given page
	 * 
	 * @param pageName
	 * @return
	 */
	public int getRowCount(String pageName) {

		int numRows = 0;

		if (pageName.equalsIgnoreCase("Dimensions")) {

			numRows = page.getInstanceOf(DimensionsPage.class).getRowCount() - 1;

		} else if (pageName.equalsIgnoreCase("Results")) {

			numRows = page.getInstanceOf(ResultsPage.class).getRowCount() - 1;

		}

		return numRows;
	}

	/**
	 * click home button in Results page
	 */
	public void navigateToHome() {

		page.getInstanceOf(ResultsPage.class).clickSubmit();

	}

	/**
	 * get list of surface area or gallons required for all rooms from results page
	 * 
	 * @param type
	 * @return
	 */
	public List<String> getResults(String type) {

		if (type.equalsIgnoreCase("surface area"))

			return page.getInstanceOf(ResultsPage.class).getSurfaceArea();

		else

			return page.getInstanceOf(ResultsPage.class).getGallonsRequired();

	}

	/**
	 * get total gallons required from results page
	 * 
	 * @return
	 */
	public String getTotalGallons() {

		return page.getInstanceOf(ResultsPage.class).getTotalGallons();

	}

	/**
	 * get expected page title of current page from TestData enum
	 * 
	 * @param title
	 * @return
	 */

	public String getExpectedPageTitle(TestData title) {

		return title.getValue();

	}

	/**
	 * get actual page title of current page from WebDriver
	 * 
	 * @return
	 */
	public String getTitle() {

		return driver.getTitle();

	}

}
