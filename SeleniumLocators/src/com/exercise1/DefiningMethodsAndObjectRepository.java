package com.exercise1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DefiningMethodsAndObjectRepository {
	WebDriver driver = new EdgeDriver();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	public String title = "";
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	//------------------ObjectRepository----------------------
	By continueBtn1 = By.xpath("//a[text() = 'Continue']");
	By firstName = By.id("input-firstname");
	By lastName = By.id("input-lastname");
	By emailId = By.id("input-email");
	By password = By.id("input-password");
	By agreeCheckbox = By.xpath("//input[@type = 'checkbox']");
	By continueBtn2 = By.xpath("//button[text() = 'Continue']");
	By loginPage = By.xpath("//a[text() = 'login page']");
	By loginBtn = By.xpath("//button[text() = 'Login']");
	//----------------------------------------------------------
	
	//1.LaunchBrowserMethod
	public void LaunchBrowser() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\SH360592\\Programs\\SeleniumLocators\\EdgeBrowserDriver\\msedgedriver.exe");
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		driver.manage().window().maximize();
	}
	
	//2. RegisterAccountMethod
	public void RegisterAccount() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(continueBtn1));
		driver.findElement(continueBtn1).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
		driver.findElement(firstName).sendKeys("Satakshi");
		driver.findElement(lastName).sendKeys("Dixit");
		driver.findElement(emailId).sendKeys("shivangidixit354@gmail.com");
		driver.findElement(password).sendKeys("Ybjk0037");
		wait.until(ExpectedConditions.visibilityOfElementLocated(agreeCheckbox));
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type = 'checkbox']")).click();
		driver.findElement(continueBtn2).click();
	}
	
	//3. GetTitleOfThePageMethod
	public void verifyTitle() {
		title = driver.getTitle();
		System.out.println("Title of the page is : "+title);
	}
	
	//4. LoginAccountMethod
	public void login() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage));
		driver.findElement(loginPage).click();
		driver.findElement(emailId).sendKeys("shivangidixit354@gmail.com");
		driver.findElement(password).sendKeys("Ybjk0037");
		driver.findElement(loginBtn).click();
	}
}
