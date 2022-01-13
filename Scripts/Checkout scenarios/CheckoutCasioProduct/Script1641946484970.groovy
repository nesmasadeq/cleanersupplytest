import helpers.ComputerAndRegisterPageHelpers
import helpers.GeneralHelpers
import helpers.HeaderHelpers
import helpers.ProductsFiltersHelpers
import models.Product
import validations.ComputerAndRegisterPageValidations
import validations.GeneralValidations
import validations.HeaderValidations
import validations.ProductDetailsPageValidations

GeneralHelpers.initScenario()

HeaderHelpers.hoveringTagsAndFormLink()

ComputerAndRegisterPageHelpers.clickingOnComputerAndRegisterLink()

ProductsFiltersHelpers.selectingManufacturer()

ProductsFiltersHelpers.selectingModel()

Product casioProduct = ComputerAndRegisterPageHelpers.clickingOnProdutItem()

GeneralValidations.verifyCurrentPageURL(casioProduct.getHref())

GeneralValidations.verifyCurrentPageTitleValue("Epson Printer Indelibond Ink Ribbons #TM290, ERC27 - 6/Box - Cleaner's Supply")

ComputerAndRegisterPageValidations.verifyBreadcrumbContent('Ink Ribbons','')

//ProductDetailsPageValidations.verifyProductTitle(product.getTitle())
//ProductDetailsPageValidations.verifyProductImage(product.getImage())
//ProductDetailsPageValidations.verifyProductSku(product.getSku())

ProductDetailsPageValidations.verifyProductPrice(casioProduct)

ProductDetailsPageValidations.verifyProductListValue(casioProduct)

HeaderValidations.verifyCartCount('0')

ProductDetailsPageValidations.verifyEnterdQuantityValue('10')


