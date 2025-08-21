package tests;


import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestTwo extends BaseTest{
	
	
//	@BeforeSuite  
//	public void beforeSuiteofTestTwo()
//	{
//		System.out.println("Before Suite of Test Two");
//	}
	
	@Test
	public void LoginTest()
	{
		System.out.println("This is login test case");
	}
	
	@Test(dependsOnMethods = {"LoginTest"} )
	public void verifyDashboard()
	{
		System.out.println("This is To verify dashboard");
	}

	@Test 
	public void testInTestTwo()
	{
		System.out.println("Test in test 2 called");
	}
	
	@Test(groups = {"Regression", "Smoke"})
	public void groupTestCase()
	{
		System.out.println("This test case belongs to Regression and Smoke");
	}
	
	@Test(groups = {"Smoke"})
	public void smokeTestCase()
	{
		System.out.println("This test case belongs to Smoke");
	}
	
//	@BeforeGroups("Regression")
//	public void beforeGroup1Executes()
//	{
//		System.out.println("This will execute before Regression");
//	}
	
	
	
	
	
//	@AfterGroups("Smoke")
//	public void afterSmoke()
//	{
//		System.out.println("This will execute After Smoke");
//	}
	
	
	
}
