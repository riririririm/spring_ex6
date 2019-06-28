package com.rim.util;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.rim.s6.AbstractTest;

public class DBConnectTest extends AbstractTest {//설정파일 상속
	@Inject
	private DriverManagerDataSource dataSource;
	

	@Test
	public void test() throws Exception {
		Connection con = dataSource.getConnection();
		assertNotNull(con);
	}

}
