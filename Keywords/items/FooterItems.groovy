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
	static TestObject facebookLink = findTestObject('Object Repository/Footer/a_facebook')
	static TestObject youtubeLink = findTestObject('Object Repository/Footer/a_youtube')
	static TestObject instegramLink = findTestObject('Object Repository/Footer/a_instegram')
	static TestObject linkedInLink = findTestObject('Object Repository/Footer/a_linkedin')
}
