import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import actions.CartPageActions as CartPageActions
import actions.CheckoutPageActions as CheckoutPageActions
import actions.HeaderActions as HeaderActions
import actions.ProductDetailsPageActions as ProductDetailsPageActions
import actions.SelectCheckoutPageActions as SelectCheckoutPageActions
import helpers.CheckoutPageHelpers as CheckoutPageHelpers
import helpers.GeneralHelpers as GeneralHelpers
import helpers.HeaderHelpers as HeaderHelpers
import helpers.ProductRowHelper as ProductRowHelper
import helpers.ProductsFiltersHelpers as ProductsFiltersHelpers
import internal.GlobalVariable as GlobalVariable
import items.CheckoutPageItems as CheckoutPageItems
import items.HeaderItems as HeaderItems
import items.ProductDetailsPageItems as ProductDetailsPageItems
import models.AppConstants as AppConstants
import models.Order as Order
import models.Product as Product
import validations.CartPageValidations as CartPageValidations
import validations.CheckoutPageValidations as CheckoutPageValidations
import validations.GeneralValidations as GeneralValidations
import validations.HeaderValidations as HeaderValidations
import validations.OrderReviewPageValidations as OrderReviewPageValidations
import validations.ProductDetailsPageValidations as ProductDetailsPageValidations
import validations.ProductsFiltersValidations as ProductsFiltersValidations
import validations.SelectCheckoutPageValidations as SelectCheckoutPageValidations

//---------------- Open Site ----------------
GeneralHelpers.initScenario()

//----------------Check cart is empty ----------------
HeaderHelpers.checkCartIsEmpty()

//---------------- Search for plastic ---------------- 
//------ inputSearch -------- 
TestObject inputSearch = findTestObject(HeaderItems.inputSearch)

assert WebUI.getAttribute(inputSearch, 'placeholder').equals('Search by Stock # or Keyword')

WebUI.setText(inputSearch, AppConstants.SEARCH_TERM)

//------ autoSuggestionSearchList -------- 
TestObject div_autoSuggestionSearchList = findTestObject(HeaderItems.autoSuggestionSearchList)

System.out.println(WebUI.getAttribute(div_autoSuggestionSearchList, 'style'))

assert WebUI.getAttribute(div_autoSuggestionSearchList, 'style').equals('')

System.out.println('getClass: ' + WebUI.getAttribute(div_autoSuggestionSearchList, 'class'))

assert WebUI.getAttribute(div_autoSuggestionSearchList, 'class').contains('open')

//------ searchForLabel -------- 
TestObject p_searchForLabel = findTestObject(HeaderItems.searchForLabel)

assert WebUI.getText(p_searchForLabel).toLowerCase().contains(AppConstants.SEARCH_TERM)

//------ autoSuggestionSearchList inner items --------
List<TestObject> autoSuggestionsInnerItems = WebUI.findWebElements(findTestObject(HeaderItems.autoSuggestionSearchItems), 
    GlobalVariable.elementVisibilityTimeOut)

println('autoSuggestionsInnerItems: ' + autoSuggestionsInnerItems.size())

for (WebElement element : autoSuggestionsInnerItems) {
    TestObject object = WebUI.convertWebElementToTestObject(element)

    System.out.println('autoSuggestionsInnerItems: ' + WebUI.getText(object))

    assert WebUI.getText(object).toLowerCase().contains(AppConstants.SEARCH_TERM)
}

//------ Press Enter -------- 
WebUI.sendKeys(inputSearch, Keys.chord(Keys.ENTER))

/***********************************************************************/
/************************ Search Results Page **************************/
/***********************************************************************/
//------ Verify Page URL --------
GeneralValidations.verifyCurrentPageURL(AppConstants.SEARCH_PAGE_URL)

//------ Verify Page Title --------
GeneralValidations.verifyCurrentPageTitleValue(AppConstants.SEARCH_PAGE_TITLE)

//------ Verify Heading --------
GeneralValidations.verifyPageHeading(AppConstants.SEARCH_PAGE_HEADING)

TestObject subPageHeader = findTestObject('SearchResultPage/h2_pageSubHeader')

System.out.println('subPageHeader: ' + WebUI.getText(subPageHeader))

assert WebUI.getText(subPageHeader).toLowerCase().contains(AppConstants.SEARCH_TERM)

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
TestObject a_productUrl = findTestObject('ProductRow/a_productUrl')

Product firstProduct = ProductRowHelper.saveProductRowData(a_productUrl)

TestObject div_firstProductRow = findTestObject('ProductRow/div_firstProductRow')

ProductDetailsPageValidations.verifyButtonShadowHover(div_firstProductRow)

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

//------ Verify Product Description --------
ProductDetailsPageValidations.verifyProductDescription()

//------ Verify Price --------
ProductDetailsPageValidations.verifyProductPrice(firstProduct)

ProductDetailsPageValidations.verifyProductPriceMatchPricingTable()

//------ Verify List Value --------
ProductDetailsPageValidations.verifyProductListValue(firstProduct)

//------ Verify Sku --------
//ProductDetailsPageActions.saveProductSkuToObject(firstProduct)
ProductDetailsPageValidations.verifyProductSku(firstProduct)

//------ Verify Q&A count --------
ProductDetailsPageValidations.verifyProductQuestionsAnswersItemsCount()

//------ Verify XSmall size selected by default --------
ProductDetailsPageValidations.verifyProductSelectedSizeOption(ProductDetailsPageItems.optionSizeXSmall)

//------ Verify Black Color selected by default --------
ProductDetailsPageValidations.verifyProductSelectedColorOption(ProductDetailsPageItems.optionColorBlack)

//------ Verify AddToCartSection is hidden --------
ProductDetailsPageValidations.verifyOutOfStockMessageIsVisible()

ProductDetailsPageValidations.verifyAddToCartSectionVisibility(false)

/***********************************************************************/
/******************** Add First Product to Cart ************************/
/***********************************************************************/
//------------------------------- Select XLarge Size Option ---------------------------
ProductDetailsPageActions.selectSizeOption(ProductDetailsPageItems.optionSizeXLarge)

ProductDetailsPageValidations.verifyProductSelectedSizeOption(ProductDetailsPageItems.optionSizeXLarge)

//------ Verify AddToCartSection is Visibile --------
ProductDetailsPageValidations.verifyInStockMessageIsVisible()

ProductDetailsPageValidations.verifyAddToCartSectionVisibility(true)

//------ Verify Product data is changed --------
ProductDetailsPageValidations.verifyProductDataChangesAfterSizeOption(firstProduct)

//------------------------------- Select Green Color Option ---------------------------
ProductDetailsPageActions.selectColorOption(ProductDetailsPageItems.optionColorGreen)

ProductDetailsPageValidations.verifyProductSelectedColorOption(ProductDetailsPageItems.optionColorGreen)

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
WebUI.waitForElementClickable(findTestObject(ProductDetailsPageItems.btnAddToCart), GlobalVariable.elementVisibilityTimeOut)

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
ProductDetailsPageActions.selectSizeOption(ProductDetailsPageItems.optionSizeLarge)

ProductDetailsPageValidations.verifyProductSelectedSizeOption(ProductDetailsPageItems.optionSizeLarge)

//------ Verify Product data is changed --------
ProductDetailsPageValidations.verifyProductDataChangesAfterSizeOption(secondProduct)

//------------------------------- Select Green Color Option ---------------------------
ProductDetailsPageActions.selectColorOption(ProductDetailsPageItems.optionColorBlue)

ProductDetailsPageValidations.verifyProductSelectedColorOption(ProductDetailsPageItems.optionColorBlue)

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
WebUI.waitForElementClickable(findTestObject(ProductDetailsPageItems.btnAddToCart), GlobalVariable.elementVisibilityTimeOut)

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
GeneralValidations.verifyCurrentPageURL(AppConstants.CART_PAGE_URL)

//------ Verify Page Title --------
GeneralValidations.verifyCurrentPageTitleValue(AppConstants.CART_PAGE_TITLE)

//------ Verify Page Heading --------
GeneralValidations.verifyPageHeading(AppConstants.CART_PAGE_HEADING)

//------ Verify products data in cart --------
CartPageValidations.verifyCartProductsData(secondProduct, firstProduct)

//------ Verify cart summary --------
CartPageValidations.verifyCartSummary(true, AppConstants.SHIPPING_NOT_AVAILABLE, AppConstants.TAX_TBD)

//------ Change firstProduct cart quantity --------
CartPageActions.clickMinusQtyButton(0)

CartPageValidations.verifyCartSummary(true, AppConstants.SHIPPING_NOT_AVAILABLE, AppConstants.TAX_TBD)

CartPageValidations.verifyProductTotalAfterChangeQty(0, secondProduct)

//------ Change secondProduct cart quantity --------
CartPageActions.clickPlusQtyButton(1)

CartPageValidations.verifyCartSummary(true, AppConstants.SHIPPING_NOT_AVAILABLE, AppConstants.TAX_TBD)

CartPageValidations.verifyProductTotalAfterChangeQty(1, firstProduct)

//------ Click ProceedToCheckout Button --------
CartPageActions.clickProceedToCheckoutButton()

/***********************************************************************/
/******************* Checkout Interstitial Page ************************/
/***********************************************************************/
//------ Verify Page URL --------
GeneralValidations.verifyCurrentPageURL(AppConstants.SELECT_CHECKOUT_PAGE_URL)

//------ Verify Page Title --------
GeneralValidations.verifyCurrentPageTitleValue(AppConstants.SELECT_CHECKOUT_PAGE_TITLE)

//------ Verify Page Heading --------
SelectCheckoutPageValidations.verifyPageHeading(AppConstants.SELECT_CHECKOUT_PAGE_HEADING)

//------ Verify Header CustomerSerice --------
HeaderValidations.verifyHeaderCustomerService()

//------ Verify products data in cart --------
CartPageValidations.verifyCartProductsData(secondProduct, firstProduct)

//------ Verify order total --------
SelectCheckoutPageValidations.verifyOrderTotal()

//------ Verify cart summary --------
CartPageValidations.verifyCartSummary(false, AppConstants.SHIPPING_FREE, AppConstants.TAX_TBD)

//------ Verify guest radion is checked --------
SelectCheckoutPageValidations.verifyGuestRadionIsChecked()

//------ Click Continue button --------
SelectCheckoutPageActions.clickContinueButton()

/***********************************************************************/
/************************** Checkout Page ******************************/
/***********************************************************************/
//Order order = new Order()
//WebUI.delay(5)
//WebUI.navigateToUrl(GlobalVariable.checkoutUrl)
GeneralValidations.verifyCurrentPageURL(GlobalVariable.checkoutUrl)

GeneralValidations.verifyCurrentPageTitleValue(GlobalVariable.checkoutTitle)

CheckoutPageValidations.verfiyCheckoutPageHeading(GlobalVariable.checkoutHeading)

//------ Verify Header CustomerSerice --------
HeaderValidations.verifyHeaderCustomerService()

//------ Verify products data in cart --------
CartPageValidations.verifyCartProductsData(secondProduct, firstProduct)

//------ Verify order total --------
SelectCheckoutPageValidations.verifyOrderTotal()

//------ Verify cart summary --------
CartPageValidations.verifyCartSummary(false, AppConstants.SHIPPING_FREE, AppConstants.TAX_ZERO)

//filling company field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.companyField, GlobalVariable.companyFieldContent)

//filling first name field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.firstNameField, GlobalVariable.firstName)

//filling last name field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.lastNameField, GlobalVariable.lastName)

//filling address1 field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.firstAddressField, GlobalVariable.address1)

//filling address2 field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.secondAddressField, GlobalVariable.address2)

//filling zip code field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.zipCodeField, GlobalVariable.zipCode)

//filling city field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.cityField, GlobalVariable.city)

//select state
CheckoutPageActions.selectState()

//verify reflected value in selection
CheckoutPageValidations.verifyTheSelectedOptionValueIsReflected(CheckoutPageItems.stateSelect, 'California')

//filling phone field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.phoneField, GlobalVariable.phone)

//filling ext field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.extField, GlobalVariable.ext)

//filling email field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.emailField, GlobalVariable.email)

//verify the fast free section is appeared
CheckoutPageValidations.verifyTheFastFreeSectionIsAppeared()

//click on fast free collapse
CheckoutPageActions.clickOnCollapse()

//verify shipping option is selected
CheckoutPageValidations.verifyShippingOptionIsSelected()

//filling name on card field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.cardNameField, GlobalVariable.cardName)

//filling card number field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.cardNumberField, '4444444444444444')

//filling security code field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.securityNumberField, GlobalVariable.securityCode)

//selecting expiration date randomly and verify reflected value
String selectedMonth = CheckoutPageHelpers.selectOptionAndVerifyReflectedValue(CheckoutPageItems.expirationDateSelect, CheckoutPageItems.mounthOptions)

//selecting year randomly and verify reflected value
String selectedYear = CheckoutPageHelpers.selectOptionAndVerifyReflectedValue(CheckoutPageItems.expirationYearSelect, CheckoutPageItems.yearOptions)

//verify belling address is checked by default
CheckoutPageValidations.verifyBillingAddressIsChecked()

//filling pon number field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.poField, GlobalVariable.po)

//fill comment field and verify reflected value
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.commentsField, GlobalVariable.comment)

//click on review order button
CheckoutPageActions.clickOnReviewOrderButton()

/***********************************************************************/
/************************ Order Review Page ****************************/
/***********************************************************************/
GeneralValidations.verifyCurrentPageURL(AppConstants.ORDER_REVIEW_PAGE_URL)

GeneralValidations.verifyCurrentPageTitleValue(AppConstants.ORDER_REVIEW_PAGE_TITLE)

GeneralValidations.verifyPageHeading(AppConstants.ORDER_REVIEW_PAGE_HEADING)

//------ Verify Header CustomerSerice --------
HeaderValidations.verifyHeaderCustomerService()

//------ Verify products data in cart --------
CartPageValidations.verifyCartProductsData(secondProduct, firstProduct)

//------ Verify order total --------
SelectCheckoutPageValidations.verifyOrderTotal()

//------ Verify cart summary --------
CartPageValidations.verifyCartSummary(false, AppConstants.SHIPPING_FREE, AppConstants.TAX_ZERO)

//------ Verify Order Shipping Data --------
OrderReviewPageValidations.verifyOrderShippingData()

System.out.println((('Selected Date:' + selectedMonth) + ' // ') + selectedYear)

//click on fast free collapse
CheckoutPageActions.clickOnCollapse()

//verify shipping option is selected
CheckoutPageValidations.verifyShippingOptionIsSelected()

//------ Verify Order Payment Data --------
OrderReviewPageValidations.verifyOrderPaymentData(selectedMonth, selectedYear)

//------ Verify Order inputs field --------
OrderReviewPageValidations.verifyPoInput()

OrderReviewPageValidations.verifyCommentsInput()