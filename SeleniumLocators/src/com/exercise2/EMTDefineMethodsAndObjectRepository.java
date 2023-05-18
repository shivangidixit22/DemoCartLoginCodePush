package com.exercise2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EMTDefineMethodsAndObjectRepository {
	WebDriver driver = new EdgeDriver();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	public String titleActual = "";
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public String HolidayMessageExpected = "Turn Your Dream Holiday Into A Reality";
	public String HotelMessageExpected = "Same hotel, Cheapest price. Guaranteed!";
	public String HomePageTitleExpected = "Book Flights, Hotels, Bus Tickets & Holidays - EaseMyTrip.com";
	public String HolidayPageTextActual,HotelPageTextActual;
	
	//----------------ObjectRepository--------------------
	By HolidaysLink = By.xpath("(//a[@href = 'https://www.easemytrip.com/holidays/'])[1]");
	By HolidayMsg = By.xpath("//h1[text() = 'Turn Your Dream Holiday Into A Reality']");
	By HotelsLink = By.xpath("(//a[@href = 'https://www.easemytrip.com/hotels/'])[1]");
	By HotelMsg = By.xpath("//h1[@class = 'hp_title']");
	By HomePage = By.xpath("//a[@title = 'easemytrip.com']");
	//----------------------------------------------------
	
	//1.LaunchBrowserMethod
		public void LaunchBrowser() {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\SH360592\\Programs\\SeleniumLocators\\EdgeBrowserDriver\\msedgedriver.exe");
			driver.get("https://www.easemytrip.com/flights.html");
			driver.manage().window().maximize();
		}
	
	//2.Click on Holidays and then click on Hotel link
	public void ClickonHolidayAndHotelLinks() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(HolidaysLink));
		driver.findElement(HolidaysLink).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HolidayMsg));
		HolidayPageTextActual = driver.findElement(HolidayMsg).getText().trim();
		driver.findElement(HotelsLink).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HotelMsg));
		HotelPageTextActual = driver.findElement(HotelMsg).getText().trim();
	}
	
	//3.Verify message on holidays and hotels
	public void ValidateMessage() {
		Assert.assertEquals(HolidayMessageExpected, HolidayPageTextActual, "Holiday page msg is as expected : "+HolidayMessageExpected);
		Assert.assertEquals(HotelMessageExpected, HotelPageTextActual, "Hotel page msg is as expected : "+HotelMessageExpected);
	}
	
	//4.CountNo.ofLinksAndVerifyHomePageTitle
	public void CountLinksAndValidateTitle() {
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		int noOfLinks = links.size();
		Assert.assertTrue(true, "No. of links are "+noOfLinks);
		driver.findElement(HomePage).click();
		titleActual = driver.getTitle();
		Assert.assertEquals(HomePageTitleExpected, titleActual, "Home Page title is as expected : "+titleActual);
		System.out.println("Title of the home page is : "+titleActual);
	}
}
