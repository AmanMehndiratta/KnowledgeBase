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

public class TestHomePage extends MyListener {

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
	public void testExistenceOfFeedbackButton() {
		boolean exist = true;
		try {
			if (utilityFunctions.checkElementExistence(driver, Locators.feedbackButton) == exist) {
				test.log(LogStatus.PASS, "Feedback button exists");

			} else {
				Assert.fail("Feedback button not found");
				test.log(LogStatus.FAIL, "Feedback button not found");
			}

		} catch (Exception e) {
			Assert.fail("Feedback button not found due to following exception ", e);
			test.log(LogStatus.FAIL, "Feedback button not found and following error was caught" + e);
		}
	}

	@Test(priority = 2)
	public void validateHomePageTitle() {
		boolean text = true;
		try {
			if (utilityFunctions.validateText(driver, Locators.homePageTitle, TestData.homePageTitle) == text) {
				test.log(LogStatus.PASS, "Home page title is correct i.e. " + TestData.homePageTitle);
			} else {
				Assert.fail("Wrong home page title is coming");
			}
		} catch (Exception e) {
			Assert.fail("Title cound not be matched due to following reason ", e);
			test.log(LogStatus.PASS, "Home page title is incorrect ");
		}
	}

	@Test(priority = 3)
	public void testHomePageTabSwitching() {
		try {
			boolean articleTab = hp.goToArticlesTab(driver);
			if (articleTab == true) {
				test.log(LogStatus.PASS, "User switched to Articles tab sucessfully");

				boolean questionsTab = hp.goToQuestionsTab(driver);
				if (questionsTab == true) {
					test.log(LogStatus.PASS, "User switched to Questions tab successfully");
				} else {
					Assert.fail("User unable to switch to Questions tab");
					test.log(LogStatus.FAIL, "User unable to switch to Questions tab");
				}
			} else {
				Assert.fail("User is unable to switch to Articles tab");
				test.log(LogStatus.FAIL, "User unable to switch to Articles tab");
			}

		} catch (Exception e) {
			Assert.fail("Tab switching now working as following error was thrown ", e);
			test.log(LogStatus.FAIL, "Tab switching now working as following error was thrown" + e);
		}
	}
	
	@Test
	public void testRedirectionToCategoryPageFromQuestionsCategory(){
		
	}
	
	@Test
	public void testRedirectionToPost(){
		
	}
	
	@Test
	public void testRedirectionToCategoryFromCategorySection(){
		
	}
	
	@Test
	public void testRedirectionToTagPageFromTagsSection(){
		
	}
	
	@Test
	public void testRedirectionToLeaderBoard(){
		
	}
	
	@Test
	public void testRedirectionToActivity(){
		
	}
	
	@Test
	public void testRedirectionToBadges(){
		
	}
	
	
	@Test
	public void testSearchAutoSuggestFeature(){
		
	}
	
	@Test
	public void testSearchWithRandomText(){
		
	}
	
}
