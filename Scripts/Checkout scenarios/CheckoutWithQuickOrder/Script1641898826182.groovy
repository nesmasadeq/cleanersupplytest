import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.CartPageActions
import actions.CheckoutPageActions
import actions.HeaderActions
import actions.QuickActionActions
import helpers.CartPageHelpers
import helpers.CheckoutPageHelpers
import helpers.GeneralHelpers
import helpers.HeaderHelpers
import helpers.MiniCartHelpers
import helpers.QuickActionsHelper
import helpers.SelectCheckoutPageHelpers
import internal.GlobalVariable
import items.CartPageItems
import items.CheckoutPageItems
import models.AppConstants
import models.Product
import validations.CartPageValidations
import validations.CheckoutPageValidations
import validations.GeneralValidations
import validations.HeaderValidations
import validations.OrderReviewPageValidations
import validations.QuickOrdersValidations
import validations.SelectCheckoutPageValidations 
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject


GeneralHelpers.initScenario()

QuickActionActions.hoverOverQuickActionIcon()

QuickOrdersValidations.verifyOnActiveIcon()

QuickActionActions.clickOverQuickActionIcon()

GeneralValidations.verifyCurrentPageTitleValue('Quick Order - Cleaner\'s Supply')

GeneralValidations.verifyCurrentPageURL('https://www.cleanersupply.com/quick-order/')

QuickOrdersValidations.verifyQuickOrderTabText()

QuickOrdersValidations.verifyDefaultQuickItemsCount()

QuickOrdersValidations.verifyAddMoreButtonExist()

QuickOrdersValidations.verifySKUFieldInEveryOrder()

List<Product> orders = QuickActionsHelper.fillOrders()




/***********************************************************************/
/***************************** Cart Page *******************************/
/***********************************************************************/
WebUI.click(findTestObject("Object Repository/QuickAction/AddToCart"))

Thread.sleep(4000)
GeneralValidations.verifyCurrentPage(AppConstants.CART_PAGE_URL, AppConstants.CART_PAGE_TITLE, AppConstants.CART_PAGE_HEADING)

//------ Verify products data in cart --------
CartPageValidations.verifyCartProductsData(orders.get(4) , orders.get(3) , orders.get(2) , orders.get(1) , orders.get(0))

//------ Verify cart summary --------
CartPageValidations.verifyCartSummary(true, AppConstants.SHIPPING_NOT_AVAILABLE, AppConstants.TAX_TBD)

//------ Verify MiniCart is change --------
HeaderValidations.verifyCartLabel(HeaderHelpers.calculateCartTotal(orders.get(4) , orders.get(3) , orders.get(2) , orders.get(1) , orders.get(0)))

MiniCartHelpers.verifyMiniCart(orders.get(4) , orders.get(3) , orders.get(2) , orders.get(1) , orders.get(0))

QuickActionActions.hoverOverQuickActionIcon()

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
CartPageValidations.verifyCartProductsData(orders.get(4) , orders.get(3) , orders.get(2) , orders.get(1) , orders.get(0))

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
CartPageValidations.verifyCartProductsData(orders.get(4) , orders.get(3) , orders.get(2) , orders.get(1) , orders.get(0))

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

//verify shipping changed in summery
CheckoutPageValidations.verifyShippingIsChanged()

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
CartPageValidations.verifyCartProductsData(orders.get(4) , orders.get(3) , orders.get(2) , orders.get(1) , orders.get(0))

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




