import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import actions.CartPageActions as CartPageActions
import actions.CheckoutPageActions as CheckoutPageActions
import actions.HeaderActions as HeaderActions
import actions.ProductDetailsPageActions as ProductDetailsPageActions
import helpers.CartPageHelpers as CartPageHelpers
import helpers.CheckoutPageHelpers as CheckoutPageHelpers
import helpers.GeneralHelpers as GeneralHelpers
import helpers.HeaderHelpers as HeaderHelpers
import helpers.MiniCartHelpers as MiniCartHelpers
import helpers.ProductDetailsPageHelpers as ProductDetailsPageHelpers
import helpers.ProductsFiltersHelpers as ProductsFiltersHelpers
import helpers.SearchResultsPageHelpers as SearchResultsPageHelpers
import helpers.SelectCheckoutPageHelpers as SelectCheckoutPageHelpers
import internal.GlobalVariable as GlobalVariable
import items.CheckoutPageItems as CheckoutPageItems
import items.HeaderItems as HeaderItems
import items.ProductDetailsPageItems as ProductDetailsPageItems
import items.ProductFiltersItems as ProductFiltersItems
import models.AppConstants as AppConstants
import models.Product as Product
import validations.CartPageValidations as CartPageValidations
import validations.CheckoutPageValidations as CheckoutPageValidations
import validations.GeneralValidations as GeneralValidations
import validations.HeaderValidations as HeaderValidations
import validations.OrderReviewPageValidations as OrderReviewPageValidations
import validations.ProductDetailsPageValidations as ProductDetailsPageValidations
import validations.ProductsFiltersValidations as ProductsFiltersValidations
import validations.SearchResultsPageValidations as SearchResultsPageValidations
import validations.SelectCheckoutPageValidations as SelectCheckoutPageValidations

//---------------- Open Site ----------------
GeneralHelpers.initScenario()

//----------------Check cart is empty ----------------
HeaderHelpers.checkCartIsEmpty()

//---------------- Search for plastic ---------------- 
//------ inputSearch -------- 
HeaderValidations.verifySearchInputPlaceHolder()

WebUI.setText(HeaderItems.inputSearch, AppConstants.SEARCH_TERM)

HeaderValidations.verifyAutoSuggestionSearchListIsVisible()

HeaderValidations.verifySearchForLabel()

HeaderValidations.verifyAutoSuggestionsInnerItems()

WebUI.sendKeys(HeaderItems.inputSearch, Keys.chord(Keys.ENTER))

/***********************************************************************/
/************************ Search Results Page **************************/
/***********************************************************************/
//------ Verify Page URL + Title + Heading --------
GeneralValidations.verifyCurrentPage(AppConstants.SEARCH_PAGE_URL, AppConstants.SEARCH_PAGE_TITLE, AppConstants.SEARCH_PAGE_HEADING)

//------ Verify filtersProductType --------
SearchResultsPageValidations.verifySubHeader()

//------ Verify Filters Products Count --------
ProductsFiltersHelpers.openFiltersCard()

//ProductsFiltersValidations.verifyAnyFiltersProductsCountMatchResultsCount()
/***********************************************************************/
//------ Check packaging products filter --------
ProductsFiltersHelpers.checkingPackagingProductFilter()

GeneralValidations.verifyCurrentPageURL(AppConstants.FILTER_PACKAGING_PRODUCT_URL)

//------ Verify filter count match product count --------
ProductsFiltersValidations.verifyFilterProductsCountMatchResultsCount(ProductFiltersItems.countPackagingProducts)

//------ Verify packagingProducts found in selected filters--------
ProductsFiltersValidations.verifySelectedFilters(AppConstants.FILTER_PACKAGING_PRODUCT)

//------ Verify pagination is changed --------
ProductsFiltersValidations.verifyPaginationIsChanged(3)

/***********************************************************************/
//------ Check PalsticBags products filter --------
ProductsFiltersHelpers.checkingPlasticBagsFilter()

GeneralValidations.verifyCurrentPageURL(AppConstants.FILTER_PLASTIC_BAGS_URL)

//------ Verify filter count match product count --------
//ProductsFiltersValidations.verifyFilterProductsCountMatchResultsCount(ProductFiltersItems.countPlasticBags)
//------ Verify packagingProducts found in selected filters--------
ProductsFiltersValidations.verifySelectedFilters(AppConstants.FILTER_PACKAGING_PRODUCT, AppConstants.FILTER_PLASTIC_BAGS)

//------ Verify pagination is changed --------
ProductsFiltersValidations.verifyPaginationIsChanged(3)

/***********************************************************************/
//------ Check Green Color filter --------
ProductsFiltersHelpers.checkingGreenColorFilter()

GeneralValidations.verifyCurrentPageURL(AppConstants.FILTER_COLOR_GREEN_URL)

//------ Verify filter count match product count --------
ProductsFiltersValidations.verifyFilterProductsCountMatchResultsCount(ProductFiltersItems.countGreen)

ProductsFiltersValidations.verifyFilterProductsCountMatchResultsCount(ProductFiltersItems.countPackagingProducts)

ProductsFiltersValidations.verifyFilterProductsCountMatchResultsCount(ProductFiltersItems.countPlasticBags)

//------ Verify pagination is hidden --------
SearchResultsPageValidations.verifyPaginatioIsHidden()

//------ Verify packagingProducts found in selected filters--------
ProductsFiltersValidations.verifySelectedFilters(AppConstants.FILTER_PACKAGING_PRODUCT, AppConstants.FILTER_PLASTIC_BAGS, 
    AppConstants.FILTER_COLOR_GREEN)

/***********************************************************************/
//Save Product data in this Cell & Click product
TestObject a_productUrl = findTestObject('ProductRow/a_productUrl')

Product firstProduct = SearchResultsPageHelpers.saveProductRowData(a_productUrl)

SearchResultsPageHelpers.clickSearchProduct()

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
GeneralValidations.verifyPageBreadcrumb('Bags', 'Plastic Bags', 'Comforter')

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
ProductDetailsPageValidations.verifyOutOfStockMessageIsVisible(AppConstants.OUT_OF_STOCK)

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
ProductDetailsPageHelpers.saveProductTitle(firstProduct)
ProductDetailsPageHelpers.clickAddToCart()

//ArrayList cartProducts = new ArrayList()
//cartProducts.add(firstProduct)
//------ Verify Product Quantity is changed --------
WebUI.waitForElementClickable(ProductDetailsPageItems.btnAddToCart, GlobalVariable.elementVisibilityTimeOut)

ProductDetailsPageValidations.verifyPrductQuantityInputValue(1)

//------ Verify Cart Count is change --------
HeaderValidations.verifyCartCount('1')

//------ Verify Product Price return to default price --------
ProductDetailsPageValidations.verifyProductPriceIsChanged(firstProduct)

//------ Verify MiniCart is change --------
HeaderValidations.verifyCartLabel(HeaderHelpers.calculateCartTotal(firstProduct))

MiniCartHelpers.verifyMiniCart(firstProduct)

/***********************************************************************/
/******************** Add Second Product to Cart ***********************/
/***********************************************************************/
Product secondProduct = Product.copyObject(firstProduct)

//secondProduct = cartProducts.get(0)
//------------------------------- Select Large Size Option ---------------------------
ProductDetailsPageActions.selectSizeOption(ProductDetailsPageItems.optionSizeLarge)

ProductDetailsPageValidations.verifyProductSelectedSizeOption(ProductDetailsPageItems.optionSizeLarge)

//------ Verify  out of stock message appeare --------
ProductDetailsPageValidations.verifyOutOfStockMessageIsVisible(AppConstants.OUT_OF_STOCK_TEMPORARILY)

//------ Verify Product data is changed --------
ProductDetailsPageValidations.verifyProductDataChangesAfterSizeOption(secondProduct)

//------------------------------- Select Blue Color Option ---------------------------
ProductDetailsPageActions.selectColorOption(ProductDetailsPageItems.optionColorBlue)

ProductDetailsPageValidations.verifyProductSelectedColorOption(ProductDetailsPageItems.optionColorBlue)

ProductDetailsPageValidations.verifyProductDataChangesAfterColorOption(secondProduct)

//------ Verify  out of stock message appeare --------
ProductDetailsPageValidations.verifyInStockMessageIsVisible()

//------------------------------- Type 3 in quantity input  ---------------------------
secondProduct.setQuantity(3)

ProductDetailsPageActions.setProductQuantityText(secondProduct.getQuantity())

//------ Verify Product Price is changed --------
ProductDetailsPageValidations.verifyPrductQuantityInputValue(secondProduct.getQuantity())

ProductDetailsPageValidations.verifyProductPriceIsChanged(secondProduct)

//------------------------------- Click AddToCart button  ---------------------------
ProductDetailsPageHelpers.saveProductTitle(secondProduct)
ProductDetailsPageHelpers.clickAddToCart()

//cartProducts.clear()
//cartProducts.add(firstProduct)
//cartProducts.add(secondProduct)
//------ Verify Product Quantity is changed --------
WebUI.waitForElementClickable(ProductDetailsPageItems.btnAddToCart, GlobalVariable.elementVisibilityTimeOut)

ProductDetailsPageValidations.verifyPrductQuantityInputValue(1)

//------ Verify Cart Count is change --------
HeaderValidations.verifyCartCount('2')

//------ Verify Product Price return to default price --------
ProductDetailsPageValidations.verifyProductPriceIsChanged(secondProduct)

//------ Verify MiniCart is change --------
HeaderValidations.verifyCartLabel(HeaderHelpers.calculateCartTotal(firstProduct, secondProduct))

MiniCartHelpers.verifyMiniCart(secondProduct, firstProduct)

/***********************************************************************/
/***************************** Cart Page *******************************/
/***********************************************************************/
HeaderActions.clickCartIcon()
GeneralValidations.verifyCurrentPage(AppConstants.CART_PAGE_URL, AppConstants.CART_PAGE_TITLE, AppConstants.CART_PAGE_HEADING)

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

//------ Verify MiniCart is change --------
HeaderValidations.verifyCartLabel(HeaderHelpers.calculateCartTotal(firstProduct, secondProduct))

MiniCartHelpers.verifyMiniCart(secondProduct, firstProduct)

//------ Click ProceedToCheckout Button --------
CartPageHelpers.clickProceedToCheckoutButton()

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
SelectCheckoutPageHelpers.clickContinueButton()

/***********************************************************************/
/************************** Checkout Page ******************************/
/***********************************************************************/
//Order order = new Order()
GeneralValidations.verifyCurrentPageURL(AppConstants.CHECKOUT_PAGE_URL)

GeneralValidations.verifyCurrentPageTitleValue(AppConstants.CHECKOUT_PAGE_TITLE)

CheckoutPageValidations.verfiyCheckoutPageHeading(AppConstants.CHECKOUT_PAGE_HEADING)

//------ Verify Header CustomerSerice --------
HeaderValidations.verifyHeaderCustomerService()

//------ Verify products data in cart --------
CartPageValidations.verifyCartProductsData(secondProduct, firstProduct)

//------ Verify order total --------
SelectCheckoutPageValidations.verifyOrderTotal()

//------ Verify cart summary --------
CartPageValidations.verifyCartSummary(false, AppConstants.SHIPPING_FREE, AppConstants.TAX_ZERO)

//filling company field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.companyField, AppConstants.CHECKOUT_COMPANY)

//filling first name field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.firstNameField, AppConstants.CHECKOUT_FNAME)

//filling last name field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.lastNameField, AppConstants.CHECKOUT_LNAME)

//filling address1 field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.firstAddressField, AppConstants.CHECKOUT_ADDRESS_1)

//filling address2 field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.secondAddressField, AppConstants.CHECKOUT_ADDRESS_2)

//filling zip code field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.zipCodeField, AppConstants.CHECKOUT_POSTAL_CODE)

//filling city field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.cityField, AppConstants.CHECKOUT_CITY)

//select state
CheckoutPageActions.selectState()

//verify reflected value in selection
CheckoutPageValidations.verifyTheSelectedOptionValueIsReflected(CheckoutPageItems.stateSelect, AppConstants.CHECKOUT_STATE)

//verify estimation date in cart products
CartPageValidations.verifyEstimationDeliveryDate()

//filling phone field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.phoneField, AppConstants.CHECKOUT_PHONE)

//filling ext field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.extField, AppConstants.CHECKOUT_EXT)

//filling email field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.emailField, AppConstants.CHECKOUT_EMAIL)

//verify the fast free section is appeared
CheckoutPageValidations.verifyTheFastFreeSectionIsAppeared()

//click on fast free collapse
CheckoutPageActions.clickOnCollapse()

//verify shipping option is selected
CheckoutPageValidations.verifyShippingOptionIsSelected()

//filling name on card field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.cardNameField, AppConstants.CHECKOUT_CARD_HOLDER)

//filling card number field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.cardNumberField, AppConstants.CHECKOUT_CARD_NUMBER)

//filling security code field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.securityNumberField, AppConstants.CHECKOUT_CARD_CVV)

//selecting expiration date randomly and verify reflected value
String selectedMonth = CheckoutPageHelpers.selectOptionAndVerifyReflectedValue(CheckoutPageItems.expirationDateSelect, CheckoutPageItems.mounthOptions)

//selecting year randomly and verify reflected value
String selectedYear = CheckoutPageHelpers.selectOptionAndVerifyReflectedValue(CheckoutPageItems.expirationYearSelect, CheckoutPageItems.yearOptions)

//verify belling address is checked by default
CheckoutPageValidations.verifyBillingAddressIsChecked()

//filling pon number field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.poField, AppConstants.CHECKOUT_PO)

//fill comment field and verify reflected value
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.commentsField, AppConstants.CHECKOUT_COMMENT)

//click on review order button
CheckoutPageHelpers.clickOnReviewOrderButton()

/***********************************************************************/
/************************ Order Review Page ****************************/
/***********************************************************************/
GeneralValidations.verifyCurrentPage(AppConstants.ORDER_REVIEW_PAGE_URL, AppConstants.ORDER_REVIEW_PAGE_TITLE, AppConstants.ORDER_REVIEW_PAGE_HEADING)

//------ Verify Header CustomerSerice --------
HeaderValidations.verifyHeaderCustomerService()

//------ Verify products data in cart --------
CartPageValidations.verifyCartProductsData(secondProduct, firstProduct)

//------ Verify order total --------
SelectCheckoutPageValidations.verifyOrderTotal()

//------ Verify cart summary --------
CartPageValidations.verifyCartSummary(false, AppConstants.SHIPPING_FREE, AppConstants.TAX_ZERO)

//------ Verify Order Shipping Data --------
System.out.println((('Selected Date:' + selectedMonth) + ' // ') + selectedYear)

OrderReviewPageValidations.verifyOrderShippingData()

OrderReviewPageValidations.verifyOrderShippingCountry()

//click on fast free collapse
CheckoutPageActions.clickOnCollapse()

//verify shipping option is selected
CheckoutPageValidations.verifyShippingOptionIsSelected()

//------ Verify Order Payment Data --------
OrderReviewPageValidations.verifyOrderPaymentData(selectedMonth, selectedYear)

//------ Verify Order inputs field --------
OrderReviewPageValidations.verifyPoInput()

OrderReviewPageValidations.verifyCommentsInput()

//---------------- Close Site ----------------
WebUI.closeBrowser()