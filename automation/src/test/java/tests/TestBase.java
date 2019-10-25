package tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utils.Helper;

public class TestBase {
	public static WebDriver driver;
	public String browserNamee;

	@BeforeSuite
	@Parameters({ "browser" })
	public void startDriver(@Optional("chrome") String browserName) {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("ie")) {
			capabilities = DesiredCapabilities.internetExplorer();
			InternetExplorerDriverService service = new InternetExplorerDriverService.Builder()
					.usingDriverExecutable(new File(System.getProperty("user.dir") + "/drivers/IEDriverServer.exe"))
					.usingAnyFreePort().build();
			InternetExplorerOptions options = new InternetExplorerOptions();
			capabilities.setCapability("ignoreZoomSetting", true);
			capabilities.setCapability("nativeEvents", false);
			options.merge(capabilities);
			driver = new InternetExplorerDriver(service, options);
		}
		capabilities.setCapability("screenResolution", "1024x768");
		browserNamee = capabilities.getBrowserName();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
	}

	@AfterSuite
	public void stopDriver() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@AfterMethod
	public void screenshotOnFailure(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Test Case Fileure!, Taking Screenshot...");
			Helper.captureScreenshot(driver, result.getName());
		}
	}
	
	}

