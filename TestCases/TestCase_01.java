package TestCases;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class TestCase_01 {
	WebDriver driver = null;

	@Test
	void test() throws Exception {

		Funtionalities.Registration(driver);

		System.out.println("Registration Successfully, now it is the time to Log in buddy.");

	}

}
