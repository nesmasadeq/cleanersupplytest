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

public class ProductDetailsPageItems {

	//----------- Product Data
	public static TestObject productTitle = findTestObject('Object Repository/ProductDetailsPage/h1_productTitle')
	public static TestObject productSku =findTestObject( 'Object Repository/ProductDetailsPage/span_productSku')
	public static TestObject productImage = findTestObject('Object Repository/ProductDetailsPage/img_productImage')
	public static TestObject productPrice = findTestObject('Object Repository/ProductDetailsPage/span_productPrice')
	public static TestObject productListValue =findTestObject( 'Object Repository/ProductDetailsPage/span_productListPrice')
	public static TestObject productSpecificationDimension = findTestObject('Object Repository/ProductDetailsPage/span_productSpecificationsDimension')
	public static TestObject productDescription =findTestObject( 'Object Repository/ProductDetailsPage/span_productDescription')
	public static TestObject productDescriptionLess = findTestObject('Object Repository/ProductDetailsPage/span_productDescriptionLess')

	public static TestObject productQestionsAnswer = findTestObject('Object Repository/ProductDetailsPage/a_productQustionsAnswers')
	public static TestObject QestionsAnswerSectionTitle =findTestObject( 'Object Repository/ProductDetailsPage/h2_quastionAnswerTitle')
	public static TestObject QestionsAnswerSectionItems = findTestObject('Object Repository/ProductDetailsPage/section_quastionAnswerItems')

	//----------- Product Size Options
	public static TestObject optionSizeXSmall =findTestObject( 'Object Repository/ProductDetailsPage/a_optionXSmall')
	public static TestObject optionSizeLarge = findTestObject('Object Repository/ProductDetailsPage/a_optionLarge')
	public static TestObject optionSizeXLarge =findTestObject( 'Object Repository/ProductDetailsPage/a_optionXLarge')

	//----------- Product Color Options
	public static TestObject spanSelectedColor = findTestObject('Object Repository/ProductDetailsPage/span_selectedColor')
	public static TestObject optionColorBlack = findTestObject('Object Repository/ProductDetailsPage/a_optionColorBlack')
	public static TestObject optionColorBlue = findTestObject('Object Repository/ProductDetailsPage/a_optionColorBlue')
	public static TestObject optionColorGreen =findTestObject( 'Object Repository/ProductDetailsPage/a_optionColorGreen')

	//----------- Add To Cart Section
	public static TestObject divAddToCartSection =findTestObject( 'Object Repository/ProductDetailsPage/div_addToCartSection')
	public static TestObject divInStock = findTestObject('Object Repository/ProductDetailsPage/div_inStock')
	public static TestObject divOutOfStock = findTestObject('Object Repository/ProductDetailsPage/div_outOfStock')
	public static TestObject inputProductQty = findTestObject('Object Repository/ProductDetailsPage/input_productQty')
	public static TestObject btnAddToCart = findTestObject('Object Repository/ProductDetailsPage/button_addToCart')

	//----------- Volume Pricing Table
	public static TestObject div_volumeTableQty = findTestObject('Object Repository/ProductDetailsPage/div_volumeTableQty')
	public static TestObject div_volumeTablePrice = findTestObject('Object Repository/ProductDetailsPage/div_volumeTablePrice')

}
