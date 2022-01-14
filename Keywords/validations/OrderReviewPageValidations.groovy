package validations

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import helpers.GeneralHelpers
import internal.GlobalVariable
import items.OrderReviewPageItems

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

		assert shippingData.contains(GlobalVariable.companyFieldContent)
		assert shippingData.contains(GlobalVariable.firstName)
		assert shippingData.contains(GlobalVariable.lastName)
		assert shippingData.contains(GlobalVariable.address1)
		assert shippingData.contains(GlobalVariable.address2)
	}

	/**
	 * Verify order po match expected po
	 * @author Eng. Amal Hamad
	 */
	public static void verifyOrderPaymentData() {
		String paymentData = ""
		List<TestObject> paymentDataList = WebUI.findWebElements(OrderReviewPageItems.paymentData ,GlobalVariable.elementVisibilityTimeOut)

		for (WebElement element : paymentDataList) {
			TestObject object = WebUI.convertWebElementToTestObject(element)
			paymentData += WebUI.getText(object) + "\t"
		}

		System.out.println("Shipping:" + paymentData)

		String cardNumber = GlobalVariable.cardNumber.toString()
		assert paymentData.contains("Visa")
		assert paymentData.contains("**** " + cardNumber.substring(cardNumber.length() - 4))
		assert paymentData.contains(GlobalVariable.phone)
		assert paymentData.contains(GlobalVariable.ext)
	}

	public static void verifyPoInput() {
		assert GeneralHelpers.getFieldInputValue(OrderReviewPageItems.inputPo).equals(GlobalVariable.po)
	}

	/**
	 * Verify order comment match expected comment
	 * @author Eng. Amal Hamad
	 */
	public static void verifyCommentsInput() {
		assert GeneralHelpers.getFieldInputValue(OrderReviewPageItems.inputComments).equals(GlobalVariable.comment)
	}
}
