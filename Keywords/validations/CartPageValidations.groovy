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
		System.out.println('productTitleList: ' + productTitleList.size())

		for (int i = 0 ; i < productTitleList.size() ; i++) {
			Product currentProduct = cartProducts[i]
			System.out.println(currentProduct.toString())

			TestObject productTitle = WebUI.convertWebElementToTestObject(productTitleList.get(i))
			CartPageValidations.verifyHoverOverProductTitle(productTitle)
			System.out.println('productTitle: ' + WebUI.getText(productTitle))
			//			assert  WebUI.getText(productTitle).toLowerCase().contains(currentProduct.getTitle().toLowerCase())

			TestObject productSku = CartPageHelpers.getCartProductDataByIndex(i, CartPageActions.productSku)
			System.out.println('productSku: ' + WebUI.getText(productSku))
			assert  WebUI.getText(productSku).equals(currentProduct.getSku())

			TestObject productPrice = CartPageHelpers.getCartProductDataByIndex(i, CartPageActions.productPrice)
			String priceStr = WebUI.getAttribute(productPrice , 'innerText')
			System.out.println('productPrice: ' + priceStr)
			assert priceStr.trim().equals(GeneralHelpers.formatePrice(currentProduct.getPrice()))

			TestObject productTotal = CartPageHelpers.getCartProductDataByIndex(i, CartPageActions.productTotal)
			String totalStr = WebUI.getAttribute(productTotal , 'innerText')
			System.out.println('productTotal: ' + totalStr)
			double total = currentProduct.getPrice() * currentProduct.getQuantity()
			assert totalStr.trim().equals(GeneralHelpers.formatePrice(total))

			TestObject inputProductQty = CartPageHelpers.getCartProductDataByIndex(i, CartPageActions.inputProductQty)
			String quantity = WebUI.getAttribute(inputProductQty , 'value')
			System.out.println('inputProductQty: ' + quantity)
			assert quantity.equals(currentProduct.getQuantity() +"")

			TestObject divProductStock = CartPageHelpers.getCartProductDataByIndex(i, CartPageActions.divProductStock)
			String stock = WebUI.getText(divProductStock)
			System.out.println('divProductStock: ' + stock)
			assert stock.contains('In Stock!')

			TestObject productImage = CartPageHelpers.getCartProductDataByIndex(i, CartPageActions.productImage)
			String image = WebUI.getAttribute(productImage, "src")
			System.out.println('productImage: ' + image)
			assert  image.contains(currentProduct.getSku().toLowerCase())

		}
	}

	/**
	 * Verify hover over productTitle in cart row
	 * @param productTitle
	 * @author Eng. Amal Hamad
	 */
	public static void verifyHoverOverProductTitle(TestObject productTitle) {
		WebUI.mouseOver(productTitle)
		String textDecoration = WebUI.getCSSValue(productTitle, "text-decoration")
		System.out.println("hoverOverProductTitle: " + textDecoration)
		assert textDecoration.equals("underline solid rgb(0, 0, 0)")
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
//		CartPageValidations.verifySummaryTax(expectedTax)
		CartPageValidations.verifySummaryTotal()
//table[@class="order-summary__totals"]/tr/td[contains(text(),'Estimated Tax')]/following-sibling::td
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
	 * Verify summary tax match expected tax value
	 * @param expectedTax
	 * @author Eng. Amal Hamad
	 */
	public static void verifySummaryTax(String expectedTax) {
		TestObject testObject = findTestObject(CartPageActions.summaryTaxValue)
		assert WebUI.getText(testObject).equals(expectedTax)
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
	public static void verifyProductTotalAfterChangeQty(int index , Product product) {
		TestObject productTotal = CartPageHelpers.getCartProductDataByIndex(index , CartPageActions.productTotal)
		TestObject inputProductQty = CartPageHelpers.getCartProductDataByIndex(index , CartPageActions.inputProductQty)

		int currentQuantity = Integer.parseInt(WebUI.getAttribute(inputProductQty, "value"))
		product.setQuantity(currentQuantity)
		String expectedTotal = GeneralHelpers.formatePrice(product.getPrice() * currentQuantity)

		System.out.println("currentQuantity: " + currentQuantity + " #expectedTotal:" + expectedTotal)

		assert WebUI.getAttribute(productTotal , 'innerText').trim().equals(expectedTotal)
	}
}
