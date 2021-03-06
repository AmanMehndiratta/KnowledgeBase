package testSuit;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import extentReportUtilities.MyListener;
import utilities.utilityFunctions;


public class TestAddDiscussion extends MyListener{

	//WebDriver driver = new FirefoxDriver();
	//ExtentReportUtility report;
	//ExtentReports extent;
	Properties prop = new Properties();
	utilityFunctions utility;

	@BeforeTest
	public void setupTest() {
		try {
			PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");

			// report.generateReport();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/utilities/OR.properties");
			prop.load(fis);
			driver.get(prop.getProperty("testSiteURL"));
			utility = new utilityFunctions(driver);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	@Test
	public void testAddDiscussion(){
		
	}
	
	@Test
	public void testFrontEndValidations(){
		
	}
	
	
	
	
}
