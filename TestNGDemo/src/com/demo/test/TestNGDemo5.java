package com.demo.test;

import com.demo.needTest.User;
import com.demo.needTest.UserDao;
import mockit.Expectations;
import mockit.Mock;
import mockit.Mocked;
import mockit.Tested;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/**
 * Created by Guangtao Zhou on 8/11/2016.
 */
public class TestNGDemo5 extends AssertJUnit {
	@Mocked
	UserDao ud;

	@Test
	public void method1() {
		new Expectations(){
			{
				ud.queryDB(anyString, anyString);
				result = new User("aa", "aaaa");
			}
		};
		User u = ud.queryDB("aa", "aaaa");

		System.out.println("method1: " + u.getUsername() + "," + u.getPassword());
	}
}