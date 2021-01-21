package com.examle.eval;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.page.employeePage;
import com.example.page.logginPage;
import com.example.page.reimbursementPage;

public class employeePageTest {

	private logginPage loginPage;
	private employeePage uPage;
	private reimbursementPage rPage;
	private employeePage uPage2;
	
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
		this.loginPage = new logginPage(driver);
	}	
	
	@After 
	public void tearDown() throws Exception{
	}
	
	@Test 
	public void goesTocreateWindow() throws InterruptedException {
		loginPage.setUsername("mendozam");
		loginPage.setPassword("Tacos");
		loginPage.submit();
		
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.urlMatches("/employee.html"));
		uPage = new employeePage(driver);
		
		Dimension d = uPage.getRows();
		System.out.println(d.getHeight());
	
		WebDriverWait wait2 = new WebDriverWait(driver,60);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.name("table")));
		uPage.submit();
		WebDriverWait wait3 = new WebDriverWait(driver,60);
		wait3.until(ExpectedConditions.urlMatches("/newReimbursement.html"));
		assertEquals("http://localhost:9012/html/newReimbursement.html",driver.getCurrentUrl());
	}
	
		@Test 
		public void addReimbursementSuccessSelenium() throws InterruptedException{
		loginPage.setUsername("mendozam");
		loginPage.setPassword("Tacos");
		loginPage.submit();
		
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.urlMatches("/employee.html"));
		uPage = new employeePage(driver);
		
		WebDriverWait wait2 = new WebDriverWait(driver,60);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("td")));
		List<WebElement> rows = uPage.getTable().findElement(By.name("body")).findElements(By.tagName("tr"));
		int rowsBefore = rows.size();
		uPage.submit();
		WebDriverWait wait3 = new WebDriverWait(driver,60);
		wait3.until(ExpectedConditions.urlMatches("/newReimbursement.html")); 
		rPage = new reimbursementPage(driver); 
		rPage.setAmount("5555");
		rPage.setDescription("Testing"); 
		rPage.submit(); 
		WebDriverWait wait5 = new WebDriverWait(driver,60);
		wait5.until(ExpectedConditions.urlMatches("/employee.html")); 
		uPage2 = new employeePage(driver); 
		WebDriverWait wait4 = new WebDriverWait(driver,60);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("td")));
		List<WebElement> rows2 = uPage2.getTable().findElement(By.name("body")).findElements(By.tagName("tr"));
		int rowsAfter = rows2.size();
		assertTrue(rowsAfter == rowsBefore + 1);
		 
	}
	
}
