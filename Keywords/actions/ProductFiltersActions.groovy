package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import javax.persistence.metamodel.StaticMetamodel

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

public class ProductFiltersActions {

	/**
	 * Click on specific filter checkBox
	 * @param testObject
	 * @author Eng. Amal Hamad
	 */
	public static  void checkSpecificFilter(TestObject testObject) {
		//WebUI.scrollToElement(chx_PackagingProducts, GlobalVariable.actionsTimeout)
		WebUI.click(testObject)
	}

	/***
	 * select casio manufacturer
	 * @author nesma
	 */
	public static  selectManufactor() {
		TestObject manufactorSelect = findTestObject('Object Repository/Filters/select_manufactor')
		WebUI.selectOptionByValue(manufactorSelect,
				'https://www.cleanersupply.com/Tags-Forms/Computer-Register/?Manufacturer=Casio', false)
		return manufactorSelect
	}
	
	/***
	 * select SP1000 model
	 * @author nesma
	 */
	public static  selectModel() {
		TestObject modelSelect = findTestObject('Object Repository/Filters/select_modelFilter')
		WebUI.selectOptionByValue(modelSelect,
				'https://www.cleanersupply.com/Tags-Forms/Computer-Register/?Model+%23=SP1000&Manufacturer=Casio', false)
		return modelSelect
	}
}
