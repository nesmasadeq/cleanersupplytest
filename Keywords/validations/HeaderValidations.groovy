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

public class HeaderValidations {

	static TestObject tagsAndFormLink = findTestObject('Object Repository/Header/a_tagsAndForms')
	/***
	 * Verify displaying tags and form menu
	 * @author nesma
	 */
	public static void verifyDisplayingTagsAndFormMenu() {
		TestObject TagsAndFormMenu = findTestObject('Object Repository/Header/ul_tagsAndFormsMenu')
		String TagsAndFormMenuClasses = WebUI.getAttribute(TagsAndFormMenu, 'class')
		assert TagsAndFormMenuClasses.contains('open-desktop')
	}

	/***
	 * verify tags and form background color match expected background color
	 * @param expectedBackgroundColor
	 * @author nesma
	 */
	public static void verifyTagsAndFormBackgroundColorChanged(String expectedBackgroundColor) {
		String tagsAndFormBackgroundColor= WebUI.getCSSValue(tagsAndFormLink, 'background')
		assert tagsAndFormBackgroundColor.contains(expectedBackgroundColor)
	}

	/***
	 * verify tags and form color match expected color
	 * @param expectedColor
	 * @author nesma
	 */
	public static void verifyTagsAndFormColorChanged(String expectedColor) {
		String tagsAndFormBackgroundColor= WebUI.getCSSValue(tagsAndFormLink, 'color')
		assert tagsAndFormBackgroundColor.equals(expectedColor)
	}

	/***
	 * verify computer And register link color match expected color
	 * @param expectedColor
	 * @author nesma
	 */
	public static void VerifyComputerAndRegisterColorChanged(String expectedColor) {
		TestObject computerAndRegisterLink = findTestObject('Object Repository/Header/a_computerAndRegister')
		String ComputerAndRegisterColor = WebUI.getCSSValue(computerAndRegisterLink, 'color')
		assert ComputerAndRegisterColor.contains(expectedColor)
	}
}
