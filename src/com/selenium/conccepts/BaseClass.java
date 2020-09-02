package com.selenium.conccepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver getBrowser(String browserName) {

		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Workspace\\eclipse-workspace_Demo\\SeleniumConcepts\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						"C:\\Workspace\\eclipse-workspace_Demo\\SeleniumConcepts\\Drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} else if (browserName.equalsIgnoreCase("gecko")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Workspace\\eclipse-workspace_Demo\\SeleniumConcepts\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else {
				System.out.println("Invalid BrowserName");
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;

	}

	public static void waitForElementVisibility(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void getUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean elementIsDisplayed(WebElement element) {
		boolean displayed = false;
		try {
			displayed = element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return displayed;
	}
	
	
	public static boolean elementIsEnabled(WebElement element) {
		boolean enabled = false;
		try {
			enabled = element.isEnabled();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return enabled;
	}

	public static void inputToElement(WebElement element, String value) {
		waitForElementVisibility(element);
		try {
			if (elementIsDisplayed(element) && elementIsEnabled(element)) {
				element.sendKeys(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clickOnElement(WebElement element) {
		waitForElementVisibility(element);

		try {
			if (elementIsEnabled(element)) {
				element.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void selectDropDown(WebElement element, String value, String option) {

		waitForElementVisibility(element);

		try {
			if (option.equalsIgnoreCase("value")) {
				Select s = new Select(element);
				s.selectByValue(value);
			} else if (option.equalsIgnoreCase("visibletext")) {
				Select s1 = new Select(element);
				s1.selectByVisibleText(value);
			} else if (option.equalsIgnoreCase("index")) {
				Select s2 = new Select(element);
				s2.selectByIndex(Integer.parseInt(value));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

	public static void simpleAlert(WebElement element) {
		try {
			waitForElementVisibility(element);
			Alert simpleAlert = driver.switchTo().alert();
			simpleAlert.accept();
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void confirmAlert(String condition, WebElement element) {
		try {
			waitForElementVisibility(element);
			Alert confirmAlert = driver.switchTo().alert();
			if (condition.equalsIgnoreCase("accept")) {
				confirmAlert.accept();
				driver.switchTo().defaultContent();

			} else if (condition.equalsIgnoreCase("dismiss")) {
				confirmAlert.dismiss();
				driver.switchTo().defaultContent();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}