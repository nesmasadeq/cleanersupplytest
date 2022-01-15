package validations

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI



public class FooterValidations {
	public static void verifyItemContent(TestObject footerItem, String expectedContent) {
		assert WebUI.getText(footerItem).equals(expectedContent)
	}
}
