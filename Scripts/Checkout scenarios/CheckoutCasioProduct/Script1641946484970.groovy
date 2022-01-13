import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.CheckoutPageActions
import helpers.CheckoutPageHelpers
import helpers.ComputerAndRegisterPageHelpers
import helpers.GeneralHelpers
import helpers.HeaderHelpers
import helpers.ProductsFiltersHelpers
import internal.GlobalVariable
import items.CheckoutPageItems
import models.Product
import validations.CheckoutPageValidations
import validations.GeneralValidations

GeneralHelpers.initScenario()

HeaderHelpers.hoveringTagsAndFormLink()

ComputerAndRegisterPageHelpers.clickingOnComputerAndRegisterLink()

ProductsFiltersHelpers.selectingManufacturer()

ProductsFiltersHelpers.selectingModel()

Product casioProduct = ComputerAndRegisterPageHelpers.clickingOnProdutItem()

GeneralValidations.verifyCurrentPageURL(casioProduct.getHref())

GeneralValidations.verifyCurrentPageTitleValue("Epson Printer Indelibond Ink Ribbons #TM290, ERC27 - 6/Box - Cleaner's Supply")
WebUI.click(findTestObject('Object Repository/ProductDetailsPage/button_addToCart'))

//ComputerAndRegisterPageValidations.verifyBreadcrumbContent('Ink Ribbons','')
//
//ProductDetailsPageValidations.verifyProductTitle(casioProduct.getTitle())
//ProductDetailsPageValidations.verifyProductImage(casioProduct.getImage())
//ProductDetailsPageValidations.verifyProductSku(casioProduct.getSku())
//
//ProductDetailsPageValidations.verifyProductPrice(casioProduct)
//
//ProductDetailsPageValidations.verifyProductListValue(casioProduct)
//
//HeaderValidations.verifyCartCount('0')
//
//ProductDetailsPageValidations.verifyEnterdQuantityValue('10')
//
//ProductDetailsPageValidations.verifyThePriceChangeReflected(casioProduct)
//
//ProductDetailsPageValidations.verifyThePriceInCellEqualPrice(
//	findTestObject('Object Repository/ProductDetailsPage/span_tablePriceMoreThan10'))

//checkout scenario
WebUI.delay(5)
WebUI.navigateToUrl(GlobalVariable.checkoutUrl)


GeneralValidations.verifyCurrentPageURL(GlobalVariable.checkoutUrl)

GeneralValidations.verifyCurrentPageTitleValue(GlobalVariable.checkoutTitle)

CheckoutPageValidations.verfiyCheckoutPageHeading(GlobalVariable.checkoutHeading)

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
CheckoutPageValidations.verifyTheSelectedOptionValueIsReflected(CheckoutPageItems.stateSelect, 'California')

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

