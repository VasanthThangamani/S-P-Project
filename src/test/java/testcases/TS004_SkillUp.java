package testcases;

import org.testng.annotations.Test;

import PageObjects.SkillUp;
import testbase.BaseClass;

public class TS004_SkillUp extends BaseClass{
	@Test(priority=4,groups= {"sanity","regression"})
    public void TC006_Employeeacquireskills() throws InterruptedException{
		System.out.println("TestCase_6:");
		SkillUp test6=new SkillUp(driver);	
		test6.skillstatus();	
    }
	
	@Test(priority=5,groups= {"sanity","regression"})
	public void TC007_Developmentplanactions() throws InterruptedException {
		System.out.println("TestCase_7:");
		SkillUp test7=new SkillUp(driver);
		test7.developmentplan();
	}
	
	

}
