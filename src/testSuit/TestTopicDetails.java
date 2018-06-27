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
import knowledgeBasePages.TopicDetails;
import testData.TestData;
import utilities.Locators;
import utilities.utilityFunctions;

public class TestTopicDetails extends MyListener{

	
	Properties prop = new Properties();
	HomePage hp;
	TopicDetails topicDetail;
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
			topicDetail = PageFactory.initElements(driver, TopicDetails.class);
			utility = new utilityFunctions(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEditDraftCancelOnTopicDetailPage() throws Exception {
		utility.loginUserIfNotLoggedIn(hp);
		hp.goToFirstTopicDetail();
		test.log(LogStatus.INFO, "User redirected to first topic");
		topicDetail.createAnswerDraftOnTopicDetail();
		topicDetail.cancelEditDraftOnTopicDetail();
		test.log(LogStatus.INFO, "Edit Draft Created");

		if (topicDetail.cancelEditDraftOnTopicDetail() == true) {
			test.log(LogStatus.PASS, "Edit Draft option present");
		} else {
			test.log(LogStatus.FAIL, "Edit Draft button is coming " + hp.answerButtonForFirstTopic.getText());
			Assert.fail();
		}

	}

}
