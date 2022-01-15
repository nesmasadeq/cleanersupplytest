package validations

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.By
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

public class QuickOrdersValidations {

	/**
	 * verify quick order active when hover 
	 * 
	 * @author selenium
	 */
	public static void verifyOnActiveIcon() {
		assert WebUI.getAttribute(findTestObject('Object Repository/QuickAction/QuickActionIcon'), "class").contains("icon-quick-order")
	}

	/**
	 * verify quick order tab 
	 * 
	 * @author selenium
	 */
	public static void verifyQuickOrderTabText() {
		assert WebUI.getText(findTestObject('Object Repository/QuickAction/QuicOrderTab')).contains("QUICK\nORDER")
	}

	/**
	 * verify default count of quick orders 
	 * 
	 * @author selenium
	 */
	public static void verifyDefaultQuickItemsCount() {
		List<WebElement> quickOrders = WebUI.findWebElements(findTestObject('Object Repository/QuickAction/QuickOrders') , GlobalVariable.elementVisibilityTimeOut)

		assert quickOrders.size().equals(5)
	}

	/**
	 * verify add more button present in page 
	 * 
	 * @author selenium
	 */
	public static void verifyAddMoreButtonExist() {
		assert WebUI.verifyElementPresent(findTestObject('Object Repository/QuickAction/AddMoreOrders'), GlobalVariable.elementVisibilityTimeOut)
	}

	/**
	 * verify SKU input in all orders and that contains default placeholder
	 * 
	 * @author selenium
	 */
	public static void verifySKUFieldInEveryOrder() {
		List<WebElement> quickOrders = WebUI.findWebElements(findTestObject('Object Repository/QuickAction/QuickOrders') , GlobalVariable.elementVisibilityTimeOut)

		for(WebElement order in quickOrders) {
			assert WebUI.verifyElementPresent(WebUI.convertWebElementToTestObject(order.findElement(By.tagName("input"))) , GlobalVariable.elementVisibilityTimeOut)
			assert WebUI.getAttribute(WebUI.convertWebElementToTestObject(order.findElement(By.tagName("input"))) , "placeholder").contains("Enter Stock #")
		}
	}

	/**
	 * verify remove button is appeared 
	 * 
	 * @param element
	 * @author selenium
	 */
	public static void verifyRemoveButton(WebElement element) {
		assert WebUI.verifyElementPresent(WebUI.convertWebElementToTestObject(element.findElement(By.className("product-table__button"))), GlobalVariable.elementVisibilityTimeOut)
	}

	/**
	 * verify menu appeared 
	 * 
	 * @param element
	 * @author selenium
	 */
	public static void verifySearchMenuPresent(WebElement element) {
		WebUI.waitForElementPresent(WebUI.convertWebElementToTestObject(element.findElement(By.cssSelector(".dropdown-menu.open"))),  GlobalVariable.elementVisibilityTimeOut)
		assert WebUI.verifyElementPresent(WebUI.convertWebElementToTestObject(element.findElement(By.cssSelector(".dropdown-menu.open"))), GlobalVariable.elementVisibilityTimeOut)
	}

	/**
	 * verify product available in stock
	 * 
	 * @param element
	 * @author selenium
	 */
	public static void verifyProductAvailableInStock(WebElement element) {
		assert element.findElement(By.cssSelector(".in-stock")).isDisplayed()
	}

	/**
	 * verify quantity of product is valid 
	 * 
	 * @param WebElement
	 */
	public static void verifyQuintityOfProductIsValid(WebElement element) {
		assert !element.findElement(By.cssSelector(".validation-error")).isDisplayed();
	}

	/**
	 * verify default value of quantity 
	 * 
	 * @param element
	 * @author selenium
	 */
	public static void verifyDefaulQuantity(WebElement element) {
		WebUI.waitForElementPresent(WebUI.convertWebElementToTestObject(element.findElements(By.cssSelector(".quantity-container input[name=\"quantity\"]")).get(0)),GlobalVariable.elementVisibilityTimeOut)

		assert element.findElements(By.cssSelector(".quantity-container input[name=\"quantity\"]")).get(0).getAttribute("value").contentEquals("1")
	}
}
