package listeners;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class TestNgListenerDemo {
	
	@Test
	public void test1(){
		System.out.println("I am inside Test 1");
		
	}
	@Test
	public void test2(){
		System.out.println("I am inside Test 2");

		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : "+projectPath);

		System.setProperty("webdriver.chrome.driver", projectPath+"/driver/chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		driver.close();
	}
	@Test
	public void test3(){
		System.out.println("I am inside Test 3");
		throw new SkipException("This test is skipped");
	}
}
