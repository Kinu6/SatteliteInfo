package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import SatteliteInfo.ObjectRepository.ContactsInfoPage;
import SatteliteInfo.ObjectRepository.ContactsPage;
import SatteliteInfo.ObjectRepository.CreateNewContactPage;
import SatteliteInfo.ObjectRepository.HomePage;
import SatteliteInfo.ObjectRepository.LoginPage;

public class TC_01 {

	public static void main(String[] args) throws InterruptedException {
		// Step 1: Launch Browser
		String key = "webdriver.gecko.driver",
				value = "C:\\Users\\kravi\\Downloads\\Compressed\\geckodriver-v0.33.0-win64\\geckodriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");

		// Step 2: Login to application with valid credentials
		SatteliteInfo.ObjectRepository.LoginPage lp = new LoginPage(driver);
		lp.loginToApp("admin", "admin");

		// Step 3: Navigate to Contacts link
		HomePage hp = new HomePage(driver);
		hp.getContactsLnk().click();

		Thread.sleep(5000);

		// Step 4: Click on Create contact look Up Image
		ContactsPage ccp = new ContactsPage(driver);
		ccp.getCreateNewIcon().click();

		// Step 5: Create Contact with Mandatory fields
		CreateNewContactPage ncp = new CreateNewContactPage(driver);
		ncp.getLastNameTxt().sendKeys(" Anmol Keshri ");

		// Step 6: Save and Verify
		ncp.getSaveBtn().click();

		ContactsInfoPage cip = new ContactsInfoPage(driver);

		String value1 = cip.getContactHeader();

		if (value1.contains("Anmol Keshri")) {
			System.out.println("Its Matched");
		} else {
			System.out.println("Not Matched");
		}
		// Step 7: logout of Application
		hp.logoutOfApp(driver);

		System.out.println("Sign out");

	}

}
