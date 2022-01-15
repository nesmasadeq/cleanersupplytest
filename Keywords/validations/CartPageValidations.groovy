package validations

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.CartPageActions
import helpers.CartPageHelpers
import helpers.GeneralHelpers
import internal.GlobalVariable
import items.CartPageItems
import models.Product

public class CartPageValidations {

	/**
	 * Verify product data in cart is correct
	 * @param expected cartProducts 
	 * @author Eng. Amal Hamad
	 */
	public static void verifyCartProductsData(Product... cartProducts) {
		List<WebElement> productTitleList = WebUI.findWebElements(CartPageItems.productTitle,GlobalVariable.elementVisibilityTimeOut)
		System.out.println('productTitleList: ' + productTitleList.size())

		for (int i = 0 ; i < productTitleList.size() ; i++) {
			Product currentProduct = cartProducts[i]
			System.out.println(currentProduct.toString())

			TestObject productTitle = WebUI.convertWebElementToTestObject(productTitleList.get(i))
			GeneralValidations.verifyLinkUnderlineHover(productTitle)
			System.out.println('productTitle: ' + WebUI.getText(productTitle))
			assert  WebUI.getText(productTitle).contains(currentProduct.getTitle())

			TestObject productSku = CartPageHelpers.getCartProductDataByIndex(i, CartPageItems.productSku)
			System.out.println('productSku: ' + WebUI.getText(productSku))
			assert  WebUI.getText(productSku).equals(currentProduct.getSku())

			TestObject productPrice = CartPageHelpers.getCartProductDataByIndex(i, CartPageItems.productPrice)
			String priceStr = GeneralHelpers.getFieldInnerText(productPrice)
			System.out.println('productPrice: ' + priceStr)
			assert priceStr.trim().equals(GeneralHelpers.formatePrice(currentProduct.getPrice()))

			TestObject productTotal = CartPageHelpers.getCartProductDataByIndex(i, CartPageItems.productTotal)
			String totalStr = GeneralHelpers.getFieldInnerText(productTotal)
			System.out.println('productTotal: ' + totalStr)
			double total = currentProduct.getPrice() * currentProduct.getQuantity()
			assert totalStr.trim().equals(GeneralHelpers.formatePrice(total))

			TestObject inputProductQty = CartPageHelpers.getCartProductDataByIndex(i, CartPageItems.inputProductQty)
			String quantity = GeneralHelpers.getFieldInputValue(inputProductQty)
			System.out.println('inputProductQty: ' + quantity)
			assert quantity.equals(currentProduct.getQuantity() +"")

			TestObject divProductStock = CartPageHelpers.getCartProductDataByIndex(i, CartPageItems.divProductStock)
			String stock = WebUI.getText(divProductStock)
			System.out.println('divProductStock: ' + stock)
			assert stock.contains('In Stock!')

			TestObject productImage = CartPageHelpers.getCartProductDataByIndex(i, CartPageItems.productImage)
			String image = GeneralHelpers.getImageSrc(productImage)
			System.out.println('productImage: ' + image)
			assert  image.contains(currentProduct.getSku().toLowerCase())
		}
	}

	/**
	 * Verify Cart Summary
	 * @param expectedShipping
	 * @author Eng. Amal Hamad
	 */
	public static void verifyCartSummary(boolean isCartExist , String expectedShipping,String expectedTax) {
		CartPageValidations.verifySummaryItemCount()
		CartPageValidations.verifySummarySubTotalMatchCartProductsTotal()
		if(isCartExist) {
			CartPageValidations.verifySummarySubTotalMatchMiniCartLabel()
		}
		CartPageValidations.verifySummaryShipping(expectedShipping)
		CartPageValidations.verifySummaryTax(expectedTax)
		CartPageValidations.verifySummaryTotal()
	}

	/**
	 * Verify summary items count match products count in cart
	 * @author Eng. Amal Hamad
	 */
	public static void verifySummaryItemCount() {
		List<WebElement> cartProducts = WebUI.findWebElements(CartPageItems.productTitle,GlobalVariable.elementVisibilityTimeOut)
		int summaryItemsCount = GeneralHelpers.convertStringToInteger(CartPageItems.summarySubtotalLabel)
		assert summaryItemsCount == cartProducts.size()
	}

	/**
	 * Verify summary subTotal match products total in cart
	 * @author Eng. Amal Hamad
	 */
	public static void verifySummarySubTotalMatchCartProductsTotal() {
		String expectedTotal = CartPageHelpers.calculateCartProductsTotal()
		assert WebUI.getText(CartPageItems.summarySubtotalValue).equals(expectedTotal)
	}

	/**
	 * Verify summary subTotal match label in MiniCart in header
	 * @author Eng. Amal Hamad
	 */
	public static void verifySummarySubTotalMatchMiniCartLabel() {
		String summaryTotal = WebUI.getText(CartPageItems.summarySubtotalValue)
		HeaderValidations.verifyCartLabel(summaryTotal)
	}

	/**
	 * Verify summary shipping match expected shipping value
	 * @param expectedShipping
	 * @author Eng. Amal Hamad
	 */
	public static void verifySummaryShipping(String expectedShipping) {
		assert WebUI.getText(CartPageItems.summaryShippingValue).equals(expectedShipping)
	}

	/**
	 * Verify summary tax match expected tax value
	 * @param expectedTax
	 * @author Eng. Amal Hamad
	 */
	public static void verifySummaryTax(String expectedTax) {
		assert WebUI.getText(CartPageItems.summaryTaxValue).equals(expectedTax)
	}

	/**
	 * Verify summary total match expected total
	 * @author Eng. Amal Hamad
	 */
	public static void verifySummaryTotal() {
		String expectedTotal = CartPageHelpers.calculateSummaryTotal()
		assert WebUI.getText(CartPageItems.summaryTotalValue).equals(expectedTotal)
	}

	/**
	 * Verify product total after change its quantity
	 * @param product
	 * @author Eng. Amal Hamad
	 */
	public static void verifyProductTotalAfterChangeQty(int index , Product product) {
		TestObject productTotal = CartPageHelpers.getCartProductDataByIndex(index , CartPageItems.productTotal)
		TestObject inputProductQty = CartPageHelpers.getCartProductDataByIndex(index , CartPageItems.inputProductQty)

		int currentQuantity = Integer.parseInt(WebUI.getAttribute(inputProductQty, "value"))
		product.setQuantity(currentQuantity)
		String expectedTotal = GeneralHelpers.formatePrice(product.getPrice() * currentQuantity)

		System.out.println("currentQuantity: " + currentQuantity + " #expectedTotal:" + expectedTotal)

		assert WebUI.getAttribute(productTotal , 'innerText').trim().equals(expectedTotal)
	}

	/**
	 * Verify product estimation delivery date match expected date
	 * @author Eng. Amal Hamad
	 */
	public static void verifyEstimationDeliveryDate() {
		List<WebElement> estDeliveryList = WebUI.findWebElements(CartPageItems.estDelivery,GlobalVariable.elementVisibilityTimeOut)
		System.out.println('estDeliveryList: ' + estDeliveryList.size())
		for (int i = 0 ; i < estDeliveryList.size() ; i++) {
			WebElement element = estDeliveryList.get(i)
			assert element.getText().concat("Est Delivery Tuesday, Jan 18")
		}
	}
}
