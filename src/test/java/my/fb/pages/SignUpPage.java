package my.fb.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SignUpPage {
	
	private WebDriver driver;
	By email;
	WebElement pass;
	WebElement login;
	WebElement signupbutton;
	By isthatyou;
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		email = By.id("email");
		pass = driver.findElement(By.id("pass"));
		login = driver.findElement(By.name("login"));
		isthatyou = By.xpath("//*[@id=\"u_0_8_31\"]/button");
		//signupbutton = driver.findElement(By.xpath("//*[@id=\"u_0_0_yc\"]"));
		signupbutton = driver.findElement(By.linkText("Create new account"));
						
		}
	
	// already existing users
	public void enterEmail() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("email"))));
		driver.findElement(email).sendKeys("1abc12@gmail.com");
	}
	
	public void enterPassword() {
		pass.sendKeys("Abctest123$");
	}
	
	public void clickLogin() {
		login.click();
	}
	
	public void isThisYou() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"u_0_8_31\"]/button")));
		System.out.println(" I am in Is thisYou () ");
		
		//*[@id="u_0_8_31"]/button
	}
	// for new user
	public void signupNewAccountButton() {
		
		signupbutton.click();
	}
}
