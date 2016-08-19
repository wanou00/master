package com.demo.test;

import org.testng.annotations.DataProvider;

/**
 * Created by Guangtao Zhou on 8/10/2016.
 */
public class StaticDataProvider {
	@DataProvider(name = "create")
	public static Object[][] createData() {
		return new Object[][] {
				{ "Cedric", new Integer(36) },
				{ "Anne", new Integer(37)},
		};
	}
}
