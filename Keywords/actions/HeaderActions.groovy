package actions

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject


public class HeaderActions {

	//----------- Cart Section
	public static String cartCount = 'Object Repository/Header/span_cartCount'
	public static String cartLabel = 'Object Repository/Header/span_cartLabel'


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
	 * Hover over Cart icon in Header
	 * @author Eng. Amal Hamad
	 */
	public static void hoverCartIcon(TestObject testObject) {
		System.out.println("Before Hover: " + WebUI.getCSSValue(testObject, 'background'))
		assert WebUI.getCSSValue(testObject, "color").contains("rgb(255, 255, 255)")
		WebUI.mouseOver(testObject)
		System.out.println("After Hover: " + WebUI.getCSSValue(testObject, 'background'))
		assert WebUI.getCSSValue(testObject, "color").contains("rgb(119, 120, 123)")
	}

	/**
	 * Click on Cart icon in header
	 * @author Eng. Amal Hamad
	 */
	public static void clickCartIcon() {
		TestObject testObject = findTestObject(HeaderActions.cartLabel)
		WebUI.click(testObject)
	}
}
