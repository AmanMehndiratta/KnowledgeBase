package extentReportUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import knowledgeBasePages.HomePage;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    
    Properties prop = new Properties();
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setup () throws IOException {
        //Create a Chrome driver. All test classes use this.
        driver = new FirefoxDriver();

        //Create a wait. All test classes use this.
        wait = new WebDriverWait(driver,15);

        //Maximize Window
        driver.manage().window().maximize();
        
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");

		// report.generateReport();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/utilities/OR.properties");
		prop.load(fis);
		driver.get(prop.getProperty("testSiteURL"));
        
		
    }

    @AfterClass
    public void teardown () {
        driver.quit();
    }

}
