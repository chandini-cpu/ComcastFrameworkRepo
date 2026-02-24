package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;

public class ListenerImpClass2 implements ITestListener,ISuiteListener{

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		Date d=new Date();
		String date=d.toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./LowLevelReport/"+date+"vtigerReport.html");
		spark.config().setDocumentTitle("Advance Reports");
		spark.config().setReportName("VTiger Report");
		spark.config().setTheme(Theme.STANDARD);
	    report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("laptop", "hp");
		report.setSystemInfo("browser", "chrome");
		report.setSystemInfo("os", "windows");
		
		
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testcase=result.getMethod().getMethodName();
		//Reporter.log(testcase+" execution started");
		 test=report.createTest(testcase);
		test.log(Status.INFO,testcase+"execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testcase=result.getMethod().getMethodName();
		//Reporter.log(testcase+" execution passed");
		test.log(Status.PASS,testcase+" execution passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testcase=result.getMethod().getMethodName();
		//Reporter.log(testcase+" execution failed");
		test.log(Status.FAIL, testcase+" execution failed");
		TakesScreenshot ss=(TakesScreenshot)BaseClass.sdriver;
		/*
		 * Date d=new Date(); String date=d.toString().replace(" ", "_").replace(":",
		 * "_"); File dest=new File("./screenshot/"+testcase+date+"sample.png"); File f=
		 * ss.getScreenshotAs(OutputType.FILE); try { FileHandler.copy(f, dest); } catch
		 * (IOException e) {
		 * 
		 * e.printStackTrace(); }
		 */
		String str=ss.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(str);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testcase=result.getMethod().getMethodName();
		//Reporter.log(testcase+" execution skipped");
		test.log(Status.SKIP, testcase+" execution skipped");
	}
	

	
}
