package validations

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.ProductDetailsPageActions
import helpers.GeneralHelpers
import helpers.ProductDetailsPageHelpers
import helpers.ProductDetailsPageHelper
import internal.GlobalVariable
import models.Product

public class ProductDetailsPageValidations {
	static TestObject priceLable = findTestObject('Object Repository/ProductDetailsPage/span_productPrice')

	/**
	 * Verify product title in productDetailsPage match expected title
	 * @param productTitel
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductTitle(String value) {
		TestObject testObject = findTestObject(ProductDetailsPageActions.productTitle)

		assert WebUI.getText(testObject).toLowerCase().contains(value.toLowerCase())
	}

	/**
	 * Verify page breadCrumb links
	 * @param breadcrumbLinks
	 * @author Eng. Amal Hamad
	 */
	public static void verifyPageBreadcrumb(String... breadcrumbLinks) {
		List<WebElement> productBreadcrumb = WebUI.findWebElements(findTestObject(ProductDetailsPageActions.productBreadcrumb),
				GlobalVariable.elementVisibilityTimeOut)

		for(int i = 0 ; i<productBreadcrumb.size() ; i++) {
			TestObject object = WebUI.convertWebElementToTestObject(productBreadcrumb.get(i))
			System.out.println('productBreadcrumb: ' + WebUI.getText(object))
			if(!WebUI.getText(object).equals("")) {
				assert breadcrumbLinks[i].equals( WebUI.getText(object))
			}
		}
	}

	/**
	 * Verify product image in productDetailsPage match expected image
	 * @param productImage
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductImage(Product product) {
		TestObject testObject = findTestObject(ProductDetailsPageActions.productImage)
		String image = WebUI.getAttribute(testObject, 'src').toLowerCase()
		product.setImage(image)
		assert image.contains(product.getSku().toLowerCase())
	}

	/**
	 * Verify current productImage in page does not match previous image
	 * @param product
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductImageIsChanged(Product product) {
		TestObject testObject = findTestObject(ProductDetailsPageActions.productImage)
		String prevImage = product.getImage()
		String currentImage = WebUI.getAttribute(testObject, 'src').toLowerCase()
		assert !currentImage.equals(prevImage)
		ProductDetailsPageValidations.verifyProductImage(product)
	}

	/**
	 * Verify product sku in productDetailsPage match expected sku
	 * @param productSku
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductSku(String productSku) {
		TestObject testObject = findTestObject(ProductDetailsPageActions.productSku)

		assert WebUI.getText(testObject).contains(productSku)

		GeneralValidations.verifyCurrentPageURL(productSku)
	}

	/**
	 * Verify current productSku in page does not match previous Sku
	 * @param product
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductSkuIsChanged(Product product) {
		String prevSku = product.getSku()
		TestObject testObject = findTestObject(ProductDetailsPageActions.productSku)

		assert !WebUI.getText(testObject).toLowerCase().contains(prevSku)

		ProductDetailsPageActions.saveProductSkuToObject(product)
		ProductDetailsPageValidations.verifyProductSku(product.getSku())
	}

	/**
	 * Verify product price in productDetailsPage between expected price range
	 * @param product
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductPrice(Product product) {
		TestObject testObject = findTestObject(ProductDetailsPageActions.productPrice)

		checkCurrency(WebUI.getText(testObject))

		double currentPrice = GeneralHelpers.convertStringToDouble(testObject)
		product.setPrice(currentPrice)

		assert (currentPrice >= product.getMinPrice()) && (currentPrice <= product.getMaxPrice())
	}

	/**
	 * Verify current productPrice in page does not match previous price
	 * @param product
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductPriceIsChanged(Product product) {
		double prevPrice = product.getPrice()

		TestObject testObject = findTestObject(ProductDetailsPageActions.productPrice)
		assert GeneralHelpers.convertStringToDouble(testObject) != prevPrice

		ProductDetailsPageValidations.verifyProductPrice(product)
		ProductDetailsPageValidations.verifyProductPriceMatchPricingTable()
	}

	/**
	 * Verify product price with this quantity match expected price in volume pricing table
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductPriceMatchPricingTable() {
		TestObject inputProductQty = findTestObject(ProductDetailsPageActions.inputProductQty)
		int quantity = Integer.parseInt(WebUI.getAttribute(inputProductQty, 'value'))
		System.out.println('quantity: ' + quantity)

		TestObject productPrice = findTestObject(ProductDetailsPageActions.productPrice)
		checkCurrency(WebUI.getText(productPrice))
		double currentPrice = GeneralHelpers.convertStringToDouble(productPrice)

		double expectedPrice = ProductDetailsPageHelpers.getProductPriceByQuantity(quantity)
		System.out.println('expectedPrice: ' + expectedPrice)
		assert currentPrice == expectedPrice
	}

	/**
	 * Verify product list value in productDetailsPage between expected list range
	 * @param product
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductListValue(Product product) {
		TestObject testObject = findTestObject(ProductDetailsPageActions.productListValue)

		checkCurrency(WebUI.getText(testObject))

		double currentValue = GeneralHelpers.convertStringToDouble(testObject)
		product.setListValue(currentValue)

		assert (currentValue >= product.getMinList()) && (currentValue <= product.getMaxList())
	}

	/**
	 * Verify current productListValue in page does not match previous listValue
	 * @param product
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductListValueIsChanged(Product product) {
		double prevValue = product.getListValue()

		TestObject testObject = findTestObject(ProductDetailsPageActions.productListValue)
		assert GeneralHelpers.convertStringToDouble(testObject) != prevValue

		ProductDetailsPageValidations.verifyProductListValue(product)
	}

	/**
	 * Verify string contain expected site currency
	 * @param stringWithCurrency
	 * @author Eng. Amal Hamad
	 */
	public static void checkCurrency(String stringWithCurrency) {
		assert stringWithCurrency.contains(GlobalVariable.siteCurrency)
	}

	/**
	 * Verify hover over product size option
	 * @param TestObject
	 * @author Eng. Amal Hamad
	 */
	public static void verifyHoverOverSizeOption(TestObject testObject ) {
		System.out.println("Before Hover: " + WebUI.getCSSValue(testObject, 'background'))
		assert WebUI.getCSSValue(testObject, "color").contains("rgb(255, 255, 255)")
		WebUI.mouseOver(testObject)
		System.out.println("After Hover: " + WebUI.getCSSValue(testObject, 'background'))
		assert WebUI.getCSSValue(testObject, "color").contains("rgb(119, 120, 123)")
	}

	/**
	 * Verify product title contains size
	 * @param fullSize
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductTitleContainsSize(String sizeSelector) {
		String fullSize = ProductDetailsPageHelpers.getCurrentText(sizeSelector)
		ProductDetailsPageValidations.verifyProductTitle(fullSize.split("-")[0])
		ProductDetailsPageValidations.verifyProductTitle(fullSize.split("-")[1])
	}

	/**
	 * Verify specific product option is selected
	 * @param testObject
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductOptionIsSelected(String selector) {
		TestObject testObject = findTestObject(selector)
		System.out .println("getClass: " + WebUI.getAttribute(testObject, "class"))
		assert WebUI.getAttribute(testObject, "class").contains("selected")
		verifySelectedSizeOptionBackground(testObject)
	}

	/**
	 * Verify selected option background
	 * @param testObject
	 * @author Eng. Amal Hamad
	 */
	public static void verifySelectedSizeOptionBackground(TestObject testObject ) {
		System.out .println("size background: " + WebUI.getCSSValue(testObject, "background"))
		//		assert WebUI.getCSSValue(testObject, "background").contains("rgb(65, 64, 66)")
		System.out .println("testColor: " + WebUI.getCSSValue(testObject, "color"))
		//		assert WebUI.getCSSValue(testObject, "color").contains("rgba(255, 255, 255, 1)")
	}

	/**
	 * Verify selected size option for product
	 * @param selector
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductSelectedSizeOption(String selector) {
		// option is selected
		ProductDetailsPageValidations.verifyProductOptionIsSelected(selector)

		// found in header
		ProductDetailsPageValidations.verifyProductTitleContainsSize(selector)

		// same as specifications dimensions
		ProductDetailsPageValidations.verifyProductSizeDimensions(ProductDetailsPageHelpers.getSizeDimensions(selector))
	}

	/**
	 * Verify hover over product size option
	 * @param TestObject
	 * @author Eng. Amal Hamad
	 */
	public static void verifyHoverOverColorOption(TestObject testObject ) {
		System.out.println("Before Hover: "+ WebUI.getCSSValue(testObject, 'border'))
		//		assert WebUI.getCSSValue(testObject, "border").contains("rgb(255, 255, 255)")
		WebUI.mouseOver(testObject)
		System.out.println("After Hover: "+ WebUI.getCSSValue(testObject, 'border'))
		//		assert WebUI.getCSSValue(testObject, "border").contains("rgb(119, 120, 123)")
	}

	/**
	 * Verify selected color option for product
	 * @param selector
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductSelectedColorOption(String selector) {
		// option is selected
		ProductDetailsPageValidations.verifyProductOptionIsSelected(selector)

		// found in header
		String optionColor = ProductDetailsPageHelpers.getElementTitleAttr(selector)

		ProductDetailsPageValidations.verifyProductTitle(optionColor)

		// found in color label
		ProductDetailsPageValidations.verifyProductColorOption(optionColor)
	}

	/**
	 * Verify product size dimensions match expected dimensions
	 * @param dimentions
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductSizeDimensions(String dimentions) {
		TestObject testObject = findTestObject(ProductDetailsPageActions.productSpecificationDimension)
		String currentValue = WebUI.getText(testObject).replaceAll("[LHW]", ' ')
		assert currentValue.replaceAll("\\s+","").contains(dimentions.replaceAll("\\s+",""))
	}

	/**
	 * Verify product title in productDetailsPage match expected title
	 * @param productTitel
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductColorOption(String value) {
		TestObject testObject = findTestObject(ProductDetailsPageActions.spanSelectedColor)

		assert WebUI.getText(testObject).toLowerCase().contains(value.toLowerCase())
	}

	/**
	 * Verify product data changes after select size option
	 * @param product
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductDataChangesAfterSizeOption(Product product) {
		//------ Verify Product Sku is changed --------
		ProductDetailsPageValidations.verifyProductSkuIsChanged(product)
		//------ Verify Product Price is changed --------
		ProductDetailsPageValidations.verifyProductPriceIsChanged(product)
		//------ Verify Product ListValue is changed --------
		ProductDetailsPageValidations.verifyProductListValueIsChanged(product)
		//------ Verify Product Image is changed --------
		ProductDetailsPageValidations.verifyProductImageIsChanged(product)
	}

	/**
	 * Verify product data changes after select color option
	 * @param product
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductDataChangesAfterColorOption(Product product) {
		//------ Verify Product Sku is changed --------
		ProductDetailsPageValidations.verifyProductSkuIsChanged(product)
		//------ Verify Product Image is changed --------
		ProductDetailsPageValidations.verifyProductImageIsChanged(product)
	}


	/**
	 * Verify OutOfStock message is visible
	 * @author Eng. Amal Hamad
	 */
	public static void verifyOutOfStockMessageIsVisible() {
		TestObject testObject = findTestObject(ProductDetailsPageActions.divOutOfStock)
		WebUI.verifyElementPresent(testObject , GlobalVariable.elementVisibilityTimeOut , FailureHandling.OPTIONAL)
		assert WebUI.getText(testObject).contains("Currently Unavailable.")
		System.out.println("outOfStock: " + WebUI.getCSSValue(testObject, "color"))
		assert WebUI.getCSSValue(testObject, "color").equals("rgba(237, 28, 36, 1)")
	}

	/**
	 * Verify inStock message is visible
	 * @author Eng. Amal Hamad
	 */
	public static void verifyInStockMessageIsVisible() {
		TestObject testObject = findTestObject(ProductDetailsPageActions.divInStock)
		WebUI.verifyElementPresent(testObject , GlobalVariable.elementVisibilityTimeOut , FailureHandling.OPTIONAL)
		assert WebUI.getText(testObject).contains("In Stock!")
		System.out.println("inStock: " + WebUI.getCSSValue(testObject, "color"))
		assert WebUI.getCSSValue(testObject, "color").equals("rgba(0, 137, 63, 1)")
	}

	/**
	 * Verify AddToCartSection is hidden
	 * @author Eng. Amal Hamad
	 */
	public static void verifyAddToCartSectionVisibility(boolean expectedVisibilty) {
		TestObject testObject = findTestObject(ProductDetailsPageActions.divAddToCartSection)
		assert	WebUI.verifyElementVisible(testObject , FailureHandling.OPTIONAL) == expectedVisibilty
	}

	/**
	 * Verify product questions and answers items count
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductQuestionsAnswersItemsCount() {
		//Get expectedCount form product data
		TestObject productQestionsAnswer = findTestObject(ProductDetailsPageActions.productQestionsAnswer)
		int expectedCount = GeneralHelpers.convertStringToInteger(productQestionsAnswer)

		//Check correct count in QestionsAnswerSectionTitle
		TestObject QestionsAnswerSectionTitle = findTestObject(ProductDetailsPageActions.QestionsAnswerSectionTitle)
		String[] splitTitle = WebUI.getText(QestionsAnswerSectionTitle).split("/")
		assert String.valueOf(expectedCount).equals(splitTitle[0].replaceAll("[^0-9]", ""))
		assert String.valueOf(expectedCount).equals(splitTitle[1].replaceAll("[^0-9]", ""))

		//Check correct count in QestionsAnswerSectionItemsList
		List<TestObject> QestionsAnswerSectionItems = WebUI.findWebElements(findTestObject(ProductDetailsPageActions.QestionsAnswerSectionItems),
				GlobalVariable.elementVisibilityTimeOut)
		assert expectedCount == QestionsAnswerSectionItems.size()
	}

	/**
	 * Verify entered quantity value is reflected in input field
	 * @param expectedValue
	 * @author Eng. Amal Hamad
	 */
	public static void verifyPrductQuantityInputValue(int quantity) {
		String expectedValue = String.valueOf(quantity)
		TestObject inputProductQty = findTestObject(ProductDetailsPageActions.inputProductQty)
		assert WebUI.getAttribute(inputProductQty, 'value').equals(expectedValue)
	}

	/***
	 * verify entered quantity match the expected quantity
	 * @param expectedQuantity
	 * @author nesma
	 */
	public static void verifyEnterdQuantityValue(String expectedQuantity){
		TestObject quantityField = ProductDetailsPageActions.enterQuantity("10")
		assert WebUI.getAttribute(quantityField, 'value').contains(expectedQuantity)
	}
	
	/***
	 * verify the price label change reflected when change quantity
	 * @param product
	 * @author nesma
	 */
	public static void verifyThePriceChangeReflected(Product product) {
		TestObject QuantityFeild = findTestObject('Object Repository/ProductDetailsPage/input_quantityFeild')
		Double totalPrice= ProductDetailsPageHelper.QuantityMultiblePrice(product.getMinPrice(),WebUI.getText(QuantityFeild))
		assert WebUI.getText(priceLable).contains(totalPrice+"")		
	}
	
	/***
	 * verify the price in volume table equal the price in label
	 * @param cellPrice
	 * @author nesma
	 */
	public static void verifyThePriceInCellEqualPrice(TestObject cellPrice) {
		String cellPriceTxt= WebUI.getText(cellPrice).replace('$', '')
		assert WebUI.getText(priceLable).equals(cellPriceTxt)
	}
}