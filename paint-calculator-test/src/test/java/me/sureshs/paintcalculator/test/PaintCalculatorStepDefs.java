package me.sureshs.paintcalculator.test;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import me.sureshs.paintcalculator.actions.PaintCalculatorActions;
import me.sureshs.paintcalculator.util.Room;
import me.sureshs.paintcalculator.util.TestData;

/**
 * Step definitions for feature file
 * 
 * @author suresh
 *
 */
public class PaintCalculatorStepDefs {
	WebDriver driver;

	PaintCalculatorActions actions;

	public PaintCalculatorStepDefs() {
		driver = Hooks.driver;
		actions = new PaintCalculatorActions(driver);
	}

	@Given("^I am in Home page$")
	public void open_browser_and_launch_app() {

		driver.get("http://localhost:5000");

	}

	@When("^I submit number of rooms as (.*?)$")
	public void submit_number_of_rooms(String num) {

		actions.submitNumRooms(num);

	}

	@And("^I submit room dimensions as:$")
	public void submit_room_dimensions(DataTable dataTable) {

		List<Room> rooms = dataTable.asList(Room.class);

		actions.submitRoomDimensions(rooms);

	}

	@And("^I click on Home button$")
	public void click_home_button() {
		actions.navigateToHome();
	}

	@Then("^I should see (\\d+) rows in (.*?) page$")
	public void verify_row_count(int num, String page) {

		Assert.assertEquals(num, actions.getRowCount(page));

	}

	@Then("^I should see (.*?) calculated in Results page for each room as:$")
	public void verify_results(String param, DataTable dataTable) throws Exception {

		Assert.assertEquals(dataTable.asList(String.class), actions.getResults(param));

	}

	@Then("^I should be in (.*?) page$")
	public void verify_navigation(TestData pageName) {

		Assert.assertEquals(actions.getExpectedPageTitle(pageName), actions.getTitle());
	}

	@Then("^I should see Total Gallons Required in Results page as (\\d+)$")
	public void verify_total_gallons_required(int total) {

		Assert.assertEquals(String.valueOf(total), actions.getTotalGallons());
	}

	@Then("^I should stay in (.*?) page and get an error message$")
	public void verify_invalid_inputs(TestData pageName) {

		Assert.assertEquals(actions.getExpectedPageTitle(pageName), actions.getTitle());

	}
}
