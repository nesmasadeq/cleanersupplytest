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

public class FooterItems {
	static TestObject exclusiveEmail = findTestObject('Object Repository/Footer/span_exclusiveEmail')
	static TestObject getSpecial = findTestObject('Object Repository/Footer/span_getSpecial')
	static TestObject newsLetterEmail = findTestObject('Object Repository/Footer/input_newsletterEmail')
	static TestObject signUpButton = findTestObject('Object Repository/Footer/a_signUp')
	static TestObject sigunUpSuccessMessage =findTestObject('Object Repository/Footer/span_signUpSuccessMessage')
	static TestObject followUs =findTestObject('Object Repository/Footer/span_folowUs')
	static TestObject socialLinks = findTestObject('Object Repository/Footer/a_socialMediaLinks')
	static TestObject connectWithUs = findTestObject('Object Repository/Footer/span_connectWithUs')
	static TestObject contactEmail = findTestObject('Object Repository/Footer/a_contactEmail')
	static TestObject contactTime = findTestObject('Object Repository/Footer/strong_contactTime')
	static TestObject contactNumbers = findTestObject('Object Repository/Footer/span_contactNumbers')
	static TestObject chatOffline = findTestObject('Object Repository/Footer/span_chatOffline')
	static TestObject catalogRequest = findTestObject('Object Repository/Footer/a_catalogRequest')
	static TestObject classified = findTestObject('Object Repository/Footer/a_calssifides')
	static TestObject regionSelect = findTestObject('Object Repository/Footer/select_region')
	static TestObject feadbackButton = findTestObject('Object Repository/Footer/button_leaveFeedback')
	static TestObject feadbackModal = findTestObject('Object Repository/Footer/div_feedbackModal')
	static TestObject infoHelper = findTestObject('Object Repository/Header/span_infoHelper')
	static TestObject closeModalButton = findTestObject('Object Repository/Footer/button_closeModal')
	static TestObject simpleFooterItems = findTestObject('Object Repository/Footer/li_simpleFooter')
	static TestObject termsLink = findTestObject('Object Repository/Footer/a_terms')
	static TestObject policyLink = findTestObject('Object Repository/Footer/a_policy')
}
