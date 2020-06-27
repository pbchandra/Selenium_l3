package TestCases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpingfiles.Constant;
import helpingfiles.excel_helper;

public class Funtionalities {

	public static void Registration (WebDriver driver) throws Exception {

		excel_helper.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");

		List<String> value = new ArrayList<String>();
		for (int i = 1; i <= 40; i++) {
			value.add(excel_helper.getCellData(1, i));
		}

		excel_helper.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet2");

		List<String> locator = new ArrayList<String>();
		for (int i = 1; i <= 40; i++) {
			locator.add(excel_helper.getCellData(2, i));
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

		WebElement Sign_in = driver.findElement(By.xpath(locator.get(0)));
		Sign_in.click();
		Thread.sleep(2000);
		WebElement element = null;
		try {
			
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 3);
			element = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.id(locator.get(1))));
			System.out.println("Element appeared on the web page");	
		} catch(Exception e) {
			System.out.println("Element not appeared on the web page");
		}
		System.out.println(driver.getTitle());
		
		StringBuilder sb = new StringBuilder();
		String characters = "1234567890";
		for (int i = 0; i < 5; i++) {
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		String rand_email =value.get(2)+sb.toString()+"@gmail.com";
		System.out.println(rand_email);
		
		WebElement Email_address = driver.findElement(By.id(locator.get(1)));
		Email_address.sendKeys(rand_email);

		WebElement Create_account = driver.findElement(By.id(locator.get(2)));
		Create_account.click();
		if (value.get(3) == "Mr.") {
			WebElement Mr = driver.findElement(By.id(locator.get(3)));
			Mr.click();
		} else {
			WebElement Mrs = driver.findElement(By.id(locator.get(4)));
			Mrs.click();
		}

		WebElement First_name = driver.findElement(By.id(locator.get(5)));
		First_name.sendKeys(value.get(5));

		WebElement Last_name = driver.findElement(By.id(locator.get(6)));
		Last_name.sendKeys(value.get(5));

		WebElement email = driver.findElement(By.id(locator.get(7)));
		email.clear();
		email.sendKeys(rand_email);

		WebElement Password = driver.findElement(By.id(locator.get(8)));
		Password.sendKeys(value.get(7));

		Select days = new Select(driver.findElement(By.id(locator.get(9))));
		days.selectByValue(value.get(8));

		Select months = new Select(driver.findElement(By.id(locator.get(10))));
		months.selectByValue((value.get(9)));

		Select years = new Select(driver.findElement(By.id(locator.get(11))));
		years.selectByValue(value.get(10));

	
		if (value.get(11).equals("click") || value.get(11).equals("Click")) {
			System.out.println(locator.get(12));
			WebElement newsletter = driver.findElement(By.id(locator.get(12)));
			newsletter.click();
		}
		if (value.get(12).equals("click") || value.get(12).equals("Click")) {
			WebElement uniform_optin = driver.findElement(By.id(locator.get(13)));
			uniform_optin.click();
		}

		WebElement company = driver.findElement(By.id(locator.get(14)));
		company.sendKeys(value.get(13));

		WebElement address1 = driver.findElement(By.id(locator.get(15)));
		address1.sendKeys(value.get(14));

		WebElement address2 = driver.findElement(By.id(locator.get(16)));
		address2.sendKeys(value.get(15));

		WebElement city = driver.findElement(By.id(locator.get(17)));
		city.sendKeys(value.get(16));

		Select state = new Select(driver.findElement(By.id(locator.get(18))));
		state.selectByVisibleText(value.get(17));

		WebElement zipcode = driver.findElement(By.id(locator.get(19)));
		zipcode.sendKeys(value.get(18));
		
		WebElement addinfo = driver.findElement(By.id(locator.get(21)));
		addinfo.sendKeys(value.get(20));
		
		WebElement hphone = driver.findElement(By.id(locator.get(22)));
		hphone.sendKeys(value.get(21));
		
		WebElement mphone = driver.findElement(By.id(locator.get(23)));
		mphone.sendKeys(value.get(22));
		
		WebElement alias = driver.findElement(By.id(locator.get(24)));
		alias.clear();
		alias.sendKeys(value.get(23));

		WebElement Register = driver.findElement(By.id(locator.get(25)));
		Register.click();
		
		String validator = driver.findElement(By.xpath(locator.get(26))).getText();
			

		if(validator.equals(value.get(25))) {
			System.out.println("pass");
			excel_helper.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
			excel_helper.setCellData("Pass",1,27);
		}
		driver.quit();
	}
	public static void Tabe(WebDriver driver) throws Exception {

		excel_helper.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");

		List<String> value = new ArrayList<String>();
		for (int i = 1; i <= 40; i++) {
			value.add(excel_helper.getCellData(2, i));
		}

		excel_helper.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet2");

		List<String> locator = new ArrayList<String>();
		for (int i = 1; i <= 40; i++) {
			locator.add(excel_helper.getCellData(5, i));//row, column
		}
		//System.out.println(locator);
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
		
		List<String> list = new ArrayList<String>	();
		  list.add(driver.findElement(By.xpath(locator.get(0))).getText());
		  list.add(driver.findElement(By.xpath(locator.get(1))).getText());
		  list.add(driver.findElement(By.xpath(locator.get(2))).getText());
		  list.add(driver.findElement(By.xpath(locator.get(3))).getText());
		  list.add(driver.findElement(By.xpath(locator.get(4))).getText());
		  list.add(driver.findElement(By.xpath(locator.get(5))).getText());
		  list.add(driver.findElement(By.xpath(locator.get(6))).getText());
		  list.add(driver.findElement(By.xpath(locator.get(7))).getText());
		  list.add(driver.findElement(By.xpath(locator.get(8))).getText());
		  
		  
		 
		  
		  System.out.println(list.contains("Let's Kode It"));
		  excel_helper.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
		  excel_helper.setCellData("Pass",2,27);
		  driver.close();
		
		
		
}

}
