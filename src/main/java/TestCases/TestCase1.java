package TestCases;

import DataReader.MRAForm.DataReader;
import constants.Constants;
import model.MRAForm.BusinessImpactDetail;
import model.MRAForm.ContactDetail;
import model.MRAForm.Cost.CostDetail;
import model.MRAForm.EligibilityDetail;
import model.LoginDetail;
import model.MRAForm.ProposalDetail;
import modules.MRAForm.*;
import modules.ManualLogin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CustomChromeDriver;
import util.PropertyReader;
import util.Util;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase1 {

    public WebDriver driver;
    WebDriverWait driverWait;

    static DataReader dataReader = new DataReader();
    static Util util = new Util();


    @Before
    public void setUp() throws IOException {
        ChromeOptions options = new ChromeOptions();
        PropertyReader propertyReader = new PropertyReader();
        System.setProperty("webdriver.chrome.driver", propertyReader.getProperty(Constants.PROPERTY_VARIABLE.CHROME_WEBDRIVER_LOCATION));
        options.setBinary(propertyReader.getProperty(Constants.PROPERTY_VARIABLE.CHROME_BINARY_LOCATION));
        driver = new CustomChromeDriver();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void runTest() throws IOException, InterruptedException {
        LoginDetail loginDetail = dataReader.readLoginDetails("1").get(0);
        System.out.println(loginDetail.getUserName());
        ManualLogin.serverLogin(driver);

        List<EligibilityDetail> eligibilityDetails = dataReader.readEligibilityDetails("1");
        List<ContactDetail> contactDetails = dataReader.readContactDetails("1");
        List<ProposalDetail> proposalDetails = dataReader.readProposalDetails("1");
        List<BusinessImpactDetail> businessImpactDetails = dataReader.readBusinessImpactDetails("1");
        List<CostDetail> costDetails = dataReader.readCostDetails("1");

        int count = 0;
        for(EligibilityDetail eligibilityDetail: eligibilityDetails){
            ManualLogin.logIn(driver,loginDetail);
            LoadMRAForm.loadMRAForm(driver);
            ContactDetail contactDetail = contactDetails.get(count);
            ProposalDetail proposalDetail = proposalDetails.get(count);
            BusinessImpactDetail businessImpactDetail = businessImpactDetails.get(count);
            CostDetail costDetail = costDetails.get(count);

            System.out.println("----Start Test 1." + (count+1) + "-------");
            util.printObjectToJson(loginDetail);
            util.printObjectToJson(eligibilityDetail);
            util.printObjectToJson(contactDetail);
            util.printObjectToJson(proposalDetail);
            util.printObjectToJson(businessImpactDetail);
            util.printObjectToJson(costDetail);
            //Fill in eligibility
            EligibilityForm.fillInMRAEligibility(driver,eligibilityDetail);
            GlobalElements.clickSaveButtonAndRefresh(driver);
            EligibilityForm.checkMRAEligibility(driver,eligibilityDetail);
            GlobalElements.clickNextButton(driver);

            //Fill in contact form
            ContactForm.fillInMainContactPerson(driver,contactDetail);
            ContactForm.fillInMailingAddress(driver,contactDetail, loginDetail);
            ContactForm.fillInLetterOfOffer(driver,contactDetail);
            GlobalElements.clickSaveButtonAndRefresh(driver);
            ContactForm.checkMainContactPerson(driver,contactDetail);
            ContactForm.checkMailingAddress(driver, contactDetail, loginDetail);
            ContactForm.checkLetterOffOfffer(driver, contactDetail);
            GlobalElements.clickNextButton(driver);

            //Fill in and check proposal
            ProposalForm.fillInProposalDetails(driver, proposalDetail);
            GlobalElements.clickSaveButtonAndRefresh(driver);
            ProposalForm.checkProposalDetails(driver, proposalDetail);
            GlobalElements.clickNextButton(driver);

            //Fill in business impact details
            BusinessImpactForm.fillInBusinessImpactDetails(driver, businessImpactDetail);
            GlobalElements.clickSaveButtonAndRefresh(driver);
            BusinessImpactForm.checkInBusinessImpactDetails(driver, businessImpactDetail);
            GlobalElements.clickNextButton(driver);

            //COSTS
            CostDetailsForm.fillInThirdPartyVendor(driver, costDetail);
            GlobalElements.clickSaveButtonAndRefresh(driver);
            System.out.println("----End Test 1." + (count+1) + "-------");

            count ++;
        }
    }


}
