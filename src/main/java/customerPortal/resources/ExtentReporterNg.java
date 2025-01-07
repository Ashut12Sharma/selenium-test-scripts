package customerPortal.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//class to create report
public class ExtentReporterNg {

	
		//method to create report
	public static ExtentReports getReportObject() {
		//ExtentsReports, ExtentSparkReporter
				ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//reports//index.html");
				//change the report name
				reporter.config().setReportName("Customer-Portal-results");
				//set document title
				reporter.config().setDocumentTitle("customer-portal-report");
				//create extent report class to get reports
				ExtentReports extent = new ExtentReports();
				//attach report to main class
				extent.attachReporter(reporter);
				//set tester name
				extent.setSystemInfo("Tester", "Ashutosh");
				return extent;
	}
}
