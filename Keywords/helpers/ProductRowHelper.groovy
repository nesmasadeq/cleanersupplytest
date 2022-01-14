package helpers

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import items.ProductRowItems
import models.Product

public class ProductRowHelper {

	/***
	 * save product data form search result in to product object
	 * @return product
	 * @author Eng. Amal Hamad
	 * @author nesma
	 */
	public static Product saveProductRowData(TestObject productUrl) {

		Product product = new Product()

		//----- Save href
		//		TestObject a_productUrl = findTestObject('ProductRow/a_productUrl')

		product.setHref(WebUI.getAttribute(productUrl, 'href'))

		//----- Save title
		TestObject h2_productTitle = findTestObject(ProductRowItems.productTitle)

		product.setTitle(WebUI.getText(h2_productTitle))

		//----- Save image
		TestObject img_productImage = findTestObject(ProductRowItems.productImage)

		product.setImage(WebUI.getAttribute(img_productImage, 'src'))

		//----- Save price
		List<WebElement> span_productPrice = WebUI.findWebElements(findTestObject(ProductRowItems.productPrice),GlobalVariable.elementVisibilityTimeOut)

		TestObject minPrice = WebUI.convertWebElementToTestObject(span_productPrice.get(0))

		product.setMinPrice(GeneralHelpers.convertStringToDouble(minPrice))

		TestObject maxPrice = WebUI.convertWebElementToTestObject(span_productPrice.get(1))

		product.setMaxPrice(GeneralHelpers.convertStringToDouble(maxPrice))

		//----- Save price list
		List<WebElement> span_productListValue = WebUI.findWebElements(findTestObject(ProductRowItems.productListValue),GlobalVariable.elementVisibilityTimeOut)

		TestObject minList = WebUI.convertWebElementToTestObject(span_productListValue.get(0))

		product.setMinList(GeneralHelpers.convertStringToDouble(minList))

		//check if price list is in range or has one value
		if(span_productListValue.size()>1) {
			TestObject maxList = WebUI.convertWebElementToTestObject(span_productListValue.get(1))
			product.setMaxList(GeneralHelpers.convertStringToInteger(maxList))
		}
		//----- Print product data
		System.out.println(product.toString())

		return product;
	}
}
