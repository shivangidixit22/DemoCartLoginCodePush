package com.exercise1;

import org.testng.annotations.Test;

public class OpenCartLogin {
	
	@Test
	public void UserRegistrationProcess() throws InterruptedException {
		DefiningMethodsAndObjectRepository obj = new DefiningMethodsAndObjectRepository();
		//Launch browser
		obj.LaunchBrowser();
		
		//RegisterAccount
		obj.RegisterAccount();
		
		//VerifyTitle
		obj.verifyTitle();
		
		//LogintoDemoCart
		obj.login();
	}
	
}
