package my.fb.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignUpElementsDialogPage {
	WebDriver driver;
	By firstname;
	By lastname;
	By phonenumber;
	By newpass;
	WebElement monthdropdown;
	WebElement datedropdown;
	WebElement yeardropdown;
	WebElement genderradiooption;
	WebElement signupbutton;
	
	
	public SignUpElementsDialogPage(WebDriver driver){
		this.driver = driver;
		
	}
	
	public void setfirstname(String str) {
		firstname = By.name("firstname");
		driver.findElement(firstname).sendKeys(str);
		
	}
	public void setlastname(String str) {
		lastname = By.name("lastname");
		driver.findElement(lastname).sendKeys(str);
		
	}
	
	public void setphonenumber(String number) {
		phonenumber = By.name("reg_email__");
		driver.findElement(phonenumber).sendKeys(number);
		}
	
	public void setnewpass(String pass) {
		newpass = By.id("password_step_input");
		driver.findElement(newpass).sendKeys(pass);
		
	}
	public void setmonth(int mon) {
		monthdropdown =	driver.findElement(By.id("month"));
		Select dropdown = new Select(monthdropdown);
		dropdown.selectByIndex(mon);
	}
	
	public void setdate(String date) {
		datedropdown = driver.findElement(By.id("day"));
		Select dropdown = new Select(datedropdown);
		dropdown.selectByValue(date);
		
	}
	public void setyear(String year1) {
		yeardropdown = driver.findElement(By.id("year"));
		Select dropdown = new Select(yeardropdown);
		List<WebElement> years = dropdown.getOptions();
		for(WebElement year: years) {
			if (year.toString()==year1) {
				return;
			}
		}
		dropdown.selectByValue(year1);
	}
public void setGenderoption(String index) {
	genderradiooption = driver.findElement(By.name("sex"));
	genderradiooption.click();
	
	/*
	 * Select select = new Select(genderradiooption); List<WebElement> options =
	 * select.getOptions(); for(WebElement option : options) {
	 * System.out.println("Year is " +option +option.toString());
	 * if(option.toString()== index) { return; } }
	 * select.selectByVisibleText(index).click()
	 */;
	
}
public void clickSignupCTA() {
	signupbutton = driver.findElement(By.name("websubmit"));
	signupbutton.click();
}

}
