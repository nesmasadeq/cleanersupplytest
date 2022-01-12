package helpers


import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.Navigations
import internal.GlobalVariable
import validations.GeneralValidations

public class GeneralHelpers {
	/***
	 * initial the site
	 * @author nesma
	 */
	public static void initScenario() {
		WebUI.openBrowser('');
		WebUI.maximizeWindow()

		Navigations.navigateToHomePage()
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimout)
		GeneralValidations.verifyCurrentPageURL(GlobalVariable.baseUrl)
	}

	/**
	 * Remove non-digits from String and convert it to Integer
	 * @param testObject
	 * @return integer
	 * @author Eng. Amal Hamad
	 */
	public static int covertStringToInteger(TestObject testObject) {
		return Integer.parseInt(WebUI.getText(testObject).replaceAll('\\D+', ''))
	}
}
