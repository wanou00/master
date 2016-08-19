package com.demo.test;

import com.demo.needTest.NeedTest;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created by Guangtao Zhou on 8/10/2016.
 */
@Test(groups = "allClass")
public class TestNGDemo1 extends AssertJUnit {
	@BeforeClass
	public void beforeClass() {
		//do something
	}

	@DataProvider(name = "data")
	public Object[][] providerHaircutAdjDataForTest(Method method) {
		return new Object[][] {
				{1, 2, 0},
				{10, 5, 2},
		};
	}

	@Test(groups = "aa, bb", dataProvider = "data")
	public void testMethod(int x, int y, int expectResult) throws Exception {
		NeedTest nt = new NeedTest();
		int result = nt.divideMethod(x, y);
		assertEquals(expectResult, result);
	}

	@Test(groups = "aa", dataProvider = "data")
	public void testMethodaa(int x, int y, int expectResult) throws Exception {
		NeedTest nt = new NeedTest();
		int result = nt.divideMethod(x, y);
		assertEquals(expectResult, result);
	}

	@Test(groups = "bb", dataProvider = "data")
	public void testMethodbb(int x, int y, int expectResult) throws Exception {
		NeedTest nt = new NeedTest();
		int result = nt.divideMethod(x, y);
		assertEquals(expectResult, result);
	}

	@Test(groups = "cc", dataProvider = "data")
	public void testMethodcc(int x, int y, int expectResult) throws Exception {
		NeedTest nt = new NeedTest();
		int result = nt.divideMethod(x, y);
		assertEquals(expectResult, result);
	}
}
