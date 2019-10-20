package com.sun.alertTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitTest {
	WebDriver driver;
	@Test
	public void allwait(){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		
	}
	
	@Test
	public void partwait(WebDriver driver, long timeOutInSeconds,By locator){
		new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		
		//new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("")));
		
		
	}

}
