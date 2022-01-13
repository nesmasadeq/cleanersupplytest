package items

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

public class CheckoutPageItems {
	static TestObject companyField = findTestObject('Object Repository/CheckoutPage/input_companyField')
	static TestObject firstNameField = findTestObject('Object Repository/CheckoutPage/input_fName')
	static TestObject lastNameField = findTestObject('Object Repository/CheckoutPage/input_lName')
	static TestObject firstAddressField = findTestObject('Object Repository/CheckoutPage/input_address1')
	static TestObject secondAddressField = findTestObject('Object Repository/CheckoutPage/input_address2')
	static TestObject zipCodeField = findTestObject('Object Repository/CheckoutPage/input_zipCode')
	static TestObject cityField = findTestObject('Object Repository/CheckoutPage/inpur_city')
	static TestObject stateSelect = findTestObject('Object Repository/CheckoutPage/select_state')
	static TestObject phoneField = findTestObject('Object Repository/CheckoutPage/input_phone')
	static TestObject extField = findTestObject('Object Repository/CheckoutPage/input_ext')
	static TestObject emailField = findTestObject('Object Repository/CheckoutPage/input_email')
	static TestObject collapseLink = findTestObject('Object Repository/CheckoutPage/a_fastCollapse')
	static TestObject shippingOptionRadio = findTestObject('Object Repository/CheckoutPage/radioBtn_shippingOption')
	static TestObject cardNameField = findTestObject('Object Repository/CheckoutPage/input_cardName')
	static TestObject cardNumberField = findTestObject('Object Repository/CheckoutPage/input_cardNumber')
	static TestObject securityNumberField = findTestObject('Object Repository/CheckoutPage/input_securityCode')
	static TestObject expirationDateSelect = findTestObject('Object Repository/CheckoutPage/select_expirationDate')
	static TestObject expirationYearSelect = findTestObject('Object Repository/CheckoutPage/select_expirationYear')
	static TestObject billingAddressCheckbox = findTestObject('Object Repository/CheckoutPage/checkbox_billingAddress')
	static TestObject poField = findTestObject('Object Repository/CheckoutPage/input_po')
	static TestObject commentsField = findTestObject('Object Repository/CheckoutPage/textarea_comments')
}
