package TestCases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import helpingfiles.Constant;
import helpingfiles.excel_helper;

public class TestCase_04 {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		
		baseUrl = Constant.practice_URL;
		
	}

	@Test
	public void testScreenshots() throws Exception {
		excel_helper.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");

		List<String> value = new ArrayList<String>();
		for (int i = 1; i <= 10; i++) {
			value.add(excel_helper.getCellData(4, i));
		}

		excel_helper.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet2");

		List<String> locator = new ArrayList<String>();
		for (int i = 1; i <= 10; i++) {
			locator.add(excel_helper.getCellData(8, i));
		}
		
		if(value.get(0).equals("Chrome")) {
			System.out.println("ChromeDriver was beeing started.....");
			driver = new ChromeDriver();
		}
		else {
			System.out.println("Mozilla Firefox beeing started..");
			driver = new FirefoxDriver();
		}
//System.out.println(locator);
//System.out.println(value);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		Select cars = new Select(driver.findElement(By.id(locator.get(0))));
	
		
		if(cars.getFirstSelectedOption().getText() == value.get(2)) {
			System.out.println("Alreday the given value is selected");
		}
		else {
			
			cars.selectByVisibleText(value.get(2));
			System.out.println("Selected the given value");

			  
			  excel_helper.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
			  excel_helper.setCellData("Pass",4,27);
			  driver.close();
		}
	}
	
	
	@After
	public void tearDown() throws Exception {
		
		driver.quit();
	}
}
