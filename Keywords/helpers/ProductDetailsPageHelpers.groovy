package helpers

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.ProductDetailsPageActions
import internal.GlobalVariable
import items.ProductDetailsPageItems

public class ProductDetailsPageHelpers {

	/**
	 * Get dimensions in selected size
	 * @param selector
	 * @return String dimensions
	 * @author Eng. Amal Hamad
	 */
	public static String getSizeDimensions(String selector) {
		TestObject testObject = findTestObject(selector)
		System.out.println("getSizeDimensions: " + WebUI.getText(testObject))
		String[] split = WebUI.getText(testObject).split(" - ")
		if (split.length > 0) {
			return split[1]
		}else {
			return ""
		}
	}

	/**
	 * 
	 * @param currentQuantity
	 * @return
	 * @author Eng. Amal Hamad
	 */
	public static double getProductPriceByQuantity(int currentQuantity) {
		List<WebElement> volumeTableQty = WebUI.findWebElements(findTestObject(ProductDetailsPageItems.div_volumeTableQty),
				GlobalVariable.elementVisibilityTimeOut)
		List<WebElement> volumeTablePrice = WebUI.findWebElements(findTestObject(ProductDetailsPageItems.div_volumeTablePrice),
				GlobalVariable.elementVisibilityTimeOut)

		System.out.println('volumeTableQty: ' + volumeTableQty.size() +' ## volumeTablePrice: ' + volumeTablePrice.size())

		for(int i = volumeTableQty.size()-1 ; i >= 0 ; i--) {

			TestObject quantityObject = WebUI.convertWebElementToTestObject(volumeTableQty.get(i))

			int volumeQuantity = GeneralHelpers.convertStringToInteger(quantityObject)
			System.out.println("volumeQuantity: " + volumeQuantity)

			if( currentQuantity >= volumeQuantity ) {
				//Get product price form Volume Pricing Table
				TestObject priceObject = WebUI.convertWebElementToTestObject(volumeTablePrice.get(i))
				double price = GeneralHelpers.convertStringToDouble(priceObject)
				return price
			}
		}
	}
}
