package actions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import helpers.GeneralHelpers
import helpers.ProductDetailsPageHelpers
import items.ProductDetailsPageItems
import models.Product
import validations.GeneralValidations



public class ProductDetailsPageActions {

	/**
	 * Save product Sku form details page to local product object
	 * @param product
	 * @author Eng. Amal Hamad
	 */
	public static void saveProductSkuToObject(Product product) {
		String sku = GeneralHelpers.getFieldTitle(ProductDetailsPageItems.productSku)
		product.setSku(sku)
	}

	/**
	 * Select Size option for product
	 * @param selector
	 * @author Eng. Amal Hamad
	 */
	public static void selectSizeOption(TestObject selector) {
		//		ProductDetailsPageValidations.verifyHoverOverSizeOption(testObject)
		WebUI.click(selector)
	}

	/**
	 * Select Color option for product
	 * @param selector
	 * @author Eng. Amal Hamad
	 */
	public static void selectColorOption(TestObject selector) {
		//		ProductDetailsPageValidations.verifyHoverOverColorOption(testObject)
		WebUI.click(selector)
	}
	/***
	 * filling quantity field
	 * @param productQuantity
	 * @return quantityFeild
	 */
	public static enterQuantity(String productQuantity) {
		TestObject quantityFeild = findTestObject('Object Repository/ProductDetailsPage/input_quantityFeild')
		WebUI.sendKeys(quantityFeild, productQuantity)
		return quantityFeild
	}

	/**
	 * Clear & type in product quantity input field
	 * @param selector
	 * @author Eng. Amal Hamad
	 */
	public static void setProductQuantityText(int quantity) {
		TestObject inputProductQty = ProductDetailsPageItems.inputProductQty
		WebUI.clearText(inputProductQty)
		WebUI.sendKeys(inputProductQty, Keys.chord(Keys.BACK_SPACE))
		WebUI.setText(inputProductQty, String.valueOf(quantity))
		WebUI.sendKeys(inputProductQty, Keys.chord(Keys.TAB))
	}

	/**
	 * Click on AddToCart button
	 * @author Eng. Amal Hamad
	 */
	public static void clickAddToCart() {
		TestObject btnAddToCart = ProductDetailsPageItems.btnAddToCart
		WebUI.click(btnAddToCart)
	}
}
