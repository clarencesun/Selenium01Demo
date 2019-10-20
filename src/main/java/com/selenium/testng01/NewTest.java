package com.selenium.testng01;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
  @Test
  public void b() {
	  System.out.println("this is new test");
	  Assert.assertTrue(true);
  }
  @Test(enabled=false)
  public void a() {
	  System.out.println("this is new test2");
	  Assert.assertTrue(true);
  }
  @Test
  public void c() {
	  System.out.println("this is new test3");
	  Assert.assertTrue(true);
  }
  @BeforeTest
  public void b1() {
	  System.out.println("this is BeforeTest");
	  Assert.assertTrue(true);
  }
  @AfterTest
  public void a1() {
	  System.out.println("this is AfterTest");
	  Assert.assertTrue(true);
  }
  @BeforeClass
  public void b2() {
	  System.out.println("this is BeforeClass");
	  Assert.assertTrue(true);
  }
  @AfterClass
  public void a2() {
	  System.out.println("this is AfterClass");
	  Assert.assertTrue(true);
  }
  @AfterMethod
  public void a3() {
	  System.out.println("this is AfterMethod");
	  Assert.assertTrue(true);
  }
  @BeforeMethod
  public void b3() {
	  System.out.println("this is BeforeMethod");
	  Assert.assertTrue(true);
  }
  @Test(timeOut = 5000) // time in mulliseconds
  public void testThisShouldPass() throws InterruptedException {
      Thread.sleep(4000);
      System.out.println("此处停顿5秒");
      System.out.println("调试");
      System.out.println("调试2");
  }

  /*@Test(timeOut = 1000)
  public void testThisShouldFail() {
      while (true){
          // do nothing
      }

  }*/
  @Test(enabled=true)
  public void TestNgLearn1() {
      System.out.println("this is TestNG test case1");
  }
  
  @Test(dependsOnMethods= {"TestNgLearn1"})
  public void TestNgLearn2() {
      System.out.println("this is TestNG test case2");
  }


}
