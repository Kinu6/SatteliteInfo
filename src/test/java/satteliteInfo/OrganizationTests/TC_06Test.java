package satteliteInfo.OrganizationTests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import SatteliteInfo.GenericUtilities.BaseClass;
import SatteliteInfo.ObjectRepository.CreateNewOrganisationPage;
import SatteliteInfo.ObjectRepository.HomePage;
import SatteliteInfo.ObjectRepository.OrganizationInfoPage;
import SatteliteInfo.ObjectRepository.OrganizationPage;

public class TC_06Test extends BaseClass {
	@Test(groups = "smokeSuite")
	public void TC_06Test() throws IOException {

		String ORGNAME = eUtil.readDataFromExcelSheet("Organization", 7, 2) + jUtil.getRandomNumber();
		String INDUSTRYDD = eUtil.readDataFromExcelSheet("Organization", 7, 3);
		String TYPE = eUtil.readDataFromExcelSheet("Organization", 7, 4);

		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLnk().click();

		OrganizationPage cop = new OrganizationPage(driver);
		wUtil.waitForElementToBeClickabale(driver, cop.getCreateOrganizationsIcon());
		wUtil.waitForElementToBeVisisble(driver, cop.getCreateOrganizationsIcon());
		cop.getCreateOrganizationsIcon().click();

		CreateNewOrganisationPage cnop = new CreateNewOrganisationPage(driver);
		wUtil.waitForPageLoad(driver);
		cnop.getOrgNameTxt().sendKeys(ORGNAME);

		WebElement IND_DD = cnop.getIndustryDD();

		wUtil.handleDropDown(INDUSTRYDD, IND_DD);

		WebElement TYPE_DD = cnop.getTypeDD();
		wUtil.handleDropDown(TYPE_DD, TYPE);

		cnop.getSaveBtn().click();

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String HD_TEXT = oip.getOrgHeaderTxt().getText();

		Assert.assertEquals(HD_TEXT.contains(ORGNAME), true);

	}
	
	@Test
	public void demoTC_06() {
		System.out.println("Hi 06");
	}
}
