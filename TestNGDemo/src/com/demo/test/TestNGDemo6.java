package com.demo.test;

import com.demo.needTest.Login;
import com.demo.needTest.User;
import com.demo.needTest.UserDao;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/**
 * Created by Guangtao Zhou on 8/11/2016.
 */
public class TestNGDemo6 extends AssertJUnit {

	@Tested
	private Login login = new Login();

	@Mocked
	private UserDao ud;

	@Test
	public void testMethod1() {
		new Expectations(){
			{
				ud.queryDB(anyString, anyString);
				result = new User("a", "aaa");
			}
		};
		boolean isLogin = login.canLogin("a", "aaa");
		System.out.println("testMethod1:isLogin: " + isLogin);
	}
}
