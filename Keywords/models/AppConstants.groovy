package models

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

public class AppConstants {

	// Search Results Page
	public static final String SEARCH_TERM = "plastic"
	public static final String SEARCH_PAGE_URL = "search-results/?q=" + SEARCH_TERM
	public static final String SEARCH_PAGE_TITLE = "Search Results - Cleaner's Supply"
	public static final String SEARCH_PAGE_HEADING = "SEARCH RESULTS"

	// Cart Page
	public static final String CART_PAGE_URL = "https://www.cleanersupply.com/shopping-cart/"
	public static final String CART_PAGE_TITLE = "Shopping Cart - Cleaner's Supply"
	public static final String CART_PAGE_HEADING = "SHOPPING CART"
	// Cart Summary
	public static final String SHIPPING_NOT_AVAILABLE = "NOT AVAILABLE"
	public static final String SHIPPING_FREE = "FREE"
	public static final String TAX_TBD = "T.B.D."
	public static final String TAX_ZERO = GlobalVariable.siteCurrency + ".00"

	// Select CheckOut Page
	public static final String SELECT_CHECKOUT_PAGE_URL = "https://www.cleanersupply.com/checkout-interstitial/"
	public static final String SELECT_CHECKOUT_PAGE_TITLE = "Checkout Interstitial - Cleaner's Supply"
	public static final String SELECT_CHECKOUT_PAGE_HEADING = "SECURE CHECKOUT"
	public static final String SELECT_STATE = "California"

	// CheckOut Page
	public static final String CHECKOUT_PAGE_URL = "https://www.cleanersupply.com/checkout/"
	public static final String CHECKOUT_PAGE_TITLE = "Checkout - Cleaner's Supply"
	public static final String CHECKOUT_PAGE_HEADING = "SECURE CHECKOUT"

	// Order Review Page
	public static final String ORDER_REVIEW_PAGE_URL = "https://www.cleanersupply.com/checkout/"
	public static final String ORDER_REVIEW_PAGE_TITLE = "Checkout - Cleaner's Supply"
	public static final String ORDER_REVIEW_PAGE_HEADING = "CHECKOUT"
	

}
