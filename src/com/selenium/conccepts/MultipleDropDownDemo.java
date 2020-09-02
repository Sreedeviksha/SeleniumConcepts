package com.selenium.conccepts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleDropDownDemo {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Workspace\\eclipse-workspace_Demo\\SeleniumConcepts\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

		WebElement multi = driver.findElement(By.id("multi-select"));
		Select s = new Select(multi);
		boolean multiple = s.isMultiple();//to chk whether it is multiple drop down
		System.out.println(multiple);
		

		s.selectByIndex(0);
		s.selectByValue("New York");
		s.selectByVisibleText("Pennsylvania");

		Thread.sleep(2000);
		List<WebElement> allOptions = s.getAllSelectedOptions();
		for (WebElement options : allOptions) {
			System.out.println(options.getText());
		}

		Thread.sleep(2000);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());

		Thread.sleep(2000);
		s.deselectAll();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
