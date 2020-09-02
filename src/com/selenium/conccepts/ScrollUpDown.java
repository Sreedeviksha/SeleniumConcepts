package com.selenium.conccepts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollUpDown {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Workspace\\eclipse-workspace_Demo\\SeleniumConcepts\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		WebElement downLogo = driver.findElement(By.xpath("//div[@class='nav-logo-base nav-sprite']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", downLogo);
		Thread.sleep(2000);
		
		
		WebElement amazon = driver.findElement(By.xpath("//a[@class='nav-logo-link']"));
		js.executeScript("arguments[0].scrollIntoView();", amazon);
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,1500)");//positive scroll down
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,-1000)");//negative scroll up
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
	}
}
