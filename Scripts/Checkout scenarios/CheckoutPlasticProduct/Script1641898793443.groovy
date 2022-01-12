import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.ProductDetailsPageActions
import actions.ProductFiltersActions
import helpers.GeneralHelpers
import helpers.HeaderHelpers
import helpers.ProductRowHelper
import helpers.ProductsFiltersHelpers as ProductsFiltersHelpers
import internal.GlobalVariable as GlobalVariable
import models.Product
import validations.GeneralValidations
import validations.HeaderValidations
import validations.ProductDetailsPageValidations
import validations.ProductsFiltersValidations as ProductsFiltersValidations

//---------------- Open Site ----------------
GeneralHelpers.initScenario()

System.out.println('Page Title:' + WebUI.getWindowTitle())

assert WebUI.getWindowTitle().equals('Cleaner\'s Supply - Dry Cleaning Supplies')

//----------------Check cart is empty ----------------
HeaderHelpers.verifyCartEmpty()

//---------------- Search for plastic ---------------- 
//------ inputSearch -------- 
TestObject inputSearch = findTestObject('Header/input_headerSearch')

assert WebUI.getAttribute(inputSearch, 'placeholder').equals('Search by Stock # or Keyword')

WebUI.setText(inputSearch, GlobalVariable.searchTerm)

//------ autoSuggestionSearchList -------- 
TestObject div_autoSuggestionSearchList = findTestObject('Header/div_autoSuggestionSearchList')

System.out.println(WebUI.getAttribute(div_autoSuggestionSearchList, 'style'))

assert WebUI.getAttribute(div_autoSuggestionSearchList, 'style').equals('')

System.out.println('getClass: ' + WebUI.getAttribute(div_autoSuggestionSearchList, 'class'))

assert WebUI.getAttribute(div_autoSuggestionSearchList, 'class').contains('open')

//------ searchForLabel -------- 
TestObject p_searchForLabel = findTestObject('Header/p_searchForLabel')

System.out.println(WebUI.getText(p_searchForLabel))

assert WebUI.getText(p_searchForLabel).toLowerCase().contains(GlobalVariable.searchTerm)

//------ autoSuggestionSearchList inner items --------
List<TestObject> autoSuggestionsInnerItems = WebUI.findWebElements(findTestObject('Header/strong_autoSuggestionsInnerItems'), 
    5)

println('autoSuggestionsInnerItems: ' + autoSuggestionsInnerItems.size())

for (WebElement element : autoSuggestionsInnerItems) {
    TestObject object = WebUI.convertWebElementToTestObject(element)

    System.out.println('autoSuggestionsInnerItems: ' + WebUI.getText(object))

    assert WebUI.getText(object).toLowerCase().contains(GlobalVariable.searchTerm)
}

//------ Press Enter -------- 
WebUI.sendKeys(inputSearch, Keys.chord(Keys.ENTER))

//---------------- Search Results page ---------------- 
System.out.println('Page Title:' + WebUI.getWindowTitle())

//------ Verify Page URL --------
assert WebUI.getUrl().equals('https://www.cleanersupply.com/search-results/?q=plastic')

//------ Verify Page Title --------
assert WebUI.getWindowTitle().equals('Search Results - Cleaner\'s Supply')

//------ Verify Heading --------
TestObject pageHeader = findTestObject('scenario01/results_page/h1_pageHeader')

assert WebUI.getText(pageHeader).equals('SEARCH RESULTS')

TestObject subPageHeader = findTestObject('scenario01/results_page/h2_pageSubHeader')

System.out.println('subPageHeader: ' + WebUI.getText(subPageHeader))

assert WebUI.getText(subPageHeader).toLowerCase().contains(GlobalVariable.searchTerm)

//------ Verify filtersProductType --------
//ProductsFiltersHelpers.openFiltersCard()
//List<TestObject> filtersProductType = WebUI.findWebElements(findTestObject('Filters/div_filtersProductType'), 
//    5)
//
//println('filtersProductType: ' + filtersProductType.size())
//
//int sum = 0
//
//for (WebElement element : filtersProductType) {
//    TestObject object = WebUI.convertWebElementToTestObject(element)
//
//    System.out.println('filtersProductType: ' + WebUI.getText(object))
//
//    int count = Integer.parseInt(WebUI.getText(object).replaceAll('\\D+', ''))
//
//    sum += count
//}
//
//System.out.println('sum: ' + sum) //277
/***********************************************************************/
//------ Check packaging products filter --------
//ProductsFiltersHelpers.openFiltersCard()
ProductsFiltersHelpers.checkingPackagingProductFilter()
GeneralValidations.verifyCurrentPageURL('Category=Packaging+Products')
//------ Verify filter count match product count --------
TestObject span_packagingProductsCount = findTestObject('Object Repository/Filters/span_packagingProductsCount')
ProductsFiltersValidations.verifyFilterProductsCountMatchResultsCount(span_packagingProductsCount, subPageHeader)
//------ Verify packagingProducts found in selected filters--------
ProductsFiltersValidations.verifySelectedFilters('Packaging Products')
//------ Verify pagination is changed --------
ProductsFiltersValidations.verifyPaginationIsChanged(3)

/***********************************************************************/
//------ Check PalsticBags products filter --------
ProductsFiltersHelpers.checkingPlasticBagsFilter()
GeneralValidations.verifyCurrentPageURL('Category=Packaging+Products_Plastic+Bags')
//------ Verify filter count match product count --------
TestObject span_plasticBagsCount = findTestObject('Filters/span_plasticBagsCount')
//ProductsFiltersValidations.verifyFilterProductsCountMatchResultsCount(span_plasticBagsCount, subPageHeader)
//------ Verify packagingProducts found in selected filters--------
ProductsFiltersValidations.verifySelectedFilters('Packaging Products', 'Plastic Bags')
//------ Verify pagination is changed --------
ProductsFiltersValidations.verifyPaginationIsChanged(3)

/***********************************************************************/
//------ Check Green Color filter --------
ProductsFiltersHelpers.openFiltersCard()
WebUI.scrollToPosition(50, 60)
ProductsFiltersHelpers.checkingGreenColorFilter()
GeneralValidations.verifyCurrentPageURL('Color+Group=Green')
//------ Verify filter count match product count --------
TestObject span_greenCount = findTestObject('Filters/span_greenCount')
ProductsFiltersValidations.verifyFilterProductsCountMatchResultsCount(span_greenCount, subPageHeader)
ProductsFiltersValidations.verifyFilterProductsCountMatchResultsCount(span_packagingProductsCount, subPageHeader)
ProductsFiltersValidations.verifyFilterProductsCountMatchResultsCount(span_plasticBagsCount, subPageHeader)
//------ Verify packagingProducts found in selected filters--------
ProductsFiltersValidations.verifySelectedFilters('Packaging Products', 'Plastic Bags', 'Green')

/***********************************************************************/
//Save Product data in this Cell & Click product
Product product = ProductRowHelper.saveProductRowData()
TestObject div_firstProductRow = findTestObject('Object Repository/scenario01/product_row/div_firstProductRow')
WebUI.click(div_firstProductRow)

/***********************************************************************/
//------ Verify Page URL --------
GeneralValidations.verifyCurrentPageURL(product.getHref())

//------ Verify Page Title --------
System.out.println('Page Title:' + WebUI.getWindowTitle())

//assert WebUI.getWindowTitle().equals('Search Results - Cleaner\'s Supply')
//------ Verify Heading & Image --------
//ProductDetailsPageValidations.verifyProductTitle(product.getTitle())
//ProductDetailsPageValidations.verifyProductImage(product.getImage())
//ProductDetailsPageValidations.verifyProductSku(product.getSku())

//------ Verify Price --------
ProductDetailsPageValidations.verifyProductPrice(product)
ProductDetailsPageValidations.verifyProductListValue(product)

//------ Save Curent SKy --------
String sku = ProductDetailsPageActions.getCurrentText(ProductDetailsPageActions.productSku)
product.setSku(sku)

//------ Default options selected Price --------
ProductDetailsPageValidations.verifyProductOptionIsSelected(ProductDetailsPageActions.optionSizeXSmall)
ProductDetailsPageValidations.verifyProductOptionIsSelected(ProductDetailsPageActions.optionColorBlack)

String optionSizeXSmall = ProductDetailsPageActions.getCurrentText(ProductDetailsPageActions.optionSizeXSmall)
ProductDetailsPageValidations.verifyProductTitle(optionSizeXSmall)
String optionColorBlack = ProductDetailsPageActions.getCurrentText(ProductDetailsPageActions.optionColorBlack)
ProductDetailsPageValidations.verifyProductTitle(optionColorBlack)





