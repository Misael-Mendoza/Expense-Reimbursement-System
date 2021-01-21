package com.example.eval;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.service.UserService;

public class UserServiceTest {

	@Mock
	private UserDao mockedDao;
	private UserService testService = new UserService(mockedDao);
	private User testUser;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		
	}
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		testService = new UserService(mockedDao);
		testUser = new User(1,"mendozam","Tacos","Misael","Mendoza","Misaelmz@hotmail.com",1);
		when(mockedDao.findByName("mendozam")).thenReturn(testUser);
	}
	
	@After 
	public void tearDown() throws Exception{
		
	}
	
	@Test
	public void testGetUserSuccess() {
		assertEquals(testService.getUser("mendozam"),testUser);
	}
	
	@Test(expected= NullPointerException.class)
	public void testGetUserFailure() {
		assertEquals(testService.getUser("dsadsadsa"),null);
	}
	
	@Test
	public void testVerifyUserSuccess() {
		assertTrue(testService.verifyUser(testUser.getUsername(), "Tacos"));
	}
	
	@Test
	public void testVerifyUserFailure() {
		assertFalse(testService.verifyUser(testUser.getUsername(), "tacos"));
	}
	
	
	
	
	
	
}
