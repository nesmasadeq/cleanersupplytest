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
		assert tagsAndFormBackgroundColor.contains('rgb(255, 255, 255)')
	}

	/***
	 * verify tags and form color match expected color
	 * @param expectedColor
	 * @author nesma
	 */
	public static void verifyTagsAndFormColorChanged() {
		String tagsAndFormBackgroundColor= WebUI.getCSSValue(tagsAndFormLink, 'color')
		assert tagsAndFormBackgroundColor.equals('rgba(82, 36, 127, 1)')
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
		TestObject logoImage = findTestObject(HeaderItems.logoImage)
//		assert GeneralHelpers.getImageSrc(logoImage).contains(GlobalVariable.siteLogo)
	}

	/**
	 * Verify header customer service data match expected data
	 * @author Eng. Amal Hamad
	 */
	public static void verifyHeaderCustomerService() {
		TestObject customerService = findTestObject(HeaderItems.customerService)
		System.out.println(GeneralHelpers.getFieldText(customerService))
		//		assert GeneralHelpers.getFieldText(customerService).equals(GlobalVariable.siteLogo)
	}


	/**
	 * Verify cart items count match expected count
	 * @param expectedCount
	 * @author Eng. Amal Hamad
	 */
	public static void verifyCartCount(String expectedCount) {
		TestObject cartCount = findTestObject(HeaderItems.cartCount)
		assert WebUI.getText(cartCount).equals(expectedCount)
	}


	/**
	 * Verify cart label match expected label
	 * @param expactedLabel
	 * @author Eng. Amal Hamad
	 */
	public static void verifyCartLabel(String expactedLabel) {
		TestObject cartLabel = findTestObject(HeaderItems.cartLabel)
		System.out.println("cartLabel: " + WebUI.getText(cartLabel))
		assert WebUI.getText(cartLabel).equals(expactedLabel)
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
			HeaderValidations.verifyLinkPageNavigation(headerNav)

			//Get sub links for this Group
			List subNavLinks = driver.findElements(By.cssSelector(HeaderItems.headerNavigation + " > li:nth-child("+i+") div.dropdown-menu a"))
			for(int j = 0 ; j < subNavLinks.size() ; j++) {
				System.out.println("j = " + j)
				// Hover Parent Navigation To Open Menu
				WebElement element = driver.findElement(By.cssSelector("ul.navbar-nav.navbar-left li:nth-child("+i+") span.l1-category + a"))
				TestObject newHeaderNav = WebUI.convertWebElementToTestObject(element)
				WebUI.mouseOver(newHeaderNav)

				// Verify Sub links
				WebElement subLink = driver.findElements(By.cssSelector(HeaderItems.headerNavigation + " > li:nth-child("+i+") div.dropdown-menu a")).get(j)
				HeaderValidations.verifyHoverOverNavigationSubLink(subLink)
				HeaderValidations.verifyLinkPageNavigation(subLink)
			}
		}
	}

	/**
	 * Verify clicking on link navigate to expected page 
	 * @param navLink
	 * @author Eng. Amal Hamad
	 */
	public static void verifyLinkPageNavigation(WebElement navLink) {
		TestObject link = WebUI.convertWebElementToTestObject(navLink)
		String href = WebUI.getAttribute(link, "href")
		String heading = WebUI.getText(link).toUpperCase()
		WebUI.click(link)
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimout)
		System.out.println("headerNav: " + WebUI.getText(link) + " ,heading: " + WebUI.getWindowTitle() + " ,href: " + href)
		GeneralValidations.verifyCurrentPageURL(href)
		//		GeneralValidations.verifyPageHeading(heading)
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
		assert  WebUI.getCSSValue(link, "background").contains("rgba(0, 0, 0, 0)")
		assert  WebUI.getCSSValue(link, "color").contains("rgba(255, 255, 255, 1)")
		WebUI.mouseOver(link)
		//------ After Hover -------
		assert  WebUI.getCSSValue(link, "background").contains("rgb(255, 255, 255)")
		assert  WebUI.getCSSValue(link, "color").contains("rgba(82, 36, 127, 1)")
	}

	/**
	 * Verify hover over navigation sub link
	 * @param subLink
	 * @author Eng. Amal Hamad
	 */
	public static void verifyHoverOverNavigationSubLink(WebElement subLink) {
		TestObject link = WebUI.convertWebElementToTestObject(subLink)
		//------ Before Hover ------
		assert WebUI.getCSSValue(link, "color").contains("rgba(0, 0, 0, 1)")
		WebUI.mouseOver(link)
		//------ After Hover ------
		assert WebUI.getCSSValue(link, "color").contains("rgba(82, 36, 127, 1)")
	}
}
