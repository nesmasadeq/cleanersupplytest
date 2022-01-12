package actions

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject


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
}
