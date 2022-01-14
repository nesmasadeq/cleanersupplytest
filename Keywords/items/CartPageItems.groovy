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

public class CartPageItems {

	//----------- Product Data
	public static TestObject productTitle =  findTestObject('Object Repository/CartPage/a_productTitle')
	public static TestObject productSku =  findTestObject('Object Repository/CartPage/span_productSku')
	public static TestObject productImage =  findTestObject('Object Repository/CartPage/img_productImage')
	public static TestObject productPrice =  findTestObject('Object Repository/CartPage/td_productPrice')
	//	public static TestObject productListValue =  findTestObject('Object Repository/ProductDetailsPage/span_productListPrice')
	public static TestObject productTotal =  findTestObject('Object Repository/CartPage/td_productTotal')
	//-----------  Cart Buttons
	public static TestObject divProductStock =  findTestObject('Object Repository/CartPage/div_productStock')
	public static TestObject inputProductQty =  findTestObject('Object Repository/CartPage/input_productQuantity')
	public static TestObject btnPlusQuantity =  findTestObject('Object Repository/CartPage/button_plusQuantity')
	public static TestObject btnMinusQuantity =  findTestObject('Object Repository/CartPage/button_minusQuantity')

	//----------- Cart Summary
	public static TestObject summaryValues =  findTestObject('Object Repository/CartPage/td_summaryValues')
	public static TestObject summarySubtotalLabel = findTestObject( 'Object Repository/CartPage/td_summarySubtotalLabel')
	public static TestObject summarySubtotalValue =  findTestObject('Object Repository/CartPage/td_summarySubtotalValue')
	public static TestObject summaryShippingValue = findTestObject( 'Object Repository/CartPage/td_summaryShippingValue')
	public static TestObject summaryTaxValue = findTestObject( 'Object Repository/CartPage/td_summaryTaxValue')
	public static TestObject summaryTotalValue =  findTestObject('Object Repository/CartPage/td_summaryTotalValue')
	//----------- Checkout
	public static TestObject buttonProceedToCheckout = findTestObject( 'Object Repository/CartPage/button_proceedToCheckout')

}
