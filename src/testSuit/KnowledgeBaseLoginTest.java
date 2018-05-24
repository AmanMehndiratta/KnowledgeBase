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

public class KnowledgeBaseLoginTest extends MyListener {

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

			if (hp.loginMobiControl(driver, TestData.correctUserName, TestData.correctPassword) == true) {
				test.log(LogStatus.PASS, "User logging in");
			} else {
				test.log(LogStatus.FAIL, "User not logging in");
				Assert.fail("User not logged in");
			}
		} catch (Exception e) {
			Assert.fail("Login failed due to following exception ", e);
			test.log(LogStatus.FAIL, "Login Failed due to following error" + e);
		}

	}

	@Test(priority = 2)
	public void testLoginWithInvalidCrerdentialsInMobicontrol() {
		try {
			if (hp.loginMobiControl(driver, TestData.incorrectUsername, TestData.incorrectPassword) == false) {
				test.log(LogStatus.PASS, "User not allowed to login with invalid credentials");
			} else {
				test.log(LogStatus.FAIL, "User logged in with invalid credentials");
				Assert.fail("User not logged in");
			}

		} catch (Exception e) {
			Assert.fail("Login with invalid credentials failed due to following exception ", e);
			test.log(LogStatus.FAIL, "Login attemt failed due to following reason" + e);
		}

	}

}
