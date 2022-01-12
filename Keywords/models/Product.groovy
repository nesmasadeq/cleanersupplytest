package models

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.security.PublicKey

import javax.persistence.metamodel.StaticMetamodel

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

public class Product {

	private String href;
	private String title;
	private String image;
	private String sku;
	private double minPrice;
	private double maxPrice;
	private double minList;
	private double maxList;
	private String optionSize;
	private String optionColor;
	private int qustionsAnswerCount;

	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public double getMinList() {
		return minList;
	}
	public void setMinList(double minList) {
		this.minList = minList;
	}
	public double getMaxList() {
		return maxList;
	}
	public void setMaxList(double maxList) {
		this.maxList = maxList;
	}
	public String getOptionSize() {
		return optionSize;
	}
	public void setOptionSize(String optionSize) {
		this.optionSize = optionSize;
	}
	public String getOptionColor() {
		return optionColor;
	}
	public void setOptionColor(String optionColor) {
		this.optionColor = optionColor;
	}
	public int getQustionsAnswerCount() {
		return qustionsAnswerCount;
	}
	public void setQustionsAnswerCount(int qustionsAnswerCount) {
		this.qustionsAnswerCount = qustionsAnswerCount;
	}
	@Override
	public String toString() {
		return "Product [href=" + href + "\n, title=" + title + "\n, image=" + image + "\n, sku=" + sku + "\n, minPrice="
		+ minPrice + "\n, maxPrice=" + maxPrice + "\n, minList=" + minList + "\n, maxList=" + maxList
		+ "\n, optionSize=" + optionSize + "\n, optionColor=" + optionColor + "\n, qustionsAnswerCount="
		+ qustionsAnswerCount + "]";
	}
}
