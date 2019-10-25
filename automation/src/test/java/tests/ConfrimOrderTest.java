package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthenticateNewUserPage;
import pages.BlouseProductsPage;
import pages.CreateAccountPage;
import pages.DashBoardPage;
import pages.HomePage;
import pages.OrderPage;

public class ConfrimOrderTest extends TestBase {

	HomePage homeObject;
	CreateAccountPage CreateAccountObject;
	AuthenticateNewUserPage AuthenticateUserObject;
	DashBoardPage DashBoardPageObject;
	BlouseProductsPage BlouseProductsPageObject;
	OrderPage OrderPageObject;
	
	@Test(priority = 1, alwaysRun = true)
	public void createNewUserSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.OpenCreateUserPage();
		CreateAccountObject = new CreateAccountPage(driver);
		CreateAccountObject.CreateNewAccount("testsh126@test.com");
		Assert.assertTrue(
				CreateAccountObject.RegistrationMessage.getText().equalsIgnoreCase("Your personal information"));
	}

	@Test(dependsOnMethods = { "createNewUserSuccessfully" })
	public void authenticateNewUser() {
		AuthenticateUserObject = new AuthenticateNewUserPage(driver);
		AuthenticateUserObject.setBrowsername(browserNamee);
		AuthenticateUserObject.AuthenticateUser("jack", "jack", "test@1234", "1", "May", "1993", "company", "cairo",
				"cairo", "cairo", "Arizona", "11222", "United States", "hi this is test", "1234567", "122333333",
				"cairo");
		Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
	}

	@Test(dependsOnMethods = { "authenticateNewUser" })
	public void selectItemFromMenuWithHover() throws Exception {
		DashBoardPageObject = new DashBoardPage(driver);
		DashBoardPageObject.selectItemFromDropDownWithHover(driver);
		BlouseProductsPageObject = new BlouseProductsPage(driver);
		Assert.assertTrue(BlouseProductsPageObject.blousesTxt.getText().contains("BLOUSES"));
	}

	@Test(priority = 4)
	public void selectResultedProduct() throws Exception {
		BlouseProductsPageObject.selectResultedProduct(driver);
		Assert.assertTrue(BlouseProductsPageObject.productAddedTxt.getText()
				.contains("Product successfully added to your shopping cart"));
	}
	
	@Test(priority = 5)
	public void proceedProductOrder() throws Exception {
		OrderPageObject = new OrderPage(driver);
		OrderPageObject.proceedOrder(driver);
		Assert.assertTrue(OrderPageObject.sectionTxt.getText()
				.contains("PLEASE CHOOSE YOUR PAYMENT METHOD"));
	}
	
	@Test(priority = 6)
	public void confirmOrder(){
		OrderPageObject = new OrderPage(driver);
		OrderPageObject.confirmOrder(driver);
		Assert.assertTrue(OrderPageObject.orderConfirmationTxt.getText()
				.contains("ORDER CONFIRMATION"));
	}
}

