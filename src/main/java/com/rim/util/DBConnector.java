package com.rim.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

//@Component
//= new DBConnector();
//root-context.xml에 등록할 필요 없음
//단, 여기서(생성자에서) 값을 셋팅할 수 없음
public class DBConnector {
	private String user;
	private String password;
	private String url;
	private String driver;
	
	/*public DBConnector(String user, String password, String url, String driver) {

	}*/
	public DBConnector() {
		// TODO Auto-generated constructor stub
	}
	
	public Connection getConnect() throws Exception {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}
	
	
}
