package com.examle.eval;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.example.page.logginPage;

public class logginPageTest {

	private logginPage page;
	
	private static WebDriver driver;
	
	@BeforeClass 
	public static void setUpBeforeClass() throws Exception{
		String filepath ="src/test/resources/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filepath);
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public static void tearDownAfteClass() throws Exception {
		driver.quit();
	}
	
	@Before
	public void setUp() throws Exception {
		this.page = new logginPage(driver);
	}
	
	@After 
	public void tearDown() throws Exception{
	}
	
	@Test 
	public void testSuccessfulLoginEmployee() {
		page.setUsername("mendozam");
		page.setPassword("Tacos");
		page.submit();
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.urlMatches("/employee.html"));
		assertEquals("http://localhost:9012/html/employee.html",driver.getCurrentUrl());
	}
	
	@Test
	public void failedLoginEmployee() {
		page.setUsername("mendozam");
		page.setPassword("tacos");
		page.submit();
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.urlMatches("/notFound.html"));
		assertEquals("http://localhost:9012/html/notFound.html",driver.getCurrentUrl());
	}
	
	@Test
	public void testSuccessfulLoginManager() {
		page.setUsername("Alanmz");
		page.setPassword("1234");
		page.submit();
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.urlMatches("/manager.html"));
		assertEquals("http://localhost:9012/html/manager.html",driver.getCurrentUrl());
	}
	
	@Test
	public void failedLoginManager() {
		page.setUsername("Alanmz");
		page.setPassword("134");
		page.submit();
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.urlMatches("/notFound.html"));
		assertEquals("http://localhost:9012/html/notFound.html",driver.getCurrentUrl());
	}
	

}
