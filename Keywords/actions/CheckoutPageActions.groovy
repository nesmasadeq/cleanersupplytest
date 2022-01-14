package actions

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import items.CheckoutPageItems


public class CheckoutPageActions {


	/***
	 * filling company field
	 * @author nesma
	 */
	public static void fillInputField(TestObject inputField, String inputValue) {
		WebUI.sendKeys(inputField, inputValue)
	}

	/***
	 * selecting California state
	 * @author nesma
	 */
	public static void selectState() {
		WebUI.selectOptionByValue(CheckoutPageItems.stateSelect, 'California', false)
	}
	/***
	 * clicking on collapse icon
	 * @author nesma
	 */
	public static void clickOnCollapse() {
		WebUI.click(CheckoutPageItems.collapseLink)
	}
	/***
	 * select option randomly
	 * @param selectOptions
	 * @return selectedOptionValue
	 * @author nesma
	 */
	public static String selectOptionRandomly(TestObject selectOptions) {
		List <WebElement> selectionOptions =
				WebUI.findWebElements(selectOptions,GlobalVariable.elementVisibilityTimeOut)
		int index = (int)(Math.random() *selectionOptions.size());
		WebElement randomSelectOption = selectionOptions.get(index)
		TestObject selectedOption = WebUI.convertWebElementToTestObject(randomSelectOption)
		WebUI.click(selectedOption)
		return randomSelectOption.getAttribute('value')
	}
	/***
	 * click on review order button
	 * @author nesma
	 */
	public static void clickOnReviewOrderButton() {
		WebUI.click(CheckoutPageItems.reviewOrderButton)
	}
}
