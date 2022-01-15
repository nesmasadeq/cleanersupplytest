package validations

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import items.FooterItems
import models.AppConstants



public class FooterValidations {
	/**
	 * verify footer item content match the expected
	 * @param footerItem
	 * @param expectedContent
	 */
	public static void verifyItemContent(TestObject footerItem, String expectedContent) {
		assert WebUI.getText(footerItem).toLowerCase().equals(expectedContent.toLowerCase())
	}

	/***
	 * switch to opened window and verify url match the expected
	 * @param expectedUrl
	 * @author nesma
	 */
	public static void verifyWindowUrl(String expectedUrl) {
		WebUI.switchToWindowIndex(1)
		assert WebUI.getUrl().contains(expectedUrl)
	}

	/***
	 * switch to opened window and verify title match the expected
	 * @param expectedUrl
	 * @author nesma
	 */
	public static void verifyWindowTitle(String expectedTitle) {
		WebUI.switchToWindowIndex(1)
		assert WebUI.getWindowTitle().contains(expectedTitle)
	}
	/***
	 * verify the sign up success message displayed and match the expected value
	 * @author nesma
	 */
	public static void verifySignUpSuccessMessage() {
		WebUI.verifyElementVisible(FooterItems.sigunUpSuccessMessage)
		assert WebUI.getText(FooterItems.sigunUpSuccessMessage).contains(AppConstants.SIGNUP_SUCCESSMESSAE)
	}
	/***
	 * verify selected region is match the expected
	 * @author nesma
	 */
	public static void verifySelectedRegion() {
		WebUI.verifyOptionSelectedByValue(FooterItems.regionSelect,AppConstants.CANADA_SELECT_VALUE, false,
			 GlobalVariable.elementVisibilityTimeOut)
	}
	
	/**
	 * verify info helper in header changed
	 * @author nesma
	 */
	public static void verifyInfoHelperChange() {
		WebUI.getText(FooterItems.infoHelper).contains(AppConstants.INFO_HELPER)
	}
	
	/***
	 * verify feedback modal displayed
	 * @author nesma
	 */
	public static void verifyFeedbackModalDisplayed() {
		WebUI.verifyElementVisible(FooterItems.feadbackModal)
	}
	/***
	 * verify feedback modal invisible
	 * @author nesma
	 */
	public static void verifyFeedbackModalDisappeared() {
		WebUI.verifyElementNotVisible(FooterItems.feadbackModal)
	}
	/***
	 * verify simple footer content match the expected
	 * @param expectedContent
	 * @author nesma
	 */
	public static void verifySimpleFooterContent(String...expectedContent) {
		List <WebElement> simpleFooterItems = WebUI.findWebElements(FooterItems.simpleFooterItems,
			GlobalVariable.elementVisibilityTimeOut)
		for(int i=0; simpleFooterItems.size(); i++) {
		TestObject simpleFooterItemTestobject = WebUI.convertWebElementToTestObject(simpleFooterItems[i])
		this.verifyItemContent(simpleFooterItemTestobject,expectedContent[i])
		}
	}
}
