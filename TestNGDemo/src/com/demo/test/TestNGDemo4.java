package com.demo.test;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Guangtao Zhou on 8/11/2016.
 */
public class TestNGDemo4 extends AssertJUnit {
	@Test(groups = { "init" })
	public void serverStartedOk() {
		System.out.println("serverStartedOk");
	}

	@Test(groups = { "init" })
	public void initEnvironment() throws Exception {
		System.out.println("initEnvironment");
//		throw new Exception();
	}

	@Test(dependsOnMethods = { "serverStartedOk" })
	public void method1() {
		System.out.println("method1");
	}


	@Test(dependsOnGroups = { "init" }/*, alwaysRun = true*/)
	public void method2() {
		Map map = new HashMap();
		map.put("a", "aaa");
		System.out.println("method2");
	}
}
