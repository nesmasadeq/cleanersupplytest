package validations

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.ProductDetailsPageActions
import helpers.GeneralHelpers
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

		assert WebUI.getText(testObject).toLowerCase().contains(value)
	}

	/**
	 * Verify product image in productDetailsPage match expected image
	 * @param productImage
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductImage(String productImage) {
		TestObject testObject = findTestObject(ProductDetailsPageActions.productImage)

		assert WebUI.getAttribute(testObject, 'src').equals(productImage)
	}

	/**
	 * Verify product sku in productDetailsPage match expected sku
	 * @param productSku
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductSku(String productSku) {
		TestObject testObject = findTestObject(ProductDetailsPageActions.productSku)

		assert WebUI.getText(testObject).toLowerCase().contains(productSku)
	}

	/**
	 * Verify product price in productDetailsPage between expected price range
	 * @param product
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductPrice(Product  product) {
		TestObject testObject = findTestObject(ProductDetailsPageActions.productPrice)

		checkCurrency(WebUI.getText(testObject))

		double currentPrice = GeneralHelpers.covertStringToInteger(testObject)

		assert (currentPrice >= product.getMinPrice()) && (currentPrice <= product.getMaxPrice())
	}

	/**
	 * Verify product list value in productDetailsPage between expected list range
	 * @param product
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductListValue(Product  product) {
		TestObject testObject = findTestObject(ProductDetailsPageActions.productListValue)

		checkCurrency(WebUI.getText(testObject))

		double currentValue = GeneralHelpers.covertStringToInteger(testObject)

		assert (currentValue >= product.getMinList()) && (currentValue <= product.getMaxList())
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
	 * Verify specific product option is selected
	 * @param testObject
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductOptionIsSelected(String selector) {
		TestObject testObject = findTestObject(selector)
		System.out .println("getClass: " + WebUI.getAttribute(testObject, "class"))
		assert WebUI.getAttribute(testObject, "class").contains("selected")
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