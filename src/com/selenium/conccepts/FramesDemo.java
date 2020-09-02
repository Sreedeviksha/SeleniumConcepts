package com.selenium.conccepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesDemo {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Workspace\\eclipse-workspace_Demo\\SeleniumConcepts\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://demo.automationtesting.in/Frames.html");
		
		//WebElement frame1 = driver.findElement(By.id("singleframe"));
		driver.switchTo().frame("singleframe");
		Thread.sleep(2000);
	
		WebElement textBox = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
		textBox.sendKeys("Greens");
		
		driver.switchTo().defaultContent();
	
		WebElement iframe = driver.findElement(By.xpath("(//a[@class='analystic'])[2]"));
		iframe.click();
		Thread.sleep(2000);

		WebElement outerFrame = driver.findElement(By.xpath("//*[@id=\"Multiple\"]/iframe"));
		driver.switchTo().frame(outerFrame);
		System.out.println("Switched into outerFrame");
		
		WebElement innerFrame = driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
		driver.switchTo().frame(innerFrame);
		System.out.println("Switched into InnerFrame");
		WebElement textBox2 = driver.findElement(By.xpath("/html/body/section/div/div/div/input"));
		textBox2.sendKeys("Hello");
	//	driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();
		System.out.println("Now in Outer Frame");
		
		List<WebElement> countOfFrames = driver.findElements(By.tagName("iframe"));
		int size = countOfFrames.size();
		System.out.println(size);
		
		driver.switchTo().defaultContent();
		WebElement webtable = driver.findElement(By.xpath("//a[text()='WebTable']"));
		webtable.click();
		
	
		
	}
}
