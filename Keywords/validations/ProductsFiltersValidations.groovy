
package validations

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.ProductFiltersActions
import helpers.GeneralHelpers
import internal.GlobalVariable
import items.ProductFiltersItems


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
		boolean isSelectedFiltersSectionExist = WebUI.verifyElementPresent(findTestObject(ProductFiltersItems.selectedFilters),GlobalVariable.elementVisibilityTimeOut, FailureHandling.CONTINUE_ON_FAILURE)
		System.out.println(isSelectedFiltersSectionExist)

		if (isSelectedFiltersSectionExist) {
			List<WebElement> selectedFilters = WebUI.findWebElements(findTestObject(ProductFiltersItems.selectedFilters),GlobalVariable.elementVisibilityTimeOut)
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
		List<TestObject> paginationLinks = WebUI.findWebElements(findTestObject('SearchResultPage/a_paginationLinks'),
				GlobalVariable.elementVisibilityTimeOut)

		assert paginationLinks.size() == size
	}

	/***
	 * Verify selected value reflected
	 * @param expectedValue
	 * @param selectFeild
	 * @author nesma 
	 */
	public static void verifySelectedOptionValue(String expectedValue, TestObject selectField) {
		WebUI.verifyOptionSelectedByValue(selectField,expectedValue, false,GlobalVariable.actionsTimeout)
	}
	/***
	 * verify manufacturer selected by default
	 * @author nesma
	 */
	public static void verifyManufactorSelectedByDefault() {
		WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Filters/btn_manufacture'), 'title',
				'Manufacturer', GlobalVariable.actionsTimeout)
	}
	/***
	 * verify model selection is disabled
	 * @author nesma
	 */
	public static void verifyModelSelectIsDisabled() {
		TestObject selectModel = findTestObject('Object Repository/Filters/select_modelFilter')
		WebUI.verifyElementNotClickable(selectModel)
	}
	/***
	 * verify specific filter disappeared
	 * @param filterSection
	 * @author nesma
	 */
	public static void verifyFilterDisappeared(TestObject... filterSection) {
		for(int i=0 ; i<filterSection.length ; i++) {
			WebUI.verifyElementNotPresent(filterSection[i],GlobalVariable.actionsTimeout )
		}
	}

	/***
	 * verify model selection is enabled
	 * @author nesma
	 */
	public static void verifyModelSelectIsEnabled() {
		TestObject selectModel = findTestObject('Object Repository/Filters/select_modelFilter')
		WebUI.verifyElementClickable(selectModel)
	}
}
