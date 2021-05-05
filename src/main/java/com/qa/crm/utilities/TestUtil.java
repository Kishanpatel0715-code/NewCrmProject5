package com.qa.crm.utilities;

import com.qa.crm.testbase.TestBase;

public class TestUtil extends TestBase{

	public static long implicit_wait = 20;
	public static long pageload_time_out = 30;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
}
