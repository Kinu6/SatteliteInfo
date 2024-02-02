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
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.beust.jcommander.Parameter;

import SatteliteInfo.ObjectRepository.HomePage;
import SatteliteInfo.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(SatteliteInfo.GenericUtilities.ListernersImplementation.class)

public class BaseClass {
	// Step 1: Create Object of Generic Utilities
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	
	public WebDriver driver = null;
	public static WebDriver sDriver;

	@BeforeSuite(groups={"smokeSuite","regionalRegression"})
	public void bsConfig() {
		System.out.println("----- database connection successful -----");
	}
	
	/*@Parameters("browser")
	@BeforeTest */ 
	
	@BeforeClass(groups={"smokeSuite","regionalRegression"})
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

	@BeforeMethod(groups={"smokeSuite","regionalRegression"}) 
	public void bmConfig() throws IOException {
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		System.out.println("--- Login to APP successful ---");
	}

	
	@AfterMethod(groups={"smokeSuite","regionalRegression"}) //@Test(retryAnalyzer = SatteliteInfo.GenericUtilities.RetryAnalyserImplementation.class)
	
	public void amConfig() {
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("--- logout of APP successful ---");
	}
    
	//@AfterTest for DP and Cross Browser
	@AfterClass(groups={"smokeSuite","regionalRegression"})
	public void acConfig() {
		driver.quit();
		System.out.println("--- Browser closed ---");
	}

	@AfterSuite(groups={"smokeSuite","regionalRegression"})
	public void asConfig() {
		System.out.println("----- database closed successfully -----");
	}

}
