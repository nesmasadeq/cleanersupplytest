package helpers

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.SearchResultsPageActions
import internal.GlobalVariable
import items.SearchResultsPageItems
import models.Product
import validations.GeneralValidations
import validations.SearchResultsPageValidations

public class SearchResultsPageHelpers {

	/**
	 * Click on first product in search results
	 * @author Eng. Amal Hamad
	 */
	public static void clickSearchProduct() {
		SearchResultsPageValidations.verifyButtonShadowHover(SearchResultsPageItems.firstProductRow)
		SearchResultsPageActions.clickSearchProduct()
	}

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

		product.setHref(GeneralHelpers.getFieldHref(productUrl))

		//----- Save title

		product.setTitle(WebUI.getText(SearchResultsPageItems.productTitle))

		//----- Save image
		product.setImage(GeneralHelpers.getImageSrc(SearchResultsPageItems.productImage))

		//----- Save price
		List<WebElement> span_productPrice = WebUI.findWebElements(SearchResultsPageItems.productPrice,GlobalVariable.elementVisibilityTimeOut)

		TestObject minPrice = WebUI.convertWebElementToTestObject(span_productPrice.get(0))

		product.setMinPrice(GeneralHelpers.convertStringToDouble(minPrice))

		TestObject maxPrice = WebUI.convertWebElementToTestObject(span_productPrice.get(1))

		product.setMaxPrice(GeneralHelpers.convertStringToDouble(maxPrice))

		//----- Save price list
		List<WebElement> span_productListValue = WebUI.findWebElements(SearchResultsPageItems.productListValue,GlobalVariable.elementVisibilityTimeOut)

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
