package helpers

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

import actions.QuickActionActions
import internal.GlobalVariable
import models.Product
import validations.QuickOrdersValidations

public class QuickActionsHelper {

	public static List<Product> fillOrders() {
		List bulkSKUOrders = GlobalVariable.bulk_SKU_orders
		List<Product> products = new ArrayList()
		List<WebElement> orders = WebUI.findWebElements(findTestObject('Object Repository/QuickAction/QuickOrders') , GlobalVariable.elementVisibilityTimeOut);

		for(int i = 0 ; i < orders.size() ; i++) {
			WebElement orderRow = orders[i]
			QuickActionActions.fillSKUNumber(orderRow, bulkSKUOrders[i])

			QuickActionActions.typeRandomQuantity(orderRow)

			QuickOrdersValidations.verifyRemoveButton(orderRow)

			QuickOrdersValidations.verifyProductAvailableInStock(orderRow)

			QuickOrdersValidations.verifyQuintityOfProductIsValid(orderRow)

//									Product product = QuickActionActions.getProductInfo(orderRow)
			products.push(QuickActionActions.getProductInfo(orderRow))
		}

		return products
	}
}
