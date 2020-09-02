package com.selenium.conccepts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserLaunch extends BaseClass {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Workspace\\eclipse-workspace_Demo\\SeleniumConcepts\\Drivers\\chromedriver.exe"
		 * ); WebDriver driver = new ChromeDriver();
		 */
		driver = getBrowser("chrome");
		getUrl("https://www.facebook.com/");

		WebElement email = driver.findElement(By.id("email"));
		inputToElement(email, "abc@gmail.com");

		WebElement password = driver.findElement(By.id("pass"));
		inputToElement(password, "12345");

		WebElement createAcc = driver.findElement(By.id("u_0_2"));
		clickOnElement(createAcc);
		
		// driver.get("https://www.facebook.com/");

		// driver.manage().window().maximize();

		/*
		 * WebElement email = driver.findElement(By.id("email")); //
		 * email.sendKeys("abc@gmail.com"); JavascriptExecutor js = (JavascriptExecutor)
		 * driver;
		 * js.executeScript("arguments[0].setAttribute('value','abc@gmail.com')",
		 * email);
		 * 
		 * WebElement password = driver.findElement(By.id("pass"));
		 * js.executeScript("arguments[0].setAttribute('value','123456')", password);
		 * 
		 * WebElement createAcc = driver.findElement(By.id("u_0_2"));
		 * js.executeScript("arguments[0].click()", createAcc);
		 */
	}

}
