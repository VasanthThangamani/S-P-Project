package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.CareerLattice;
import io.cucumber.java.en.Given;

public class Cucu_Careerlattice {

	WebDriver driver = new ChromeDriver();
	CareerLattice test1= new CareerLattice(driver);

	@Given("User Navigated to OneC Website")
	public void user_navigated_to_one_c_website() {
		test1.TC001_careerlatticepage();
		
	}

}
