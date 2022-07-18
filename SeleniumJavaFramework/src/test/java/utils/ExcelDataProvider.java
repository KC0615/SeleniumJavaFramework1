package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class ExcelDataProvider {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest(){
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/driver/chromedriver/chromedriver");
		driver = new ChromeDriver();
		
		
	}
	
	@Test(dataProvider = "test1data")
	public void test1(String username, String password) throws Exception{
		System.out.println(username+" | "+password);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		//driver.findElement(By.id("btnLogin")).sendKeys(Keys.RETURN);
		Thread.sleep(2000);
	}
	
	@DataProvider(name = "test1data")
	public static Object[][] getData(){
		String excelPath = System.getProperty("user.dir")+"/excel/data.xlsx";
		
		Object data[][] = testData(excelPath, "Sheet1");
		return data;
	}
	
	public static Object[][] testData(String excelPath, String sheetName) {
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i=1; i<rowCount; i++){
			for(int j=0; j<colCount; j++){
				String cellData = excel.getCellDataString(i, j);
				//System.out.print(cellData + " | ");
				data[i-1][j] = cellData;

			}
			//System.out.println();
		}
		return data;
	}
	
}
