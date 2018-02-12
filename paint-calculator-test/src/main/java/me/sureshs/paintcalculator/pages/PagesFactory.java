package me.sureshs.paintcalculator.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * factory for initializing page objects. with this factory in place, scaling
 * application with new pages is easy
 * 
 * @author suresh
 *
 */
public class PagesFactory {

	WebDriver driver;

	public PagesFactory(WebDriver driver) {

		this.driver = driver;

	}

	/**
	 * returns instance of any of the individual pages which extend BasePage
	 * 
	 * @param pageClass
	 * @return
	 */
	public <T extends BasePage> T getInstanceOf(Class<T> pageClass) {
		T page = null;

		try {

			page = PageFactory.initElements(driver, pageClass);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return page;
	}

}
