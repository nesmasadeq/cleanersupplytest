package items

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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

public class MiniCartItems {

	//----------- MiniCart
	public static TestObject miniCart =  findTestObject('Object Repository/MiniCart/a_miniCart')
	public static TestObject miniCartHolder =  findTestObject('Object Repository/MiniCart/li_miniCartHolder')
	
	//----------- Product Data
	public static TestObject productTitle =  findTestObject('Object Repository/MiniCart/a_productTitle')
	public static TestObject productSku =  findTestObject('Object Repository/MiniCart/span_productSku')
	public static TestObject productQty =  findTestObject('Object Repository/MiniCart/td_productQty')
	public static TestObject productImage =  findTestObject('Object Repository/MiniCart/img_productImage')
	public static TestObject productPrice =  findTestObject('Object Repository/MiniCart/span_productPrice')
	public static TestObject productTotal =  findTestObject('Object Repository/MiniCart/td_productTotal')

	//----------- Cart Total
	public static TestObject cartItemsCount = findTestObject('Object Repository/MiniCart/span_cartItemsCount')
	public static TestObject shippingValue = findTestObject('Object Repository/MiniCart/span_shipping')
	public static TestObject totalValue =  findTestObject('Object Repository/MiniCart/span_cartTotal')

}
