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
		GeneralValidations.verifyCurrentPageTitleValue(GlobalVariable.siteTitle)
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
	 * @author nesma
	 */
	public static void CheckingPageURLTitleAndHeading(String expectedUrl, String expectedTitle, String expectedHeading) {
		GeneralValidations.verifyCurrentPageURL(expectedUrl)
		GeneralValidations.verifyCurrentPageTitleValue(expectedTitle)
		GeneralValidations.verifyPageHeading(expectedHeading)
	}

	/**
	 * Get text for this field
	 * @param testObject
	 * @return field text
	 * @author Eng. Amal Hamad
	 */
	public static String getFieldText(TestObject testObject) {
		return WebUI.getText(testObject).trim()
	}

	/**
	 * Get title attribute for this field
	 * @param testObject
	 * @return field title attribute
	 * @author Eng. Amal Hamad
	 */
	public static String getFieldTitle(TestObject testObject) {
		return WebUI.getAttribute(testObject, 'title').trim()
	}

	/**
	 * Get input value for this field
	 * @param testObject
	 * @return input value
	 * @author Eng. Amal Hamad
	 */
	public static String getFieldInputValue(TestObject testObject) {
		return WebUI.getAttribute(testObject, 'value').trim()
	}

	/**
	 * Get inner text for this field
	 * @param testObject
	 * @return inner text
	 * @author Eng. Amal Hamad
	 */
	public static String getFieldInnerText(TestObject testObject) {
		return WebUI.getAttribute(testObject, 'innerText').trim()
	}

	/**
	 * Get classes for this field
	 * @param testObject
	 * @return field classes
	 * @author Eng. Amal Hamad
	 */
	public static String getFieldCalsses(TestObject testObject) {
		return WebUI.getAttribute(testObject, 'class').trim()
	}

	/**
	 * Get href attribute for this field
	 * @param testObject
	 * @return href
	 * @author Eng. Amal Hamad
	 */
	public static String getFieldHref(TestObject testObject) {
		return WebUI.getAttribute(testObject, "href").trim()
	}

	/**
	 * Get image src attribute for this field
	 * @param testObject
	 * @return image src
	 * @author Eng. Amal Hamad
	 */
	public static String getImageSrc(TestObject testObject) {
		return WebUI.getAttribute(testObject, "src").trim()
	}

	/**
	 * Get css background attribute for this field
	 * @param testObject
	 * @return background color
	 * @author Eng. Amal Hamad
	 */
	public static String getCssBackground(TestObject testObject) {
		return WebUI.getCSSValue(testObject, "background").trim()
	}

	/**
	 * Get css text color attribute for this field
	 * @param testObject
	 * @return text color
	 * @author Eng. Amal Hamad
	 */
	public static String getCssTextColor(TestObject testObject) {
		return WebUI.getCSSValue(testObject, "color").trim()
	}

	/**
	 * Get checked attribute for this field
	 * @param testObject
	 * @return checked
	 * @author Eng. Amal Hamad
	 */
	public static String isFieldChecked(TestObject testObject) {
		return WebUI.getAttribute(testObject, 'checked').trim()
	}
}
