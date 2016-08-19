package com.demo.test;

import org.testng.AssertJUnit;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Guangtao Zhou on 8/10/2016.
 */
public class TestNGDemo2 extends AssertJUnit {

	@Parameters({"first_name"})
	@Test
	public void testMethod(@Optional("aaaa") String firstName) {
		assertEquals("aaaa", firstName);
	}

}
