package helpers

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.ProductFiltersActions
import validations.ComputerAndRegisterPageValidations
import validations.GeneralValidations
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
	 * Click & Verify plasticBags filter checkBox
	 * @author Eng. Amal Hamad
	 */
	public static void checkingPlasticBagsFilter() {
		TestObject chx_plasticBags = findTestObject('Object Repository/Filters/chx_plasticBags')
		ProductFiltersActions.checkSpecificFilter(chx_plasticBags)
		ProductsFiltersValidations.verifyFilterIsChecked(chx_plasticBags)
	}

	/**
	 * Click & Verify GreenColor filter checkBox
	 * @author Eng. Amal Hamad
	 */
	public static void checkingGreenColorFilter() {
		TestObject chx_green = findTestObject('Object Repository/Filters/chx_green')
		ProductFiltersActions.checkSpecificFilter(chx_green)
		ProductsFiltersValidations.verifyFilterIsChecked(chx_green)
	}

	/**
	 * Open all products filters cards in left side
	 * @author Eng. Amal Hamad
	 */
	public static void openFiltersCard() {
		List<TestObject> filtersCards = WebUI.findWebElements(findTestObject('Object Repository/Filters/div_filtersCards'),
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
		
		TestObject selectedManufactorer= ProductFiltersActions.selectManufactor()
		
		ProductsFiltersValidations.
		verifySelectedOptionValue('https://www.cleanersupply.com/Tags-Forms/Computer-Register/?Manufacturer=Casio',
			selectedManufactorer)
		
		ProductsFiltersValidations.verifySelectedFilters('Casio','')
		
		ProductsFiltersValidations.verifyFilterDisappeared(
			findTestObject('Object Repository/Filters/div_brandFilter'),
			findTestObject('Object Repository/Filters/div_colorGroupFilter'),
			findTestObject('Object Repository/Filters/div_designFilter'),
			findTestObject('Object Repository/Filters/div_filtersProductType'),
			findTestObject('Object Repository/Filters/div_lengthFilter'),
			findTestObject('Object Repository/Filters/div_sizeFilter'),
			findTestObject('Object Repository/Filters/div_styleFilter'))
		
		ProductsFiltersValidations.verifyModelSelectIsEnabled()
		ComputerAndRegisterPageValidations.verifyHeaderResultCount()
		GeneralValidations.verifyCurrentPageURL('Manufacturer=Casio')
	}
	
	/***
	 * selecting SP1000 model filter
	 * @author nesma
	 */
	public static void selectingModel() {
		TestObject selectedModel= ProductFiltersActions.selectModel()
		
//		ProductsFiltersValidations.
//		verifySelectedOptionValue('https://www.cleanersupply.com/Tags-Forms/Computer-Register/?Model+%23=SP1000&Manufacturer=Casio',
//			selectedModel)
		ProductsFiltersValidations.verifySelectedFilters('Casio','SP1000')
		
		ProductsFiltersValidations.verifyFilterDisappeared(findTestObject('Object Repository/Filters/div_materialFilter'))
		
		GeneralValidations.verifyCurrentPageURL('Model+%23=SP1000')
		
	}
}
