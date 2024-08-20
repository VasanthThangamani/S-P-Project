package PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.excelUtils;

public class Uploadresume extends BasePage {

	public Uploadresume(WebDriver driver) {
		super(driver);
	}
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	@FindBy(xpath ="//iframe[@id=\"findDeviceTypeFrame\"]")
	WebElement frame1;

	@FindBy(xpath ="//a[@class=\"oneC_brandName\"]")
	WebElement menubar_mycareer;

	@FindBy(xpath ="//span[@class=\"mt-15 mx-0\" and text()=\"Upload Resume or LinkedIn Profile\"]")
	WebElement click_page;

	@FindBy(xpath = "//div[@class=\"mat-tooltip-trigger ml-1 label black cursor-pointer\"]")
	WebElement name;
	
	@FindBy(xpath = "//span[@class=\"d-flex align-items-center ng-star-inserted\"]/div")
	List<WebElement> Designation;
	

	@FindBy(xpath = "//span[@class=\"tertiary-button label cursor-pointer ng-star-inserted\" and text()=\"MY PROFILE ➝\"]")
	WebElement profile;

	@FindBy(xpath ="//div[@class=\"exp-con\"]/div[1]")
	WebElement working_company;

	@FindBy(xpath = "//div[@class=\"exp-con\"]/div[2]")
	WebElement experience;

	@FindBy(xpath = "//div[@class=\"education-details\"]/div[2]")
	WebElement education;

	@FindBy(xpath = "//div[@class=\"card-skill-con ng-star-inserted\"]/div")
	List<WebElement> topskills;

	@FindBy(xpath = "//span[@class=\"gray h5 item-name\" and text()=\"My Skilling Paths\" ]")
	WebElement skillpath;

	@FindBy(xpath = "//button[@class=\"mat-focus-indicator mat-tooltip-trigger primary-button mat-stroked-button mat-button-base ng-star-inserted\"]")
	WebElement skillpath_button;

	@FindBy(xpath = "//button[@class=\"mat-focus-indicator secondary-button h6 mat-button mat-button-base ng-star-inserted\"]")
	WebElement filter;

	@FindBy(xpath = "//button[@class=\"mat-focus-indicator secondary-button mat-stroked-button mat-button-base\"]")
	WebElement github_Account;

	public void TC002_uploadresumehomepage() throws IOException {
		int row1=1;
		System.out.println("Upload Resume Page Card Will Be Open:"); 
		
		
		driver.navigate().to("https://cognizantmyskills.prismforce.ai/home");

		System.out.println("Display name:");
		System.out.println(name.getText());
		String Employee_name=name.getText();
		excelUtils.setCellData("XLwrite", row1, 1,Employee_name);
		
		System.out.println("Role  Designation    Employeeid");
		System.out.println("===============================================");
		
		for(WebElement d:Designation) {
			//System.out.print(d.getText()+"     ");
			String designation_result=d.getText();
			excelUtils.setCellData("XLwrite", row1, 1,designation_result);
		}
		
		System.out.println();
		System.out.println("===============================================");

	}
	
	public void TC003_myprofilepage() throws IOException {
		System.out.println("My Profile Page is Opened....");
		profile.click();
		System.out.print("Comapny:");
		System.out.println(working_company.getText());
		System.out.print("Experience:");
		System.out.println(experience.getText());
		
		System.out.println("Emplyee Top skills:");
		int row=1;
		for(WebElement t:topskills) {
			//System.out.println(c+"."+t.getText());
			String skills=t.getText();
			excelUtils.setCellData("XLwrite", row, 0, skills);
			row++;
		}
	}

}
