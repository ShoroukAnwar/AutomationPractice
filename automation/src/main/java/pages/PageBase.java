package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	protected static WebDriver driver;

	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	protected static void clickButton(WebElement button) {
		button.click();

	}

	protected static void setTextInFields(WebElement textElement, String textValue) {
		textElement.sendKeys(textValue);
	}

	public Select getSelectOptions(WebElement dropdownList) {
		return new Select(dropdownList);
	}

	public void selectItemWithHover(WebElement womenHoverLink, WebElement menuItemElement, WebDriver driver)
			throws Exception {
		Actions actions = new Actions(driver);
		actions.clickAndHold(womenHoverLink).build().perform();
		WebElement menuItem = new WebDriverWait(driver, 8)
				.until(ExpectedConditions.elementToBeClickable(menuItemElement));
		menuItem.click();
	}

	public void waitElement(WebElement Element , WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}

	public Boolean hasEmptyField(WebElement field) {
		String webElemnt = field.getAttribute("value");
		return webElemnt.isEmpty();

	}

}
