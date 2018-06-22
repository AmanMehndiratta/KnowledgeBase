package extentReportUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.utilityFunctions;

public class MyListener implements ITestListener {

	protected static WebDriver driver;
	protected static ExtentReports reports;
	protected static ExtentTest test;
	Properties OR = new Properties();
	

	public void onTestStart(ITestResult result) {
		System.out.println("Test Case " + result.getMethod().getMethodName() + " started");
		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName() + "test is started");

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case Passed");
		test.log(LogStatus.PASS, result.getMethod().getMethodName() + "test is passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case Failed");
		test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"
				+ result.getMethod().getMethodName() + ".png";

		File finalDestination = new File(destination);
		try {
			Files.copy(src, finalDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		String file = test.addScreenCapture(System.getProperty("user.dir") + "/FailedTestsScreenshots/"
				+ result.getMethod().getMethodName() + ".png");
		test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", file);
		test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed",
				result.getThrowable().getMessage());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case Skipped");
		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "test is skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("on test sucess within percentage");
	}

	public void onStart(ITestContext context) {
		System.out.println("Test Case Started");

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/utilities/OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			OR.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String browser = OR.getProperty("browser");
		switch (browser) {
		case "firefox":
			System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		default:
			System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		reports = new ExtentReports(System.getProperty("user.dir") + "//Report//"
				+ new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + " reports.html");
		reports.loadConfig(new File(System.getProperty("user.dir") + "//ExtentReport.xml"));
	}

	public void onFinish(ITestContext context) {
		System.out.println("on finish");
		driver.close();
		reports.endTest(test);
		reports.flush();
	}

}
