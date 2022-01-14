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
	public static String productTitle = 'Object Repository/ProductDetailsPage/h1_productTitle'
	public static String productSku = 'Object Repository/ProductDetailsPage/span_productSku'
	public static String productImage = 'Object Repository/ProductDetailsPage/img_productImage'
	public static String productPrice = 'Object Repository/ProductDetailsPage/span_productPrice'
	public static String productListValue = 'Object Repository/ProductDetailsPage/span_productListPrice'
	public static String productBreadcrumb = 'Object Repository/ProductDetailsPage/span_productBreadcrumb'
	public static String productSpecificationDimension = 'Object Repository/ProductDetailsPage/span_productSpecificationsDimension'
	public static String productDescription = 'Object Repository/ProductDetailsPage/span_productDescription'
	public static String productDescriptionLess = 'Object Repository/ProductDetailsPage/span_productDescriptionLess'
	
	public static String productQestionsAnswer = 'Object Repository/ProductDetailsPage/a_productQustionsAnswers'
	public static String QestionsAnswerSectionTitle = 'Object Repository/ProductDetailsPage/h2_quastionAnswerTitle'
	public static String QestionsAnswerSectionItems = 'Object Repository/ProductDetailsPage/section_quastionAnswerItems'

	//----------- Product Size Options
	public static String optionSizeXSmall = 'Object Repository/ProductDetailsPage/a_optionXSmall'
	public static String optionSizeLarge = 'Object Repository/ProductDetailsPage/a_optionLarge'
	public static String optionSizeXLarge = 'Object Repository/ProductDetailsPage/a_optionXLarge'

	//----------- Product Color Options
	public static String spanSelectedColor = 'Object Repository/ProductDetailsPage/span_selectedColor'
	public static String optionColorBlack = 'Object Repository/ProductDetailsPage/a_optionColorBlack'
	public static String optionColorBlue = 'Object Repository/ProductDetailsPage/a_optionColorBlue'
	public static String optionColorGreen = 'Object Repository/ProductDetailsPage/a_optionColorGreen'

	//----------- Add To Cart Section
	public static String divAddToCartSection = 'Object Repository/ProductDetailsPage/div_addToCartSection'
	public static String divInStock = 'Object Repository/ProductDetailsPage/div_inStock'
	public static String divOutOfStock = 'Object Repository/ProductDetailsPage/div_outOfStock'
	public static String inputProductQty = 'Object Repository/ProductDetailsPage/input_productQty'
	public static String btnAddToCart = 'Object Repository/ProductDetailsPage/button_addToCart'

	//----------- Volume Pricing Table
	public static String div_volumeTableQty = 'Object Repository/ProductDetailsPage/div_volumeTableQty'
	public static String div_volumeTablePrice = 'Object Repository/ProductDetailsPage/div_volumeTablePrice'

}
