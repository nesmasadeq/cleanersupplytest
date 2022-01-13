package helpers

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import actions.HeaderActions
import models.Product
import validations.ComputerAndRegisterPageValidations
import validations.GeneralValidations
import validations.HeaderValidations



public class ComputerAndRegisterPageHelpers {

	/**
	 * clicking on computer and register link
	 * @author nesma
	 */
	public static void clickingOnComputerAndRegisterLink() {
		HeaderActions.clickOnComputersAndRegisterLink()
		HeaderValidations.VerifyComputerAndRegisterColorChanged('rgba(0, 0, 0, 1)')
		GeneralValidations.verifyCurrentPageTitleValue("Computer & Register - Cleaner's Supply")
		GeneralValidations.verifyCurrentPageURL('Tags-Forms/Computer-Register')
		ComputerAndRegisterPageValidations.verfiyCurrentPageHeading('Computer & Register Tags & Forms')
		ComputerAndRegisterPageValidations.verifyBreadcrumbContent('Tags & Forms', 'Computer & Register')
	}

	/***
	 * clicking on product item and save product details in model object
	 * @return casioProduct
	 * @author nesma
	 */
	public static Product clickingOnProdutItem() {
		TestObject productItem = findTestObject('Object Repository/ComputerAndRegisterPage/a_productItem')
		Product casioProduct = ProductRowHelper.saveProductRowData(productItem)
		//		assert WebUI.getCSSValue(productItem, 'box-shadow').contains('rgba(0, 0, 0, 0.25) 0px 0px 7px 0px')
		WebUI.click(productItem)
		return casioProduct
	}
}
