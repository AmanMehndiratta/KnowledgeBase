package testSuit;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import extentReportUtilities.MyListener;
import knowledgeBasePages.MyFollowing;

public class TestMyFollowing extends MyListener {

	// WebDriver driver = new FirefoxDriver();
	// ExtentReportUtility report;
	// ExtentReports extent;

	Properties prop = new Properties();
	MyFollowing myFollowing;

	@BeforeTest
	public void setupTest() {
		try {
			PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");

			// report.generateReport();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/utilities/OR.properties");
			prop.load(fis);
			
			driver.get(prop.getProperty("testSiteURL"));
			myFollowing = PageFactory.initElements(driver, MyFollowing.class);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority = 1)
	public void testPageTitle() {
		test.log(LogStatus.PASS, "testPageTitle test passed");
	}

	@Test(priority = 2)
	public void testTabSwitching() {
		test.log(LogStatus.PASS, "testTabSwitiching test passed");
	}

	@Test(priority = 3)
	public void testRedirectitonToUserProfile() {
		test.log(LogStatus.PASS, "testRedirectionToUserProfile test passed");
	}

	@Test(priority = 4)
	public void testRedirectionToPost() {
		test.log(LogStatus.PASS, "testRedirectionToPost test passed");
	}

	@Test(priority = 5)
	public void testPostStats() {
		test.log(LogStatus.PASS, "testPostStats test passed");
	}

}
