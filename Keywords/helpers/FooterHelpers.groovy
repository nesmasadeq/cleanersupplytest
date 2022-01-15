package helpers

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.FooterActions
import validations.FooterValidations
import validations.GeneralValidations


public class FooterHelpers {
	/***
	 * verify footer item match the expected content and if is clickable check page validations
	 * @param footerItem
	 * @param expectedContent
	 * @param expectedTitle
	 * @param expectedHeading
	 * @author nesma
	 */
	public static void verifyFooterItemContentAndClickability(TestObject footerItem, String expectedContent, String...expectedTitle, String...expectedHeading) {
		FooterValidations.verifyItemContent(footerItem,expectedContent)
		if(WebUI.verifyElementClickable(footerItem)) {
			FooterActions.clickOnFooterItem(footerItem)
			String expectedUrl= WebUI.getAttribute(footerItem, 'href')
			GeneralValidations.verifyCurrentPageURL(expectedUrl)
			GeneralValidations.verifyCurrentPageTitleValue(expectedTitle[0])
		}
	}
}
