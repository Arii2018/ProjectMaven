package com.mypractices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectMultiDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		WebElement elmCars = driver.findElement(By.id("cars"));
		Select selCars = new Select(elmCars);
		List<WebElement> listCars = selCars.getOptions();
		
		System.out.println("Car choices options count : " + listCars.size());
		
		for(int i=0; i<listCars.size(); i++) {
			System.out.println("All Cars listing: " + listCars.get(i).getText());
		}
		
		selCars.selectByValue("saab");
		selCars.selectByIndex(2);
		selCars.selectByVisibleText("Audi");
		driver.findElement(By.xpath("/html/body/form/input")).click();
		Thread.sleep(3000);
		String str = driver.findElement(By.xpath("/html/body/div[1]")).getText();
		System.out.println("Cars Output Text String: " + str);
		
		System.out.println("Filtered Output from text: ");
		String[] strFiltered = str.split("&");
		for(String i:strFiltered) {
			System.out.println((i));
		}
		Thread.sleep(3000);
		System.out.println("Thank You.");
		driver.close();
	}

}
