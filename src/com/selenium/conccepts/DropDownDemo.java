package com.selenium.conccepts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDemo extends BaseClass {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Workspace\\eclipse-workspace_Demo\\SeleniumConcepts\\Drivers\\chromedriver.exe"
		 * ); WebDriver driver = new ChromeDriver();
		 */
		// driver.get("https://www.facebook.com/");

		driver = getBrowser("chrome");
		getUrl("https://www.facebook.com/");

		WebElement email = driver.findElement(By.id("email"));
		boolean displayed = email.isDisplayed(); // to chk whether the element is available or visible in the
													// application
		System.out.println(displayed);
		email.sendKeys("abc@gmail,com");
		String attribute = email.getAttribute("value");
		System.out.println("Value sent by us: " + attribute);
		Thread.sleep(2000);

		WebElement paswrd = driver.findElement(By.id("pass"));
		paswrd.sendKeys("12345");
		String attribute2 = paswrd.getAttribute("class");
		System.out.println("Password of Attribute Name class: " + attribute2);
		Thread.sleep(2000);

		WebElement createAcc = driver.findElement(By.xpath("(//a[@role='button'])[1]"));
		boolean enabled = createAcc.isEnabled();// to chk wwhether the element is editable or clickable
		System.out.println(enabled);
		createAcc.click();
		Thread.sleep(2000);

		WebElement day = driver.findElement(By.id("day"));
		selectDropDown(day, "3", "value");

		/*
		 * Select s = new Select(day); s.selectByValue("3"); Thread.sleep(2000);
		 */

		WebElement month = driver.findElement(By.id("month"));
		selectDropDown(month, "May", "visibletext");

		/*
		 * Select s1 = new Select(month); s1.selectByVisibleText("May");
		 */
		Thread.sleep(2000);

		WebElement year = driver.findElement(By.id("year"));
		selectDropDown(year, "5", "index");

		/*
		 * Select s2 = new Select(year); s2.selectByIndex(5);
		 */
		Thread.sleep(2000);

		// to get the text from the element we use getText() method
		String text = month.getText();
		System.out.println(text);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File desFile = new File("C:\\Workspace\\eclipse-workspace_Demo\\SeleniumConcepts\\Screenshot\\test.png");
		FileUtils.copyFile(srcFile, desFile);

	}
}
