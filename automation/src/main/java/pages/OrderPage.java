package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends PageBase {

	public OrderPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	WebElement proceedCheckOutBtn;

	@FindBy(xpath = "//p//a[@title='Proceed to checkout']")
	WebElement summaryCheckOutBtn;

	@FindBy(xpath = "//button[@name='processAddress']")
	WebElement addressCheckOutBtn;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement shippingCheckBox;

	@FindBy(xpath = "//button[@name='processCarrier']")
	WebElement shippingCheckOutBtn;

	@FindBy(css = ".page-heading")
	public WebElement sectionTxt;

	@FindBy(css = ".bankwire")
	WebElement bankWireBtn;

	@FindBy(xpath = "//p/button[@type=\"submit\"]")
	WebElement confirmOrderBtn;

	@FindBy(css = ".page-heading")
	public WebElement orderConfirmationTxt;

	@FindBy(css = "#center_column > div")
	WebElement orderReference;

	public String orderReferenceNum;

	public void proceedOrder(WebDriver driver) {
		waitElement(proceedCheckOutBtn, driver);
		clickButton(proceedCheckOutBtn);
		clickButton(summaryCheckOutBtn);
		clickButton(addressCheckOutBtn);
		clickButton(shippingCheckBox);
		clickButton(shippingCheckOutBtn);
		waitElement(sectionTxt, driver);
	}

	public void confirmOrder(WebDriver driver) {
		clickButton(bankWireBtn);
		clickButton(confirmOrderBtn);
		waitElement(orderReference, driver);
		orderReferenceNum =  orderReference.getAttribute("textContent");
	}

}
