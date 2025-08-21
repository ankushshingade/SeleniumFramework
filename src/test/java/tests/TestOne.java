package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestOne extends BaseTest{

//	@BeforeSuite
//	public void beforeSuite()
//	{
//		System.out.println("This will execute before suite");
//	}
//	
//	@BeforeTest
//	public void beforeTest()
//	{
//		System.out.println("This will run before Test");
//	}
	
//	@BeforeClass   
//	public void beforeClass()
//	{
//		System.out.println("This will run before first test case of a class is executed");
//	}
	
	
	@Test
	public void testMethod()
	{
		System.out.println("This is test case 1");
	}
	
	@Test
	public void testMethod2()
	{
		System.out.println("This is test case 2");
	}
	
//	@BeforeMethod
//	public void beforeMethod()
//	{
//		System.out.println("This will run before every test case");
//	}
//	
//	@AfterMethod
//	public void afterMethod()
//	{
//		System.out.println("This will run After every test case");
//	}
//	
//	@AfterClass
//	public void afterClass()
//	{
//		System.out.println("This will run After all test cases of a class");
//	}
//	
//	@AfterTest
//	public void afterTest()
//	{
//		System.out.println("This will run After Test tag");
//	}
	
//	@AfterSuite
//	public void afterSuite()
//	{
//		System.out.println("This will run After Suite tag");
//	}
//	
	
	
}


//BeforeSuite
//BeforeTest
//BeforeClass   --- before executing first test case of a class
//BeforeMethod  -- before test case


//AfterMethod
//AfterClass
//AfterTest
//AfterSuite


