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
	public static String productTitle = 'Object Repository/CartPage/a_productTitle'
	public static String productSku = 'Object Repository/CartPage/span_productSku'
	public static String productImage = 'Object Repository/CartPage/img_productImage'
	public static String productPrice = 'Object Repository/CartPage/td_productPrice'
	//	public static String productListValue = 'Object Repository/ProductDetailsPage/span_productListPrice'
	public static String productTotal = 'Object Repository/CartPage/td_productTotal'
	//-----------  Cart Buttons
	public static String divProductStock = 'Object Repository/CartPage/div_productStock'
	public static String inputProductQty = 'Object Repository/CartPage/input_productQuantity'
	public static String btnPlusQuantity = 'Object Repository/CartPage/button_plusQuantity'
	public static String btnMinusQuantity = 'Object Repository/CartPage/button_minusQuantity'

	//----------- Cart Summary
	public static String summaryValues = 'Object Repository/CartPage/td_summaryValues'
	public static String summarySubtotalLabel = 'Object Repository/CartPage/td_summarySubtotalLabel'
	public static String summarySubtotalValue = 'Object Repository/CartPage/td_summarySubtotalValue'
	public static String summaryShippingValue = 'Object Repository/CartPage/td_summaryShippingValue'
	public static String summaryTaxValue = 'Object Repository/CartPage/td_summaryTaxValue'
	public static String summaryTotalValue = 'Object Repository/CartPage/td_summaryTotalValue'
	//----------- Checkout
	public static String buttonProceedToCheckout = 'Object Repository/CartPage/button_proceedToCheckout'

}
