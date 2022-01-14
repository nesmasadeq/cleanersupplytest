package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.By
import org.openqa.selenium.Keys
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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.inspect.swingui.BytecodeCollector
import helpers.GeneralHelpers
import internal.GlobalVariable
import models.Product
import validations.GeneralValidations
import validations.QuickOrdersValidations

public class QuickActionActions {
	/**
	 * make hover over quick action button 
	 * 
	 * @author selenium
	 */
	public static void hoverOverQuickActionIcon() {
		WebUI.mouseOver(findTestObject('Object Repository/QuickAction/QuickActionIcon'))
	}

	/**
	 * click over quick action button 
	 * 
	 * @author selenium
	 */
	public static void clickOverQuickActionIcon() {
		WebUI.click(findTestObject('Object Repository/QuickAction/QuickActionIcon'))
	}

	/**
	 * type sku number in sku field 
	 * 
	 * @param element
	 * @param sku
	 * @author selenium
	 */
	public static void fillSKUNumber ( WebElement element ,String sku) {
		element.findElement(By.tagName("input")).sendKeys(sku)

		WebUI.waitForElementPresent(WebUI.convertWebElementToTestObject(element.findElement(By.cssSelector(".dropdown-menu.inner"))), GlobalVariable.elementVisibilityTimeOut)
		this.verifySKUExistInSearchList(element , sku)
	}

	public static void verifySKUExistInSearchList(WebElement element , String sku) {
		List<WebElement> options = element.findElements(By.cssSelector(".dropdown-menu.inner span.text"))
		def optionsText = []
		for (option in options) {
			optionsText.push(option.getText())
			if(option.getText().contentEquals(sku)) {
				option.click()
			}
		}
		if (! optionsText.contains(sku)) {
			options.get(0).click()
		}
		assert optionsText.contains(sku)
	}


	/**
	 * get product data 
	 * 
	 * @param element
	 * @return Product product
	 * @author selenium
	 */
	public static Product getProductInfo(WebElement element) {
		Product product = new Product()

		product.setSku(element.findElement(By.tagName("input")).getAttribute("value"))
		product.setTitle(element.findElement(By.className("product-title")).getText())
		product.setPrice( GeneralHelpers.convertStringToDouble(WebUI.convertWebElementToTestObject(element.findElement(By.cssSelector(".product-table__price .price-holder")))) )
		product.setTotalPrice( GeneralHelpers.convertStringToDouble(WebUI.convertWebElementToTestObject(element.findElement(By.cssSelector(".product-table__price .price-holder")))) )

		return product
	}

	/**
	 * type random quantity for products 
	 * 
	 * @param element
	 * @author selenium
	 */
	public static void typeRandomQuantity(WebElement element) {
		WebUI.waitForElementVisible(WebUI.convertWebElementToTestObject(element.findElements(By.cssSelector(".quantity-container input[name=\"quantity\"]")).get(0)),GlobalVariable.elementVisibilityTimeOut)
		WebElement quantityInput = element.findElements(By.cssSelector(".quantity-container input[name=\"quantity\"]")).get(0)

		quantityInput.sendKeys(Keys.CONTROL + "a")
		quantityInput.sendKeys(Keys.DELETE)

		quantityInput.sendKeys("" + (int )(Math.random() * 50 + 1))
	}
}
