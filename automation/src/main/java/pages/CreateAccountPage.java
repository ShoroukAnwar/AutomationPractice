package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends PageBase {

	public CreateAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "email_create")
	WebElement emailAddressBox;

	@FindBy(id = "SubmitCreate")
	WebElement creatAccountBtn;

	@FindBy(css = "#account-creation_form > div:nth-child(1) > h3")
	public WebElement RegistrationMessage;

	public void CreateNewAccount(String emailAddress) {
		setTextInFields(emailAddressBox, emailAddress);
		clickButton(creatAccountBtn);

	}

}
