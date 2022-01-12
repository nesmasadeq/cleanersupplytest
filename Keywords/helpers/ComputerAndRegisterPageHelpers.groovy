package helpers

import actions.HeaderActions
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
		HeaderValidations.VerifyComputerAndRegisterColorChanged('rgba(82, 36, 127, 1)')
		GeneralValidations.verifyCurrentPageTitleValue("Computer & Register - Cleaner's Supply")
		GeneralValidations.verifyCurrentPageURL('Tags-Forms/Computer-Register')
		ComputerAndRegisterPageValidations.verfiyCurrentPageHeading('Computer & Register Tags & Forms')
		ComputerAndRegisterPageValidations.verifyBreadcrumbContent('Tags & Forms', 'Computer & Register')
	}
	
}
