package SatteliteInfo.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import SatteliteInfo.ObjectRepository.HomePage;
import SatteliteInfo.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	// Step 1: Create Object of Generic Utilities
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();

	public WebDriver driver = null;

	public static WebDriver sDriver;

	@BeforeSuite(groups ="SmokeSuite")
	public void bsConfig() {
		System.out.println("----- database connection successful -----");
	}
	
	/*@Parameters("browser")
    @BeforeTest  //Parallel Execution */
	
	@BeforeClass(alwaysRun = true )	
    public void bcConfig(/*String BROWSER*/) throws IOException {

		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");

		// Step 3: Launch the Browser - RUNTIME POLYMORPHISM
		if (BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

			System.out.println("--- " + BROWSER + " launched ---");

		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			System.out.println("--- " + BROWSER + " launched ---");

		} else {
			System.out.println("invalid browser name");
		}
		sDriver = driver;// For Listeners
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);

	}

	@BeforeMethod(groups = "SmokeSuite")
	public void bmConfig() throws IOException {
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		System.out.println("--- Login to APP successful ---");
	}

	@AfterMethod(groups = "SmokeSuite")
	public void amConfig() {
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);

		System.out.println("--- logout of APP successful ---");
	}
    
	//@AfterTest
	@AfterClass(groups = "SmokeSuite")
	public void acConfig() {
		driver.quit();
		System.out.println("--- Browser closed ---");
	}

	@AfterSuite(groups = "SmokeSuite")
	public void asConfig() {
		System.out.println("----- database closed successfully -----");
	}

}
