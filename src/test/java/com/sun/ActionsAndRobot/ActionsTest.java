package com.sun.ActionsAndRobot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableBiMap.Builder;

public class ActionsTest {
WebDriver driver;
String url = "http://www.baidu.com";
	
	
	@BeforeTest
	public void open(){
		System.setProperty("webdriver.chrome.driver", "F:\\javaworkspace\\Seleniumtest\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
	}
	
	//在元素中鼠标双击或者右击
	@Test
	public void actionsTest1(){
		driver.get(url);
		WebElement element = driver.findElement(By.id("su"));
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
		action.doubleClick(element).perform();
	
	}
	
	
	//鼠标移动到某个元素上
	@Test
	public void actionsTest2() throws InterruptedException{
		driver.get(url);
		WebElement element = driver.findElement(By.partialLinkText("设置"));
		Actions action =new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(element).perform();
	}
	
	
	//把元素拖到另一个元素上
	@Test
	public void actionsTest3(){
		driver.get(url);
		WebElement element1 = driver.findElement(By.className(""));
		WebElement element2 = driver.findElement(By.xpath(""));
		Actions action = new Actions(driver);
		action.clickAndHold(element1)
			.moveToElement(element2)
			.release(element2)
			.perform();
	}
	
	
	//下拉框多选
	@Test
	public void actionTest4(){
		driver.get(url);
		Actions action = new Actions(driver);
		WebElement select = driver.findElement(By.xpath(""));
		List<WebElement> list = select.findElements(By.tagName(""));
		Action multipleSelect = action.keyDown(Keys.SHIFT)
				.click(list.get(0))
				.click(list.get(2))
				.build();
		multipleSelect.perform();
	}
	
	@Test
    public void robotDemo() throws AWTException {
        Robot robot = new Robot();
//        按住Ctrl按键
        robot.keyPress(KeyEvent.VK_CONTROL);
//        按住S按键
        robot.keyPress(KeyEvent.VK_S);
//        得到S的ASCII值
        int keyS = (int)new Character('S');
//        松开s键
        robot.keyRelease(keyS);
//        松开Ctrl键
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }
	@Test
	public void uploadTest(){
		driver.get(url);
		driver.findElement(By.id("load")).sendKeys("C:\\Download");
			
	}
	

}
