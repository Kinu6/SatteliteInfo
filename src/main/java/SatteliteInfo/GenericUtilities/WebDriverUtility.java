package SatteliteInfo.GenericUtilities;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic Methods related to WebDriver
 * 
 * @author kravi
 *
 */
public class WebDriverUtility {

	/**
	 * This Method is for Maximizing Window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This Method is for Minimizing Window
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	// POPUPS
	/**
	 * This Method is for Accepting Alert
	 * 
	 * @param driver
	 */

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This Method Dismisses Alert
	 * 
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This Method reads Alert
	 * 
	 * @param driver
	 * @return
	 */
	public String readAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	// Actions Class
	/**
	 * This Method double clicks at current Mouse Location
	 * 
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions acton = new Actions(driver);
		acton.doubleClick().perform();
	}

	/**
	 * This Method double Clicks at element
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions acton = new Actions(driver);
		acton.doubleClick(element).perform();
	}

	/**
	 * This Method helps to drag and drop a element at destined Location
	 * 
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions acton = new Actions(driver);
		acton.dragAndDrop(source, target).perform();
		;
	}

	/**
	 * This Method helps to right click on Element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions acton = new Actions(driver);
		acton.contextClick(element).perform();
	}

	/**
	 * This Method performs Right Click Action at current Location
	 * 
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver) {
		Actions acton = new Actions(driver);
		acton.contextClick().perform();
	}

	/**
	 * This Method Will perform the Mouse Hover Actions
	 * 
	 * @param driver
	 * @param ele
	 */
	public void mouseHoverAction(WebDriver driver, WebElement ele) {
		Actions acton = new Actions(driver);
		acton.moveToElement(ele).perform();
	}

	// Robot Class KeyBoard Actions
	public void pressEnterKey(WebDriver driver) throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}

	public void releaseEnterKey(WebDriver driver) throws AWTException {
		Robot r = new Robot();
		r.mouseRelease(KeyEvent.VK_ENTER);
	}

	// Sync
	/**
	 * This Method will wait 20 seconds for Page Load
	 * 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	/**
	 * This Method will wait until a particular WebElement is Visible
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisisble(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This Method will wait for a particular element to be Clickable
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickabale(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// FRAMES
	/**
	 * This Mehod handleFrame by Index
	 * 
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This Mehod handleFrame by Name or Id
	 * 
	 * @param driver
	 * @param nameorId
	 */
	public void handleFrame(WebDriver driver, String nameorId) {
		driver.switchTo().frame(nameorId);
	}

	/**
	 * This Mehod handleFrame by WebElement
	 * 
	 * @param driver
	 * @param elemet
	 */
	public void handleFrame(WebDriver driver, WebElement elemet) {
		driver.switchTo().frame(elemet);
	}

	/**
	 * This Method switch to parent Frame
	 * 
	 * @param driver
	 */
	public void handleParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/**
	 * This Mehod handleFrame by Defaultframe
	 * 
	 * @param driver
	 */
	public void handleDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	// Select Class
	/**
	 * This method will handle drop down by Index
	 * 
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * This method will handle drop down by value
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);

	}

	/**
	 * This method will handle drop down by Text
	 * 
	 * @param Text
	 * @param element
	 */

	public void handleDropDown(String Text, WebElement element) {
		Select sel = new Select(element);
		sel.selectByValue(Text);
	}

	/**
	 * This Method De-selects the Selection
	 * 
	 * @param Text
	 * @param element
	 */
	public void deSelectDropDown(String Text, WebElement element) {
		Select sel = new Select(element);
		sel.deselectByVisibleText(Text);
	}

	/**
	 * This Method will scroll downwards
	 * 
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "null");
	}

	/**
	 * This Method scroll upto a webElement
	 * 
	 * @param driver
	 * @param element
	 */

	public void scrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollby(0," + y + ")", element);
	}

	/**
	 * This Method will take screenshot and save it in screenshot Folder
	 * 
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String takesScreenShot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File((".\\Screenshots\\") + screenshotName + ".png");
		FileUtils.copyFile(src, dest); // Commons IO Dependency

		return dest.getAbsolutePath(); // Used for Extent Reports
	}

	/**
	 * This Method will perform switching Windows
	 * 
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle) {
		// Switch 1: Capture all the window IDs
		Set<String> winIDs = driver.getWindowHandles();
		// Switch 2: Navigate to each window
		for (String win : winIDs) {
			// Step3: Switch to window and capture the title
			String winTitle = driver.switchTo().window(win).getTitle();
			// Step 4: Compare the title with required partial title
			if (winTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}

}
