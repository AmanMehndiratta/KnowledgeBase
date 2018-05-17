package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReportUtility {

	public ExtentReportUtility(){
		
	}
	
	ExtentTest test;
	ExtentReports extent;

	
	public void generateReport() {
		extent = new ExtentReports(
				"C:\\Users\\Aman Mehndiratta\\workspace\\KnowledgeBaseWithPageObjectModel\\Report\\report.html", true);
	}

	public void startTest(ExtentReports extent, String testName, String Description) {
		test = extent.startTest(testName, Description);
	}

	public void flushReport(ExtentReports extent) {
		extent.flush();
	}

}
