package testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Properties p;
	
	@BeforeTest(groups= {"sanity","regression"})
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException
	
	{
		//loading properties file
		 FileReader file=new FileReader(".//src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);
		

		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			//launching browser based on condition - locally
			switch(br.toLowerCase())
			{
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
			default: System.out.println("No matching browser..");
						return;
			}
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		
		//Launch url_in Browser
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterTest(groups= {"sanity","regression"})
	public void tearDown() {
		driver.quit();
	}

	public String captureScreen(String name) {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\Screenshot\\" + name + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;
	}
	
}
