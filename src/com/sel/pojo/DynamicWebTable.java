package com.sel.pojo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.worldometers.info/coronavirus/");
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		List<WebElement> headers = driver
				.findElements(By.xpath("//table[@id='main_table_countries_today']/thead/tr/th"));

		int population_index = 0;
		for (int i = 0; i < headers.size(); i++) {
			System.out.println(i + " " + headers.get(i).getText().replaceAll("\n", " "));
			if (headers.get(i).getText().equalsIgnoreCase("Population")) {
				System.out.println("Column number of Population is" + i);
				population_index = i;
			}
		}

		List<WebElement> allRows = driver
				.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody[1]/tr"));
		System.out.println("Number of countries: " + allRows.size() + "\n");

	}
}
