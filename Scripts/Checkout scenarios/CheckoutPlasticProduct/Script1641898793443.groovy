import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.ProductFiltersActions
import helpers.GeneralHelpers as GeneralHelpers
import helpers.ProductsFiltersHelpers as ProductsFiltersHelpers
import internal.GlobalVariable as GlobalVariable
import models.Product
import validations.GeneralValidations
import validations.HeaderValidations
import validations.ProductsFiltersValidations as ProductsFiltersValidations

//---------------- Open Site ----------------
GeneralHelpers.initScenario()

System.out.println('Page Title:' + WebUI.getWindowTitle())

assert WebUI.getWindowTitle().equals('Cleaner\'s Supply - Dry Cleaning Supplies')

//----------------Check cart is empty ----------------
HeaderValidations.verifyCartCount('0')
HeaderValidations.verifyCartLabel('Cart')

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
TestObject span_PackagingProductsCount = findTestObject('Object Repository/Filters/span_packagingProductsCount')
ProductsFiltersValidations.verifyFilterProductsCountMatchResultsCount(span_PackagingProductsCount, subPageHeader)
//------ Verify packagingProducts found in selected filters--------
ProductsFiltersValidations.verifySelectedFilters('Packaging Products')
//------ Verify pagination is changed --------
ProductsFiltersValidations.verifyPaginationIsChanged(3)

/***********************************************************************/
//------ Check PalsticBags products filter --------
TestObject chx_plasticBags = findTestObject('Filters/chx_plasticBags')

//WebUI.scrollToElement(chx_plasticBags, GlobalVariable.actionsTimeout)
WebUI.click(chx_plasticBags)

System.out.println('getClass: ' + WebUI.getAttribute(chx_plasticBags, 'class'))

assert WebUI.getAttribute(chx_plasticBags, 'class').contains('selected')

//------ Verify Page URL --------
assert WebUI.getUrl().equals('https://www.cleanersupply.com/search-results/?Category=Packaging+Products_Plastic+Bags&q=plastic&r=true')

//------ Verify filter count match product count --------
TestObject span_plasticBagsCount = findTestObject('Filters/span_plasticBagsCount')

int plasticBagsCount = Integer.parseInt(WebUI.getText(span_plasticBagsCount).replaceAll('\\D+', ''))

System.out.println('plasticBagsCount: ' + plasticBagsCount)

productsCountInHeader = Integer.parseInt(WebUI.getText(subPageHeader).replaceAll('\\D+', ''))

System.out.println('productsCountInHeader: ' + productsCountInHeader)

//assert (packagingProductsCount + plasticBagsCount) == productsCountInHeader
//------ Verify packagingProducts found in selected filters--------
ProductsFiltersValidations.verifySelectedFilters('Packaging Products', 'Plastic Bags')

//------ Verify pagination is changed --------
paginationLinks = WebUI.findWebElements(findTestObject('Object Repository/scenario01/results_page/a_paginationLinks'), 5)

assert paginationLinks.size() == 3

/***********************************************************************/
//------ Color filter --------
ProductsFiltersHelpers.openFiltersCard()

//------ Check Green Color filter --------
TestObject chx_green = findTestObject('Filters/chx_green')

WebUI.waitForElementVisible(chx_green, 10)

WebUI.scrollToElement(chx_green, GlobalVariable.actionsTimeout)

//WebUI.waitForElementClickable(chx_green, GlobalVariable.actionsTimeout)
WebUI.click(chx_green)

System.out.println('getClass: ' + WebUI.getAttribute(chx_green, 'class'))

assert WebUI.getAttribute(chx_green, 'class').contains('selected')

//------ Verify Page URL --------
assert WebUI.getUrl().equals('https://www.cleanersupply.com/search-results/?Color+Group=Green&Category=Packaging+Products_Plastic+Bags&q=plastic&r=true')

//------ Verify filter count match product count --------
TestObject span_greenCount = findTestObject('Filters/span_greenCount')

int greenCount = Integer.parseInt(WebUI.getText(span_greenCount).replaceAll('\\D+', ''))

System.out.println('greenCount: ' + greenCount)

productsCountInHeader = Integer.parseInt(WebUI.getText(subPageHeader).replaceAll('\\D+', ''))

System.out.println('productsCountInHeader: ' + productsCountInHeader)

assert greenCount == productsCountInHeader

packagingProductsCount = Integer.parseInt(WebUI.getText(span_PackagingProductsCount).replaceAll('\\D+', ''))

assert greenCount == packagingProductsCount

plasticBagsCount = Integer.parseInt(WebUI.getText(span_plasticBagsCount).replaceAll('\\D+', ''))

assert greenCount == plasticBagsCount

//------ Verify packagingProducts found in selected filters--------
ProductsFiltersValidations.verifySelectedFilters('Packaging Products', 'Plastic Bags', 'Green')

/***********************************************************************/
//Save Product data in this Cell & Click product
Product product = new Product()

TestObject a_productUrl = findTestObject('Object Repository/scenario01/product_row/a_productUrl')

product.setHref(WebUI.getAttribute(a_productUrl, 'href'))

TestObject h2_productTitle = findTestObject('Object Repository/scenario01/product_row/h2_productTitle')

product.setTitle(WebUI.getText(h2_productTitle))

TestObject img_productImage = findTestObject('Object Repository/scenario01/product_row/img_productImage')

product.setImage(WebUI.getAttribute(img_productImage, 'src'))

List<WebElement> span_productPrice = WebUI.findWebElements(findTestObject('Object Repository/scenario01/product_row/span_productPrice'), 
    5)

TestObject minPrice = WebUI.convertWebElementToTestObject(span_productPrice.get(0))

product.setMinPrice(Double.parseDouble(WebUI.getText(minPrice).replaceAll('\\D+', '')))

TestObject maxPrice = WebUI.convertWebElementToTestObject(span_productPrice.get(1))

product.setMaxPrice(Double.parseDouble(WebUI.getText(maxPrice).replaceAll('\\D+', '')))

System.out.println(product.toString())

WebUI.click(h2_productTitle)

/***********************************************************************/
//------ Verify Page URL --------
assert WebUI.getUrl().contains(product.getHref())

//------ Verify Page Title --------
System.out.println('Page Title:' + WebUI.getWindowTitle())

//assert WebUI.getWindowTitle().equals('Search Results - Cleaner\'s Supply')
//------ Verify Heading --------
TestObject productTitleObject =findTestObject('Object Repository/scenario01/product_details_page/h1_productTitle')

assert WebUI.getText(productTitleObject).toLowerCase().contains(product.getTitle())

//------ Verify Price --------
TestObject productPriceObject = findTestObject('Object Repository/scenario01/product_details_page/span_productPrice')

assert WebUI.getText(productPriceObject).contains('$')

double price = Double.parseDouble(WebUI.getText(productPriceObject).replaceAll('\\D+', ''))

assert (price >= product.getMinPrice()) && (price <= product.getMaxPrice())

//------ Verify List Price --------
TestObject productListPriceObject = findTestObject('Object Repository/scenario01/product_details_page/span_productListPrice')

assert WebUI.getText(productListPriceObject).contains('$')

double listPrice = Double.parseDouble(WebUI.getText(productListPriceObject).replaceAll('\\D+', ''))

assert (listPrice >= product.getMinList()) && (listPrice <= product.getMaxList())
//------ Verify Image --------
TestObject productImageObject =findTestObject('Object Repository/scenario01/product_details_page/img_productImage')
assert WebUI.getAttribute(productImageObject, 'src').equals(product.getImage())
//------ Save SKy --------
TestObject productSkuObject =findTestObject('Object Repository/scenario01/product_details_page/span_productSku')
product.setSku(WebUI.getText(productSkuObject))



