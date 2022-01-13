package helpers

import com.kms.katalon.core.testobject.TestObject

import actions.CheckoutPageActions
import validations.CheckoutPageValidations

public class CheckoutPageHelpers {
	public static void fillInputAndVerifyFocusAndValue(TestObject inputField, String inputValue) {
		//filling company field
		CheckoutPageActions.fillInputField(inputField,inputValue)
		//verify the input has been focused
		CheckoutPageValidations.verifyFocusedField(inputField)
		//verify the value of company input reflected
		CheckoutPageValidations.verifyInputValueReflected(inputValue, inputField)
	}
}
