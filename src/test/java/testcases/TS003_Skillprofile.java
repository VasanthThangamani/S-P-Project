package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.Skillprofile;
import testbase.BaseClass;

public class TS003_Skillprofile extends BaseClass{
	@Test(priority=2,groups= {"sanity","regression"})
    public void TC004_Skillprofilepageactions() throws InterruptedException, IOException {
		System.out.println("TestCase_4:");
		Skillprofile test4=new Skillprofile(driver);
		test4.employee_Technicalskill_data();
		test4.employee_domainskill_data();
		System.out.println("===========================================================");
		 	
    }
	
	@Test(priority=3,groups= {"sanity","regression"})
    public void TC005_filterskillactions() throws InterruptedException {
		System.out.println("TestCase_5:");
		Skillprofile test5=new Skillprofile(driver);
		test5.filter_skills();
		System.out.println("===========================================================");
    }
	

}
