import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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
