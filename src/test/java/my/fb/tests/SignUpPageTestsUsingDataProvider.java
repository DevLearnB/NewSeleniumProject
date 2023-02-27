package my.fb.tests;

import org.testng.annotations.Test;
import my.fb.dataprovider.ExcelDataProvider;
import my.fb.pages.SignUpPage;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterMethod;


public class SignUpPageTestsUsingDataProvider {

	WebDriver driver;
	
	@Test (dataProvider="searchTerms", dataProviderClass = ExcelDataProvider.class)
	public void signinTest1(String email, String pwd) {
		
		SignUpPage signup = new SignUpPage(driver);
		
		signup.enterEmail1(email);
		signup.enterPassword1(pwd);
		signup.clickLogin();
		LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
	}
	
	@Test (dataProvider="loginData", dataProviderClass = ExcelDataProvider.class)
	public void signinTest2(String email, String pwd) {
		
		SignUpPage signup = new SignUpPage(driver);
		
		System.out.println("Data provider data of username" + email);
		System.out.println("Data provider data of username" + pwd);
		signup.enterEmail1(email);
		signup.enterPassword1(pwd);
		signup.clickLogin();
		LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
	}
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vijaypar\\Downloads\\Sari\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}


	@AfterMethod
	public void signout() {
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.quit();
	}

}
