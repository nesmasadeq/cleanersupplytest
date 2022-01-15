package actions

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import items.HeaderItems

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject


public class HeaderActions {

	/***
	 * Hovering on tags & forms link
	 * @author nesma
	 */
	public static void hoverOnTagsAndFormsLink() {
		WebUI.mouseOver(findTestObject('Object Repository/Header/a_tagsAndForms'))
	}

	/***
	 * Clicking on computers and register link
	 * @author nesma
	 */
	public static void clickOnComputersAndRegisterLink() {
		WebUI.click(findTestObject('Object Repository/Header/a_computerAndRegister'))
	}

	/**
	 * Click on Cart icon in header
	 * @author Eng. Amal Hamad
	 */
	public static void clickCartIcon() {
		WebUI.click(HeaderItems.cartLabel)
	}

	/**
	 * Back to home page
	 * @author Eng. Amal Hamad
	 */
	public static void backToHome() {
		WebUI.back()
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimout)
	}
}
