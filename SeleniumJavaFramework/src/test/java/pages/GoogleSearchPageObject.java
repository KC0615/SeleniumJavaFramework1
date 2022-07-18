package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObject {

	WebDriver driver = null;
	
	By textbox_search = By.name("q");
	By button_search = By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/center[1]/input[1]");
	
	public GoogleSearchPageObject(WebDriver driver){
		this.driver = driver;
	}
	
	public void setTextInSearchBox(String text){
		driver.findElement(textbox_search).sendKeys(text);
	}
	
	public void clickSearchButton(){
		driver.findElement(button_search).sendKeys(Keys.RETURN);
	}
}
