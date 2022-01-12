package helpers

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


public class ProductsFiltersHelpers {


	/**
	 * Open all products filters cards in left side
	 * @author Eng. Amal Hamad
	 */
	public static void openFiltersCard() {
		List<TestObject> filtersCards = WebUI.findWebElements(findTestObject('Object Repository/scenario01/results_page/div_filtersCards'),
				5)

		System.out.println('filtersCards: ' + filtersCards.size())

		for (WebElement element : filtersCards) {
			TestObject object = WebUI.convertWebElementToTestObject(element)

			String objectClasses =  WebUI.getAttribute(object, 'class')
			System.out.println('filtersCards: ' +objectClasses)

			if( objectClasses.contains('collapsed')) {
				//				WebUI.scrollToElement(object, 5)
				//				WebUI.waitForElementClickable(object,10)
				WebUI.click(object)
			}
		}
	}
}
