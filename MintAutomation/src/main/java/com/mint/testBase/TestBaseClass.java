package com.mint.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.mint.modulePageElements.MyProposalPageElements;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static FileInputStream configFilePath;
	public MyProposalPageElements myProposalScreenPage;

	public TestBaseClass() 
	{
		try {
			prop = new Properties();
			configFilePath = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
			prop.load(configFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
	}

	public static void initialization() throws InterruptedException
	{
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		wait = new WebDriverWait(driver, 100);
		driver.get(prop.getProperty("foxOkta"));
	}

	public WebDriver getDriver() {
		return driver;
	}

	@AfterMethod
	public void Close() {
		// driver.quit();
	}

	protected void waitForElementToAppear(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void clickUsingJavaScript(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void selectValue(WebElement element, String data) throws InterruptedException {
		Select selvalue = new Select(element);
		selvalue.selectByVisibleText(data);
	}
}