package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends PageBase {

	public DashBoardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#block_top_menu > ul > li:nth-child(1) > a")
	public WebElement womenHoverLink;

	@FindBy(xpath = "//div[@id='block_top_menu']//a[@title=\"Blouses\"]")
	public WebElement menuItemElement;
	
	@FindBy(xpath = "//div[@class='header_user_info']/a/span")
	public WebElement userName;
	
	@FindBy(xpath ="//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")
	public WebElement OrderHistoryTab;

	public void selectItemFromDropDownWithHover(WebDriver driver) throws Exception {
		selectItemWithHover(womenHoverLink, menuItemElement, driver);
	}
	
	public void gotoHistoryPage() {
		clickButton(userName);
		clickButton(OrderHistoryTab);
		
	}

}
