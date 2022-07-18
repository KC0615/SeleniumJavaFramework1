package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.sdk.trace.internal.data.ExceptionEventData;

public class SeleniumWaitDemo {

	public static void main(String[] args) {
		seleniumWaits();
	}
	
	public static void seleniumWaits(){
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/driver/chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//implicit wait The web site wait 10s
		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/center[1]/input[1]")).sendKeys(Keys.RETURN);
		
		//explicit wait find target and condition per 500ms
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcdef")));
		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.name("abcdef")));
		System.out.println(element.getText());
		driver.findElement(By.name("abcd")).click();
		
		driver.close();
		driver.quit();
	}
	
}
