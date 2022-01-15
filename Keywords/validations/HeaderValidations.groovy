package validations

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.HeaderActions
import helpers.GeneralHelpers
import internal.GlobalVariable
import items.HeaderItems
import models.AppConstants


public class HeaderValidations {

	static TestObject tagsAndFormLink = findTestObject('Object Repository/Header/a_tagsAndForms')
	/***
	 * Verify displaying tags and form menu
	 * @author nesma
	 */
	public static void verifyDisplayingTagsAndFormMenu() {
		TestObject TagsAndFormMenu = findTestObject('Object Repository/Header/ul_tagsAndFormsMenu')
		String TagsAndFormMenuClasses = WebUI.getAttribute(TagsAndFormMenu, 'class')
		assert TagsAndFormMenuClasses.contains('open-desktop')
	}

	/***
	 * verify tags and form background color match expected background color
	 * @param expectedBackgroundColor
	 * @author nesma
	 */
	public static void verifyTagsAndFormBackgroundColorChanged() {
		String tagsAndFormBackgroundColor= WebUI.getCSSValue(tagsAndFormLink, 'background')
		assert GeneralHelpers.getCssBackground(tagsAndFormLink).contains('rgb(255, 255, 255)')
	}

	/***
	 * verify tags and form color match expected color
	 * @param expectedColor
	 * @author nesma
	 */
	public static void verifyTagsAndFormColorChanged() {
		assert GeneralHelpers.getCssTextColor(tagsAndFormLink).equals('rgba(82, 36, 127, 1)')
	}

	/***
	 * verify computer And register link color match expected color
	 * @param expectedColor
	 * @author nesma
	 */
	public static void VerifyComputerAndRegisterColorChanged() {
		TestObject computerAndRegisterLink = findTestObject('Object Repository/Header/a_computerAndRegister')
		String ComputerAndRegisterColor = WebUI.getCSSValue(computerAndRegisterLink, 'color')
		assert ComputerAndRegisterColor.contains('rgba(0, 0, 0, 1)')
	}

	/**
	 * Verify header logo match expected logo
	 * @author Eng. Amal Hamad
	 */
	public static void verifyHeaderLogo() {

		//		TestObject logoImage = findTestObject(HeaderItems.logoImage)
		//		assert GeneralHelpers.getImageSrc(logoImage).contains(GlobalVariable.siteLogo)
	}

	/**
	 * Verify input search place holder
	 * @author Eng. Amal Hamad
	 */
	public static void verifySearchInputPlaceHolder() {
		assert WebUI.getAttribute(HeaderItems.inputSearch, 'placeholder').equals('Search by Stock # or Keyword')
	}

	/**
	 * Verify auto suggestion search list is visible
	 * @author Eng. Amal Hamad
	 */
	public static void verifyAutoSuggestionSearchListIsVisible() {
		TestObject div_autoSuggestionSearchList = HeaderItems.autoSuggestionSearchList
		//		System.out.println(WebUI.getAttribute(div_autoSuggestionSearchList, 'style'))
		assert WebUI.getAttribute(div_autoSuggestionSearchList, 'style').equals('')
		System.out.println('getClass: ' + GeneralHelpers.getFieldCalsses(div_autoSuggestionSearchList))
		assert GeneralHelpers.getFieldCalsses(div_autoSuggestionSearchList).contains('open')
	}

	/**
	 * Verify SerchFor label contains search text
	 * @author Eng. Amal Hamad
	 */
	public static void verifySearchForLabel() {
		assert WebUI.getText(HeaderItems.searchForLabel).toLowerCase().contains(AppConstants.SEARCH_TERM.toLowerCase())
	}

	/**
	 * Verify auto suggestions inner items contain search text
	 * @author Eng. Amal Hamad
	 */
	public static void verifyAutoSuggestionsInnerItems() {
		List<TestObject> autoSuggestionsInnerItems = WebUI.findWebElements(HeaderItems.autoSuggestionSearchItems,GlobalVariable.elementVisibilityTimeOut)
		//		System.out.println('autoSuggestionsInnerItems: ' + autoSuggestionsInnerItems.size())
		for (WebElement element : autoSuggestionsInnerItems) {
			TestObject object = WebUI.convertWebElementToTestObject(element)
			System.out.println('autoSuggestionsInnerItems: ' + WebUI.getText(object))
			assert WebUI.getText(object).toLowerCase().contains(AppConstants.SEARCH_TERM.toLowerCase())
		}
	}

	/**
	 * Verify header customer service data match expected data
	 * @author Eng. Amal Hamad
	 */
	public static void verifyHeaderCustomerService() {
		System.out.println(HeaderItems.customerService)
		assert WebUI.getText(HeaderItems.customerService).contains(AppConstants.CUSTOMER_SERVICE_PHONE)
		assert WebUI.getText(HeaderItems.customerService).contains(AppConstants.CUSTOMER_SERVICE_WORK_HOURS)
	}

	/**
	 * Verify cart items count match expected count
	 * @param expectedCount
	 * @author Eng. Amal Hamad
	 */
	public static void verifyCartCount(String expectedCount) {
		assert WebUI.getText(HeaderItems.cartCount).equals(expectedCount)
	}

	/**
	 * Verify cart label match expected label
	 * @param expactedLabel
	 * @author Eng. Amal Hamad
	 */
	public static void verifyCartLabel(String expactedLabel) {
		System.out.println("cartLabel: " + WebUI.getText(HeaderItems.cartLabel))
		assert WebUI.getText(HeaderItems.cartLabel).equals(expactedLabel)
	}

	/**
	 * Verify Header navigation links 
	 * @author Eng. Amal Hamad
	 */
	public static void varifyHeaderNavigationsLinks() {
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> headerNavGroub = driver.findElements(By.cssSelector(HeaderItems.headerNavGroubs))

		for(int i = 1 ; i <= headerNavGroub.size() ; i++) {
			System.out.println("i = " + i)
			// Verify Main Navigation Links
			WebElement headerNav = driver.findElement(By.cssSelector("ul.navbar-nav.navbar-left li:nth-child("+i+") span.l1-category + a"))
			HeaderValidations.verifyHoverOverNavGroupLink(headerNav)
			HeaderValidations.verifyHeaderLinkPageNavigation(null, headerNav)

			//Get sub links for this Group
			List subNavLinks = driver.findElements(By.cssSelector("ul.navbar-nav.navbar-left > li:nth-child("+i+") div.dropdown-menu a"))
			for(int j = 0 ; j < subNavLinks.size() ; j++) {
				System.out.println("j = " + j)
				// Hover Parent Navigation To Open Menu
				WebElement element = driver.findElement(By.cssSelector("ul.navbar-nav.navbar-left li:nth-child("+i+") span.l1-category + a"))
				TestObject newHeaderNav = WebUI.convertWebElementToTestObject(element)
				WebUI.mouseOver(newHeaderNav)

				// Verify Sub links
				WebElement subLink = driver.findElements(By.cssSelector("ul.navbar-nav.navbar-left > li:nth-child("+i+") div.dropdown-menu a")).get(j)
				HeaderValidations.verifyHoverOverNavigationSubLink(subLink)
				HeaderValidations.verifyHeaderLinkPageNavigation(WebUI.getText(newHeaderNav), subLink)
			}
		}
	}

	/**
	 * Verify Footer navigation links
	 * @author Eng. Amal Hamad
	 */
	public static void varifyFooterNavigationsLinks() {
		WebDriver driver = DriverFactory.getWebDriver()
		String selector = "#footer-container .footer-item > ul.list-unstyled a"
		List<WebElement> footerLinks = driver.findElements(By.cssSelector(selector))
		for(int i = 0 ; i < footerLinks.size() ; i++) {
			WebElement link =  driver.findElements(By.cssSelector(selector)).get(i)
			verifyFooterLinkPageNavigation(link)
		}
	}

	/**
	 * Verify clicking on footer link navigate to expected page
	 * @param navLink
	 * @author Eng. Amal Hamad
	 */
	public static void verifyFooterLinkPageNavigation(WebElement navLink) {
		TestObject link = WebUI.convertWebElementToTestObject(navLink)
		String href = WebUI.getAttribute(link, "href")
		String heading = WebUI.getText(link)
		System.out.println("footerNav: " + heading + " ,title: " + WebUI.getWindowTitle() + " ,href: " + href)
		WebUI.click(link)
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimout)

		switch(heading) {
			case "Manage My Account":
				GeneralValidations.verifyCurrentPageURL("log-in/?ReturnUrl=%2fmy-account%2f")
				break;

			case "Start A Return":
				GeneralValidations.verifyCurrentPageURL(GlobalVariable.baseUrl)
				break;

			case "Our Story":
			case "Customer Service":
			case "Careers":
				GeneralValidations.verifyCurrentPageURL(href)
				break;

			case "Favorites":
				GeneralValidations.verifyCurrentPageURL("log-in/?ReturnUrl=%2ffavorites%2f")
				break;

			case "Previously Ordered":
				GeneralValidations.verifyCurrentPageURL("log-in/?ReturnUrl=%2fpreviously-ordered%2f")
				break;

			case "Online Catalog":
				WebUI.switchToWindowIndex(1)
				assert WebUI.getUrl().contains(href)
				WebUI.closeWindowIndex(1)
				break;

			default:
				GeneralValidations.verifyCurrentPageURL(href)
			//				GeneralValidations.verifyPageHeading(heading.toUpperCase())
				break;
		}
		//		HeaderActions.backToHome()
	}

	/**
	 * Verify clicking on header link navigate to expected page 
	 * @param navLink
	 * @author Eng. Amal Hamad
	 */
	public static void verifyHeaderLinkPageNavigation(String parent, WebElement navLink) {
		TestObject link = WebUI.convertWebElementToTestObject(navLink)
		String href = WebUI.getAttribute(link, "href")
		String heading = WebUI.getText(link).toUpperCase()
		System.out.println("headerNav: " + heading + " ,title: " + WebUI.getWindowTitle() + " ,href: " + href)
		GeneralValidations.verifyLinkUnderlineHover(link)
		WebUI.click(link)
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimout)
		GeneralValidations.verifyCurrentPageURL(href)
		if(!heading.equals("TAGS & FORMS")) {
			GeneralValidations.verifyPageHeading(heading)
		}
		if(parent != null){
			GeneralValidations.verifyPageBreadcrumb(parent , " " , heading)
		}
		//		HeaderActions.backToHome()
	}

	/**
	 * Verify hover over navigation group link
	 * @param headerNav
	 * @author Eng. Amal Hamad
	 */
	public static void verifyHoverOverNavGroupLink(WebElement headerNav) {
		TestObject link = WebUI.convertWebElementToTestObject(headerNav)
		//------ Before Hover ------
		assert  GeneralHelpers.getCssBackground(link).contains("rgba(0, 0, 0, 0)")
		assert  GeneralHelpers.getCssTextColor(link).contains("rgba(255, 255, 255, 1)")
		WebUI.mouseOver(link)
		//------ After Hover -------
		assert  GeneralHelpers.getCssBackground(link).contains("rgb(255, 255, 255)")
		assert  GeneralHelpers.getCssTextColor(link).contains("rgba(82, 36, 127, 1)")
	}

	/**
	 * Verify hover over navigation sub link
	 * @param subLink
	 * @author Eng. Amal Hamad
	 */
	public static void verifyHoverOverNavigationSubLink(WebElement subLink) {
		TestObject link = WebUI.convertWebElementToTestObject(subLink)
		//------ Before Hover ------
		assert GeneralHelpers.getCssTextColor(link).contains("rgba(0, 0, 0, 1)")
		WebUI.mouseOver(link)
		//------ After Hover ------
		assert GeneralHelpers.getCssTextColor(link).contains("rgba(82, 36, 127, 1)")
	}
}
