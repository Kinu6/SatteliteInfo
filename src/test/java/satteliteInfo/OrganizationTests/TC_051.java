package satteliteInfo.OrganizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import SatteliteInfo.GenericUtilities.BaseClass;
import SatteliteInfo.GenericUtilities.RetryAnalyserImplementation;
import SatteliteInfo.ObjectRepository.CreateNewOrganisationPage;
import SatteliteInfo.ObjectRepository.HomePage;
import SatteliteInfo.ObjectRepository.LoginPage;
import SatteliteInfo.ObjectRepository.OrganizationInfoPage;
import SatteliteInfo.ObjectRepository.OrganizationPage;

@Listeners (SatteliteInfo.GenericUtilities.ListernersImplementation.class)

public class TC_051 extends BaseClass {
	
	@Test (dataProvider = "readMyData", retryAnalyzer =SatteliteInfo.GenericUtilities.RetryAnalyserImplementation.class )
	public void reviewTest$TC_05(String ORGNAME, String INDUSTRY){
		
		String ORG= ORGNAME+jUtil.getRandomNumber();
		
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(INDUSTRY, ORG);
		
		wUtil.waitForPageLoad(driver);
		
		HomePage hp= new HomePage(driver);
		hp.clickOnOrganisationsLink();
		
		wUtil.waitForPageLoad(driver);
		OrganizationPage op = new OrganizationPage(driver);
		
		op.clickonCreateOrganisationLookupImage();
		wUtil.waitForElementToBeVisisble(driver, op.getCreateOrganizationsIcon());
		
		CreateNewOrganisationPage cno= new CreateNewOrganisationPage(driver);
		cno.createNewOrganisation(ORG, INDUSTRY);
		
		OrganizationInfoPage oip= new OrganizationInfoPage(driver);
		String text= oip.getOrgHeader();
		
		Assert.assertTrue(text.contains(ORG));
		
		Reporter.log("CREATED"+ ORG,true);
		
		wUtil.waitForPageLoad(driver);
		
	}
	
	@DataProvider(name= "readMyData")
	public Object[][] sendMydata() throws EncryptedDocumentException, IOException
	{
		Object [] [] data =eUtil.readDataFromExcelToDataProvider("DataProviderOrg");
		
		return data;
		
	}
	
	
	
	
	
}
