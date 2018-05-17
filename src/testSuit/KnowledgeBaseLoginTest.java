package testSuit;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import knowledgeBasePages.HomePage;
import testData.TestData;
import utilities.ExtentReport;
import utilities.ExtentReportUtility;
import utilities.Locators;
import utilities.utilityFunctions;

@Listeners(extentReportUtilities.TestListener.class)

public class KnowledgeBaseLoginTest {

	WebDriver driver = new FirefoxDriver();
	ExtentReportUtility report;
	ExtentReport extent;
	Properties prop = new Properties();
	
	
	public WebDriver getDriver() {
        return driver;
    }
	
	

	@BeforeTest
	public void setupTest() {
		try {
			PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");

			// report.generateReport();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/utilities/OR.properties");
			prop.load(fis);
			driver.get(prop.getProperty("testSiteURL"));

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	HomePage hp = PageFactory.initElements(driver, HomePage.class);

	@Test(priority = 1)
	public void testLoginWithValidCredentialsInMobiControl() {
		try {
			hp.loginMobiControl(driver, TestData.correctUserName, TestData.correctPassword);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 2)
	public void testLoginWithInvalidCrerdentialsInMobicontrol() {
		try {
			hp.loginMobiControl(driver, TestData.incorrectUsername, TestData.incorrectPassword);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test(priority = 3)
	public void testExistenceOfFeedbackButton(){
		boolean exist = true;
		try{
			if(utilityFunctions.checkElementExistence(driver, Locators.feedbackButton)== exist){
				//write pass statement to be printed in report
				System.out.println("Pass");
			}else{
				//write fail statement to be printed in report
				System.out.println("Fail");
			}
				
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test(priority = 4)
	public void testHomePageTitle(){
		boolean text = true;
		try{
			if(utilityFunctions.validateText(driver, Locators.homePageTitle, TestData.homePageTitle) == text){
				//write pass statement to be printed in report
				System.out.println("Pass");
				}
			}catch(Exception e){
				//write fail statement to be printed in report
				System.out.println("Fail");
			}
		}
	
	@Test
	public void testHomePageTabSwitching(){
		
	}
	

	@AfterClass
	public void tearDown() {
		ExtentReport.flushReport();
		
	}

}
