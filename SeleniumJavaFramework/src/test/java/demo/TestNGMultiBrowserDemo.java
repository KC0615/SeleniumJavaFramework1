package demo;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultiBrowserDemo {
	
	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
	
	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName){
		System.out.println("Browser name is : "+browserName+"\n Thread id : "+Thread.currentThread().getId());
		
		
		if(browserName.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", projectPath+"/driver/chromedriver/chromedriver");
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", projectPath+"/driver/geckodriver/geckodriver");
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("safari")){
			System.setProperty("webdriver.gecko.driver", projectPath+"/driver/safari/safaridriver");
			driver = new SafariDriver();
		}
		
	}
	@Test
	public void test1() throws Exception{
		driver.get("https://google.com");
		Thread.sleep(4000);
	}
	@AfterTest
	public void teardown(){
		driver.close();
		System.out.println("Test Completed Sucessfully");
	}
	
}
