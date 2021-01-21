package com.example.eval;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.dao.ReimbursementDao;
import com.example.model.Reimbursement;
import com.example.service.ReimbursementService;

public class ReimbursementServiceTest {
	
	@Mock
	private ReimbursementDao mockedDao;
	private ReimbursementService testService = new ReimbursementService(mockedDao);
	private Reimbursement testReimb;
	private Reimbursement testReimb2;
	
	Timestamp created = new Timestamp(System.currentTimeMillis());
	List<Reimbursement> list = new ArrayList<Reimbursement>();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		
	}
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		testService = new ReimbursementService(mockedDao);
		testReimb = new Reimbursement(1,150.0,created,created,"Test1","1","1001","0","0");
		testReimb2 = new Reimbursement(3,132.0,created,created,"Test32","3","1","2","1");
		
		
		list.add(testReimb);
		list.add(testReimb2);
		when(mockedDao.findByName("1")).thenReturn(testReimb);
		when(mockedDao.findById(1)).thenReturn(testReimb);
		when(mockedDao.getAllManager()).thenReturn(list);
		when(mockedDao.getAll(1)).thenReturn(list);
		
	}
	
	@After 
	public void tearDown() throws Exception{
	}
	
	@Test 
	public void testGetReimbSuccess() {
		assertEquals(testService.getReimbursement("1"),testReimb);
	}

	@Test(expected = NullPointerException.class)
	public void testGetReimbFailure() {
		assertEquals(testService.getReimbursement("561"),null);
	}
	
	@Test 
	public void testgetReimbursementById() {
		assertEquals(testService.getReimbursementById(1),testReimb);
	}
	
	@Test
	public void testGetallSuccess() {
		assertEquals(testService.getAllForManager(),list);
	}
	
	@Test
	public void testGetallSuccess2() {
		assertEquals(testService.getAllReimbursements(1), list);
	}
	
}
