package SatteliteInfo.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SatteliteInfo.GenericUtilities.WebDriverUtility;

public class ContactsInfoPage {
	@FindBy(name = "Edit")
	WebElement editBtn;
	@FindBy(name = "Duplicate")
	WebElement duplicateBtn;
	@FindBy(name = "Delete")
	WebElement deleteBtn;
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	WebElement OrgHeaderTxt;

	public ContactsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getEditBtn() {
		return editBtn;
	}

	public WebElement getDuplicateBtn() {
		return duplicateBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	/**
	 * This Method returns the text of created contact Header
	 * 
	 * @return
	 */
	public String getContactHeader() {
		return OrgHeaderTxt.getText();
	}
}
