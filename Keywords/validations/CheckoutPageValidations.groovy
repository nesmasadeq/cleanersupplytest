package validations

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class CheckoutPageValidations {
	/***
	 * Verify current page heading match the expected heading
	 * @param expectedHeading
	 * @author nesma
	 */
	public static void verfiyCheckoutPageHeading(String expectedHeading) {
		TestObject checkoutHeading =
				findTestObject('Object Repository/CheckoutPage/h1_pageHeading')
		assert WebUI.getText(checkoutHeading).equalsIgnoreCase(expectedHeading)
	}

	/***
	 * verify the current field be focused
	 * @param inputField
	 * @author nesma
	 */
	public static void verifyFocusedField(TestObject inputField) {
		String focusedStyle = WebUI.getCSSValue(inputField, 'border-color')
		assert focusedStyle.contains('rgb(99, 99, 99)')
	}

	/***
	 * verify the filled value match the expected value
	 * @param expectedValue
	 * @param inputField
	 */
	public static void verifyInputValueReflected(String expectedValue, TestObject inputField) {
		assert WebUI.getAttribute(inputField, 'value').equals(expectedValue)
	}
}
