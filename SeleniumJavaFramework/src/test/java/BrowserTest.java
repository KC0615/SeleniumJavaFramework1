
import java.util.List;
import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserTest {
	public static void main(String[] args) throws InterruptedException {
		
		//String projectPath = System.getProperty("user.dir");
		//System.out.println("projectPath : "+projectPath);
		
		//System.setProperty("webdriver.gecko.driver", projectPath+"/driver/geckodriver/geckodriver");
		//WebDriver driver = new FirefoxDriver();
		
		//System.setProperty("webdriver.chrome.driver", projectPath+"/driver/chromedriver/chromedriver");
		//WebDriver driver = new ChromeDriver();
		
		//#The IE driver only runs on Windows.
		//System.setProperty("webdriver.ie.driver", projectPath+"/driver/iedriver/IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver();
		
		//#Enable Safari > Choose Develop > Allow Remote Automation.
		//System.setProperty("webdriver.safari.driver", projectPath+"/driver/safaridriver/safaridriver");
		//WebDriver driver = new SafariDriver();
		WebDriverManager.chromedriver().driverVersion("2.3.6").setup();
		WebDriver driver = new ChromeDriver();

//		try {
//			if(true){
//				
//			}
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
//		List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
//		
//		int count = listOfInputElements.size();
//		
//		System.out.println("Count of Input Elements : "+count);
//		
//		driver.findElement(By.cssSelector("div.login-box div.el-card.login-card.is-never-shadow div.el-card__body div.el-tabs.el-tabs--top:nth-child(4) div.el-tabs__content div.el-tab-pane:nth-child(1) form.el-form.el-form--label-left div.el-form-item.is-required:nth-child(2) div.el-form-item__content div.el-input.el-input--prefix.el-input--suffix > input.el-input__inner")).sendKeys("Auto text the email");
//		Thread.sleep(3000);
		
	}
}
