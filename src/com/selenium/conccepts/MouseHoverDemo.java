package com.selenium.conccepts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverDemo {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Workspace\\eclipse-workspace_Demo\\SeleniumConcepts\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		
		driver.manage().window().maximize();
		
		WebElement women = driver.findElement(By.xpath("//a[@title='Women']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(women).perform();
		Thread.sleep(2000);
		
		WebElement tshirt = driver.findElement(By.xpath("(//a[@title='T-shirts'])[1]"));
		ac.moveToElement(tshirt).perform();
		//ac.click(tshirt).perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", tshirt);
		Thread.sleep(2000);
		
		/*ac.click(women)
		ac.clickAndHold(target)
		ac.contextClick(target)
		ac.doubleClick(target)
		ac.dragAndDrop(source, target)
		ac.moveToElement(target)
		ac.perform();
		ac.release(target)
		ac.sendKeys(keys)*/
		
	
	}

}
