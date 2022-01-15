package validations

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.MiniCartActions
import helpers.CartPageHelpers
import helpers.GeneralHelpers
import helpers.MiniCartHelpers
import internal.GlobalVariable
import items.MiniCartItems
import models.Product

public class MiniCartValidations {

	/**
	 * Hover over MiniCart icon in Header
	 * @author Eng. Amal Hamad
	 */
	public static void verifyMiniCartHover() {
		MiniCartActions.hoverMiniCart()
		//Verify MiniCart Background
		//		System.out.println("After Hover: " + GeneralHelpers.getCssBackground(MiniCartItems.miniCart))
		assert GeneralHelpers.getCssBackground(MiniCartItems.miniCart).contains("rgb(255, 255, 255)")
		//Verify MiniCart Open
		//		System.out.println("After Hover: " + GeneralHelpers.getFieldCalsses(MiniCartItems.miniCartHolder))
		assert GeneralHelpers.getFieldCalsses(MiniCartItems.miniCartHolder).contains("open")
	}

	/**
	 * Verify product data in cart is correct
	 * @param expected cartProducts
	 * @author Eng. Amal Hamad
	 */
	public static void verifyMiniCartProductsData(Product... cartProducts) {
		List<WebElement> productTitleList = WebUI.findWebElements(MiniCartItems.productTitle,GlobalVariable.elementVisibilityTimeOut)
		System.out.println('productTitleList: ' + productTitleList.size())

		for (int i = 0 ; i < productTitleList.size() ; i++) {
			Product currentProduct = cartProducts[i]
			System.out.println(currentProduct.toString())

			TestObject productTitle = WebUI.convertWebElementToTestObject(productTitleList.get(i))
			GeneralValidations.verifyLinkUnderlineHover(productTitle)
			System.out.println('productTitle: ' + WebUI.getText(productTitle))
			assert  WebUI.getText(productTitle).contains(currentProduct.getTitle())

			TestObject productSku = CartPageHelpers.getCartProductDataByIndex(i, MiniCartItems.productSku)
			System.out.println('productSku: ' + WebUI.getText(productSku))
			assert  WebUI.getText(productSku).contains(currentProduct.getSku())

			TestObject productPrice = CartPageHelpers.getCartProductDataByIndex(i, MiniCartItems.productPrice)
			System.out.println('productPrice: ' + WebUI.getText(productPrice))
			assert WebUI.getText(productPrice).equals(GeneralHelpers.formatePrice(currentProduct.getPrice()))

			TestObject productTotal = CartPageHelpers.getCartProductDataByIndex(i, MiniCartItems.productTotal)
			System.out.println('productTotal: ' + WebUI.getText(productTotal))
			double total = currentProduct.getPrice() * currentProduct.getQuantity()
			assert WebUI.getText(productTotal).equals(GeneralHelpers.formatePrice(total))

			TestObject productQty = CartPageHelpers.getCartProductDataByIndex(i, MiniCartItems.productQty)
			System.out.println('productQty: ' + WebUI.getText(productTotal))
			assert WebUI.getText(productQty).equals(currentProduct.getQuantity() +"")

			TestObject productImage = CartPageHelpers.getCartProductDataByIndex(i, MiniCartItems.productImage)
			String image = GeneralHelpers.getImageSrc(productImage)
			System.out.println('productImage: ' + image)
			assert  image.contains(currentProduct.getSku().toLowerCase())
		}
	}

	/**
	 * Verify miniCart items count match products count in miniCart
	 * @author Eng. Amal Hamad
	 */
	public static void verifyMiniCartItemsCount() {
		List<WebElement> cartProducts = WebUI.findWebElements(MiniCartItems.productTitle,GlobalVariable.elementVisibilityTimeOut)
		int summaryItemsCount = GeneralHelpers.convertStringToInteger(MiniCartItems.cartItemsCount)
		assert summaryItemsCount == cartProducts.size()
	}

	/**
	 * Verify summary shipping match expected shipping value
	 * @param expectedShipping
	 * @author Eng. Amal Hamad
	 */
	public static void verifyShipping(String expectedShipping) {
		assert WebUI.getText(MiniCartItems.shippingValue).contains(expectedShipping)
	}

	/**
	 * Verify miniCart total match products total in miniCart
	 * @author Eng. Amal Hamad
	 */
	public static String verifyMiniCartTotalMatchProductsTotal() {
		String expectedTotal = MiniCartHelpers.calculateMiniCartProductsTotal()
		assert WebUI.getText(MiniCartItems.totalValue).equals(expectedTotal)
		return expectedTotal
	}
}
