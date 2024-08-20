package PageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareerLattice extends BasePage {

	public CareerLattice(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@placeholder=\"Search this site...\"]")
	WebElement Search;
	
	@FindBy(xpath="//div[@class=\"appsResultText\" and text()=\"MyCareer\"]")
	WebElement inputbox;
	
	@FindBy(xpath="//iframe[@id=\"appFrame\"]")
    WebElement farmeno1;
	
	@FindBy(xpath="//span[@class=\"mt-15 mx-0\" and text()=\"Career Lattice & Role Description\"]")
	WebElement click_page;
	
	@FindBy(xpath="//iframe[@id=\"content_area\"]")
    WebElement farmeno2;
	
	@FindBy(xpath="//div[@class=\"HR-careerLattice\"]/h3")
	WebElement serviceline;
	
	//@FindBy(xpath="//td[@role=\"QQE112\"]/div/span/a")
	//WebElement patrole;
	
	@FindBy(xpath="//tr[@grade=\"PAT/PT/AS\"]/td[7]/div/span/a")
	WebElement patrole;
	
	@FindBy(xpath="//td[@role=\"QDE313\"]/div/span/a")
	WebElement associaterole;
	
	public void TC001_careerlatticepage() {
		
		System.out.println("Searching MyCareer App");
		
		Search.sendKeys("MyCareer");
		
		inputbox.click();
		
		System.out.println("MyCareer App Clicked");
		
		driver.switchTo().frame(farmeno1);
		
		System.out.println("MyCareer App Display Available Cards");
		
		click_page.click();
		
		System.out.println("Careerlattice and Role Discription Card is clicked");
		
		driver.switchTo().frame(farmeno2);
		
		System.out.println("Service Line of the Domain");
		System.out.println(serviceline.getText());
		
		String Actual_result=patrole.getText();
		
		System.out.println("Actual result is"+Actual_result);
		
		
	}
	
	
	

}
