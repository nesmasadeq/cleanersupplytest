package helpers

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import items.MiniCartItems
import models.AppConstants
import models.Product
import validations.MiniCartValidations


public class MiniCartHelpers {

	/**
	 * Verify MiniCar products data and total
	 * @param cartProducts
	 * @author Eng. Amal Hamad
	 */
	public static void verifyMiniCart(Product... cartProducts) {
		MiniCartValidations.verifyMiniCartHover()
		MiniCartValidations.verifyMiniCartProductsData(cartProducts)
		MiniCartValidations.verifyMiniCartItemsCount()

		double cartTotal = GeneralHelpers.convertStringToDouble(MiniCartItems.totalValue)
		if(cartTotal < 99) {
			double remaining  = (99 - cartTotal)
			MiniCartValidations.verifyShipping('ONLY ' + GeneralHelpers.formatePrice(remaining) + ' MORE FOR FREE SHIPPING')
		}else {
			MiniCartValidations.verifyShipping(AppConstants.SHIPPING_FREE)
		}
	}

	/**
	 * Calculate mini cart products total
	 * @return cartProductTotal
	 * @author Eng. Amal Hamad
	 */
	public static String calculateMiniCartProductsTotal() {
		List<WebElement> productTotalList = WebUI.findWebElements(MiniCartItems.productTotal,GlobalVariable.elementVisibilityTimeOut)
		double total = 0;
		for(WebElement element: productTotalList) {
			TestObject productTotal = WebUI.convertWebElementToTestObject(element)
			String textWithNumber = GeneralHelpers.getFieldInnerText(productTotal).replaceAll("[^\\d.]", "")
			total +=  Double.parseDouble(textWithNumber)
		}
		return GeneralHelpers.formatePrice(total)
	}
}
