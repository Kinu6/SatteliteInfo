package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC_03 {

	public static void main(String[] args) {
		// Step 1: Launch Browser
		String key = "webdriver.gecko.driver",
				value = "C:\\Users\\kravi\\Downloads\\Compressed\\geckodriver-v0.33.0-win64\\geckodriver.exe";
		System.setProperty(key, value);

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");

		// Step 2: Login to application with valid credentials
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		// Step 3: Navigate to Organizations link

		driver.findElement(By.linkText("Organizations")).click();

		// Step 4: Click on Create Organization look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		// Step 5: Create Organization with Mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("Keerthi_Constructions1");

		// Step 6: Select "Chemicals" in the industry drop down
		WebElement ele = driver.findElement(By.name("industry"));
		Select sel = new Select(ele);
		sel.selectByValue("Chemicals");

		// Step 7: Save and Verify
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		String value1 = driver.findElement(By.xpath("//span[.='Keerthi_Constructions1']")).getText();

		if (value1.contains("Keerthi_Constructions1")) {
			System.out.println("Its Matched");
		} else {
			System.out.println("Not Matched");
		}
		// Step 7: logout of Application
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions acton = new Actions(driver);
		acton.moveToElement(ele1).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Sign out");

	}

}
