package validations

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.CartPageActions
import helpers.CartPageHelpers
import helpers.GeneralHelpers
import internal.GlobalVariable
import models.Product

public class CartPageValidations {

	/**
	 * Verify product data in cart is correct
	 * @param expected cartProducts 
	 * @author Eng. Amal Hamad
	 */
	public static void verifyCartProductsData(Product... cartProducts) {
		List<WebElement> productTitleList = WebUI.findWebElements(findTestObject(CartPageActions.productTitle),GlobalVariable.elementVisibilityTimeOut)
		//		List<WebElement> productSku = WebUI.findWebElements(findTestObject(CartPageActions.productSku),GlobalVariable.elementVisibilityTimeOut)
		//		List<WebElement> productPrice = WebUI.findWebElements(findTestObject(CartPageActions.productPrice),GlobalVariable.elementVisibilityTimeOut)
		//		List<WebElement> productTotal = WebUI.findWebElements(findTestObject(CartPageActions.productTotal),GlobalVariable.elementVisibilityTimeOut)
		//		List<WebElement> inputProductQty = WebUI.findWebElements(findTestObject(CartPageActions.inputProductQty),GlobalVariable.elementVisibilityTimeOut)
		//		List<WebElement> btnPlusQuantity = WebUI.findWebElements(findTestObject(CartPageActions.btnPlusQuantity),GlobalVariable.elementVisibilityTimeOut)
		//		List<WebElement> btnMinusQuantity = WebUI.findWebElements(findTestObject(CartPageActions.btnMinusQuantity),GlobalVariable.elementVisibilityTimeOut)

		System.out.println('productTitleList: ' + productTitleList.size())

		for (int i = 0 ; i < productTitleList.size() ; i++) {
			Product currentProduct = cartProducts[i]
			System.out.println(currentProduct.toString())

			TestObject productTitle = WebUI.convertWebElementToTestObject(productTitleList.get(i))
			System.out.println('productTitle: ' + WebUI.getText(productTitle))
			//			assert  WebUI.getText(productTitle).toLowerCase().contains(currentProduct.getTitle().toLowerCase())

			TestObject productSku = CartPageActions.getCartProductDataByIndex(i, CartPageActions.productSku)
			System.out.println('productSku: ' + WebUI.getText(productSku))
			assert  WebUI.getText(productSku).equals(currentProduct.getSku())

			TestObject productPrice = CartPageActions.getCartProductDataByIndex(i, CartPageActions.productPrice)
			System.out.println('productPrice: ' + WebUI.getText(productPrice))
			assert  WebUI.getText(productPrice).equals(GeneralHelpers.formatePrice(currentProduct.getPrice()))

			TestObject productTotal = CartPageActions.getCartProductDataByIndex(i, CartPageActions.productTotal)
			System.out.println('productTotal: ' + WebUI.getText(productTotal))
			double total = currentProduct.getPrice() * currentProduct.getQuantity()
			assert  WebUI.getText(productTotal).equals(GeneralHelpers.formatePrice(total))

			TestObject inputProductQty = CartPageActions.getCartProductDataByIndex(i, CartPageActions.inputProductQty)
			System.out.println('inputProductQty: ' + WebUI.getAttribute(inputProductQty, "value"))
			assert  WebUI.getAttribute(inputProductQty ,"value").equals( currentProduct.getQuantity() +"")
		}
	}

	/**
	 * Verify Cart Summary
	 * @param expectedShipping
	 * @author Eng. Amal Hamad
	 */
	public static void verifyCartSummary(String expectedShipping) {
		CartPageValidations.verifySummaryItemCount()
		CartPageValidations.verifySummarySubTotalMatchCartProductsTotal()
		CartPageValidations.verifySummarySubTotalMatchMiniCartLabel()
		CartPageValidations.verifySummaryShipping(expectedShipping)
		//		CartPageValidations.verifySummaryTotal()
	}

	/**
	 * Verify summary items count match products count in cart
	 * @author Eng. Amal Hamad
	 */
	public static void verifySummaryItemCount() {
		List<WebElement> cartProducts = WebUI.findWebElements(findTestObject(CartPageActions.productTitle),GlobalVariable.elementVisibilityTimeOut)
		TestObject testObject = findTestObject(CartPageActions.summarySubtotalLabel)
		int summaryItemsCount = GeneralHelpers.convertStringToInteger(testObject)
		assert summaryItemsCount == cartProducts.size()
	}

	/**
	 * Verify summary subTotal match products total in cart
	 * @author Eng. Amal Hamad
	 */
	public static void verifySummarySubTotalMatchCartProductsTotal() {
		String expectedTotal = CartPageHelpers.calculateCartProductsTotal()
		TestObject testObject = findTestObject(CartPageActions.summarySubtotalValue)
		assert WebUI.getText(testObject).equals(expectedTotal)
	}

	/**
	 * Verify summary subTotal match label in MiniCart in header
	 * @author Eng. Amal Hamad
	 */
	public static void verifySummarySubTotalMatchMiniCartLabel() {
		TestObject testObject = findTestObject(CartPageActions.summarySubtotalValue)
		String summaryTotal = WebUI.getText(testObject)
		HeaderValidations.verifyCartLabel(summaryTotal)
	}

	/**
	 * Verify summary shipping match expected shipping value
	 * @param expectedShipping
	 * @author Eng. Amal Hamad
	 */
	public static void verifySummaryShipping(String expectedShipping) {
		TestObject testObject = findTestObject(CartPageActions.summaryShippingValue)
		assert WebUI.getText(testObject).equals(expectedShipping)
	}

	/**
	 * Verify summary total match expected total
	 * @author Eng. Amal Hamad
	 */
	public static void verifySummaryTotal() {
		String expectedTotal = CartPageHelpers.calculateSummaryTotal()
		TestObject testObject = findTestObject(CartPageActions.summaryTotalValue)
		assert WebUI.getText(testObject).equals(expectedTotal)
	}

	/**
	 * Verify product total after change its quantity
	 * @param product
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductTotalAfterChangeQty(Product product) {
		TestObject productTotal = CartPageHelpers.getProductFiledBySku(product , CartPageActions.productTotal)
		TestObject inputProductQty = CartPageHelpers.getProductFiledBySku(product , CartPageActions.inputProductQty)

		int currentQuantity = Integer.parseInt(WebUI.getAttribute(inputProductQty, "value"))
		String expectedTotal = GeneralHelpers.formatePrice(product.getPrice() * currentQuantity)

		System.out.println("currentQuantity: " + currentQuantity + " #expectedTotal:" + expectedTotal)

		assert WebUI.getText(productTotal).equals(expectedTotal)
	}

}
