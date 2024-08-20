package PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.excelUtils;

public class Skillprofile extends BasePage {

	public Skillprofile(WebDriver driver) {
		super(driver);
	}
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	@FindBy(xpath="//span[@class=\"gray h5 item-name\" and text()=\"My Skills & Competencies\"]")
	WebElement Employeeskills;
	
	
	@FindBy(xpath="//div[@class=\"truncate-skill label black\"]")
	List<WebElement> skilldata;
	
	@FindBy(xpath = "//*[text()=\"Domain (2)\"]")
	WebElement Domain;
 
	@FindBy(xpath = "//div[@class=\"name body black\"]")
	List<WebElement> DomainSkills;
	
	@FindBy(xpath="//span[@class=\"gray h5 item-name\" and text()=\"My Skilling Paths\"]")
	WebElement skillpath;
	
	
	@FindBy(xpath="//button[@class=\"mat-focus-indicator mat-tooltip-trigger primary-button mat-stroked-button mat-button-base ng-star-inserted\"]")
	WebElement button;
	
	@FindBy(xpath="//button[@class=\"mat-focus-indicator secondary-button h6 mat-button mat-button-base ng-star-inserted\"]")
	WebElement filter_button;
	
	@FindBy(xpath="//div[@class=\"input-con-quarter ng-star-inserted\"]")
	List<WebElement>dropdowns;
	
	@FindBy(xpath="//input[@formcontrolname=\"input\"]")
	WebElement inputbox;
	
	@FindBy(xpath="//div[@class=\"skill-cluster-list-found caption gray\"]")
	WebElement totalclusters;
	
	
	public void employee_Technicalskill_data() throws InterruptedException, IOException {
		
		driver.navigate().back();
		
		System.out.println("Employees Technical Skill:");
		
		Thread.sleep(2000);		
		
		Employeeskills.click();
		int row=1;
		for(WebElement skill:skilldata) {
			String skill2=skill.getText();
			excelUtils.setCellData("XLwrite", row, 2, skill2);
			row++;
		}
		System.out.println("Data Entered in Excel sheet");
	}
	
	public void employee_domainskill_data() throws InterruptedException, IOException {
		
        Domain.click();
		System.out.println("Employees Domain Skill:");
		Thread.sleep(1000);
		int row=1;
		for(WebElement skill1:skilldata) {
			String skill3=skill1.getText();
			excelUtils.setCellData("XLwrite", row, 3, skill3);
			row++;
		}
		System.out.println("Data Entered in Excel sheet");
		
	}
	

	
	public void filter_skills() throws InterruptedException {
		
		System.out.println("My Skillpath menu is Clicked.");
		skillpath.click();
		
		Thread.sleep(5000);
		
		System.out.println("Select Skill path button");
		
		button.click();
		
		Thread.sleep(1000);
		
		filter_button.click();
		
		System.out.println("Filter Button is Clicked");
		
		System.out.println(totalclusters.getText());
		
		Thread.sleep(1000);
		
	}
	
	
	
	

}
