package helpers

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import models.Product

public class ProductRowHelper {

	public static Product saveProductRowData() {

		Product product = new Product()

		//----- Save href
		TestObject a_productUrl = findTestObject('Object Repository/scenario01/product_row/a_productUrl')

		product.setHref(WebUI.getAttribute(a_productUrl, 'href'))

		//----- Save title
		TestObject h2_productTitle = findTestObject('Object Repository/scenario01/product_row/h2_productTitle')

		product.setTitle(WebUI.getText(h2_productTitle))

		//----- Save image
		TestObject img_productImage = findTestObject('Object Repository/scenario01/product_row/img_productImage')

		product.setImage(WebUI.getAttribute(img_productImage, 'src'))

		//----- Save price
		List<WebElement> span_productPrice = WebUI.findWebElements(findTestObject('Object Repository/scenario01/product_row/span_productPrice'),
				5)

		TestObject minPrice = WebUI.convertWebElementToTestObject(span_productPrice.get(0))

		product.setMinPrice(GeneralHelpers.covertStringToInteger(minPrice))

		TestObject maxPrice = WebUI.convertWebElementToTestObject(span_productPrice.get(1))

		product.setMaxPrice(GeneralHelpers.covertStringToInteger(maxPrice))

		//----- Save price list
		List<WebElement> span_productListValue = WebUI.findWebElements(findTestObject('Object Repository/scenario01/product_row/span_productListValue'),
				5)

		TestObject minList = WebUI.convertWebElementToTestObject(span_productListValue.get(0))

		product.setMinList(GeneralHelpers.covertStringToInteger(minList))

		TestObject maxList = WebUI.convertWebElementToTestObject(span_productListValue.get(1))

		product.setMaxList(GeneralHelpers.covertStringToInteger(maxList))

		//----- Print product data
		System.out.println(product.toString())

		return product;
	}
}
