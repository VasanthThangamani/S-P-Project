package PageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SkillUp extends BasePage {

	public SkillUp(WebDriver driver) {
		super(driver);
	}
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	
	@FindBy(xpath="//iframe[@id=\"appFrame\"]")
	WebElement frame1;
	
	@FindBy(xpath="//td[@class=\"con-wrapper ng-scope\"]/div/span")
	List<WebElement> courses;
	
	@FindBy(xpath="//td[@class=\"con-wrapper\"]/span")
	List<WebElement> skillstatus;
	
	@FindBy(xpath="//a[@class=\"accordion-toggle Acquireaccordin\" and text()=\"Acquire Skills\"]")
	WebElement scroll;
	
	@FindBy(xpath="//button[@class=\"btn setdevbtn\"]")
	WebElement plan_button;
	
	@FindBy(xpath="//span[@class=\"title\"]")
	WebElement scroll_1;
	
	
	@FindBy(xpath="//span[@class=\"close-icon\"]")
	WebElement popup;
	
	@FindBy(xpath="//iframe[@id=\"appFrame\"]")
	WebElement frame2;
	
	@FindBy(xpath="id=\"dropdownMenu1\"")
	WebElement dropdown;
	
	public void skillstatus() throws InterruptedException {
		driver.navigate().to("https://onecognizant.cognizant.com/Home?GlobalAppID=1738&URL=https://onecognizantazrapps.cognizant.com/1738/RDPApp/");
		
		driver.switchTo().frame(frame1);
		
		js.executeScript("arguments[0].scrollIntoView(true);",scroll);
	
		for(WebElement c:courses) {
			System.out.println(c.getText());
		}
		
		System.out.println("Skill Type    Expected Proficiency      Status");
		System.out.println("===============================================================");
		for(WebElement s:skillstatus) {
			System.out.print(s.getText()+"      ");
		}
		System.out.println();
		System.out.println("===============================================================");
		Thread.sleep(1000);
		
	}
	
	public void developmentplan() throws InterruptedException {
		
		js.executeScript("arguments[0].click();",plan_button);
		System.out.println("Edit Development paln button is clicked");
		Thread.sleep(1000);
		//popup.click();
		js.executeScript("arguments[0].click();",popup);
		System.out.println("Tutorial Video is Closed");
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		
		
		System.out.println("Show Available Development Option");
		
		driver.switchTo().frame(frame2);
		
		
		Thread.sleep(2000);
		/*
		js.executeScript("arguments[0].click();",dropdown);
		
		Select d=new Select(dropdown);
		
		List<WebElement> down=d.getOptions();
		for(WebElement options:down) {
			System.out.println(options.getText());
		}*/
	}
	
	
}
