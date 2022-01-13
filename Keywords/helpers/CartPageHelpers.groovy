package helpers

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.CartPageActions
import internal.GlobalVariable

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
	
	public static TestObject getProductFiledBySku(Product product , String dataSelector) {
		String productSku = product.getSku()

		List<WebElement> productSkuList = WebUI.findWebElements(findTestObject(CartPageActions.productSku),GlobalVariable.elementVisibilityTimeOut)

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
