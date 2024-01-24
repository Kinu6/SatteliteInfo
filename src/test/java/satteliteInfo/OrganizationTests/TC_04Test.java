package satteliteInfo.OrganizationTests;

import org.testng.annotations.Test;
import SatteliteInfo.GenericUtilities.BaseClass;
import SatteliteInfo.ObjectRepository.CreateNewOrganisationPage;
import SatteliteInfo.ObjectRepository.HomePage;
import SatteliteInfo.ObjectRepository.OrganizationInfoPage;
import SatteliteInfo.ObjectRepository.OrganizationPage;

import java.io.IOException;
import org.testng.Assert;

public class TC_04Test extends BaseClass {
	@Test()
	public void TC_04Test() throws IOException {

		String ORGNAME = eUtil.readDataFromExcelSheet("Organization", 1, 2) + jUtil.getRandomNumber();
		HomePage hp = new HomePage(driver);
		wUtil.waitForElementToBeVisisble(driver, hp.getOrganizationsLnk());
		hp.getOrganizationsLnk().click();

		OrganizationPage cop = new OrganizationPage(driver);
		wUtil.waitForElementToBeVisisble(driver, cop.getCreateOrganizationsIcon());
		cop.getCreateOrganizationsIcon().click();

		CreateNewOrganisationPage cno = new CreateNewOrganisationPage(driver);
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
