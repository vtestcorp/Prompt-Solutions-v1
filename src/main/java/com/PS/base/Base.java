package com.PS.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.PS.pages.CustomerDetails_Page;
import com.PS.util.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base {

	public static Properties prop;
	public static WebDriver driver;
	public static ExtentReports er;
	public static ExtentTest et;
	public static Logger log;
	public static String s1;
	public static String Report_Path = null;

	public Base() {
		try {

			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\PS\\resources\\config.properties");
			prop.load(fis);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void driverInitilization(String Browser)
	// public static void main(String args[])
	{
		if (Browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + prop.getProperty("chromedriver"));
			driver = new ChromeDriver();
			driver.get(prop.getProperty("NewURL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} else if (Browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + prop.getProperty("firefoxdriver"));
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("URL"));
			driver.manage().window().maximize();
		} else if (Browser.equals("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + prop.getProperty("IEDriver"));
			driver = new InternetExplorerDriver();
			driver.get(prop.getProperty("URL"));
			driver.manage().window().maximize();
		}
	}

	public static void logger() {
		log = LogManager.getLogger(Base.class.getName());
		log.info("Info");
		log.error("Error");
		log.fatal("Fatal");
		log.debug("Debug");
		
	}

	public static void create_ext_report(String reportName) {
		String Report_Timestamp = "Extent_Report" + (LocalDateTime.now()).getHour() + "_"
				+ (LocalDateTime.now()).getMinute() + "_" + (LocalDateTime.now()).getSecond();

		Report_Path ="Report\\"+"_" + Report_Timestamp;

		er = new ExtentReports( Report_Path +"\\" + Report_Timestamp + ".html");
		File file = new File("extent-config.xml");
		er.loadConfig(file);
		er.addSystemInfo("host", "Prompt Solutions");
	   
	}

	public static void create_extent_test(String testName)

	{
		//et = er.startTest(testName + "_@_" + Utility.Date_Time().toString());
		et= er.startTest(testName);
	}

	public static void close_ext_Report() {
		er.endTest(et);
		er.flush();
	}

	public static String pass(String testMethodName) throws IOException {
		  //String title=testMethodName;
		   TakesScreenshot screen = (TakesScreenshot) driver;
			File src = screen.getScreenshotAs(OutputType.FILE);
			String dest ="Screenshots//"+ testMethodName+getcurrentdateandtime()+".png";
			File target = new File(Report_Path+"/"+dest);
			FileUtils.copyFile(src, target);
		   return dest;
	}
	public static String pass1(String testMethodName) throws IOException {
		  //String title=testMethodName;
		System.out.println("1");
		   TakesScreenshot screen = (TakesScreenshot) driver;
		   System.out.println("2");
			File src = screen.getScreenshotAs(OutputType.FILE);
			System.out.println("3" + src);
			String dest ="Screenshots//"+ testMethodName+getcurrentdateandtime()+".png";
			System.out.println("4");
			File target = new File(Report_Path+"/"+dest);
			System.out.println("5" + target);
			FileUtils.copyFile(src, target);
			System.out.println("6");
		   return dest;
	}

	public static String fail(String testMethodName) throws IOException {
		// String title = testMethodName;
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest ="Screenshots\\"+testMethodName+getcurrentdateandtime()+".png";
		File target = new File(Report_Path+"/"+dest);
		FileUtils.copyFile(src, target);
		return dest;

	}

	public static String getcurrentdateandtime()
	{
		String str = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return str;
	}
	@BeforeSuite
	public void createReport() {
		create_ext_report("PS " + Utility.Date_Time().toString());

	}

	@Parameters({ "Browser" })
	@BeforeMethod
	public void setup(@Optional("Chrome") String Browser) throws URISyntaxException, IOException, InterruptedException {
		driverInitilization(Browser);
		
	}
	
	@AfterMethod
	public void tearDown() {
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	driver.close();
	}

	@AfterSuite
	public void closeReport() {
		if (driver != null) {
		//	driver.quit();
		}
		close_ext_Report();
	//	Utility.closeAllOpenBrowser();
	}

}