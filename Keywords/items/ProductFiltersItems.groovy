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

	public static String btnManufacture = 'Object Repository/Filters/btn_manufacture'
	public static String brandFilter = 'Object Repository/Filters/div_brandFilter'
	public static String colorGroupFilter = 'Object Repository/Filters/div_colorGroupFilter'
	public static String designFilter = 'Object Repository/Filters/div_designFilter'
	public static String lengthFilter = 'Object Repository/Filters/div_lengthFilter'
	public static String materialFilter = 'Object Repository/Filters/div_materialFilter'
	public static String sizeFilter = 'Object Repository/Filters/div_sizeFilter'
	public static String styleFilter = 'Object Repository/Filters/div_styleFilter'
	public static String selectManufactor = 'Object Repository/Filters/select_manufactor'
	public static String selectModelFilter = 'Object Repository/Filters/select_modelFilter'
	public static String materailOptionCount = 'Object Repository/Filters/span_materailOptionCount'

	// Selected Filters
	public static String selectedFilters = 'Object Repository/Filters/ul_selectedFilters'

	// All Cards
	public static String filtersCards = 'Object Repository/Filters/div_filtersCards'
	public static String productTypeFilter = 'Object Repository/Filters/div_productTypeFilter'

	// Specific Filters
	public static String filtersProductType = 'Object Repository/Filters/div_filtersProductType'

	// Categories
	public static String checkBoxPackagingProducts = 'Object Repository/Filters/chx_packagingProducts'
	public static String countPackagingProducts = 'Object Repository/Filters/span_packagingProductsCount'

	public static String checkBoxPlasticBags = 'Object Repository/Filters/chx_plasticBags'
	public static String countPlasticBags = 'Object Repository/Filters/span_plasticBagsCount'

	// Colors
	public static String checkBoxGreen = 'Object Repository/Filters/chx_green'
	public static String countGreen = 'Object Repository/Filters/span_greenCount'

}
