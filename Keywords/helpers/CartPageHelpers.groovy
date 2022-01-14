package helpers

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.CartPageActions
import internal.GlobalVariable
import items.CartPageItems
import models.Product

public class CartPageHelpers {

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
		List<WebElement> productTotalList = WebUI.findWebElements(findTestObject(CartPageItems.productTotal),GlobalVariable.elementVisibilityTimeOut)
		double total = 0;
		for(WebElement element: productTotalList) {
			TestObject productTotal = WebUI.convertWebElementToTestObject(element)
			String textWithNumber = WebUI.getAttribute(productTotal , 'innerText').replaceAll("[^\\d.]", "")
			total +=  Double.parseDouble(textWithNumber)
		}
		return GeneralHelpers.formatePrice(total)
	}

	/**
	 * Calculate cart products total
	 * @return cartProductTotal
	 * @author Eng. Amal Hamad
	 */
	public static String calculateSummaryTotal() {
		List<WebElement> summaryValuesList = WebUI.findWebElements(findTestObject(CartPageItems.summaryValues),GlobalVariable.elementVisibilityTimeOut)

		double total = 0;
		for(int i = 0 ;  i < summaryValuesList.size()-1 ; i++) {
			TestObject productTotal = WebUI.convertWebElementToTestObject(summaryValuesList.get(i))
			String currentText = WebUI.getText(productTotal)
			System.out.println("currentText: " + currentText)
			if(currentText.contains(GlobalVariable.siteCurrency)) {
				total += GeneralHelpers.convertStringToDouble(productTotal)
			}
		}
		return GeneralHelpers.formatePrice(total)
	}

	/**
	 * Get product field by selector in Cart product row
	 * @param product
	 * @param dataSelector
	 * @return TestObject
	 * @author Eng. Amal Hamad
	 */
	public static TestObject getCartProductDataBySku(Product product , String dataSelector) {
		String productSku = product.getSku()

		List<WebElement> productSkuList = WebUI.findWebElements(findTestObject(CartPageItems.productSku),GlobalVariable.elementVisibilityTimeOut)

		for (int i = 0 ; i < productSkuList.size() ; i++) {
			TestObject productSkuTestObject = WebUI.convertWebElementToTestObject(productSkuList.get(i))
			String currentSku = WebUI.getText(productSkuTestObject)
			if(currentSku.equals(productSku)) {
				TestObject testObject = CartPageHelpers.getCartProductDataByIndex(i , dataSelector)
				return testObject
			}
		}
	}
}
