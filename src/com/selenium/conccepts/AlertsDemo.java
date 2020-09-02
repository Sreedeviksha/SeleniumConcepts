package com.selenium.conccepts;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsDemo {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Workspace\\eclipse-workspace_Demo\\SeleniumConcepts\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();

		WebElement alert1 = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		alert1.click();
		Thread.sleep(2000);
		Alert simpleAlert = driver.switchTo().alert();
		String text = simpleAlert.getText();
		System.out.println(text);
		simpleAlert.accept();
		Thread.sleep(2000);

		WebElement alert2 = driver.findElement(By.xpath("(//a[@class='analystic'])[2]"));
		alert2.click();
		Thread.sleep(2000);
		WebElement cAlert = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		cAlert.click();
		Thread.sleep(2000);
		Alert confirmAlert = driver.switchTo().alert();
		String text2 = confirmAlert.getText();
		System.out.println(text2);
		confirmAlert.dismiss();
		Thread.sleep(2000);

		WebElement alert3 = driver.findElement(By.xpath("(//a[@class='analystic'])[3]"));
		alert3.click();
		Thread.sleep(2000);
		WebElement pAlert = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
		pAlert.click();
		Thread.sleep(2000);
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("Greens Technology");
		promptAlert.accept();

	}
}
