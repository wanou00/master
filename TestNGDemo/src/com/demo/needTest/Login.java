package com.demo.needTest;

/**
 * Created by Guangtao Zhou on 8/11/2016.
 */
public class Login {
	private UserDao ud = new UserDao();

	public boolean canLogin(String username, String password) {
		User u = ud.queryDB(username, password);
		return u != null;
	}
}
