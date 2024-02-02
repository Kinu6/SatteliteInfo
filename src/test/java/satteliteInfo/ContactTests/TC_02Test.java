package satteliteInfo.ContactTests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import SatteliteInfo.GenericUtilities.BaseClass;
import SatteliteInfo.ObjectRepository.ContactsInfoPage;
import SatteliteInfo.ObjectRepository.ContactsPage;
import SatteliteInfo.ObjectRepository.CreateNewContactPage;
import SatteliteInfo.ObjectRepository.CreateNewOrganisationPage;
import SatteliteInfo.ObjectRepository.HomePage;
import SatteliteInfo.ObjectRepository.OrganizationInfoPage;
import SatteliteInfo.ObjectRepository.OrganizationPage;


@Listeners(SatteliteInfo.GenericUtilities.ListernersImplementation.class)

public class TC_02Test extends BaseClass {

	@Test(groups = {"regionalRegression"})
	public void TC_02Test() throws IOException {

		String ORGNAME = eUtil.readDataFromExcelSheet("Contact", 4, 2) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcelSheet("Contact", 4, 3);

		// Create Organization
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLnk().click();

		OrganizationPage cop = new OrganizationPage(driver);
		cop.clickonCreateOrganisationLookupImage();

		CreateNewOrganisationPage nop = new CreateNewOrganisationPage(driver);
		nop.getOrgNameTxt().sendKeys(ORGNAME);
		nop.getSaveBtn().click();

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeaderTxt().getText();

		Assert.assertEquals(orgHeader.contains(ORGNAME), true);
		System.out.println(ORGNAME + " " + "Its Matched");

		// Contacts TAB
		wUtil.waitForPageLoad(driver);
		hp.getContactsLnk().click();

		ContactsPage ccp = new ContactsPage(driver);
		ccp.getCreateNewIcon().click();

		CreateNewContactPage ncp = new CreateNewContactPage(driver);
		ncp.getLastNameTxt().sendKeys(LASTNAME);
		wUtil.switchToWindow(driver, "Accounts");
		driver.switchTo().parentFrame();
		ncp.getSaveBtn().click();

		ContactsInfoPage cip = new ContactsInfoPage(driver);

		// Verification -
		String orginfo1 = cip.getContactHeader();
		Assert.assertEquals(orginfo1.contains(LASTNAME), true);

	}
}
