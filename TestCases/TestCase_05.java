package TestCases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import helpingfiles.Constant;
import helpingfiles.excel_helper;

public class TestCase_05 {
	private WebDriver driver;
	

	@Test
	public void testScreenshots() throws Exception {
		excel_helper.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");

		List<String> value = new ArrayList<String>();
		for (int i = 1; i <= 10; i++) {
			value.add(excel_helper.getCellData(6, i));
		}

		excel_helper.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet2");

		List<String> locator = new ArrayList<String>();
		for (int i = 1; i <= 10; i++) {
			locator.add(excel_helper.getCellData(11, i));
		}
		
		if(value.get(0).equals("Chrome")) {
			System.out.println("ChromeDriver was beeing started.....");
			driver = new ChromeDriver();
		}
		else {
			System.out.println("Mozilla Firefox beeing started..");
			driver = new FirefoxDriver();
		}
	

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(value.get(1));
		 excel_helper.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
		  
		if (value.get(2).equals("click") || value.get(2).equals("Click")) {
		
			WebElement bmwcheck = driver.findElement(By.id(locator.get(0)));
			bmwcheck.click();
			
				if(bmwcheck.isSelected() == true) {
					excel_helper.setCellData("True",6,7);
				}
				else {
					excel_helper.setCellData("True",6,6);
				}
		}
		if (value.get(3).equals("click") || value.get(3).equals("Click")) {
			
			WebElement benzcheck = driver.findElement(By.id(locator.get(1)));
			benzcheck.click();
		}
		if (value.get(4).equals("click") || value.get(4).equals("Click")) {
			
			WebElement hondacheck = driver.findElement(By.id(locator.get(2)));
			hondacheck.click();
			
			
			
		}
		excel_helper.setCellData("Pass",6,27);
		
			  
		}
	
	
	
	@After
	public void tearDown() throws Exception {
		
		driver.quit();
	}
}
