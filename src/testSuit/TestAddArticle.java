package testSuit;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.LogStatus;

import extentReportUtilities.MyListener;
import knowledgeBasePages.ArticleDetails;
import knowledgeBasePages.HomePage;
import utilities.utilityFunctions;

public class TestAddArticle extends MyListener {

	Properties prop = new Properties();
	ArticleDetails articles;
	HomePage hp;
	utilityFunctions utility;

	@BeforeTest
	public void setupTest() {
		try {
			PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");

			// report.generateReport();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/utilities/OR.properties");
			prop.load(fis);

			driver.get(prop.getProperty("testSiteURL"));
			articles = PageFactory.initElements(driver, ArticleDetails.class);
			utility = new utilityFunctions(driver);
			hp = PageFactory.initElements(driver, HomePage.class);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	//@Test
	public void addArticle() throws Exception{
		utility.loginUserIfNotLoggedIn(hp);
		
		if(articles.addArticleWithCorrectData()==true){
			test.log(LogStatus.PASS, "Article Added successfully");
		}else{
			Assert.fail("Test Case failed");
		}
	}

}
