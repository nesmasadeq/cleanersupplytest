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

public class HeaderItems {

	//----------- General
	public static TestObject logoImage = findTestObject('Object Repository/Header/a_headerLogo')
	public static TestObject customerService = findTestObject('Object Repository/Header/a_headerCustumerServicePhone')

	//----------- Page Heading
	public static TestObject pageHeading =findTestObject( 'Object Repository/Header/h1_pageHeader')

	//----------- Search Section
	public static TestObject inputSearch = findTestObject('Object Repository/Header/input_headerSearch')
	public static TestObject autoSuggestionSearchList = findTestObject('Object Repository/Header/div_autoSuggestionSearchList')
	public static TestObject searchForLabel =findTestObject( 'Object Repository/Header/p_searchForLabel')
	public static TestObject autoSuggestionSearchItems = findTestObject('Object Repository/Header/strong_autoSuggestionsInnerItems')

	//----------- Cart Section
	public static TestObject cartCount = findTestObject('Object Repository/Header/span_cartCount')
	public static TestObject cartLabel = findTestObject('Object Repository/Header/span_cartLabel')

	//----------- Navigation Links
	public static String headerNavigation = 'ul.navbar-nav.navbar-left'
	public static String headerNavGroubs = 'ul.navbar-nav.navbar-left span.l1-category + a'


}
