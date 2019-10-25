package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends PageBase {

	public OrderHistoryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#order-list > tbody > tr.first_item > td.history_link.bold.footable-first-column > a")
	public WebElement orderHistory;
	
	

}