package SatteliteInfo.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SatteliteInfo.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	@FindBy(linkText = "Organizations")
	WebElement OrganizationsLnk;
	@FindBy(linkText = "Contacts")
	WebElement ContactsLnk;
	@FindBy(linkText = "Oppurtunities")
	private WebElement OpprtunitiesLnk;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLnk;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpprtunitiesLnk() {
		return OpprtunitiesLnk;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}

	/**
	 * This Method will click on Organisation Link
	 */
	public void clickOnOrganisationsLink() {
		OrganizationsLnk.click();
	}

	/**
	 * This Method will click on Contacts Link
	 */
	public void clickOnContactsLink() {
		ContactsLnk.click();
	}

	/**
	 * This Method will perform Sign out operation
	 * 
	 * @param driver
	 */
	public void logoutOfApp(WebDriver driver) {
		mouseHoverAction(driver, AdministratorImg);
		SignOutLnk.click();
	}

}
