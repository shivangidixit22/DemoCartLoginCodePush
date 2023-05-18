package com.exercise3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgeCalculatorMethodsAndObjectRepository {

	WebDriver driver = new EdgeDriver();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	
	//----------------------------------ObjectRepository----------------------------
	By AgeCalculator = By.xpath("//a[text() = 'Age Calculator  ']");
	By date = By.xpath("(//input[@class = 'easypositive-integer'])[1]");
	By month = By.xpath("(//input[@class = 'easypositive-integer'])[2]");
	By year = By.xpath("(//input[@class = 'easypositive-integer'])[3]");
	By goBtn = By.xpath("//input[@value = 'Go']");
	By yourAge = By.id("r1");
	By yourAgeInDays = By.id("r4");
	By ageInHours = By.id("r3");
	By ageInMin = By.id("r2");
	By reset = By.xpath("(//input[@value = 'Reset'])[1]");
	By closeBtn = By.xpath("//span[text() = 'Close']");
	//--------------------------------------------------------------------------------
	
	//1. LaunchBrowser
	public void LaunchBrowser() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\SH360592\\Programs\\SeleniumLocators\\EdgeBrowserDriver\\msedgedriver.exe");
		driver.get("https://www.easycalculation.com/index.php");
		driver.manage().window().maximize();
	}

	//2.Click Age calculator, find count of links and images then print top 5 only, select birth date
	public void clickAgeCalculator() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(AgeCalculator));
		driver.findElement(AgeCalculator).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AgeCalculator));
		driver.findElement(AgeCalculator).click();
		
		//getLinks
		/*
		 * List<WebElement> allLinks = driver.findElements(By.tagName("//a"));
		 * System.out.println(allLinks.size());
		 * 
		 * for(int i = 1; i<5; i++) { System.out.println(allLinks.get(i).getText());
		 * System.out.println(allLinks.get(i).getAttribute("href")); }
		 */
		
		//getImages
		List<WebElement> allImages = driver.findElements(By.tagName("img"));
		System.out.println("Total images on this page are "+allImages.size());
		
		for(int i = 1; i<5; i++) {
			System.out.println("src"+allImages.get(i).getAttribute("src"));
		}
		
		//select birth date
		wait.until(ExpectedConditions.visibilityOfElementLocated(date));
		driver.findElement(date).sendKeys("18");
		driver.findElement(month).sendKeys("05");
		driver.findElement(year).sendKeys("1947");
	}
	
	//3.Click Go button
	public void clickGoBtn() {
		driver.findElement(goBtn).click();
	}
	
	//4.PrintValuesFromAgeFields
	public void printAge() {
		String Age = driver.findElement(yourAge).getText();
		String AgeInDays = driver.findElement(yourAgeInDays).getText();
		String AgeInHours = driver.findElement(ageInHours).getText();
		String AgeInMinutes = driver.findElement(ageInMin).getText();
		System.out.println("Your Age "+Age);
		System.out.println("Your Age in days "+AgeInDays);
		System.out.println("Your Age in hours"+AgeInHours);
		System.out.println("Your Age in minutes "+AgeInMinutes);	
	}
	
	//5.Click Reset
	public void clickResetButton() {
		driver.findElement(reset).click();
	}
}
