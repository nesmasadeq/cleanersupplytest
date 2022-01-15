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

public class ProductFiltersItems {

	public static TestObject btnManufacture = findTestObject('Object Repository/Filters/btn_manufacture')
	public static TestObject brandFilter =findTestObject( 'Object Repository/Filters/div_brandFilter')
	public static TestObject colorGroupFilter = findTestObject('Object Repository/Filters/div_colorGroupFilter')
	public static TestObject designFilter = findTestObject('Object Repository/Filters/div_designFilter')
	public static TestObject lengthFilter = findTestObject('Object Repository/Filters/div_lengthFilter')
	public static TestObject materialFilter = findTestObject('Object Repository/Filters/div_materialFilter')
	public static TestObject sizeFilter =findTestObject( 'Object Repository/Filters/div_sizeFilter')
	public static TestObject styleFilter = findTestObject('Object Repository/Filters/div_styleFilter')
	public static TestObject selectManufactor = findTestObject('Object Repository/Filters/select_manufactor')
	public static TestObject selectModelFilter =findTestObject( 'Object Repository/Filters/select_modelFilter')
	public static TestObject materailOptionCount = findTestObject('Object Repository/Filters/span_materailOptionCount')

	// Selected Filters
	public static TestObject selectedFilters = findTestObject('Object Repository/Filters/ul_selectedFilters')

	// All Cards
	public static TestObject filtersCards = findTestObject('Object Repository/Filters/div_filtersCards')
	public static TestObject productTypeFilter = findTestObject('Object Repository/Filters/div_productTypeFilter')

	// Specific Filters
	public static TestObject filtersProductType = findTestObject('Object Repository/Filters/div_filtersProductType')

	// Categories
	public static TestObject checkBoxPackagingProducts =findTestObject( 'Object Repository/Filters/chx_packagingProducts')
	public static TestObject countPackagingProducts = findTestObject('Object Repository/Filters/span_packagingProductsCount')

	public static TestObject checkBoxPlasticBags = findTestObject('Object Repository/Filters/chx_plasticBags')
	public static TestObject countPlasticBags = findTestObject('Object Repository/Filters/span_plasticBagsCount')


	// Colors
	public static TestObject checkBoxGreen = findTestObject('Object Repository/Filters/chx_green')
	public static TestObject countGreen = findTestObject('Object Repository/Filters/span_greenCount')

}
