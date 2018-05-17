package testSuit;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import utilities.ExtentReportUtility;

public class TestAddDiscussion {

	WebDriver driver = new FirefoxDriver();
	ExtentReportUtility report;
	ExtentReports extent;
	Properties prop = new Properties();

	@BeforeTest
	public void setupTest() {
		try {
			PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");

			// report.generateReport();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/utilities/OR.properties");
			prop.load(fis);
			driver.get(prop.getProperty("testSiteURL"));

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
