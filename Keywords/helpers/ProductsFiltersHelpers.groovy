package helpers

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.ProductFiltersActions
import validations.ProductsFiltersValidations


public class ProductsFiltersHelpers {

	/**
	 * Click & Verify packagingProducts  filter checkBox
	 * @author nesma
	 */
	public static void checkingPackagingProductFilter() {
		TestObject chx_PackagingProducts = findTestObject('Object Repository/Filters/chx_packagingProducts')
		ProductFiltersActions.checkSpecificFilter(chx_PackagingProducts)
		ProductsFiltersValidations.verifyFilterIsChecked(chx_PackagingProducts)
	}

	/**
	 * Open all products filters cards in left side
	 * @author Eng. Amal Hamad
	 */
	public static void openFiltersCard() {
		List<TestObject> filtersCards = WebUI.findWebElements(findTestObject('Filters/div_filtersCards'),
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

	/***
	 * selecting casio manufacturer
	 * @author nesma
	 */
	public static void selectingManufacturer() {
		ProductsFiltersValidations.verifyManufactorSelectedByDefault()
		ProductsFiltersValidations.verifyModelSelectIsDisabled()
		ProductsFiltersValidations.verifySelectedOptionValue()
		ProductsFiltersValidations.verifySelectedFilters('Casio','')
	}
}
