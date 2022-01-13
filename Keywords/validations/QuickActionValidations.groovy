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

public class QuickActionValidations {

	/**
	 * verify quick action active when hover 
	 * 
	 * @author selenium
	 */
	public static void verifyOnActiveIcon() {
		assert WebUI.getAttribute(findTestObject('Object Repository/QuickAction/QuickActionIcon'), "class").contains("icon-quick-order")
	}

	/**
	 * verify quick action tab 
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
}
