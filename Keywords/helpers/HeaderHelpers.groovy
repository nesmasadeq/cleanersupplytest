package helpers

import java.text.DecimalFormat

import com.kms.katalon.core.testobject.TestObject

import actions.HeaderActions
import internal.GlobalVariable
import models.Product
import validations.HeaderValidations

public class HeaderHelpers {

	/**
	 * Hover on Header tag
	 * @author nesma
	 */
	public static void hoveringTagsAndFormLink() {
		HeaderActions.hoverOnTagsAndFormsLink()
		HeaderValidations.verifyDisplayingTagsAndFormMenu()
		HeaderValidations.verifyTagsAndFormBackgroundColorChanged('rgb(255, 255, 255)')
		HeaderValidations.verifyTagsAndFormColorChanged('rgba(82, 36, 127, 1)')
	}

	/**
	 * Verify Cart in header is empty
	 * @author Eng. Amal Hamad
	 */
	public static void checkCartIsEmpty() {
		HeaderValidations.verifyCartCount('0')
		HeaderValidations.verifyCartLabel('Cart')
	}

	/**
	 * Calculate Cart products total
	 * @param cartProducts
	 * @return expectedCartTotal
	 * @author Eng. Amal Hamad
	 */
	public static String calculateCartTotal(Product... cartProducts) {
		System.out.println("cartProductsSize:" + cartProducts.length)
		double total = 0;
		for (Product product: cartProducts) {
			System.out.println("product:" +product.toString())
			int quantity = product.getQuantity()
			double price = ProductDetailsPageHelpers.getProductPriceByQuantity(quantity)
			product.setPrice(price)
			total += price * quantity
			System.out.println("Price: " + product.getPrice()  + " #Quantity:" + product.getQuantity())
		}
		String expectedCartTotal = new DecimalFormat("#.00").format(total)
		return (GlobalVariable.siteCurrency + expectedCartTotal)
	}
}
