package items

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject

public class SearchResultsPageItems {

	public static TestObject paginationLinks = findTestObject('Object Repository/SearchResultPage/a_paginationLinks')
	public static TestObject pageSubHeader = findTestObject('Object Repository/SearchResultPage/h2_pageSubHeader')

	//----------- Product Row Data
	public static TestObject productHref = findTestObject('Object Repository/ProductRow/a_productUrl')
	public static TestObject productTitle = findTestObject('Object Repository/ProductRow/h2_productTitle')
	public static TestObject productImage = findTestObject('Object Repository/ProductRow/img_productImage')
	public static TestObject productPrice = findTestObject('Object Repository/ProductRow/span_productPrice')
	public static TestObject productListValue =findTestObject( 'Object Repository/ProductRow/span_productListValue')
	public static TestObject productAvailability =findTestObject( 'Object Repository/ProductRow/span_productAvailability')
	public static TestObject firstProductRow = findTestObject('Object Repository/ProductRow/div_firstProductRow')

}
