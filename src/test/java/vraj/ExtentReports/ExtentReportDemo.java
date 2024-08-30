package vraj.ExtentReports;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;




@Test
public class ExtentReportDemo {
	ExtentReports extent;
    @BeforeTest
    public void config() {
    	String path = System.getProperty("user.dir")+"\\report\\index.html";
    	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
    	reporter.config().setReportName("Web Automation Result");
    	reporter.config().setDocumentTitle("Test Result");
    	
    	extent = new ExtentReports();
    	extent.attachReporter(reporter);
    	extent.setSystemInfo("Tester", "Vraj Patel");
    }


	public void initialDemo(){
		extent.createTest("Initial Demo");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		extent.flush();
		
	}
}
