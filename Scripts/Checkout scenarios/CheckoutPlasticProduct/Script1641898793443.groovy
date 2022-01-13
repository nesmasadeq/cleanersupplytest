import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import actions.CartPageActions as CartPageActions
import actions.CheckoutInterstitialPageActions as CheckoutInterstitialPageActions
import actions.HeaderActions as HeaderActions
import actions.ProductDetailsPageActions as ProductDetailsPageActions
import helpers.GeneralHelpers as GeneralHelpers
import helpers.HeaderHelpers as HeaderHelpers
import helpers.ProductRowHelper as ProductRowHelper
import helpers.ProductsFiltersHelpers as ProductsFiltersHelpers
import internal.GlobalVariable as GlobalVariable
import models.Product as Product
import validations.CartPageValidations as CartPageValidations
import validations.CheckoutInterstitialPageValidations as CheckoutInterstitialPageValidations
import validations.GeneralValidations as GeneralValidations
import validations.HeaderValidations as HeaderValidations
import validations.ProductDetailsPageValidations as ProductDetailsPageValidations
import validations.ProductsFiltersValidations as ProductsFiltersValidations

//---------------- Open Site ----------------
GeneralHelpers.initScenario()

System.out.println('Page Title:' + WebUI.getWindowTitle())

assert WebUI.getWindowTitle().equals('Cleaner\'s Supply - Dry Cleaning Supplies')

//----------------Check cart is empty ----------------
HeaderHelpers.checkCartIsEmpty()

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
    GlobalVariable.elementVisibilityTimeOut)

println('autoSuggestionsInnerItems: ' + autoSuggestionsInnerItems.size())

for (WebElement element : autoSuggestionsInnerItems) {
    TestObject object = WebUI.convertWebElementToTestObject(element)

    System.out.println('autoSuggestionsInnerItems: ' + WebUI.getText(object))

    assert WebUI.getText(object).toLowerCase().contains(GlobalVariable.searchTerm)
}

//------ Press Enter -------- 
WebUI.sendKeys(inputSearch, Keys.chord(Keys.ENTER))

/***********************************************************************/
/*********************** Search Results Page **************************/
/***********************************************************************/
//------ Verify Page URL --------
GeneralValidations.verifyCurrentPageURL('search-results/?q=plastic')

//------ Verify Page Title --------
GeneralValidations.verifyCurrentPageTitleValue('Search Results - Cleaner\'s Supply')

//------ Verify Heading --------
GeneralValidations.verifyPageHeading('SEARCH RESULTS')

TestObject subPageHeader = findTestObject('scenario01/results_page/h2_pageSubHeader')

System.out.println('subPageHeader: ' + WebUI.getText(subPageHeader))

assert WebUI.getText(subPageHeader).toLowerCase().contains(GlobalVariable.searchTerm)

//------ Verify filtersProductType --------
//ProductsFiltersHelpers.openFiltersCard()
//List<TestObject> filtersProductType = WebUI.findWebElements(findTestObject('Filters/div_filtersProductType'), 
//    GlobalVariable.elementVisibilityTimeOut)
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
TestObject a_productUrl = findTestObject('Object Repository/scenario01/product_row/a_productUrl')

Product firstProduct = ProductRowHelper.saveProductRowData(a_productUrl)

TestObject div_firstProductRow = findTestObject('Object Repository/scenario01/product_row/div_firstProductRow')

WebUI.click(div_firstProductRow)

/***********************************************************************/
/*********************** Product Details Page **************************/
/***********************************************************************/
//------ Verify Page URL --------
GeneralValidations.verifyCurrentPageURL(firstProduct.getHref())

//------ Verify Page Title --------
System.out.println('Page Title:' + WebUI.getWindowTitle())

//assert WebUI.getWindowTitle().equals('Search Results - Cleaner\'s Supply')
//------ Verify Title & Image --------
//GeneralValidations.verifyCurrentPageURL(firstProduct.getTitle().toLowerCase().replaceAll(' ', '-'))
//ProductDetailsPageValidations.verifyProductTitle(product.getTitle())
//ProductDetailsPageValidations.verifyProductImage(product.getImage())
//------ Verify Page Breadcrumb --------
ProductDetailsPageValidations.verifyPageBreadcrumb('Bags', 'Plastic Bags', 'Comforter')

//------ Verify Price --------
ProductDetailsPageValidations.verifyProductPrice(firstProduct)

ProductDetailsPageValidations.verifyProductPriceMatchPricingTable()

//------ Verify List Value --------
ProductDetailsPageValidations.verifyProductListValue(firstProduct)

//------ Verify Sku --------
ProductDetailsPageActions.saveProductSkuToObject(firstProduct)

ProductDetailsPageValidations.verifyProductSku(firstProduct.getSku())

//------ Verify Q&A count --------
ProductDetailsPageValidations.verifyProductQuestionsAnswersItemsCount()

//------ Verify XSmall size selected by default --------
ProductDetailsPageValidations.verifyProductSelectedSizeOption(ProductDetailsPageActions.optionSizeXSmall)

//------ Verify Black Color selected by default --------
ProductDetailsPageValidations.verifyProductSelectedColorOption(ProductDetailsPageActions.optionColorBlack)

//------ Verify AddToCartSection is hidden --------
ProductDetailsPageValidations.verifyOutOfStockMessageIsVisible()

ProductDetailsPageValidations.verifyAddToCartSectionVisibility(false)

/***********************************************************************/
/******************** Add First Product to Cart ************************/
/***********************************************************************/
//------------------------------- Select XLarge Size Option ---------------------------
ProductDetailsPageActions.selectSizeOption(ProductDetailsPageActions.optionSizeXLarge)

ProductDetailsPageValidations.verifyProductSelectedSizeOption(ProductDetailsPageActions.optionSizeXLarge)

//------ Verify AddToCartSection is Visibile --------
ProductDetailsPageValidations.verifyInStockMessageIsVisible()

ProductDetailsPageValidations.verifyAddToCartSectionVisibility(true)

//------ Verify Product data is changed --------
ProductDetailsPageValidations.verifyProductDataChangesAfterSizeOption(firstProduct)

//------------------------------- Select Green Color Option ---------------------------
ProductDetailsPageActions.selectColorOption(ProductDetailsPageActions.optionColorGreen)

ProductDetailsPageValidations.verifyProductSelectedColorOption(ProductDetailsPageActions.optionColorGreen)

ProductDetailsPageValidations.verifyProductDataChangesAfterColorOption(firstProduct)

//------------------------------- Type 5 in quantity input  ---------------------------
firstProduct.setQuantity(5)

ProductDetailsPageActions.setProductQuantityText(firstProduct.getQuantity())

//------ Verify Product Price is changed --------
ProductDetailsPageValidations.verifyPrductQuantityInputValue(firstProduct.getQuantity())

ProductDetailsPageValidations.verifyProductPriceIsChanged(firstProduct)

//------------------------------- Click AddToCart button  ---------------------------
ProductDetailsPageActions.clickAddToCart()

//ArrayList cartProducts = new ArrayList()
//cartProducts.add(firstProduct)
//------ Verify Product Quantity is changed --------
WebUI.waitForElementClickable(findTestObject(ProductDetailsPageActions.btnAddToCart), GlobalVariable.elementVisibilityTimeOut)

ProductDetailsPageValidations.verifyPrductQuantityInputValue(1)

//------ Verify Cart Count is change --------
HeaderValidations.verifyCartCount('1')

//------ Verify Product Price return to default price --------
ProductDetailsPageValidations.verifyProductPriceIsChanged(firstProduct)

HeaderValidations.verifyCartLabel(HeaderHelpers.calculateCartTotal(firstProduct))

/***********************************************************************/
/******************** Add Second Product to Cart ***********************/
/***********************************************************************/
Product secondProduct = Product.copyObject(firstProduct)

//secondProduct = cartProducts.get(0)
//------------------------------- Select Large Size Option ---------------------------
ProductDetailsPageActions.selectSizeOption(ProductDetailsPageActions.optionSizeLarge)

ProductDetailsPageValidations.verifyProductSelectedSizeOption(ProductDetailsPageActions.optionSizeLarge)

//------ Verify Product data is changed --------
ProductDetailsPageValidations.verifyProductDataChangesAfterSizeOption(secondProduct)

//------------------------------- Select Green Color Option ---------------------------
ProductDetailsPageActions.selectColorOption(ProductDetailsPageActions.optionColorBlue)

ProductDetailsPageValidations.verifyProductSelectedColorOption(ProductDetailsPageActions.optionColorBlue)

ProductDetailsPageValidations.verifyProductDataChangesAfterColorOption(secondProduct)

//------------------------------- Type 3 in quantity input  ---------------------------
secondProduct.setQuantity(3)

ProductDetailsPageActions.setProductQuantityText(secondProduct.getQuantity())

//------ Verify Product Price is changed --------
ProductDetailsPageValidations.verifyPrductQuantityInputValue(secondProduct.getQuantity())

ProductDetailsPageValidations.verifyProductPriceIsChanged(secondProduct)

//------------------------------- Click AddToCart button  ---------------------------
ProductDetailsPageActions.clickAddToCart()

//cartProducts.clear()
//cartProducts.add(firstProduct)
//cartProducts.add(secondProduct)
//------ Verify Product Quantity is changed --------
WebUI.waitForElementClickable(findTestObject(ProductDetailsPageActions.btnAddToCart), GlobalVariable.elementVisibilityTimeOut)

ProductDetailsPageValidations.verifyPrductQuantityInputValue(1)

//------ Verify Cart Count is change --------
HeaderValidations.verifyCartCount('2')

//------ Verify Product Price return to default price --------
ProductDetailsPageValidations.verifyProductPriceIsChanged(secondProduct)

HeaderValidations.verifyCartLabel(HeaderHelpers.calculateCartTotal(firstProduct, secondProduct))

/***********************************************************************/
/***************************** Cart Page *******************************/
/***********************************************************************/
HeaderActions.clickCartIcon()

//------ Verify Page URL --------
GeneralValidations.verifyCurrentPageURL('https://www.cleanersupply.com/shopping-cart/')

//------ Verify Page Title --------
GeneralValidations.verifyCurrentPageTitleValue('Shopping Cart - Cleaner\'s Supply')

//------ Verify Page Heading --------
GeneralValidations.verifyPageHeading('SHOPPING CART')

//------ Verify products data in cart --------
CartPageValidations.verifyCartProductsData(secondProduct, firstProduct)

//------ Verify cart summary --------
CartPageValidations.verifyCartSummary(true, 'NOT AVAILABLE', 'T.B.D.')

//------ Change firstProduct cart quantity --------
CartPageActions.clickMinusQtyButton(0)

CartPageValidations.verifyCartSummary(true, 'NOT AVAILABLE', 'T.B.D.')

CartPageValidations.verifyProductTotalAfterChangeQty(0, secondProduct)

//------ Change secondProduct cart quantity --------
CartPageActions.clickPlusQtyButton(1)

CartPageValidations.verifyCartSummary(true, 'NOT AVAILABLE', 'T.B.D.')

CartPageValidations.verifyProductTotalAfterChangeQty(1, firstProduct)

//------ Click ProceedToCheckout Button --------
CartPageActions.clickProceedToCheckoutButton()

/***********************************************************************/
/******************* Checkout Interstitial Page ************************/
/***********************************************************************/
//------ Verify Page URL --------
GeneralValidations.verifyCurrentPageURL('https://www.cleanersupply.com/checkout-interstitial/')

//------ Verify Page Title --------
GeneralValidations.verifyCurrentPageTitleValue('Checkout Interstitial - Cleaner\'s Supply')

//------ Verify Page Heading --------
CheckoutInterstitialPageValidations.verifyPageHeading('SECURE CHECKOUT')

//------ Verify products data in cart --------
CartPageValidations.verifyCartProductsData(secondProduct, firstProduct)

//------ Verify cart summary --------
CartPageValidations.verifyCartSummary(false, 'FREE', 'T.B.D.')

//------ Verify guest radion is checked --------
CheckoutInterstitialPageValidations.verifyGuestRadionIsChecked()

//------ Click Continue button --------
CheckoutInterstitialPageActions.clickContinueButton()