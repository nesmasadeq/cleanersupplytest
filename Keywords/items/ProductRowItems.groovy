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

public class ProductRowItems {

	//----------- Product Data
	public static String productHref = 'Object Repository/ProductRow/a_productUrl'
	public static String productTitle = 'Object Repository/ProductRow/h2_productTitle'
	public static String productImage = 'Object Repository/ProductRow/img_productImage'
	public static String productPrice = 'Object Repository/ProductRow/span_productPrice'
	public static String productListValue = 'Object Repository/ProductRow/span_productListValue'
	public static String productAvailability = 'Object Repository/ProductRow/span_productAvailability'
	public static String firstProductRow = 'Object Repository/ProductRow/div_firstProductRow'


}
