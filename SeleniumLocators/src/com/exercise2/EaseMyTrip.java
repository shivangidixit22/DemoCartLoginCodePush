package com.exercise2;

import org.testng.annotations.Test;

public class EaseMyTrip {
	@Test
	public void EaseMyTripWebsite() {
	EMTDefineMethodsAndObjectRepository obj1 = new EMTDefineMethodsAndObjectRepository();
	obj1.LaunchBrowser();
	obj1.ClickonHolidayAndHotelLinks();
	obj1.ValidateMessage();
	obj1.CountLinksAndValidateTitle();
	}
}
