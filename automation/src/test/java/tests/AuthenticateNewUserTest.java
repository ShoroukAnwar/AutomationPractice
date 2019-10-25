package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AuthenticateNewUserPage;
import pages.CreateAccountPage;
import pages.DashBoardPage;
import pages.HomePage;

public class AuthenticateNewUserTest extends TestBase {

	HomePage homeObject;
	CreateAccountPage CreateAccountObject;
	AuthenticateNewUserPage AuthenticateUserObject;
	DashBoardPage DashBoardPageObject;

	@Test(priority = 1, alwaysRun = true)
	public void createNewUserSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.OpenCreateUserPage();
		CreateAccountObject = new CreateAccountPage(driver);
		CreateAccountObject.CreateNewAccount("testsh99@test.com");
		Assert.assertTrue(
				CreateAccountObject.RegistrationMessage.getText().equalsIgnoreCase("Your personal information"));
	}

	@Test(dependsOnMethods = { "createNewUserSuccessfully" })
	public void authenticateNewUser() {
		System.out.println("i am herer");
		AuthenticateUserObject = new AuthenticateNewUserPage(driver);
		AuthenticateUserObject.setBrowsername(browserNamee);
		AuthenticateUserObject.AuthenticateUser("jack", "jack", "test@1234", "1", "May", "1993", "company", "cairo",
				"cairo", "cairo", "Arizona", "11222", "United States", "hi this is test", "1234567", "122333333",
				"cairo");
		Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
	}
}
