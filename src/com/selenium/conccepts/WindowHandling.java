package com.selenium.conccepts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Workspace\\eclipse-workspace_Demo\\SeleniumConcepts\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();

		WebElement mobile = driver.findElement(By.xpath("//a[text()='Mobiles']"));
		Actions ac = new Actions(driver);
		ac.contextClick(mobile).perform();
		Thread.sleep(2000);

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		WebElement todayDeals = driver.findElement(By.xpath("(//a[@class='nav-a  '])[2]"));
		ac.contextClick(todayDeals).perform();
		Thread.sleep(2000);

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		WebElement bestSellers = driver.findElement(By.xpath("//a[text()='Best Sellers']"));
		ac.contextClick(bestSellers).perform();
		Thread.sleep(2000);

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		WebElement sigIn = driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));
		ac.contextClick(sigIn).perform();
		Thread.sleep(2000);

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		System.out.println("=======Id of Parent window===========");
		String pId = driver.getWindowHandle();
		System.out.println(pId);
		String title = driver.switchTo().window(pId).getTitle();
		System.out.println(title);

		System.out.println("=============All Ids===========");
		Set<String> allId = driver.getWindowHandles();
		for (String id : allId) {
			String title2 = driver.switchTo().window(id).getTitle();
			System.out.println(title2);
		}

		for (String id : allId) {
			if (driver.switchTo().window(id).getTitle().equals("Amazon Sign In")) {
				WebElement email = driver.findElement(By.id("ap_email"));
				email.sendKeys("abc@gmail.com");
				break;
			}

		}

	}

}
