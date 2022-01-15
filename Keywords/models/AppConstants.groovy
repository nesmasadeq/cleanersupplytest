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

	// Quick Order Page
	public static final String QUICK_ORDER_PAGE_URL = "https://www.cleanersupply.com/quick-order/"
	public static final String QUICK_ORDER_PAGE_TITLE = "'Quick Order - Cleaner's Supply"

	// Search Results Page
	public static final String SEARCH_TERM = "Plastic"
	public static final String SEARCH_PAGE_URL = "search-results/?q=" + SEARCH_TERM
	public static final String SEARCH_PAGE_TITLE = "Search Results - Cleaner's Supply"
	public static final String SEARCH_PAGE_HEADING = "SEARCH RESULTS"

	// Products Filters
	public static final String FILTER_PACKAGING_PRODUCT_URL = "Category=Packaging+Products"
	public static final String FILTER_PACKAGING_PRODUCT = "Packaging Products"

	public static final String FILTER_PLASTIC_BAGS_URL = "Category=Packaging+Products_Plastic+Bags"
	public static final String FILTER_PLASTIC_BAGS = "Plastic Bags"

	public static final String FILTER_COLOR_GREEN_URL = "Color+Group=Green"
	public static final String FILTER_COLOR_GREEN = "Green"

	// Cart Page
	public static final String CART_PAGE_URL = "https://www.cleanersupply.com/shopping-cart/"
	public static final String CART_PAGE_TITLE = "Shopping Cart - Cleaner's Supply"
	public static final String CART_PAGE_HEADING = "SHOPPING CART"
	// Cart Summary
	public static final String SHIPPING_NOT_AVAILABLE = "NOT AVAILABLE"
	public static final String SHIPPING_FREE = "FREE"
	public static final String SHIPPING_TO_CALIFORNIA = GlobalVariable.siteCurrency + "4.89"
	public static final String TAX_TBD = "T.B.D."
	public static final String TAX_ZERO = GlobalVariable.siteCurrency + ".00"

	// Product Details Page
	public static final String IN_STOCK = "In Stock!"
	public static final String OUT_OF_STOCK = "Currently Unavailable."
	public static final String OUT_OF_STOCK_TEMPORARILY = "Temporarily Out of Stock!"


	// Select CheckOut Page
	public static final String SELECT_CHECKOUT_PAGE_URL = "https://www.cleanersupply.com/checkout-interstitial/"
	public static final String SELECT_CHECKOUT_PAGE_TITLE = "Checkout Interstitial - Cleaner's Supply"
	public static final String SELECT_CHECKOUT_PAGE_HEADING = "SECURE CHECKOUT"

	// CheckOut Page
	public static final String CHECKOUT_PAGE_URL = "https://www.cleanersupply.com/checkout/"
	public static final String CHECKOUT_PAGE_TITLE = "Checkout - Cleaner's Supply"
	public static final String CHECKOUT_PAGE_HEADING = "CHECKOUT"

	// Order Review Page
	public static final String ORDER_REVIEW_PAGE_URL = "https://www.cleanersupply.com/checkout/"
	public static final String ORDER_REVIEW_PAGE_TITLE = "Checkout - Cleaner's Supply"
	public static final String ORDER_REVIEW_PAGE_HEADING = "CHECKOUT"

	// ContactUs Data
	public static final String CUSTOMER_SERVICE_PHONE = "1-800-388-5410"
	public static final String CUSTOMER_SERVICE_WORK_HOURS = "Monday - Friday 8am - 8pm EST"

	// Fake CheckOut Data
	public static final String CHECKOUT_COMPANY  = "test company";
	public static final String CHECKOUT_FNAME = "testFName";
	public static final String CHECKOUT_LNAME = "testLName";
	public static final String CHECKOUT_ADDRESS_1 = "address1";
	public static final String CHECKOUT_ADDRESS_2 = "address2";
	public static final String CHECKOUT_POSTAL_CODE = "12345";
	public static final String CHECKOUT_COUNTRY = "United States";
	public static final String CHECKOUT_CITY = "testCity";
	public static final String CHECKOUT_STATE = "California";
	public static final String CHECKOUT_PHONE =  "555-555-5555";
	public static final String CHECKOUT_EXT = "6";
	public static final String CHECKOUT_EMAIL = "test@gmail.com";

	public static final String CHECKOUT_CARD_HOLDER = "testCard";
	public static final String CHECKOUT_CARD_NUMBER = "4242424242424242";
	public static final String CHECKOUT_CARD_CVV = "100";

	public static final String CHECKOUT_PO = "1234";
	public static final String CHECKOUT_COMMENT = "testComment";

	// Footer data
	public static final String EXClUSIVE_EMAIL ="Exclusive email specials";
	public static final String EXClUSIVE_EMAIL_DESCRIPTION ="Get Specials, Exclusive Promotions & Updates";
	public static final String SIGNUP_SUCCESSMESSAE = "Thanks for signing up";
	public static final String FOLLOW_US = "Follow Us";
	public static final String CONNECT_WITH_US = "CONNECT WITH US"
	public static final String CONTACT_EMAIL = "customerservice@cleanersupply.com"
	public static final String CONTACT_TIME = "Monday - Friday 8am - 8pm EST"
	public static final String ENGLISH_SPEAKER = "1-800-388-5410"
	public static final String KOREAN_SPEAKER = "1-800-388-0190"
	public static final String ITERNATIONAL_SPEAKER = "1-607-584-5853"
	public static final String CHAT_OFFLINE = "Chat Offline"
	public static final String CATALOG_REQUEST = "Request a Catalog"
	public static final String FREE_CLASSIFIDES = "Free Classifieds"
	public static final String USA = "USA"
	public static final String CANADA = "Canada"
	public static final String CANADA_SELECT_VALUE = "https://www.cleanersupply.ca/"
	public static final String COPY_RIGHTS = "© 2022 Cleaner’s Supply ® All Rights Reserved"
	public static final String TERM_OF_USE ="Terms of Use"
	public static final String POLICY ="Privacy Policy"
	public static final String REQUEST_CATALOG_URL ="https://www.cleanersupply.com/request-a-catalog/"
	public static final String REQUEST_CATALOG_TITLE ="Request A Catalog – Free Monthly Printed Catalog - Cleaner's Supply"
	public static final String REQUEST_CATALOG_HEADING ="LET’S GET STARTED"
	public static final String CLASSIFIDE_URL ="https://www.cleanersupply.com/classifieds-list/"
	public static final String CLASSIFIDE_TITLE ="Classifieds List - Cleaner's Supply"
	public static final String CLASSIFIDE_HEADING ="CLASSIFIEDS"
	public static final String INFO_HELPER ="ALL PRICES IN CANADIAN"
	public static final String TERMS_URL ="https://www.cleanersupply.ca/terms-of-use/"
	public static final String TERMS_TITLE ="Terms of Use - Cleaner's Supply"
	public static final String TERMS_HEADING ="Terms of Use"
	public static final String POLICY_URL ="https://www.cleanersupply.com/privacy-policy/"
	public static final String POLICY_TITLE ="Privacy Policy - Cleaner's Supply"
	public static final String POLICY_HEADING ="Privacy Policy"


}
