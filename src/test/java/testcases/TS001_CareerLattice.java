package testcases;

import org.testng.annotations.Test;

import PageObjects.CareerLattice;
import testbase.BaseClass;

public class TS001_CareerLattice extends BaseClass {
	@Test(priority=1,groups= {"sanity","regression"})
    public void TC001_careerlatticepageactions() {
		System.out.println("TestCase_1:");
		CareerLattice test1=new CareerLattice(driver);
		test1.TC001_careerlatticepage();
    	System.out.println("===========================================================");
    }

}
