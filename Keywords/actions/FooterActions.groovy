package actions

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import items.FooterItems


public class FooterActions {
	/***
	 * click on footer item
	 * @param footerItem
	 * @author nesma
	 */
	public static void clickOnFooterItem(TestObject footerItem) {
		WebUI.click(footerItem)
	}

	/**
	 * fill newsletter email input
	 * @author nesma
	 */
	public static void fillingNewsLetterEmail() {
		WebUI.sendKeys(FooterItems.newsLetterEmail, GlobalVariable.email)
	}
	/**
	 * select Canada region
	 * @author nesma
	 */
	public static void selectRegion() {
		WebUI.selectOptionByValue(FooterItems.regionSelect, "https://www.cleanersupply.ca/", false)
	}
}
