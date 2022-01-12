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
import org.openqa.selenium.WebElement

public class ComputerAndRegisterPageValidations {

	/***
	 * Verify current page heading match the expected heading
	 * @param expectedHeading
	 * @author nesma
	 */
	public static void verfiyCurrentPageHeading(String expectedHeading) {
		TestObject computerAndRegisterHeading =
				findTestObject('Object Repository/ComputerAndRegisterPage/h1_computerAndRegisterHeading')
		assert WebUI.getText(computerAndRegisterHeading).equalsIgnoreCase(expectedHeading)
	}

	/***
	 * verify breadcrumb content match the expected content
	 * @param expectedContent
	 * @param expectedContentTwo
	 */
	public static void verifyBreadcrumbContent(String expectedContent, String expectedContentTwo) {
		List <WebElement> breadcrumbList =
				WebUI.findWebElements(findTestObject("Object Repository/ComputerAndRegisterPage/li_breadcrumb"),
				GlobalVariable.elementVisibilityTimeOut)
		breadcrumbList.get(0).getText().contains(expectedContent)
		breadcrumbList.get(1).getText().contains(expectedContentTwo)
	}
}
