package satteliteInfo.OrganizationTests;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import SatteliteInfo.GenericUtilities.BaseClass;
import SatteliteInfo.ObjectRepository.CreateNewOrganisationPage;
import SatteliteInfo.ObjectRepository.HomePage;
import SatteliteInfo.ObjectRepository.OrganizationInfoPage;
import SatteliteInfo.ObjectRepository.OrganizationPage;

public class TC_05Test extends BaseClass {

	@Test(groups= {"regionalRegression"},dataProvider = "OrgWithIndustry")
	
	public void TC_04Test(String ORGNAME1, String INDUSTRY) throws EncryptedDocumentException, IOException {
		
		String ORGNAME = ORGNAME1+ jUtil.getRandomNumber();

		HomePage hp = new HomePage(driver);
		wUtil.waitForElementToBeVisisble(driver, hp.getOrganizationsLnk());
		hp.getOrganizationsLnk().click();

		OrganizationPage cop = new OrganizationPage(driver);
		
		wUtil.waitForElementToBeClickabale(driver, cop.getCreateOrganizationsIcon());
		wUtil.waitForElementToBeVisisble(driver, cop.getCreateOrganizationsIcon());
		
		cop.getCreateOrganizationsIcon().click();

		CreateNewOrganisationPage cnop = new CreateNewOrganisationPage(driver);
		cnop.getOrgNameTxt().sendKeys(ORGNAME);

		WebElement IND_DD = cnop.getIndustryDD();

		wUtil.handleDropDown(INDUSTRY, IND_DD);
		cnop.getSaveBtn().click();

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		wUtil.waitForElementToBeVisisble(driver, oip.getOrgHeaderTxt());
		String HD_TEXT = oip.getOrgHeaderTxt().getText();

		Assert.assertTrue(HD_TEXT.contains(ORGNAME));
	}
	
	@DataProvider(name="OrgWithIndustry")
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		Object [][] data=eUtil.readDataFromExcelToDataProvider("DataProviderOrg");
		return data;
	}
	
	@Test()
	public void demoTest04() {
		System.out.println("Hey i want to print TC04");
	}
	
}
