package me.sureshs.paintcalculator.util;

/**
 * Enum to hold page titles and dimension field names
 * 
 * @author suresh
 *
 */
public enum TestData {

	Home("Calculating Paint Amount"),		//page title for home page
	Dimensions("Dimension Calculation"),	//page title for dimensions calculation page
	Results("Results!"),					//page title for Results page
	
	Length("length-"), 						//locator name for length fields in dimensions page
	Width("width-"), 						//locator name for width fields in dimensions page
	Height("height-");						//locator name for height fields in dimensions page

	private final String value;

	TestData(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
	
	public String getName() {
		return this.name();
	}
	
}
