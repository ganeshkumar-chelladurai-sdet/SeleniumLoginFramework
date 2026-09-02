package com.ganeshkumar.automation.SeleniumLoginFramework.config;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {
	
	@DataProvider(name = "loginRoles")
	public static Object[][] getLoginRoles(){
		return new Object[][] {
			{Roles.ADMIN},
			{Roles.USER},
			{Roles.STUDENT}
		};
	}

}
