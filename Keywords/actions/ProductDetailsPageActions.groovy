package actions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import helpers.ProductDetailsPageHelpers
import models.Product



public class ProductDetailsPageActions {

	//----------- Product Data
	public static String productTitle = 'Object Repository/ProductDetailsPage/h1_productTitle'
	public static String productSku = 'Object Repository/ProductDetailsPage/span_productSku'
	public static String productImage = 'Object Repository/ProductDetailsPage/img_productImage'
	public static String productPrice = 'Object Repository/ProductDetailsPage/span_productPrice'
	public static String productListValue = 'Object Repository/ProductDetailsPage/span_productListPrice'
	public static String productBreadcrumb = 'Object Repository/ProductDetailsPage/span_productBreadcrumb'
	public static String productSpecificationDimension = 'Object Repository/ProductDetailsPage/span_productSpecificationsDimension'

	public static String productQestionsAnswer = 'Object Repository/ProductDetailsPage/a_productQustionsAnswers'
	public static String QestionsAnswerSectionTitle = 'Object Repository/ProductDetailsPage/h2_quastionAnswerTitle'
	public static String QestionsAnswerSectionItems = 'Object Repository/ProductDetailsPage/section_quastionAnswerItems'

	//----------- Product Size Options
	public static String optionSizeXSmall = 'Object Repository/ProductDetailsPage/a_optionXSmall'
	public static String optionSizeLarge = 'Object Repository/ProductDetailsPage/a_optionLarge'
	public static String optionSizeXLarge = 'Object Repository/ProductDetailsPage/a_optionXLarge'

	//----------- Product Color Options
	public static String spanSelectedColor = 'Object Repository/ProductDetailsPage/span_selectedColor'
	public static String optionColorBlack = 'Object Repository/ProductDetailsPage/a_optionColorBlack'
	public static String optionColorBlue = 'Object Repository/ProductDetailsPage/a_optionColorBlue'
	public static String optionColorGreen = 'Object Repository/ProductDetailsPage/a_optionColorGreen'

	//----------- Add To Cart Section
	public static String divAddToCartSection = 'Object Repository/ProductDetailsPage/div_addToCartSection'
	public static String divInStock = 'Object Repository/ProductDetailsPage/div_inStock'
	public static String divOutOfStock = 'Object Repository/ProductDetailsPage/div_outOfStock'
	public static String inputProductQty = 'Object Repository/ProductDetailsPage/input_productQty'
	public static String btnAddToCart = 'Object Repository/ProductDetailsPage/button_addToCart'

	//----------- Volume Pricing Table
	public static String div_volumeTableQty = 'Object Repository/ProductDetailsPage/div_volumeTableQty'
	public static String div_volumeTablePrice = 'Object Repository/ProductDetailsPage/div_volumeTablePrice'


	/**
	 * Save product Sku form details page to local product object
	 * @param product
	 * @author Eng. Amal Hamad
	 */
	public static void saveProductSkuToObject(Product product) {
		String sku = ProductDetailsPageHelpers.getCurrentText(ProductDetailsPageActions.productSku)
		product.setSku(sku)
	}

	/**
	 * Select Size option for product
	 * @param selector
	 * @author Eng. Amal Hamad
	 */
	public static void selectSizeOption(String selector) {
		TestObject testObject = findTestObject(selector)
		//		ProductDetailsPageValidations.verifyHoverOverSizeOption(testObject)
		WebUI.click(testObject)
	}

	/**
	 * Select Color option for product
	 * @param selector
	 * @author Eng. Amal Hamad
	 */
	public static void selectColorOption(String selector) {
		TestObject testObject = findTestObject(selector)
		//		ProductDetailsPageValidations.verifyHoverOverColorOption(testObject)
		WebUI.click(testObject)
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
		TestObject inputProductQty = findTestObject(ProductDetailsPageActions.inputProductQty)
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
		TestObject btnAddToCart = findTestObject(ProductDetailsPageActions.btnAddToCart)
		WebUI.click(btnAddToCart)
	}



}
