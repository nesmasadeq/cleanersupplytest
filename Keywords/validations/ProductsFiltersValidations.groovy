package validations

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class ProductsFiltersValidations {

	/**
	 * @author Eng. Amal Hamad
	 * @param filters
	 */
	public static void verifySelectedFilters(String... filters) {
		String selector ='Object Repository/scenario01/results_page/ul_selectedFilters'
		boolean isSelectedFiltersSectionExist = WebUI.verifyElementPresent(findTestObject(selector),10, FailureHandling.OPTIONAL)
		System.out.println(isSelectedFiltersSectionExist)

		if (isSelectedFiltersSectionExist) {
			List<WebElement> selectedFilters = WebUI.findWebElements(findTestObject(selector),
					5)
			for(int i=0 ; i<selectedFilters.size() ; i++) {
				TestObject object = WebUI.convertWebElementToTestObject(selectedFilters.get(i))
				System.out.println('selectedFilters: ' + WebUI.getText(object))
				assert filters[i].equals( WebUI.getText(object))
			}
		}
	}
}
