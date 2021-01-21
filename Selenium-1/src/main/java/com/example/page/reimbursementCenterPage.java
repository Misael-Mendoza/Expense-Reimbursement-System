package com.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class reimbursementCenterPage {
	
	private WebDriver driver; 
	private WebElement filterField;
	private WebElement table;
	
	
	public reimbursementCenterPage(WebDriver driver) {
		this.driver = driver;
		this.navigateTo();
		this.filterField = driver.findElement(By.className("filter-reimb"));
		this.table = driver.findElement(By.name("body"));
		
	}
	
	
	public void navigateTo() {
		this.driver.get("http://localhost:9012/html/manager.html");
	}
	
	public void setFilter(String filterValue) {
		Select filter = new Select(this.filterField);
		filter.selectByVisibleText(filterValue);
	}

	
	public WebElement getTable() {
		return this.table;
	}

}
