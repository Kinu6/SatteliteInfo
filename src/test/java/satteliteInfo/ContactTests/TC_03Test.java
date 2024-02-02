package satteliteInfo.ContactTests;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import SatteliteInfo.GenericUtilities.BaseClass;
import SatteliteInfo.ObjectRepository.ContactsInfoPage;
import SatteliteInfo.ObjectRepository.ContactsPage;
import SatteliteInfo.ObjectRepository.CreateNewContactPage;
import SatteliteInfo.ObjectRepository.HomePage;

public class TC_03Test extends BaseClass {

	@Test ()
	public void TC_03Test() throws IOException, InterruptedException {

		String LASTNAME = eUtil.readDataFromExcelSheet("Contact", 7, 2);
		String LEAD_DD = eUtil.readDataFromExcelSheet("Contact", 7, 3);

		HomePage hp = new HomePage(driver);
		hp.getContactsLnk().click();
		
		ContactsPage ccp = new ContactsPage(driver);
		wUtil.waitForPageLoad(driver);
		ccp.getCreateNewIcon().click();
        
        wUtil.waitForElementToBeVisisble(driver, ccp.getCreateNewIcon());
        
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		wUtil.waitForPageLoad(driver);
		cncp.getLastNameTxt().sendKeys(LASTNAME);

		WebElement leadEle = cncp.getLeadDD();
		wUtil.handleDropDown(LEAD_DD, leadEle);
		;
		cncp.getSaveBtn().click();

		ContactsInfoPage cip = new ContactsInfoPage(driver);

		// Verification -
		String orginfo = cip.getContactHeader();

		Assert.assertEquals(orginfo.contains(LASTNAME), true);
	}

}
