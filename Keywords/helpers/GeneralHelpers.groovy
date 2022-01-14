package helpers


import java.text.DecimalFormat

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.Navigations
import internal.GlobalVariable
import validations.GeneralValidations

public class GeneralHelpers {
	/***
	 * initial the site
	 * @author nesma
	 */
	public static void initScenario() {
		WebUI.openBrowser('');
		WebUI.maximizeWindow()

		Navigations.navigateToHomePage()
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimout)
		GeneralValidations.verifyCurrentPageURL(GlobalVariable.baseUrl)
	}

	/**
	 * Remove non-digits from String and convert it to Integer
	 * @param testObject
	 * @return integer
	 * @author Eng. Amal Hamad
	 */
	public static int convertStringToInteger(TestObject testObject) {
		String textWithNumber = WebUI.getText(testObject).replaceAll("[^0-9]", "")
		return Integer.parseInt(textWithNumber)
	}

	/**
	 * Remove non-digits from String and convert it to Double
	 * @param testObject
	 * @return double
	 * @author Eng. Amal Hamad
	 */
	public static double convertStringToDouble(TestObject testObject) {
		String textWithNumber = WebUI.getText(testObject).replaceAll("[^\\d.]", "")
		return Double.parseDouble(textWithNumber)
	}

	/**
	 * Format double price to string with currency
	 * @param price
	 * @return String formated price
	 * @author Eng. Amal Hamad
	 */
	public static String formatePrice(double price) {
		String priceStr = new DecimalFormat("#.00").format(price)
		return (GlobalVariable.siteCurrency + priceStr)
	}
	/***
	 * Check if page url, title and heading match the expected values
	 * @param expectedUrl
	 * @param expectedTitle
	 * @param expectedHeading
	 */
	public static void CheckingPageURLTitleAndHeading(String expectedUrl, String expectedTitle, String expectedHeading) {
		GeneralValidations.verifyCurrentPageURL(expectedUrl)
		GeneralValidations.verifyCurrentPageTitleValue(expectedTitle)
		GeneralValidations.verifyPageHeading(expectedHeading)
	}
}
