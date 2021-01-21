package com.example.page;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class employeePage {
	

	private WebDriver driver;
	private WebElement createButton;
	private WebElement tbody;
	
	
	public employeePage(WebDriver driver) {
		this.driver = driver;
		this.navigateTo();
		this.tbody = driver.findElement(By.name("table"));
		this.createButton = driver.findElement(By.name("enter"));
		
	}
	
	public void navigateTo(){
		this.driver.get("http://localhost:9012/html/employee.html");
	}
	
	public Dimension getRows() {
		return tbody.getSize();
	}
	
	public void submit() {
		 this.createButton.click();
	}
	
	public WebElement getTable() {
		return this.tbody;
	}
}
