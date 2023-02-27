package my.fb.tests;

import org.testng.annotations.Test;

import my.fb.pages.FileUpDownLoadAlertsPopUpsPage;
import my.fb.pages.FindBrokenLinksPage;
import my.fb.pages.SignUpElementsDialogPage;
import my.fb.pages.SignUpPage;
import my.fb.pages.ToolTipPage;
import my.fb.pages.WebTablePage;

import org.testng.annotations.BeforeMethod;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterMethod;

@Test
public class SignUpPageTests {
  WebDriver driver;
  private static final Logger LOGGER = Logger.getLogger(SignUpPageTests.class.getName());
  
  @Test 
  public void signupTest() {
	  LOGGER.info("Starting SignupTest");
	  SignUpElementsDialogPage signupdialogpage = new SignUpElementsDialogPage(driver);
	  System.out.println("Title of the page is : " + driver.getTitle());
	  SignUpPage signup = new SignUpPage(driver);
	  System.out.println("Title of the page is : " + driver.getTitle());
	  signup.signupNewAccountButton();
	  signupdialogpage.setfirstname("ABC");
	  signupdialogpage.setlastname("DEF");
	  signupdialogpage.setphonenumber("4408364279");
	  signupdialogpage.setnewpass("pass123&");
	  signupdialogpage.setmonth(6);
	  signupdialogpage.setdate("19");
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  signupdialogpage.setyear("2000");
	  signupdialogpage.setGenderoption("1");
	  signupdialogpage.clickSignupCTA();
	  LOGGER.info("Ending SignupTest");
  }
  
  @Test (priority = 2)
  public void signinTest() {
	  LOGGER.warning("Starting signinTest");
	
	  System.out.println("Title of the page is : " + driver.getTitle());
	  SignUpPage signup = new SignUpPage(driver);
	  System.out.println("Title of the page is : " + driver.getTitle());
	  signup.enterEmail();
	  signup.enterPassword();
	  signup.clickLogin();
	  LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
	  
	  for(LogEntry log : logs) {
		 LOGGER.info(log.getMessage());
	  }
	  
	  LOGGER.warning("End of signinTest");
  }
  @Test (priority = 3)
  public void fileUploadTest() {
	  FileUpDownLoadAlertsPopUpsPage page = new FileUpDownLoadAlertsPopUpsPage(driver);
	  page.fileupload();
	 
  }
  
  @Test (priority = 4)
  public void fileDownloadTest() throws IOException {
	  FileUpDownLoadAlertsPopUpsPage page = new FileUpDownLoadAlertsPopUpsPage(driver);
	  page.fileDownload();
  }
  
  @Test (priority = 5)
  public void alertDialogTest(){
	  FileUpDownLoadAlertsPopUpsPage page = new FileUpDownLoadAlertsPopUpsPage(driver);
	  page.handleAlertDialog();
	  page.handlePopUpDialog();
  }
  
  @Test
  public void toolTipTest() {
	  ToolTipPage tt = new ToolTipPage(driver);
	  tt.readTextOfToolTip();
  }
  
  @Test
  public void findBorkenUrlsTest() throws IOException {
	  FindBrokenLinksPage brokenLinks = new FindBrokenLinksPage(driver);
	  brokenLinks.findBrokenLinks();
	  
  }
  
  @Test
  public void findWebTableTest() {
	  WebTablePage webTable = new WebTablePage(driver);
	  webTable.fetchWebTableData();
	  
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
