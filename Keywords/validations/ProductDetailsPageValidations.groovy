package validations

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import actions.ProductDetailsPageActions
import helpers.GeneralHelpers
import internal.GlobalVariable
import models.Product

public class ProductDetailsPageValidations {

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
	 */
	public static void verifyEnterdQuantityValue(String expectedQuantity){
		TestObject quantityField = ProductDetailsPageActions.enterQuantity("10")
		assert WebUI.getAttribute(quantityField, 'value').contains(expectedQuantity)
	}
}