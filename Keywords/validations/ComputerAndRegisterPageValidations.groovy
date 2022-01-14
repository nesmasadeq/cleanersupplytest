package validations

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import helpers.GeneralHelpers
import internal.GlobalVariable

public class ComputerAndRegisterPageValidations {

	/***
	 * Verify current page heading match the expected heading
	 * @param expectedHeading
	 * @author nesma
	 */
	public static void verfiyCurrentPageHeading(String expectedHeading) {
		TestObject computerAndRegisterHeading =
				findTestObject('Object Repository/ComputerAndRegisterPage/h1_computerAndRegisterHeading')
		assert WebUI.getText(computerAndRegisterHeading).equalsIgnoreCase(expectedHeading)
	}

	/***
	 * verify breadcrumb content match the expected content
	 * @param expectedContent
	 */
	public static void verifyBreadcrumbContent(String... expectedContent) {
		List <WebElement> breadcrumbList =
				WebUI.findWebElements(findTestObject("Object Repository/ComputerAndRegisterPage/li_breadcrumb"),
				GlobalVariable.elementVisibilityTimeOut)
		for(int i=0 ; i<breadcrumbList.size() ; i++) {
			assert breadcrumbList.get(i).getText().contains(expectedContent[i])
		}
	}
	/***
	 * verify result count in header match the total count in filter
	 */
	public static void verifyHeaderResultCount() {
		List <WebElement> materialList = WebUI.findWebElements(findTestObject('Object Repository/Filters/span_materailOptionCount'),
				GlobalVariable.elementVisibilityTimeOut)
		TestObject headerResult = findTestObject('Object Repository/ComputerAndRegisterPage/h2_headerResult')
		int productsCountInHeader=0
		for(WebElement materialOption : materialList) {
			productsCountInHeader += Integer.parseInt(materialOption.getText().replaceAll('\\D+', ''))
		}
		assert WebUI.getText(headerResult).contains(productsCountInHeader+"")
	}
}
