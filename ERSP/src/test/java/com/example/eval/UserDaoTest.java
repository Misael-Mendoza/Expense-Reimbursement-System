package com.example.eval;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.dao.ERSDBConnection;
import com.example.dao.UserDao;
import com.example.model.User;

public class UserDaoTest {
	
	private static String URL = "jdbc:mariadb://database-1.cjjlktgocanw.us-east-2.rds.amazonaws.com:3306/ERSdb";
	private static String username = "ERSuser";
	private static String password = "mypassword";
	
	@Mock 
	private ERSDBConnection eCon;
	
	@Mock 
	private Connection c ;
	
	@Mock 
	private PreparedStatement ps;
	
	@Mock 
	private ResultSet rs;
	
	private User user;
	
	@BeforeClass 
	public static void setUpBeforeClass() throws Exception{
	
	}
	
	@AfterClass 
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before 
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		when(eCon.getDBConnection()).thenReturn(c);
		when(c.prepareStatement(any(String.class))).thenReturn(ps);
		user = new User(1,"mendozam","Tacos","Misael","Mendoza","misaelmz@hotmail.com",1);
		when(rs.first()).thenReturn(true);
		when(rs.getInt(1)).thenReturn(user.getUserId());
		when(rs.getString(2)).thenReturn(user.getUsername());
		when(rs.getString(3)).thenReturn(user.getPassword());
		when(rs.getString(4)).thenReturn(user.getFirstName());
		when(rs.getString(5)).thenReturn(user.getLastName());
		when(rs.getString(6)).thenReturn(user.getEmail());
		when(rs.getInt(7)).thenReturn(user.getRoleId());
		when(ps.executeQuery()).thenReturn(rs);
	}
	
	@After 
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testFindByNameSuccess() {
		assertEquals(new UserDao(eCon).findByName("mendozam").getUsername(),user.getUsername());
	}
	
	@Test 
	public void testFindByIdSuccess() {
		assertEquals(new UserDao(eCon).findById(1).getUserId(),user.getUserId());
	}
	
	

}
