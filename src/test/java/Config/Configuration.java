package Config;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.*;

import static java.lang.System.setProperty;

public class Configuration {

	public WebDriver driver;
	public Common common;

	@BeforeMethod
	public void init(){
		setProperty("webdriver.chrome.driver", "src/Driver/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		common = new Common(driver);

	}


	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult) throws IOException {
		String testName = testResult.getName();
		Reporter.setCurrentTestResult(testResult);
		File img = new File("target" + File.separator + "surefire-reports" + File.separator + testName + ".png");
		if (testResult.getStatus() == 1) {
			common.log("PASS : " + testResult.getName() + "\n");
			testResult.getThrowable();
		}
		if (testResult.getStatus() == 2) {
			common.makeScreenshot(driver, testName);
			Reporter.log("Failed : This is failed log from reporter.log" + "<br>", true);
			FileOutputStream screenshotStream = new FileOutputStream(img);
			screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			Reporter.log("<a target='blank' href='" + testName + ".png'> <img  src='" + testName + ".png' height='250' width='500'></img> </a>" + "<br>");
		}
		driver.quit();
	}

}