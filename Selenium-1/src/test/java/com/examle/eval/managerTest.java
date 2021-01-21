package com.examle.eval;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.page.ReimbursmentFormPage;
import com.example.page.logginPage;
import com.example.page.reimbursementCenterPage;
import com.example.page.reimbursementPage;

public class managerTest {
	private logginPage loginPage;
	private reimbursementCenterPage rPage;
	private ReimbursmentFormPage fPage;
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
	public void updatesReimbursement() throws InterruptedException {
		loginPage.setUsername("Alanmz");
		loginPage.setPassword("1234");
		loginPage.submit();
		
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.urlMatches("/manager.html"));
		this.rPage = new reimbursementCenterPage(driver);
		
	}

}
