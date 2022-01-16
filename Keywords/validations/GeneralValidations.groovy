package validations

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import items.HeaderItems

public class GeneralValidations {

	/**
	 * Verify current page url, title and heading
	 * @param URL
	 * @param title
	 * @param heading
	 * @author Eng. Amal Hamad
	 */
	public static void verifyCurrentPage(String URL , String title , String heading) {
		WebUI.waitForPageLoad(GlobalVariable.pageLoadTimout)

		//------ Verify Page URL --------
		GeneralValidations.verifyCurrentPageURL(URL)
		//------ Verify Page Title --------
		GeneralValidations.verifyCurrentPageTitleValue(title)
		//------ Verify Heading --------
		GeneralValidations.verifyPageHeading(heading)
	}

	/***
	 * verify current page title match the expected title
	 * @param expectedTitle
	 * @author nesma
	 */
	public static void verifyCurrentPageTitleValue(String expectedTitle) {
		assert WebUI.getWindowTitle().equals(expectedTitle)
	}

	/**
	 * Verify Current Page URL matched the passed url
	 * @param expectedURL expectedURL or part of expectedURL
	 * @author nesma
	 */
	public static void verifyCurrentPageURL(String expectedURL) {
		Thread.sleep(3000)
		assert WebUI.getUrl().contains(expectedURL)
		HeaderValidations.verifyHeaderLogo()
	}

	/**
	 * Verify Current Page Heading match expected heading
	 * @param expectedHeading
	 * @author Eng. Amal Hamad
	 */
	public static void verifyPageHeading(String expectedHeading) {
		assert WebUI.getText(HeaderItems.pageHeading).toLowerCase().contains(expectedHeading.toLowerCase())
	}

	/**
	 * Verify page pageBreadcrumb links
	 * @param breadcrumbLinks
	 * @author Eng. Amal Hamad
	 * @author nesma
	 */
	public static void verifyPageBreadcrumb(String... breadcrumbLinks) {
		List <WebElement> breadcrumbList = WebUI.findWebElements(HeaderItems.pageBreadcrumb, GlobalVariable.elementVisibilityTimeOut)
		for(int i = 0 ; i < breadcrumbList.size() ; i++) {
			String currentValue =  breadcrumbList.get(i).getText()
			if(!currentValue.equals("")) {
				assert currentValue.toLowerCase().contains(breadcrumbLinks[i].toLowerCase())
			}
		}
	}

	/**
	 * Verify shadow after hover over button
	 * @param button
	 * @author Eng. Amal Hamad
	 */
	public static void verifyButtonShadowHover(TestObject button) {
		WebUI.mouseOver(button)
		//------ After Hover -------
		System.out.println("box-shadow: " +  WebUI.getCSSValue(button, "box-shadow"))
		assert  WebUI.getCSSValue(button, "box-shadow").contains("rgba(0, 0, 0, 0.3) 0px 0px 10px 2px")
	}

	/**
	 * Verify underline after hover over link
	 * @param link
	 * @author Eng. Amal Hamad
	 */
	public static void verifyLinkUnderlineHover(TestObject link) {
		WebUI.mouseOver(link)
		String textDecoration = WebUI.getCSSValue(link, "text-decoration")
		System.out.println("LinkUnderlineHover: " + textDecoration)
		assert textDecoration.equals("underline solid rgb(0, 0, 0)")
	}
}
