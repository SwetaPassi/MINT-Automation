package com.mint.testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePageClass {

	public WebDriverWait wait;
	public final Logger logger = LoggerFactory.getLogger(getClass());
	protected WebDriver driver;
	public static final int MAX_TIMEOUT = 100;
	public Properties prop;

	protected BasePageClass(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, MAX_TIMEOUT);
		configReader();
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public void configReader() {
		try {
			prop = new Properties();
			FileInputStream configFilePath = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
			prop.load(configFilePath);
		} catch (IOException e) {
			System.out.println("Path of the config is not getting loaded ");
			e.printStackTrace();
		}
	}

	protected void selectDropdownByVisibleText(WebElement element, String dropdownValue) throws InterruptedException {
		try {
			Select selvalue = new Select(element);
			wait.until(ExpectedConditions.visibilityOf(element));
			selvalue.selectByVisibleText(dropdownValue);
		} catch (Exception e) {
			System.out.println(element + " = dropdown does not got selected by visible text ");
			e.printStackTrace();
		}
	}

	protected void selectDropdownByIndex(WebElement element, int index) throws InterruptedException {
		try {
			Select selvalue = new Select(element);
			wait.until(ExpectedConditions.visibilityOf(element));
			selvalue.selectByIndex(index);
		} catch (Exception e) {
			System.out.println(element + " = dropdown does not got selected by index ");
			e.printStackTrace();
		}
	}

	protected void selectDropdownByValue(WebElement element, String dropdownValue) throws InterruptedException {
		try {
			Select selvalue = new Select(element);
			wait.until(ExpectedConditions.visibilityOf(element));
			selvalue.selectByValue(dropdownValue);
		} catch (Exception e) {
			System.out.println(element + "= dropdown value does not got selected by value ");
			e.printStackTrace();
		}
	}

	protected void elementExists(WebElement element) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(element + " does not Exists ! ");
		}
	}

	protected boolean elementIsDisplayed(WebElement element) {
		try {
			return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(element + " does not got displayed ! ");
			return false;
		}
	}

	protected void clickOn(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Actions act = new Actions(driver);
			act.moveToElement(element).click().build().perform();
			System.out.println("Clicking on the element " + element);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(element + " does not got clicked on the element ! ");
		}
	}

	protected boolean getAttribute(WebElement element, String attr) {
		return Boolean.valueOf(element.getAttribute(attr));
	}

	protected boolean elementIsEnable(WebElement element) {
		try {
			return wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	protected String getText(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).getText();
	}

	protected void clearFieldAndThenType(WebElement element, String text) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element)).clear();
			System.out.println("Clearing the field and then typing new value");
			wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void clickAndtype(WebElement element, String text) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			Actions act = new Actions(driver);
			act.moveToElement(element).sendKeys(text).build().perform();
			Thread.sleep(2000);
			act.moveToElement(element).sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void enterValueIn(WebElement element, String text) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Actions act = new Actions(driver);
			act.moveToElement(element).sendKeys(text).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrollToElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			wait.until(ExpectedConditions.visibilityOf(element));
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			System.out.println("Scrolling to the element");
		} catch (Exception e) {
			System.out.println("Did not got scroll to the element");
			e.printStackTrace();
		}
	}

	public void windowHandle(int tabPosition) {
		try {
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabPosition));
			System.out.println("Switching to the new tab");
		} catch (Exception e) {
			System.out.println("Did not switched to the new tab");
			e.printStackTrace();
		}
	}
}