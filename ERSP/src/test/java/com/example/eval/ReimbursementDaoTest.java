package com.example.eval;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.dao.ERSDBConnection;
import com.example.dao.ReimbursementDao;
import com.example.model.Reimbursement;

public class ReimbursementDaoTest {
	
	private static String URL = "jdbc:mariadb://database-1.cjjlktgocanw.us-east-2.rds.amazonaws.com:3306/ERSdb";
	private static String username = "ERSuser";
	private static String password = "mypassword";
	
	@Mock 
	private ERSDBConnection rCon;
	
	@Mock 
	private Connection c;
	
	@Mock 
	private PreparedStatement ps;
	
	@Mock 
	private ResultSet rs;
	
	private Reimbursement reimbursement;
	private Timestamp created = new Timestamp(System.currentTimeMillis());
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
	}
	
	@AfterClass 
	public static void tearDownAfterClass() throws Exception{
		
	}	

	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		when(rCon.getDBConnection()).thenReturn(c);
		when(c.prepareStatement(any(String.class))).thenReturn(ps);
		reimbursement = new Reimbursement(1,150.00,created,created,"Test1","1","1001","0","0");
		when(rs.first()).thenReturn(true);
		when(rs.getInt(1)).thenReturn(reimbursement.getReimbId());
		when(rs.getDouble(2)).thenReturn(reimbursement.getAmount());
		when(rs.getTimestamp(3)).thenReturn(reimbursement.getSubmitted());
		when(rs.getTimestamp(4)).thenReturn(reimbursement.getResolved());
		when(rs.getString(5)).thenReturn(reimbursement.getDescription());
		when(rs.getInt(6)).thenReturn(Integer.parseInt(reimbursement.getAuthor()));
		when(rs.getInt(7)).thenReturn(Integer.parseInt(reimbursement.getResolver()));
		when(rs.getInt(8)).thenReturn(Integer.parseInt(reimbursement.getStatusId()));
		when(rs.getInt(9)).thenReturn(Integer.parseInt(reimbursement.getTypeId()));
		when(ps.executeQuery()).thenReturn(rs);
	}
	
	@After 
	public void tearDown() throws Exception{
		
	}
	
	@Test 
	public void testFindByIdSuccess() {
		assertEquals(new ReimbursementDao(rCon).findById(1).getReimbId(),reimbursement.getReimbId());
	}
	
	@Test 
	public void testFindByNameSuccess() {
		assertEquals(new ReimbursementDao(rCon).findByName("1").getAuthor(),reimbursement.getAuthor());
	}
	
	
}
