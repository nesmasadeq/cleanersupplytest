package actions

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
import com.sun.org.apache.bcel.internal.generic.RETURN

import internal.GlobalVariable

public class ProductDetailsPageActions {

	public static String productTitle = 'Object Repository/ProductDetailsPage/h1_productTitle'
	public static String productSku = 'Object Repository/ProductDetailsPage/span_productSku'
	public static String productImage = 'Object Repository/ProductDetailsPage/img_productImage'
	public static String productPrice = 'Object Repository/ProductDetailsPage/span_productPrice'
	public static String productListValue = 'Object Repository/ProductDetailsPage/span_productListPrice'
	public static String productQestionsAnswerTitle = 'Object Repository/ProductDetailsPage/h2_quastionAnswerTitle'
	public static String productQestionsAnswerCount = 'Object Repository/ProductDetailsPage/section_quastionAnswerItems'
	public static String productBreadcrumb = 'Object Repository/ProductDetailsPage/span_productBreadcrumb'
	public static String productSpecificationDimension = 'Object Repository/ProductDetailsPage/span_productSpecificationsDimension'

	//----------- Product Size Options
	public static String optionSizeXSmall = 'Object Repository/ProductDetailsPage/a_optionXSmall'
	public static String optionSizeLarge = 'Object Repository/ProductDetailsPage/a_optionLarge'
	public static String optionSizeXLarge = 'Object RObject Repository/ProductDetailsPage/a_optionXLarge'

	//----------- Product Color Options
	public static String optionColorBlack = 'Object Repository/ProductDetailsPage/a_optionColorBlack'
	public static String optionColorBlue = 'Object Repository/ProductDetailsPage/a_optionColorBlue'
	public static String optionColorGreen = 'Object Repository/ProductDetailsPage/a_optionColorGreen'

	//	public static String getCurrentProductTitle() {
	//		TestObject testObject = findTestObject(productTitle)
	//		return  WebUI.getText(testObject);
	//	}

	/**
	 * Get current text by this selector
	 * @param selector
	 * @return String of current value for this field
	 * @author Eng. Amal Hamad
	 */
	public static String getCurrentText(String selector) {
		TestObject testObject = findTestObject(selector)
		return  WebUI.getText(testObject);
	}
	/***
	 * filling quantity field
	 * @param productQuantity
	 * @return quantityFeild
	 */
	public static enterQuantity(String productQuantity) {
		TestObject quantityFeild = findTestObject('Object Repository/ProductDetailsPage/input_quantityFeild')
		WebUI.sendKeys(quantityFeild, productQuantity)
		return quantityFeild
	}


}
