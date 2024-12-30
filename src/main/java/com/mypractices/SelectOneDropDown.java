package com.mypractices;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

// Select Single item from Select List/Drop Down.
// user story/test scenario/requirement: Verify and Validate Vindeep
//IRC feature/module and automate it.
public class SelectOneDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		ArrayList<String> arrPF = new ArrayList<String>();
		ArrayList<String> arrCF = new ArrayList<String>();
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://vindeep.com/Calculators/RateConverterCalc.aspx");
		driver.manage().window().maximize();
		
		//Handle Interest Rate Element
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$cphCentre$InterestRateTextBox")).clear();
		Thread.sleep(3000);
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$cphCentre$InterestRateTextBox")).sendKeys("2.6");
		
		//Handle Payment Frequency Element
		WebElement pfElm = driver.findElement(By.id("ContentPlaceHolder1_cphCentre_IntPayableDropDown"));
		Select pfSel = new Select (pfElm);//pass the whole WebElemnt information to Select Class to disect.
		pfSel.selectByValue("Monthly");
		Thread.sleep(3000);
		List<WebElement> pfList = pfSel.getOptions();//
		for (int i=0; i<pfList.size(); i++) {
			//System.out.println("Payment Frequency Periods listed: "+pfList.get(i).getText());
			arrPF.add(pfList.get(i).getText());
		}
		System.out.println("This is Payment Frequency List: " + arrPF);
		
		//Convert to Frequency
		WebElement cfElm = driver.findElement(By.id("ContentPlaceHolder1_cphCentre_ConvertToDropDown"));//insert content
		Select cfSel = new Select(cfElm);//pass the cfElm to be parsed.
		cfSel.selectByVisibleText("Quarterly");
		Thread.sleep(3000);
		List<WebElement> cfList = cfSel.getOptions();
		for(int i=0; i<cfList.size(); i++) {
			//System.out.println("Convert to Frequency Periods are: "+ cfList.get(i).getText());
			arrCF.add(cfList.get(i).getText());
			
		}
			System.out.println("This is Convert to Frequency ArrayList: " +arrCF);	
			System.out.println("Thank You.");
		//Click Convert Interest Rate
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$cphCentre$btnConvertRate")).click();
		String cir = driver.findElement(By.name("ctl00$ContentPlaceHolder1$cphCentre$ResultRate")).getDomAttribute("2.5156");
		System.out.println(cir);
		// I'm unable to fetch Convert Interest Rate Data.
		// Why it shows null? 
		
		
		
		Thread.sleep(3000);
		driver.quit();
	
		
	}

}
