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
import items.HeaderItems

public class GeneralValidations {

	/***
	 * verify current page title match the expected title
	 * @param expectedTitle
	 * @author nesma
	 */
	public static void verifyCurrentPageTitleValue(String expectedTitle) {
		assert WebUI.getWindowTitle().equals(expectedTitle)
	}

	/**
	 * Verify Current Page URL matched the passed url
	 * @param expectedURL expectedURL or part of expectedURL
	 * @author nesma
	 */
	public static void verifyCurrentPageURL(String expectedURL) {
		assert WebUI.getUrl().contains(expectedURL)
		HeaderValidations.verifyHeaderLogo()
	}

	/**
	 * Verify Current Page Heading match expected heading
	 * @param expectedHeading
	 * @author Eng. Amal Hamad
	 */
	public static void verifyPageHeading(String expectedHeading) {
		TestObject pageHeader = findTestObject(HeaderItems.pageHeading)
		assert WebUI.getText(pageHeader).contains(expectedHeading)
	}

	/**
	 * Verify shadow after button hovering
	 * @param button
	 * @author Eng. Amal Hamad
	 */
	public static void verifyButtonShadowHover(TestObject button) {
		WebUI.mouseOver(button)
		//------ After Hover -------
		System.out.println("box-shadow: " +  WebUI.getCSSValue(button, "box-shadow"))
		assert  WebUI.getCSSValue(button, "box-shadow").contains("rgba(0, 0, 0, 0.3) 0px 0px 10px 2px")
	}
}
