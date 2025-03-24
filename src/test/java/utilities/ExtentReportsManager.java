package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.Writable;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.BaseClass;

public class ExtentReportsManager implements ITestListener {
	
	public ExtentSparkReporter sparkRepoter;// ui of the report
	public ExtentReports extentReports;// pupulate common infomation of the report
	public ExtentTest extentTest;//updating the status of the report passed,failed skipped
	
	String repName;
	
	public void onStart(ITestContext textcontext) {
		
		
		
		
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        repName  = "ExtentReport_" + timestamp + ".html";

		
		sparkRepoter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + repName);
		
		sparkRepoter.config().setDocumentTitle("openCart Automation Report"); // Title of the report
		
		sparkRepoter.config().setReportName("openCart Functional Testing"); // name of the report
		
		sparkRepoter.config().setTheme(Theme.DARK);
		
		
		extentReports = new ExtentReports();
		
		extentReports.attachReporter(sparkRepoter);
		extentReports.setSystemInfo("Application", "openCart");
		extentReports.setSystemInfo("Module", "Admin");
		extentReports.setSystemInfo("Sub Module", "Customers");
		extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReports.setSystemInfo("Environment", "QA");
		
		String os = textcontext.getCurrentXmlTest().getParameter("os");
		extentReports.setSystemInfo("Operating System", os);
		
		String browser = textcontext.getCurrentXmlTest().getParameter("browser");
		extentReports.setSystemInfo("Browser", browser);
		
		List<String> includedGroups = textcontext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
	    extentReports.setSystemInfo("Groups", includedGroups.toString());
		}
		
		
		
	   
		
	 }
	
	public void onTestSuccess(ITestResult result) {
		
		extentTest= extentReports.createTest(result.getTestClass().getName()); //create new entry
		extentTest.assignCategory(result.getMethod().getGroups());
		extentTest.log(Status.PASS, "Test case got successfuly executed:" +result.getName()); //update status
	    
	  }
	
	public void onTestFailure(ITestResult result) {
		extentTest= extentReports.createTest(result.getTestClass().getName()); //create new entry
		extentTest.assignCategory(result.getMethod().getGroups());
		extentTest.log(Status.FAIL, "Test case got failed:" +result.getName());//update status
		extentTest.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
			String imgPath = new BaseClass().captureScreen(result.getName());
			extentTest.addScreenCaptureFromPath(imgPath);
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		
		
	  }
	
	public void onTestSkipped(ITestResult result) {
		
		extentTest= extentReports.createTest(result.getTestClass().getName()); //create new entry
		extentTest.assignCategory(result.getMethod().getGroups());
		extentTest.log(Status.SKIP, "Test case got skipped :" +result.getName());//update status
		extentTest.log(Status.INFO, result.getThrowable().getMessage());
	  }
	
	public void onFinish(ITestContext testContext) {
		
		    extentReports.flush();
		    String reportPath = System.getProperty("user.dir") + "\\reports\\" + repName;
		    File extentReport = new File(reportPath);

		    if (extentReport.exists()) {  // Check if file exists before opening
		        try {
		            Desktop.getDesktop().browse(extentReport.toURI());
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    } else {
		        System.out.println("Extent Report file not found: " + reportPath);
		    }
		}
		    
		    /*
		    try { URL url = new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);

		        // Create the email message
		        ImageHtmlEmail email = new ImageHtmlEmail();
		        email.setDataSourceResolver(new DataSourceUrlResolver(url));
		        email.setHostName("smtp.googlemail.com");
		        email.setSmtpPort(465);
		        email.setAuthenticator(new DefaultAuthenticator("gowthamvekatesan2@gmail.com","password"));
		        email.setSSLOnConnect(true);
		        email.setFrom("gowthamvekatesan2@gmail.com"); // Sender
		        email.setSubject("Test Results");
		        email.setMsg("Please find Attached Report....");
		        email.addTo("gowtham2711999@gmail.com"); // Receiver
		        email.attach(url, "extent report", "please check report...");
		        email.send(); // send the email
		    } catch(Exception e) { e.printStackTrace(); } */
		    
		    
		    
		    
		    
		    
		    
		}

	   
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	 

	
	
	
	
	


