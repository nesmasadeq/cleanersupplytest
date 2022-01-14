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
	public static String logoImage = 'Object Repository/Header/a_headerLogo'
	public static String customerService = 'Object Repository/Header/a_headerCustumerServicePhone'

	//----------- Page Heading
	public static String pageHeading = 'Object Repository/Header/h1_pageHeader'

	//----------- Search Section
	public static String inputSearch = 'Object Repository/Header/input_headerSearch'
	public static String autoSuggestionSearchList = 'Object Repository/Header/div_autoSuggestionSearchList'
	public static String searchForLabel = 'Object Repository/Header/p_searchForLabel'
	public static String autoSuggestionSearchItems = 'Object Repository/Header/strong_autoSuggestionsInnerItems'

	//----------- Cart Section
	public static String cartCount = 'Object Repository/Header/span_cartCount'
	public static String cartLabel = 'Object Repository/Header/span_cartLabel'

	//----------- Navigation Links
	public static String headerNavigation = 'ul.navbar-nav.navbar-left'
	public static String headerNavGroubs = 'ul.navbar-nav.navbar-left span.l1-category + a'


}
