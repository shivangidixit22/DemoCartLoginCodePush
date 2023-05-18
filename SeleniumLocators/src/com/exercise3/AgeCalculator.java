package com.exercise3;

import org.testng.annotations.Test;

public class AgeCalculator {
	@Test
	public void AgeCalculatorWebsite() throws InterruptedException {
	AgeCalculatorMethodsAndObjectRepository obj2 = new AgeCalculatorMethodsAndObjectRepository();
	obj2.LaunchBrowser();
	obj2.clickAgeCalculator();
	obj2.clickGoBtn();
	obj2.printAge();
	obj2.clickResetButton();
	}
	
}
