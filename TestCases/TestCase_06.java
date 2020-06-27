package TestCases;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import helpingfiles.Constant;
import helpingfiles.excel_helper;

public class TestCase_06 {
	private WebDriver driver;


	@Before
	public void setUp() throws Exception {
		
		
		
	}

	@Test
	public void testScreenshots() throws Exception {
		excel_helper.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");

		List<String> value = new ArrayList<String>();
		for (int i = 1; i <= 10; i++) {
			value.add(excel_helper.getCellData(7, i));
		}

		excel_helper.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet2");

		List<String> locator = new ArrayList<String>();
		for (int i = 1; i <= 10; i++) {
			locator.add(excel_helper.getCellData(14, i));
		}
		/*
		 * System.out.println(locator); System.out.println(value);
		 */
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
		
		 excel_helper.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
		  
		 
		 driver.get(value.get(1));
			
			WebElement priceSlider = driver.findElement(By.id(locator.get(0)));
			
			assertTrue(priceSlider.isDisplayed());
			
			Dimension sliderSize = priceSlider.getSize();
			System.out.println(sliderSize);
			
			Actions builder = new Actions(driver);   
			
			builder.clickAndHold(priceSlider)
				    .moveByOffset((-(int)priceSlider.getSize().width / 2), 0)
				    .moveByOffset(100, 0).release().perform();
		
		
		
		}
		 																											
		 
	
	
	
	
	@After
	public void tearDown() throws Exception {
		
		driver.quit();
	}
}
