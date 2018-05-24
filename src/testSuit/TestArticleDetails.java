package testSuit;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import extentReportUtilities.MyListener;
import junit.framework.Assert;
import knowledgeBasePages.ArticleDetails;
import knowledgeBasePages.HomePage;
import testData.TestData;
import utilities.Locators;
import utilities.utilityFunctions;

public class TestArticleDetails extends MyListener{

	Properties prop = new Properties();
	ArticleDetails articleDetail;
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
			articleDetail = PageFactory.initElements(driver, ArticleDetails.class);
			hp = PageFactory.initElements(driver, HomePage.class);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	
	//@Test
	//need to remove this test as it is very hard to manage xpaths of same articles etc
	public void testPresenceOfArticleHelpfulPercentageAfterVotingYes() throws Exception{
		if(utilityFunctions.checkElementExistence(driver, Locators.userProfileIcon)!=true){
			hp.remainLoginMobiControl(driver,TestData.correctUserName , TestData.correctPassword);
			utilityFunctions.checkElementExistence(driver, Locators.userProfileIcon);
		}
		try{
		articleDetail.voteArticleWasHelpful(driver);
		if(articleDetail.presenceOfPercentArticleWasHelpful(driver) == true){
			test.log(LogStatus.PASS, "% of article is present after voting Yes");
		}else{
			Assert.fail();
			test.log(LogStatus.FAIL, "% of article is not present after voting Yes");
		}
		}catch(Exception e){
			Assert.fail("Test Case Failed due to following reason" + e);
		}
	}

	
	
	
	
}
