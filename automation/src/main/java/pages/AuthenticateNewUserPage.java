package pages;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticateNewUserPage extends PageBase {
	public AuthenticateNewUserPage(WebDriver driver) {
		super(driver);
	}

	public String browsername;

	Method method;

	public String getBrowsername() {
		return browsername;
	}

	public void setBrowsername(String browsername) {
		this.browsername = browsername;
	}

	@FindBy(id = "id_gender2")
	WebElement genderRdoBtn;

	@FindBy(id = "customer_firstname")
	WebElement firstNameTxtBox;

	@FindBy(id = "customer_lastname")
	WebElement lasttNameTxtBox;

	@FindBy(id = "email")
	WebElement emailTxtBox;

	@FindBy(id = "passwd")
	WebElement passwordTxtBox;

	@FindBy(id = "days")
	WebElement daysDropDown;

	@FindBy(id = "months")
	WebElement monthsDropDown;

	@FindBy(id = "years")
	WebElement yearsDropDown;

	@FindBy(id = "newsletter")
	WebElement newsletterCheckBox;

	@FindBy(id = "optin")
	WebElement offersCheckBox;

	@FindBy(css = ".form-control#firstname")
	WebElement addFirstNameTxtBox;

	@FindBy(css = ".form-control#lastname")
	WebElement addLastNameTxtBox;

	@FindBy(id = "company")
	WebElement companyTxtBox;

	@FindBy(id = "address1")
	WebElement addressLine1TxtBox;

	@FindBy(id = "address2")
	WebElement addressLine2TxtBox;

	@FindBy(id = "city")
	WebElement cityTxtBox;

	@FindBy(id = "id_state")
	WebElement stateDropDown;

	@FindBy(id = "postcode")
	WebElement postcodeTxtBox;

	@FindBy(id = "id_country")
	WebElement countryDropDown;

	@FindBy(id = "other")
	WebElement addInfoTxtBox;

	@FindBy(id = "phone")
	WebElement homePhoneTxtBox;

	@FindBy(id = "phone_mobile")
	WebElement mobilePhoneTxtBox;

	@FindBy(id = "alias")
	WebElement aliasTxtBox;

	@FindBy(id = "submitAccount")
	WebElement registerBtn;

	public void setOption(WebElement dropdownList, String value) {
		if (getBrowsername().equalsIgnoreCase("internet explorer")) {
			getSelectOptions(dropdownList).selectByVisibleText(value);

		} else {
			getSelectOptions(dropdownList).getOptions().parallelStream()
					.filter(option -> option.getAttribute("textContent").toLowerCase().contains(value.toLowerCase()))
					.findFirst().ifPresent(option -> getSelectOptions(dropdownList)
							.selectByVisibleText(option.getAttribute("textContent")));
		}
	}

	public void AuthenticateUser(String firstName, String lastName, String password, String day, String month,
			String year, String companyName, String addressLine1, String addressLine2, String city, String state,
			String postcode, String country, String addInfo, String homePhone, String mobilePhone, String alias) {

		clickButton(genderRdoBtn);
		setTextInFields(firstNameTxtBox, firstName);
		setTextInFields(lasttNameTxtBox, lastName);
		setTextInFields(passwordTxtBox, password);
		setOption(daysDropDown, day);
		setOption(monthsDropDown, month);
		setOption(yearsDropDown, year);
		clickButton(newsletterCheckBox);
		clickButton(offersCheckBox);
		setTextInFields(companyTxtBox, companyName);
		setTextInFields(addressLine1TxtBox, addressLine1);
		setTextInFields(addressLine2TxtBox, addressLine2);
		setTextInFields(cityTxtBox, city);
		setOption(stateDropDown, state);
		setTextInFields(postcodeTxtBox, postcode);
		setOption(countryDropDown, country);
		setTextInFields(addInfoTxtBox, addInfo);
		setTextInFields(homePhoneTxtBox, homePhone);
		setTextInFields(mobilePhoneTxtBox, mobilePhone);
		setTextInFields(aliasTxtBox, alias);
		clickButton(registerBtn);
	}
}
