package validations

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import helpers.GeneralHelpers
import internal.GlobalVariable
import items.OrderReviewPageItems
import models.AppConstants

public class OrderReviewPageValidations {

	/**
	 * Verify order shipping data match expected data
	 * @author Eng. Amal Hamad
	 */
	public static void verifyOrderShippingData() {
		String shippingData = ""
		List<TestObject> shippingDataList = WebUI.findWebElements(OrderReviewPageItems.shippingData ,GlobalVariable.elementVisibilityTimeOut)

		for (WebElement element : shippingDataList) {
			TestObject object = WebUI.convertWebElementToTestObject(element)
			shippingData += WebUI.getText(object) + "\t"
		}

		System.out.println("Shipping:" + shippingData)

		assert shippingData.contains(AppConstants.CHECKOUT_COMPANY)
		assert shippingData.contains(AppConstants.CHECKOUT_FNAME)
		assert shippingData.contains(AppConstants.CHECKOUT_LNAME)
		assert shippingData.contains(AppConstants.CHECKOUT_ADDRESS_1)
		assert shippingData.contains(AppConstants.CHECKOUT_ADDRESS_2)
	}

	/**
	 * Verify order po match expected po
	 * @author Eng. Amal Hamad
	 */
	public static void verifyOrderPaymentData(String selectedMonth , String selectedYear) {
		String paymentData = ""
		List<TestObject> paymentDataList = WebUI.findWebElements(OrderReviewPageItems.paymentData ,GlobalVariable.elementVisibilityTimeOut)

		for (WebElement element : paymentDataList) {
			TestObject object = WebUI.convertWebElementToTestObject(element)
			paymentData += WebUI.getText(object) + "\t"
		}

		System.out.println("Shipping:" + paymentData)

		String cardNumber = AppConstants.CHECKOUT_CARD_NUMBER.toString()
		//		String cardNumber = "4444444444444444"
		assert paymentData.contains("Visa")
		assert paymentData.contains("**** " + cardNumber.substring(cardNumber.length() - 4))
		assert paymentData.contains(AppConstants.CHECKOUT_PHONE)
		assert paymentData.contains(AppConstants.CHECKOUT_EXT)
		assert paymentData.contains(selectedMonth + "/" + selectedYear.substring(selectedYear.length() - 2))
	}

	public static void verifyPoInput() {
		assert GeneralHelpers.getFieldInputValue(OrderReviewPageItems.inputPo).equals(AppConstants.CHECKOUT_PO)
	}

	/**
	 * Verify order comment match expected comment
	 * @author Eng. Amal Hamad
	 */
	public static void verifyCommentsInput() {
		assert GeneralHelpers.getFieldInputValue(OrderReviewPageItems.inputComments).equals(AppConstants.CHECKOUT_COMMENT)
	}
}
