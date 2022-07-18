package test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.GoogleSearchPage;

public class TestNg_Demo2 {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest(){
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/driver/chromedriver/chromedriver");
		driver = new ChromeDriver();
		
		
	}
	
	@Test
	public void googleSearch3(){
		
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
			driver.quit();
			System.out.println("Test Completed SuccessFully");
	}
	
}
