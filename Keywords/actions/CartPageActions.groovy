package actions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import helpers.CartPageHelpers
import helpers.GeneralHelpers
import internal.GlobalVariable
import models.Product

public class CartPageActions {

	//----------- Product Data
	public static String productTitle = 'Object Repository/CartPage/a_productTitle'
	public static String productSku = 'Object Repository/CartPage/span_productSku'
	public static String productImage = 'Object Repository/CartPage/img_productImage'
	public static String productPrice = 'Object Repository/CartPage/td_productPrice'
	//	public static String productListValue = 'Object Repository/ProductDetailsPage/span_productListPrice'
	public static String productTotal = 'Object Repository/CartPage/td_productTotal'
	//-----------  Cart Buttons
	public static String divProductStock = 'Object Repository/CartPage/div_productStock'
	public static String inputProductQty = 'Object Repository/CartPage/input_productQuantity'
	public static String btnPlusQuantity = 'Object Repository/CartPage/button_plusQuantity'
	public static String btnMinusQuantity = 'Object Repository/CartPage/button_minusQuantity'

	//----------- Cart Summary
	public static String summaryValues = 'Object Repository/CartPage/td_summaryValues'
	public static String summarySubtotalLabel = 'Object Repository/CartPage/td_summarySubtotalLabel'
	public static String summarySubtotalValue = 'Object Repository/CartPage/td_summarySubtotalValue'
	public static String summaryShippingValue = 'Object Repository/CartPage/td_summaryShippingValue'
	public static String summaryTotalValue = 'Object Repository/CartPage/td_summaryTotalValue'


	/**
	 * Click on "+" button for this product index
	 * @param product
	 * @author Eng. Amal Hamad
	 */
	public static void clickPlusQtyButton(Product product) {
		TestObject btnPlus = CartPageHelpers.getProductFiledBySku(product , CartPageActions.btnPlusQuantity)
		WebUI.click(btnPlus)
	}

	/**
	 * Click on "-" button for this product index
	 * @param product
	 * @author Eng. Amal Hamad
	 */
	public static void clickMinusQtyButton(Product product) {
		TestObject btnMinus = CartPageHelpers.getProductFiledBySku(product , CartPageActions.btnMinusQuantity)
		WebUI.click(btnMinus)
	}

}
