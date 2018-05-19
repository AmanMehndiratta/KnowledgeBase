package testSuit;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import extentReportUtilities.MyListener;
import knowledgeBasePages.HomePage;
import testData.TestData;
import utilities.Locators;
import utilities.utilityFunctions;

//@Listeners(extentReportUtilities.TestListener.class)

public class KnowledgeBaseLoginTest extends MyListener {

	// WebDriver driver = new FirefoxDriver();
	// ExtentReportUtility report;
	// ExtentReport extent;
	Properties prop = new Properties();
	HomePage hp;

	@BeforeTest
	public void setupTest() {
		try {
			PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");

			// report.generateReport();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/utilities/OR.properties");
			prop.load(fis);

			driver.get(prop.getProperty("testSiteURL"));

			// initialize all the elements of all the pages
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
			Assert.fail("Login failed due to following exception ", e);
			test.log(LogStatus.FAIL, "Login Failed due to following error" + e);
		}

	}

	@Test(priority = 2)
	public void testLoginWithInvalidCrerdentialsInMobicontrol() {
		try {
			hp.loginMobiControl(driver, TestData.incorrectUsername, TestData.incorrectPassword);
			test.log(LogStatus.PASS, "User not allowed to login with invalid credentials");
		} catch (Exception e) {
			Assert.fail("Login with invalid credentials failed due to following exception ", e);
			test.log(LogStatus.FAIL, "Login attemt failed due to following reason" + e);
		}

	}

	

}
