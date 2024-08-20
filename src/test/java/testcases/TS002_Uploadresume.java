package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.Uploadresume;
import testbase.BaseClass;

public class TS002_Uploadresume extends BaseClass{
	
		@Test(priority=2,groups= {"sanity","regression"})
	    public void TC002_003_uploadresumepageactions() throws IOException{
			System.out.println("TestCase_2:");
			Uploadresume test2=new Uploadresume(driver);
			test2.TC002_uploadresumehomepage();
			System.out.println("===========================================================");
			System.out.println("TestCase_3:");
			test2.TC003_myprofilepage(); 
			System.out.println("===========================================================");
	    }

}
