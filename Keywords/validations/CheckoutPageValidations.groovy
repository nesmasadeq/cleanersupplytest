package validations

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import items.CheckoutPageItems

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
		//		assert focusedStyle.contains('rgb(99, 99, 99)')
	}

	/***
	 * verify the filled value match the expected value
	 * @param expectedValue
	 * @param inputField
	 */
	public static void verifyInputValueReflected(String expectedValue, TestObject inputField) {
		assert WebUI.getAttribute(inputField, 'value').equals(expectedValue)
	}

	/***
	 * verify the selected option value is reflected
	 * @param selectFeild
	 * @param expectedValue
	 */
	public static void verifyTheSelectedOptionValueIsReflected(TestObject selectFeild, String expectedValue ) {
		WebUI.verifyOptionSelectedByValue(selectFeild,expectedValue, false, GlobalVariable.actionsTimeout)
	}
	/***
	 * verify the fast free section is appeared
	 * @author nesma
	 */
	public static void verifyTheFastFreeSectionIsAppeared() {
		WebUI.verifyElementPresent(CheckoutPageItems.collapseLink, GlobalVariable.actionsTimeout)
	}
	/***
	 * verify shipping option is selected
	 * @author nesma
	 */
	public static void verifyShippingOptionIsSelected() {
		WebUI.verifyElementChecked(CheckoutPageItems.shippingOptionRadio, GlobalVariable.actionsTimeout)
	}
	/***
	 * verify billing address is checked
	 * @author nesma
	 */
	public static void verifyBillingAddressIsChecked() {
		WebUI.verifyElementChecked(CheckoutPageItems.billingAddressCheckbox,GlobalVariable.actionsTimeout)
	}
	public static void verifyCommentTextIsReflected(String expectedValue) {
		assert WebUI.getText(CheckoutPageItems.commentsField).contains(expectedValue)
	}
}
