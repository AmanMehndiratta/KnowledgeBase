package testSuit;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import extentReportUtilities.MyListener;
import knowledgeBasePages.HomePage;
import testData.TestData;
import utilities.ExtentReport;
import utilities.Locators;
import utilities.utilityFunctions;

//@Listeners(extentReportUtilities.TestListener.class)

public class KnowledgeBaseLoginTest extends MyListener {

//	WebDriver driver = new FirefoxDriver();
	//ExtentReportUtility report;
//	ExtentReport extent;
	Properties prop = new Properties();
	HomePage hp;
	
	
	
	 

	@BeforeTest
	public void setupTest() {
		try {
			PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");

			// report.generateReport();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/utilities/OR.properties");
			prop.load(fis);
			//test.log(LogStatus.INFO, "Browser Launched");
			driver.get(prop.getProperty("testSiteURL"));
			//test.log(LogStatus.INFO, "Test URL Launched");
			 hp = PageFactory.initElements(driver, HomePage.class);
			

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	

	@Test(priority = 1)
	public void testLoginWithValidCredentialsInMobiControl() {
		try {
			
			hp.loginMobiControl(driver, TestData.correctUserName, TestData.correctPassword);
			test.log(LogStatus.PASS, "User logging in");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Login Failed due to following error" + e);
		}

	}

	@Test(priority = 2)
	public void testLoginWithInvalidCrerdentialsInMobicontrol() {
		try {
			hp.loginMobiControl(driver, TestData.incorrectUsername, TestData.incorrectPassword);
			test.log(LogStatus.PASS, "User not allowed to login with invalid credentials");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Login attemt failed due to following reason" + e);
		}

	}
	
	@Test(priority = 3)
	public void testExistenceOfFeedbackButton(){
		boolean exist = true;
		try{
			if(utilityFunctions.checkElementExistence(driver, Locators.feedbackButton)== exist){
				test.log(LogStatus.PASS, "Feedback button exists");
				
			}else{
				test.log(LogStatus.FAIL, "Feedback button not found and following error was caught");

			}
				
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Feedback button not found and following error was caught" + e );
		}
	}
	
	@Test(priority = 4)
	public void testHomePageTitle(){
		boolean text = true;
		try{
			if(utilityFunctions.validateText(driver, Locators.homePageTitle, TestData.homePageTitle) == text){
				test.log(LogStatus.PASS, "Home page title is correct i.e. " + TestData.homePageTitle);
				}
			}catch(Exception e){
				test.log(LogStatus.PASS, "Home page title is incorrect " );
			}
		}
	
	@Test
	public void testHomePageTabSwitching(){
		
	}

}
