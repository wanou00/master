package com.demo.test;

import com.demo.needTest.ExternalService;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Guangtao Zhou on 8/12/2016.
 */
public class TestNGDemo7 extends AssertJUnit {

	@Mocked
	private ExternalService service;

	@BeforeClass
	public static void applyMockUps()
	{
		// Applies the mock-up by instantiating it:
		new ExampleMockUp();
	}

	@Test
	public void fakingExample() {
		// Exercise code under test normally; calls to ExternalService#doSomething will
		// execute the mock method above.
		boolean result = service.doSomething(1, "a");
		assertEquals(true, result);
	}

	static final class ExampleMockUp extends MockUp<ExternalService> {
		@Mock
		public boolean doSomething(int n, String s) {
			System.out.println("ExampleMockUp");
			return true;
		}
	}
}


