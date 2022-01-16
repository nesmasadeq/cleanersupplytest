import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import actions.FooterActions
import actions.Navigations
import helpers.FooterHelpers
import helpers.GeneralHelpers
import items.FooterItems
import models.AppConstants
import validations.FooterValidations
import validations.GeneralValidations

//initial scenario
GeneralHelpers.initScenario()

//verify execlusive email title
FooterValidations.verifyItemContent(FooterItems.exclusiveEmail,AppConstants.EXClUSIVE_EMAIL)

//verify execlusive email description
FooterValidations.verifyItemContent(FooterItems.getSpecial,AppConstants.EXClUSIVE_EMAIL_DESCRIPTION)

//verify filling newsletter email
FooterActions.fillingNewsLetterEmail()

//verify clicking on sign up button
FooterActions.clickOnFooterItem(FooterItems.signUpButton)

//verify success message displayed
FooterValidations.verifySignUpSuccessMessage()

//verify follow us content
FooterValidations.verifyItemContent(FooterItems.followUs,AppConstants.FOLLOW_US)

//verify social media links
FooterHelpers.verifySocialLinks()

//verify connect with us title
FooterValidations.verifyItemContent(FooterItems.connectWithUs,AppConstants.CONNECT_WITH_US)

//verify contact email
FooterValidations.verifyItemContent(FooterItems.contactEmail,AppConstants.CONTACT_EMAIL)

//verify clicking on contact email link
FooterActions.clickOnFooterItem(FooterItems.contactEmail)

//verify url and title then close window
//FooterHelpers.newWindowVlidations(AppConstants.CONTACT_EMAIL)

//return to default content
//WebUI.switchToDefaultContent()

//verify contact time content
FooterValidations.verifyItemContent(FooterItems.contactTime,AppConstants.CONTACT_TIME)

//verify speaker content
FooterHelpers.verifyContactSpeakers(AppConstants.ENGLISH_SPEAKER,AppConstants.KOREAN_SPEAKER,AppConstants.ITERNATIONAL_SPEAKER)

//verify chat offline content
FooterValidations.verifyItemContent(FooterItems.chatOffline,AppConstants.CHAT_OFFLINE)

//verify the links in the center of footer
//FooterValidations.varifyFooterNavigationsLinks()

//return to home page
//Navigations.navigateToHomePage()

//verify request catalog
FooterValidations.verifyItemContent(FooterItems.catalogRequest,AppConstants.CATALOG_REQUEST)

//verify underline style
//GeneralValidations.verifyLinkUnderlineHover(FooterItems.catalogRequest)

//click in request catalog link
FooterActions.clickOnFooterItem(FooterItems.catalogRequest)

//verify url title, and heading
GeneralHelpers.CheckingPageURLTitleAndHeading(AppConstants.REQUEST_CATALOG_URL,AppConstants.REQUEST_CATALOG_TITLE
	,AppConstants.REQUEST_CATALOG_HEADING)

//return to home page
Navigations.navigateToHomePage()

//verify free calssifide content
FooterValidations.verifyItemContent(FooterItems.classified,AppConstants.FREE_CLASSIFIDES)

//click on classified link
FooterActions.clickOnFooterItem(FooterItems.classified)

//verify url title, and heading
GeneralHelpers.CheckingPageURLTitleAndHeading(AppConstants.CLASSIFIDE_URL,AppConstants.CLASSIFIDE_TITLE
	,AppConstants.CLASSIFIDE_HEADING)

//return to home page
Navigations.navigateToHomePage()

//select region
FooterActions.selectRegion()

//verify the selected value is reflected
FooterValidations.verifySelectedRegion()

//verify region flag visibility
FooterValidations.verifyRegionFlagIChanged()

//verify the current url changed
GeneralValidations.verifyCurrentPageURL(AppConstants.CANADA_SELECT_VALUE)

//verify info helper in header changed
FooterValidations.verifyInfoHelperChange()

//click on feedback button
FooterActions.clickOnFooterItem(FooterItems.feadbackButton)

//verify modal feedback visibility
FooterValidations.verifyFeedbackModalDisplayed()

//click on close button
FooterActions.clickOnFooterItem(FooterItems.closeModalButton)

//verify modal feedback invisible
FooterValidations.verifyFeedbackModalDisappeared()

//verify simple footer content
FooterValidations.verifySimpleFooterContent(AppConstants.COPY_RIGHTS,AppConstants.TERM_OF_USE,AppConstants.POLICY)

//verify click on terms link
FooterActions.clickOnFooterItem(FooterItems.termsLink)

//verify url title, and heading
GeneralHelpers.CheckingPageURLTitleAndHeading(AppConstants.TERMS_URL,AppConstants.TERMS_TITLE
	,AppConstants.TERMS_HEADING)

//return to home page
Navigations.navigateToHomePage()

//verify click on policy link
FooterActions.clickOnFooterItem(FooterItems.policyLink)

//verify url title, and heading
GeneralHelpers.CheckingPageURLTitleAndHeading(AppConstants.POLICY_URL,AppConstants.POLICY_TITLE
	,AppConstants.POLICY_HEADING)

//close browser
WebUI.closeBrowser()