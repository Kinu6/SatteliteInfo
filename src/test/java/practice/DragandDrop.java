package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.xpath("//div[@id='box5']"));
		WebElement ele1 = driver.findElement(By.xpath("//div[@id='box105']"));
		Actions acton = new Actions(driver);
		acton.doubleClick(ele).perform();
		acton.dragAndDrop(ele, ele1).perform();
	}

}
