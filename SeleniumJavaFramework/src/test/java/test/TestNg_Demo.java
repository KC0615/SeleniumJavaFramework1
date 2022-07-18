package test;

import org.testng.annotations.Test;

import config.PropertiesFile;
import demo.Log4jDemo;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.GoogleSearchPage;

public class TestNg_Demo {
	
	WebDriver driver = null; 
	public static String browserName = null;
	private static Logger logger = LogManager.getLogger(Log4jDemo.class);
	
	@BeforeTest
	public void setUpTest(){
		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", projectPath+"/driver/chromedriver/chromedriver");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", projectPath+"/driver/geckodriver/geckodriver");
			driver = new FirefoxDriver();
		}
		
	}
	
	@Test
	public void googleSearch(){
		
		//goto google.com
		driver.get("https://google.com");
		
		//enter text in search box
		//driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		GoogleSearchPage.textbox_search(driver).sendKeys("Automation Step by Step");
		
		//click on search button
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
		
		
		
	}
	
	@AfterTest
	public void tearDownTest(){
		//close browser
			driver.close();
			//driver.quit();
			System.out.println("Test Completed SuccessFully");
			PropertiesFile.setProperties();
	}
	
}
