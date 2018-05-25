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
import knowledgeBasePages.ArticleDetails;
import knowledgeBasePages.HomePage;
import testData.TestData;
import utilities.Locators;
import utilities.utilityFunctions;

public class TestAddArticle extends MyListener {

	Properties prop = new Properties();
	ArticleDetails articles;
	HomePage hp;

	@BeforeTest
	public void setupTest() {
		try {
			PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");

			// report.generateReport();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/utilities/OR.properties");
			prop.load(fis);

			driver.get(prop.getProperty("testSiteURL"));
			articles = PageFactory.initElements(driver, ArticleDetails.class);
			hp = PageFactory.initElements(driver, HomePage.class);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	@Test
	public void addArticle() throws Exception{
		if(utilityFunctions.checkElementExistence(Locators.userProfileIcon)!=true){
			hp.remainLoginMobiControl(TestData.correctUserName , TestData.correctPassword);
			utilityFunctions.checkElementExistence(Locators.userProfileIcon);
		}
		
		if(articles.addArticleWithCorrectData()==true){
			test.log(LogStatus.PASS, "Article Added successfully");
		}else{
			Assert.fail("Test Case failed");
		}
	}

}
