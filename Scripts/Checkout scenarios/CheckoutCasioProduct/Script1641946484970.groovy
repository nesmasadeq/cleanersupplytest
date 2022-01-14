import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import actions.CheckoutPageActions
import actions.HeaderActions
import actions.ProductDetailsPageActions
import helpers.CheckoutPageHelpers
import helpers.ComputerAndRegisterPageHelpers
import helpers.GeneralHelpers
import helpers.HeaderHelpers
import helpers.ProductsFiltersHelpers
import internal.GlobalVariable
import items.CheckoutPageItems
import items.ProductDetailsPageItems
import models.Product
import validations.CheckoutPageValidations
import validations.ComputerAndRegisterPageValidations
import validations.GeneralValidations
import validations.HeaderValidations
import validations.ProductDetailsPageValidations
import models.AppConstants as AppConstants
import validations.CartPageValidations as CartPageValidations
import actions.CartPageActions as CartPageActions
import validations.SelectCheckoutPageValidations as SelectCheckoutPageValidations
import actions.SelectCheckoutPageActions as SelectCheckoutPageActions


//initial checking casio product to cart
GeneralHelpers.initScenario()

//verify hovering on tags and forms link
HeaderActions.hoverOnTagsAndFormsLink()

//verfiy displaying tags and forms menu
HeaderValidations.verifyDisplayingTagsAndFormMenu()

//verfiy tags and forms link background changed
HeaderValidations.verifyTagsAndFormBackgroundColorChanged()

//verfiy tags and forms link color changed
HeaderValidations.verifyTagsAndFormColorChanged()

//verfiy clicking on computer and register link
HeaderActions.clickOnComputersAndRegisterLink()

//verfiy computer and register link color changed
HeaderValidations.VerifyComputerAndRegisterColorChanged()

//verify computer and register page url, title and heading content
GeneralHelpers.CheckingPageURLTitleAndHeading(GlobalVariable.computerAndRegisterUrl,
	 GlobalVariable.computerAndRegiterTitle, GlobalVariable.computerAndRegisterPageHeading)

//verify breadcrumb content
ComputerAndRegisterPageValidations.verifyBreadcrumbContent(GlobalVariable.computerAndRegisterBreadcrumb1,
	GlobalVariable.computerAndRegisterBreadcrumb2)

ProductsFiltersHelpers.selectingManufacturer()

ProductsFiltersHelpers.selectingModel()

Product casioProduct = ComputerAndRegisterPageHelpers.clickingOnProdutItem()

GeneralValidations.verifyCurrentPageURL(casioProduct.getHref())

GeneralValidations.verifyCurrentPageTitleValue(GlobalVariable.casioPageTitle)

//verify breadcrumb changed in casio product page
ProductDetailsPageValidations.verifyPageBreadcrumb(GlobalVariable.computerAndRegisterBreadcrumb1,
	GlobalVariable.computerAndRegisterBreadcrumb2,GlobalVariable.casioBeadcrumb)

//verify the cart is empty
HeaderHelpers.checkCartIsEmpty()

//verify product name is match the expected
ProductDetailsPageValidations.verifyProductTitle(casioProduct.getTitle())

//verify product price is match the expected
ProductDetailsPageValidations.verifyProductPrice(casioProduct)

//verify product price is found in the volume table
ProductDetailsPageValidations.verifyProductPriceMatchPricingTable()

//verify list value match the expected
ProductDetailsPageValidations.verifyProductListValue(casioProduct)

//verify sku value match the expected
ProductDetailsPageActions.saveProductSkuToObject(casioProduct)
ProductDetailsPageValidations.verifyProductSku(casioProduct.getSku())

//Verify Q&A count match the expected
ProductDetailsPageValidations.verifyProductQuestionsAnswersItemsCount()

//verify image match the expected
//ProductDetailsPageValidations.verifyProductImage(casioProduct.getImage())

//verify in stock is visible
ProductDetailsPageValidations.verifyInStockMessageIsVisible()


//verify entering product  quantity
casioProduct.setQuantity(5)

ProductDetailsPageActions.setProductQuantityText(casioProduct.getQuantity())
//verify the product price changed
ProductDetailsPageValidations.verifyPrductQuantityInputValue(casioProduct.getQuantity())

ProductDetailsPageValidations.verifyProductPriceIsChanged(casioProduct)

//verify the price in volume table
ProductDetailsPageValidations.verifyThePriceInCellEqualPrice(
	findTestObject('Object Repository/ProductDetailsPage/span_tablePriceMoreThan10'))

//cicking on add to cart button
ProductDetailsPageActions.clickAddToCart()
WebUI.waitForElementClickable(findTestObject(ProductDetailsPageItems.btnAddToCart), GlobalVariable.elementVisibilityTimeOut)

//verify cart count changed
HeaderValidations.verifyCartCount('1')

//verify the quantity input return to 1
ProductDetailsPageValidations.verifyPrductQuantityInputValue(1)

//verify the label for price in the header reflected the price
HeaderValidations.verifyCartLabel(HeaderHelpers.calculateCartTotal(casioProduct))

//verify the product price changed to default
ProductDetailsPageValidations.verifyProductPriceIsChanged(casioProduct)

//clicking on cart icon
HeaderActions.clickCartIcon()

//------- cart page --------//
//verify computer and register page url, title and heading content
GeneralHelpers.CheckingPageURLTitleAndHeading(AppConstants.CART_PAGE_URL,
	 AppConstants.CART_PAGE_TITLE, AppConstants.CART_PAGE_HEADING)

//verify product data in cart
CartPageValidations.verifyCartProductsData(casioProduct)

//verify the price in summery
CartPageValidations.verifyProductTotalAfterChangeQty(1, casioProduct)

//verify summery shipping and tax
CartPageValidations.verifyCartSummary(true, AppConstants.SHIPPING_FREE, AppConstants.TAX_ZERO)

//verify clicking on proceed button
CartPageActions.clickProceedToCheckoutButton()

//------- checkout interstitial page --------//

//verify interstitial page url, title and heading content
GeneralHelpers.CheckingPageURLTitleAndHeading(AppConstants.SELECT_CHECKOUT_PAGE_URL,
	 AppConstants.SELECT_CHECKOUT_PAGE_TITLE, AppConstants.ORDER_REVIEW_PAGE_HEADING)

//verify header customer service
HeaderValidations.verifyHeaderCustomerService()

//verify product data in cart
CartPageValidations.verifyCartProductsData(casioProduct)

//verify product total
SelectCheckoutPageValidations.verifyOrderTotal()

//verify shipping and tax in summery
CartPageValidations.verifyCartSummary(false, AppConstants.SHIPPING_FREE, AppConstants.TAX_ZERO)

//verify guest radio is checked by default
SelectCheckoutPageValidations.verifyGuestRadionIsChecked()

//clicking Continue button
SelectCheckoutPageActions.clickContinueButton()

//--------- Checkout page -------------//

//verify checkout page url, title and heading content
GeneralHelpers.CheckingPageURLTitleAndHeading(GlobalVariable.checkoutUrl,
	 GlobalVariable.checkoutTitle, GlobalVariable.checkoutHeading)

//verify product data in cart
CartPageValidations.verifyCartProductsData(casioProduct)

//verify product total
SelectCheckoutPageValidations.verifyOrderTotal()

//verify shipping and tax in summery
CartPageValidations.verifyCartSummary(false, AppConstants.SHIPPING_FREE, AppConstants.TAX_ZERO)

//filling company field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.companyField,GlobalVariable.companyFieldContent)

//filling first name field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.firstNameField,GlobalVariable.firstName)

//filling last name field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.lastNameField,GlobalVariable.lastName)

//filling address1 field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.firstAddressField,GlobalVariable.address1)

//filling address2 field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.secondAddressField,GlobalVariable.address2)

//filling zip code field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.zipCodeField,GlobalVariable.zipCode)

//filling city field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.cityField,GlobalVariable.city)

//select state
CheckoutPageActions.selectState()

//verify reflected value in selection
CheckoutPageValidations.verifyTheSelectedOptionValueIsReflected(CheckoutPageItems.stateSelect, AppConstants.SELECT_STATE)

//filling phone field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.phoneField,GlobalVariable.phone)

//filling ext field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.extField,GlobalVariable.ext)

//filling email field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.emailField,GlobalVariable.email)

//verify the fast free section is appeared
CheckoutPageValidations.verifyTheFastFreeSectionIsAppeared()

//click on fast free collapse
CheckoutPageActions.clickOnCollapse()

//verify shipping option is selected
CheckoutPageValidations.verifyShippingOptionIsSelected()

//filling name on card field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.cardNameField,GlobalVariable.cardName)

//filling card number field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.cardNumberField,GlobalVariable.cardNumber)

//filling security code field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.securityNumberField,GlobalVariable.securityCode)

//selecting expiration date randomly and verify reflected value
CheckoutPageHelpers.selectOptionAndVerifyReflectedValue(CheckoutPageItems.expirationDateSelect,CheckoutPageItems.mounthOptions)

//selecting year randomly and verify reflected value
CheckoutPageHelpers.selectOptionAndVerifyReflectedValue(CheckoutPageItems.expirationYearSelect,CheckoutPageItems.yearOptions)

//verify belling address is checked by default
CheckoutPageValidations.verifyBillingAddressIsChecked()

//filling pon number field and verify focus and values
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.poField,GlobalVariable.po)

//fill comment field and verify reflected value
CheckoutPageHelpers.fillInputAndVerifyFocusAndValue(CheckoutPageItems.commentsField,GlobalVariable.comment)

//click on review order button
CheckoutPageActions.clickOnReviewOrderButton()

