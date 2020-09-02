package com.selenium.conccepts;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableDemo {
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Workspace\\eclipse-workspace_Demo\\SeleniumConcepts\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		//driver.manage().window().maximize();
		
		System.out.println("=========All Data==========");
		List<WebElement> allData = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td"));
		for (WebElement data : allData) {
			System.out.println(data.getText());
		}
		
		System.out.println("=========Par Row=============");
		List<WebElement> parRow = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[4]/td"));
		for (WebElement data : parRow) {
			System.out.println(data.getText());
		}
		
		System.out.println("======== Column=============");
		List<WebElement> Column = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
		System.out.println(Column.size());
		for (WebElement data : Column) {
			System.out.println(data.getText());
		}
		
		System.out.println("===========Par Data===========");
		WebElement data = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[5]/td[2]"));
		System.out.println(data.getText());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
