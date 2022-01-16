package helpers

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.FooterActions
import internal.GlobalVariable
import items.FooterItems
import validations.FooterValidations


public class FooterHelpers {

	/***
	 * verify clicking on social links with validations
	 * @author nesma
	 */
	public static void verifySocialLinks() {
		List <WebElement> socialLinks = WebUI.findWebElements(FooterItems.socialLinks,
				GlobalVariable.elementVisibilityTimeOut)
		for(WebElement socialLink : socialLinks) {
			TestObject socialLinkTestobject = WebUI.convertWebElementToTestObject(socialLink)
			String expectedUrl= WebUI.getAttribute(socialLinkTestobject, 'href')
			String linkedinUrl ='https://www.linkedin.com/'
			WebUI.verifyElementClickable(socialLinkTestobject)
			FooterActions.clickOnFooterItem(socialLinkTestobject)
			if(expectedUrl.contains('linkedin')) {
				FooterValidations.verifyWindowUrl(linkedinUrl)
				FooterValidations.verifyWindowTitle(WebUI.getWindowTitle())
				WebUI.closeWindowUrl(WebUI.getUrl())
			}else {
				this.newWindowVlidations(expectedUrl)
			}
			WebUI.switchToDefaultContent()
		}
	}
	/**
	 * validation for new window then close window
	 * @param expectedUrl
	 * @author nesma
	 */
	public static void newWindowVlidations(String expectedUrl ) {
		FooterValidations.verifyWindowUrl(expectedUrl)
		FooterValidations.verifyWindowTitle(WebUI.getWindowTitle())
		WebUI.closeWindowUrl(expectedUrl)
	}
	/**
	 * verify contact speakers content
	 */
	public static void verifyContactSpeakers(String...expectedContent) {
		List <WebElement> contactSpeakers = WebUI.findWebElements(FooterItems.contactNumbers,
				GlobalVariable.elementVisibilityTimeOut)
		for(int i=0; i< contactSpeakers.size(); i++) {
			TestObject contactNumberTestobject = WebUI.convertWebElementToTestObject(contactSpeakers[i])
			FooterValidations.verifyItemContent(contactNumberTestobject,expectedContent[i])
		}
	}
}
