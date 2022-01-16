package actions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import helpers.GeneralHelpers
import internal.GlobalVariable
import models.Product

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
		element.findElement(By.tagName("input")).sendKeys(Keys.TAB)

		WebUI.waitForElementPresent(WebUI.convertWebElementToTestObject(element.findElement(By.cssSelector(".dropdown-menu.inner"))), GlobalVariable.elementVisibilityTimeOut)

		//		this.verifySKUExistInSearchList(element , sku)
	}

	/**
	 * verify SKU exist in search list and handle if that have bug
	 * 
	 * @param element
	 * @param sku
	 */
	public static void verifySKUExistInSearchList(WebElement element , String sku) {
		List<WebElement> options = element.findElements(By.cssSelector(".dropdown-menu.inner span.text"))
		def optionsText = []
		for (option in options) {
			optionsText.push(option.getText())
			if(option.getText().contentEquals(sku)) {
				option.click()
			}
		}
		if (! optionsText.contains(sku) && options.size() > 0) {

			//			options.get(2).click()

		}
		//		assert optionsText.contains(sku)
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
		product.setQuantity(element.findElements(By.cssSelector(".quantity-container input[name=\"quantity\"]")).get(0).getAttribute("value").toInteger());
		return product
	}

	/**
	 * type random quantity for products 
	 * 
	 * @param element
	 * @author selenium
	 */
	public static void typeRandomQuantity(WebElement element) {
		WebElement quantityInput = element.findElements(By.cssSelector(".quantity-container input[name=\"quantity\"]")).get(0)

		quantityInput.sendKeys(Keys.CONTROL + "a")
		quantityInput.sendKeys(Keys.DELETE)

		quantityInput.sendKeys("" + (int )(Math.random() * 50 + 1))

		quantityInput.sendKeys(Keys.TAB)
	}
}
