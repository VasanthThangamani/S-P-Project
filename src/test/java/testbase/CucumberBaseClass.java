package testbase;

import java.io.FileReader;

import java.io.IOException;

import java.time.Duration;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;

public class CucumberBaseClass {

	public static WebDriver driver;

	public static Properties p;

	public static WebDriver initilizeBrowser() throws IOException {

		switch (getProperties().getProperty("browser").toLowerCase()) {

		case "chrome":

			driver = new ChromeDriver();

			break;

		case "edge":

			driver = new EdgeDriver();

			break;

		default:

			System.out.println("No matching browser");

			driver = null;

		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;

	}

	

	public static Properties getProperties() throws IOException {

		FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");

		p = new Properties();

		p.load(file);

		return p;

	}

}
