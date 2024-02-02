package SatteliteInfo.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation for ITestListener interface of TestNg
 * 
 * @author kravi
 *
 */

public class ListernersImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		// System.out.println(methodName+ "==test script execution started==");
		test = report.createTest(methodName + "LISTENER TEST SCIPT EXECUTION STATRED");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		// System.out.println(methodName+ "==test script success==");
		test.log(Status.PASS, methodName + "=== LISTENER PASS ===");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "==LISTENER test script failed==");
		System.out.println(result.getThrowable()); // Print the exception
		
		WebDriverUtility wUtil = new WebDriverUtility();
		String screeShotName = methodName + "-" + new JavaUtility().getSystemDateInFormat();

		try {
			String path = wUtil.takesScreenShot(BaseClass.sDriver, screeShotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(screeShotName);
		test.log(Status.FAIL, methodName + "=== LISTENER FAIL ===");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		// System.out.println(methodName+ "==test script skipped==");
		System.out.println(result.getThrowable()); // Print the exception
		test.log(Status.SKIP, methodName + "===LISTENER SKIP ===");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}
	

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("== LISTENER Execution started");
		ExtentSparkReporter htmlreporter = new ExtentSparkReporter(
				".\\ExtentReports\\Report-" + new JavaUtility().getSystemDateInFormat() + ".html");
		htmlreporter.config().setDocumentTitle("vTiger Execution Report");
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setReportName("Execution Report");

		report = new ExtentReports();
		report.attachReporter(htmlreporter);
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base Browser", "firefox");
		report.setSystemInfo("Reporter Name", "Ravish Keshri");
		report.setSystemInfo("Base Platform", "Windows");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("==LISTENER Execution finished");
		report.flush();
	}

}
