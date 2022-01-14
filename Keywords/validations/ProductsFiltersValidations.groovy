
package validations

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.security.acl.Group

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.text.Template
import helpers.GeneralHelpers
import internal.GlobalVariable
import items.HeaderItems
import items.ProductFiltersItems
import items.SearchResultsPageItems


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
	public static void verifyFilterProductsCountMatchResultsCount(TestObject filterCount) {
		int filterProductsCount = GeneralHelpers.convertStringToInteger(filterCount)
		int productsCountInHeader = GeneralHelpers.convertStringToInteger(SearchResultsPageItems.pageSubHeader)
		System.out.println('filterProductsCount: ' + filterProductsCount + ' ##productsCountInHeader: ' + productsCountInHeader)
		assert filterProductsCount == productsCountInHeader
	}

	/**
	 * Verify filters product count in each group match results count
	 * @author Eng. Amal Hamad
	 */
	public static void verifyAnyFiltersProductsCountMatchResultsCount() {
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> filtersMainGroup = driver.findElements(By.cssSelector("div[class*= 'js-fg-']"))

		for(int i = 0 ; i < filtersMainGroup.size() ; i++) {
			WebElement groupElement = filtersMainGroup.get(i)
			//Get sub links for this Group
			List groupLinks = groupElement.findElements(By.cssSelector(".list-unstyled a"))
			int productsCount = 0
			for(int j = 0 ; j < groupLinks.size() ; j++) {
				TestObject currentFilter = WebUI.convertWebElementToTestObject(groupLinks.get(j))
				//				System.out.println(WebUI.getText(currentFilter))
				String text = WebUI.getText(currentFilter)
				String temp =  text.substring(text.indexOf("(")+1, text.indexOf(")"));
				try {
					int currentCount  = Integer.parseInt(temp.replaceAll("[^0-9]", ""))
					productsCount += currentCount
				}catch(Exception e) {
					System.out.println( "Exception: " + e.getMessage())
				}

			}
			System.out.println(groupElement.getText() + " >> productsCount = " + productsCount)
		}
	}

	/**
	 * Verify selected filters found in selectedFiltersSections
	 * @param filters
	 * @author Eng. Amal Hamad
	 */
	public static void verifySelectedFilters(String... filters) {
		boolean isSelectedFiltersSectionExist = WebUI.verifyElementPresent(ProductFiltersItems.selectedFilters,GlobalVariable.elementVisibilityTimeOut, FailureHandling.CONTINUE_ON_FAILURE)
		System.out.println(isSelectedFiltersSectionExist)

		if (isSelectedFiltersSectionExist) {
			List<WebElement> selectedFilters = WebUI.findWebElements(ProductFiltersItems.selectedFilters,GlobalVariable.elementVisibilityTimeOut)
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
		List<TestObject> paginationLinks = WebUI.findWebElements(SearchResultsPageItems.paginationLinks, GlobalVariable.elementVisibilityTimeOut)
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
