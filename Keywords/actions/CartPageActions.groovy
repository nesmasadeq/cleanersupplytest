package actions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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
	 * Get cart product specific data by product index in cart list
	 * @param dataSelector
	 * @return TestObject
	 * @author Eng. Amal Hamad
	 */
	public static TestObject getCartProductDataByIndex(int index ,String dataSelector) {
		List<WebElement> data = WebUI.findWebElements(findTestObject(dataSelector),GlobalVariable.elementVisibilityTimeOut)
		TestObject object = WebUI.convertWebElementToTestObject(data.get(index))
		return object
	}

	/**
	 * Calculate cart products total
	 * @return cartProductTotal
	 * @author Eng. Amal Hamad
	 */
	public static String calculateCartProductsTotal() {
		List<WebElement> productTotalList = WebUI.findWebElements(findTestObject(CartPageActions.productTotal),GlobalVariable.elementVisibilityTimeOut)
		double total = 0;
		for(WebElement element: productTotalList) {
			TestObject productTotal = WebUI.convertWebElementToTestObject(element)
			total += GeneralHelpers.convertStringToDouble(productTotal)
		}
		return GeneralHelpers.formatePrice(total)
	}

	/**
	 * Calculate cart products total
	 * @return cartProductTotal
	 * @author Eng. Amal Hamad
	 */
	public static String calculateSummaryTotal() {
		List<WebElement> summaryValuesList = WebUI.findWebElements(findTestObject(CartPageActions.summaryValues),GlobalVariable.elementVisibilityTimeOut)
		double total = 0;
		for(WebElement element: summaryValuesList) {
			TestObject productTotal = WebUI.convertWebElementToTestObject(element)
			if(WebUI.getText(productTotal).contains("[0-9]+")) {
				total += GeneralHelpers.convertStringToDouble(productTotal)
			}
		}
		return GeneralHelpers.formatePrice(total)
	}

	/**
	 * Click on "+" button for this product index
	 * @param product
	 * @author Eng. Amal Hamad
	 */
	public static void clickPlusQtyButton(Product product) {
		TestObject btnPlus = CartPageActions.getProductFiledBySku(product , CartPageActions.btnPlusQuantity)
		WebUI.click(btnPlus)
	}

	/**
	 * Click on "-" button for this product index
	 * @param product
	 * @author Eng. Amal Hamad
	 */
	public static void clickMinusQtyButton(Product product) {
		TestObject btnMinus = CartPageActions.getProductFiledBySku(product , CartPageActions.btnMinusQuantity)
		WebUI.click(btnMinus)
	}

	public static TestObject getProductFiledBySku(Product product , String dataSelector) {
		String productSku = product.getSku()

		List<WebElement> productSkuList = WebUI.findWebElements(findTestObject(CartPageActions.productSku),GlobalVariable.elementVisibilityTimeOut)

		for (int i = 0 ; i < productSkuList.size() ; i++) {
			TestObject productSkuTestObject = WebUI.convertWebElementToTestObject(productSkuList.get(i))
			String currentSku = WebUI.getText(productSkuTestObject)
			if(currentSku.equals(productSku)) {
				TestObject testObject = CartPageActions.getCartProductDataByIndex(i , dataSelector)
				return testObject
			}
		}
	}

}
