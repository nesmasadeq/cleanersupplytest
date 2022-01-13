
package validations

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import helpers.GeneralHelpers
import internal.GlobalVariable


public class ProductsFiltersValidations {

	/**
	 * Verify filter checkBox is checked
	 * @param testObject
	 * @author Eng. Amal Hamad
	 */
	public static void verifyFilterIsChecked(TestObject testObject) {
		System.out .println("getClass: " + WebUI.getAttribute(testObject, "class"))
		assert WebUI.getAttribute(testObject, "class").contains("selected")
	}


	/**
	 * Verify filter products count match results count
	 * @param filterCount
	 * @param resultsCount
	 * @author Eng. Amal Hamad
	 */
	public static void verifyFilterProductsCountMatchResultsCount(TestObject filterCount , TestObject resultsCount) {
		int filterProductsCount = GeneralHelpers.convertStringToInteger(filterCount)

		System.out.println('filterProductsCount: ' + filterProductsCount)

		int productsCountInHeader = GeneralHelpers.convertStringToInteger(resultsCount)

		System.out.println('productsCountInHeader: ' + productsCountInHeader)

		assert filterProductsCount == productsCountInHeader
	}

	/**
	 * Verify selected filters found in selectedFiltersSections
	 * @param filters
	 * @author Eng. Amal Hamad
	 */
	public static void verifySelectedFilters(String... filters) {
		String selector ='Object Repository/Filters/ul_selectedFilters'
		boolean isSelectedFiltersSectionExist = WebUI.verifyElementPresent(findTestObject(selector),10, FailureHandling.OPTIONAL)
		System.out.println(isSelectedFiltersSectionExist)

		if (isSelectedFiltersSectionExist) {
			List<WebElement> selectedFilters = WebUI.findWebElements(findTestObject(selector),
					GlobalVariable.elementVisibilityTimeOut)
			for(int i = 0 ; i<selectedFilters.size() ; i++) {
				TestObject object = WebUI.convertWebElementToTestObject(selectedFilters.get(i))
				System.out.println('selectedFilters: ' + WebUI.getText(object))
				assert filters[i].equals( WebUI.getText(object))
			}
		}
	}

	/**
	 * Verify pagination is changed
	 * @param size
	 * @author Eng. Amal Hamad
	 */
	public static void verifyPaginationIsChanged(int size) {
		List<TestObject> paginationLinks = WebUI.findWebElements(findTestObject('Object Repository/scenario01/results_page/a_paginationLinks'),
				GlobalVariable.elementVisibilityTimeOut)

		assert paginationLinks.size() == size
	}
}
