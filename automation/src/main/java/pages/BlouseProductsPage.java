package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlouseProductsPage extends PageBase {

	public BlouseProductsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")
	WebElement addToCartBtn;

	@FindBy(xpath = "//div[@class=\"layer_cart_product col-xs-12 col-md-6\"]//h2")
	public WebElement productAddedTxt;

	@FindBy(xpath = "//span[@class=\"cat-name\"]")
	public WebElement blousesTxt;

	@FindBy(css = ".product-container")
	WebElement productContainer;
	
	

	public void selectResultedProduct(WebDriver driver) throws Exception {
		waitElement(productContainer, driver);
		selectItemWithHover(productContainer, addToCartBtn, driver);
		waitElement(productAddedTxt, driver);
		// clickButton(addToCartBtn);
	}

}
