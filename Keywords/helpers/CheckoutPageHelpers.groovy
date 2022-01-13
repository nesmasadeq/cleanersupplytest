package helpers

import org.openqa.selenium.Keys

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.CheckoutPageActions
import validations.CheckoutPageValidations

public class CheckoutPageHelpers {
	/***
	 * verify filling input and check focus style and value
	 * @param inputField
	 * @param inputValue
	 * @author nesma
	 */
	public static void fillInputAndVerifyFocusAndValue(TestObject inputField, String inputValue) {
		//filling company field
		CheckoutPageActions.fillInputField(inputField,inputValue)
		//verify the input has been focused
		CheckoutPageValidations.verifyFocusedField(inputField)
		WebUI.sendKeys(inputField, Keys.chord(Keys.TAB))
		//verify the value of company input reflected
		CheckoutPageValidations.verifyInputValueReflected(inputValue, inputField)
	}
	
	public static void selectOptionAndVerifyReflectedValue(TestObject selectField,TestObject selectOptions) {
		//select option randomly
		String optionValue= CheckoutPageActions.selectOptionRandomly(selectOptions)
		// verify the selected value is reflected
		CheckoutPageValidations.verifyTheSelectedOptionValueIsReflected(selectField, optionValue)
	}
	
}
