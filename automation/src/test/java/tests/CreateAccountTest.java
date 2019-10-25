package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.HomePage;

public class CreateAccountTest extends TestBase {

	HomePage homeObject;
	CreateAccountPage CreateAccountObject;

	@Test(priority = 1, alwaysRun = true)
	public void createNewUserSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.OpenCreateUserPage();
		CreateAccountObject = new CreateAccountPage(driver);
		CreateAccountObject.CreateNewAccount("testsh20@test.com");
		Assert.assertTrue(
				CreateAccountObject.RegistrationMessage.getText().equalsIgnoreCase("Your personal information"));
	}

}
