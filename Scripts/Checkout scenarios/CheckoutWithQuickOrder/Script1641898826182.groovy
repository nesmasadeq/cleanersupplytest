import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import actions.QuickActionActions as QuickActionActions
import helpers.GeneralHelpers as GeneralHelpers
import helpers.QuickActionsHelper as QuickActionsHelper
import internal.GlobalVariable as GlobalVariable
import models.Product as Product
import validations.GeneralValidations as GeneralValidations
import validations.QuickOrdersValidations as QuickOrdersValidations
import org.openqa.selenium.Keys as Keys

GeneralHelpers.initScenario()

QuickActionActions.hoverOverQuickActionIcon()

QuickOrdersValidations.verifyOnActiveIcon()

QuickActionActions.clickOverQuickActionIcon()

GeneralValidations.verifyCurrentPageTitleValue('Quick Order - Cleaner\'s Supply')

GeneralValidations.verifyCurrentPageURL('https://www.cleanersupply.com/quick-order/')

QuickOrdersValidations.verifyQuickOrderTabText()

QuickOrdersValidations.verifyDefaultQuickItemsCount()

QuickOrdersValidations.verifyAddMoreButtonExist()

QuickOrdersValidations.verifySKUFieldInEveryOrder()

int orders = QuickActionsHelper.fillOrders()

println("products count " + orders.size())
//QuickActionsHelper.fillOrders()

WebUI.closeBrowser()

