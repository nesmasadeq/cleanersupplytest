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

import actions.SelectCheckoutPageActions
import internal.GlobalVariable
import items.CartPageItems
import items.SelectCheckoutPageItems

public class SelectCheckoutPageValidations {

	/**
	 * Verify Checkout interstitial page heading
	 * @param expectedHeading
	 * @author Eng. Amal Hamad
	 */
	public static void verifyPageHeading(String expectedHeading) {
		TestObject pageHeader = findTestObject(SelectCheckoutPageItems.pageHeading)
		assert WebUI.getText(pageHeader).contains(expectedHeading)
	}

	/**
	 * Verify guest radio is checked
	 * @author Eng. Amal Hamad
	 */
	public static void verifyGuestRadionIsChecked() {
		TestObject guestCheckoutRadio = findTestObject(SelectCheckoutPageItems.guestCheckoutRadio)
		assert WebUI.getAttribute(guestCheckoutRadio, 'checked').equals('true')
	}

	/**
	 * Verify order total match summary total
	 * @author Eng. Amal Hamad
	 */
	public static void verifyOrderTotal() {
		TestObject summaryTotalValue = findTestObject(CartPageItems.summaryTotalValue)
		TestObject orderTotal = findTestObject(SelectCheckoutPageItems.orderTotal)
		assert WebUI.getText(orderTotal).equals(WebUI.getText(summaryTotalValue))
	}
}
