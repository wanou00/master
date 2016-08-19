package com.demo.needTest;

/**
 * Created by Guangtao Zhou on 8/11/2016.
 */
public class UserDao {
	public User queryDB(String username, String password) {
		return new User("sa", "password");
	}
}
