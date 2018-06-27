package testSuit;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import extentReportUtilities.MyListener;
import knowledgeBasePages.HomePage;
import knowledgeBasePages.PendingPosts;
import utilities.utilityFunctions;

public class TestPendingPosts extends MyListener {

	Properties prop = new Properties();
	HomePage hp;
	PendingPosts pendingPosts;
	utilityFunctions utility;

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
			pendingPosts = PageFactory.initElements(driver, PendingPosts.class);
			utility = new utilityFunctions(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testApproveFirstTopicFromPendingPostsScreen() throws Exception {
		
		utility.loginUserIfNotLoggedIn(hp);
		if (hp.goToPendingPosts() == true) {
			try {
				pendingPosts.approveFirstPendingTopic();
				test.log(LogStatus.PASS, "First topic Approved");
			} catch (Exception e) {
				test.log(LogStatus.ERROR, "Exception returned" + e);
			}

		} else {
			//test.log(LogStatus.ERROR, "Test Skipped");
			test.log(LogStatus.SKIP, "No Pending Posts present");
			throw new SkipException("No Pending Posts present");
		}

	}
}
