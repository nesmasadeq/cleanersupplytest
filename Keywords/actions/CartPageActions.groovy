package actions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import helpers.CartPageHelpers
import helpers.GeneralHelpers
import internal.GlobalVariable
import items.CartPageItems
import models.Product
import validations.GeneralValidations

public class CartPageActions {

	/**
	 * Click on "+" button for this product index
	 * @param index
	 * @author Eng. Amal Hamad
	 */
	public static void clickPlusQtyButton(int index) {
		TestObject btnPlus = CartPageHelpers.getCartProductDataByIndex(index , CartPageItems.btnPlusQuantity)
		WebUI.click(btnPlus)
	}

	/**
	 * Click on "-" button for this product index
	 * @param index
	 * @author Eng. Amal Hamad
	 */
	public static void clickMinusQtyButton(int index ) {
		TestObject btnMinus = CartPageHelpers.getCartProductDataByIndex(index, CartPageItems.btnMinusQuantity)
		WebUI.click(btnMinus)
	}

	//	public static void clickPlusQtyButton(Product product) {
	//		TestObject btnPlus = CartPageHelpers.getCartProductDataBySku(product , CartPageActions.btnPlusQuantity)
	//		WebUI.click(btnPlus)
	//	}
	//
	//	public static void clickMinusQtyButton(Product product) {
	//		TestObject btnMinus = CartPageHelpers.getCartProductDataBySku(product , CartPageActions.btnMinusQuantity)
	//		WebUI.click(btnMinus)
	//	}

	/**
	 * Click on "ProceedToCheckout" button
	 * @author Eng. Amal Hamad
	 */
	public static void clickProceedToCheckoutButton() {
		WebUI.click(CartPageItems.buttonProceedToCheckout)
	}


}
