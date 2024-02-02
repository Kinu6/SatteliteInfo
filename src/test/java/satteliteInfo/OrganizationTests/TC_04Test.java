package satteliteInfo.OrganizationTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import SatteliteInfo.GenericUtilities.BaseClass;
import SatteliteInfo.ObjectRepository.CreateNewOrganisationPage;
import SatteliteInfo.ObjectRepository.HomePage;
import SatteliteInfo.ObjectRepository.OrganizationInfoPage;
import SatteliteInfo.ObjectRepository.OrganizationPage;

import java.io.IOException;
import org.testng.Assert;

@Listeners(SatteliteInfo.GenericUtilities.ListernersImplementation.class)
public class TC_04Test extends BaseClass {
	@Test(retryAnalyzer = SatteliteInfo.GenericUtilities.RetryAnalyserImplementation.class)
	public void TC_04Test() throws IOException, InterruptedException {

		String ORGNAME = eUtil.readDataFromExcelSheet("Organization", 1, 2) + jUtil.getRandomNumber();
		
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLnk().click();
        
		OrganizationPage cop = new OrganizationPage(driver);
		wUtil.waitForElementToBeVisisble(driver,  cop.getCreateOrganizationsIcon());
		wUtil.waitForElementToBeClickabale(driver, cop.getCreateOrganizationsIcon());
		cop.getCreateOrganizationsIcon().click();
        
		Thread.sleep(2000);
		CreateNewOrganisationPage cno = new CreateNewOrganisationPage(driver);
		wUtil.waitForElementToBeClickabale(driver, cno.getOrgNameTxt());
		cno.getOrgNameTxt().sendKeys(ORGNAME);
		cno.getSaveBtn().click();

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		wUtil.waitForElementToBeVisisble(driver, oip.getOrgHeaderTxt());

		String orginfo = oip.getOrgHeader();

		Assert.assertEquals(orginfo.contains(ORGNAME), true);
		System.out.println("Hi its " + ORGNAME);
	}

	@Test
	public void demo() {
		System.out.println("DEMO T.S");
	}

}
