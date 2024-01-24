package satteliteInfo.ContactTests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import SatteliteInfo.GenericUtilities.BaseClass;
import SatteliteInfo.ObjectRepository.ContactsInfoPage;
import SatteliteInfo.ObjectRepository.ContactsPage;
import SatteliteInfo.ObjectRepository.CreateNewContactPage;
import SatteliteInfo.ObjectRepository.HomePage;

@Listeners(SatteliteInfo.GenericUtilities.ListernersImplementation.class)

public class TC_01Test extends BaseClass {
	@Test(groups = "SmokeSuite")
	public void TC_01() throws IOException {

		String LASTNAME = eUtil.readDataFromExcelSheet("Contact", 1, 2);

		HomePage hp = new HomePage(driver);
		wUtil.waitForPageLoad(driver);
		hp.getContactsLnk().click();
        Reporter.log("Naviated to contacts link");
		ContactsPage ccp = new ContactsPage(driver);
		wUtil.waitForPageLoad(driver);
		ccp.getCreateNewIcon().click();
		Reporter.log("Naviated to create new link");
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		wUtil.waitForPageLoad(driver);
		cncp.getLastNameTxt().sendKeys(LASTNAME);
		cncp.getSaveBtn().click();
		Reporter.log("Naviated to last name",true);
		ContactsInfoPage cip = new ContactsInfoPage(driver);
        Assert.fail();
		String orginfo = cip.getContactHeader();
		Assert.assertEquals(orginfo.contains(LASTNAME), true);

	}
	@Test
	public void demoTest() {
		System.out.println("IMPACTED AREAS");
	}
}
