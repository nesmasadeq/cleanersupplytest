import helpers.FooterHelpers
import helpers.GeneralHelpers
import items.FooterItems
import models.AppConstants

//initial scenario
GeneralHelpers.initScenario()
FooterHelpers.verifyFooterItemContentAndClickability(FooterItems.exclusiveEmail,AppConstants.EXClUSIVE_EMAIL)