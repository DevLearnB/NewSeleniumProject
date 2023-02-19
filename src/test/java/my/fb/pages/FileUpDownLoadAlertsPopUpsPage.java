package my.fb.pages;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class FileUpDownLoadAlertsPopUpsPage {
   	WebDriver driver;
   	Logger LOGGER;
	WebElement upload;
	WebElement submitButton;
	WebElement filelink;
	WebElement yescontinue;
	WebElement popup;
	
	public FileUpDownLoadAlertsPopUpsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	 public void fileupload() {
		  LOGGER.info("Start filwupload() method ************* ");
		  upload = driver.findElement(By.id("fileupload"));
		  upload.sendKeys("\"C:\\Users\\vijaypar\\Desktop\\Selenium.xlsx\"");
		  submitButton = driver.findElement(By.id("submit"));
	      submitButton.click();
	      LOGGER.info("END filwupload() method ************* ");
	  }
	  
	  public void fileDownload() throws IOException {
	      //put this file into the page where you want to upload a file (do it at home)
	      System.out.println("after finding WebElement filelink ");
	      filelink = driver.findElement(By.xpath("//*[@id=\"pageFooter\"]/ul/li[10]/a"));
	      System.out.println("after webelemnet filelink ");
	      String fileurl = filelink.getAttribute("href");
	      System.out.println("URL " + fileurl);
	      URL url = new URL(fileurl);
	      URLConnection connection = url.openConnection();
	      connection.connect();

	      InputStream input = connection.getInputStream();
	      OutputStream output = null;

	      try {
	          output = new FileOutputStream("/path/to/save/file");
	          byte[] buffer = new byte[4096];
	          int bytesRead;
	          while ((bytesRead = input.read(buffer)) != -1) {
	              output.write(buffer, 0, bytesRead);
	          }
	      } finally {
	          try {
	              input.close();
	          } catch (IOException e) {
	              e.printStackTrace();
	          }
	          try {
	              output.close();
	          } catch (IOException e) {
	              e.printStackTrace();
	          }
	      }
	  }
	  
	  public void handleAlertDialog() {
		  yescontinue = driver.findElement(By.xpath("//*[@id=\"u_0_8_Za\"]/button"));
		  
		  Alert alert = driver.switchTo().alert();
		  String alerttext = alert.getText();
		  System.out.println("Alert Text: " +alerttext);
		  
		  alert.accept();
		  driver.switchTo().defaultContent();
		  
	  }
	  public void handlePopUpDialog() {
		  popup = driver.findElement(By.xpath("//*[@id=\"u_0_8_Za\"]/button"));
		  
		Set<String> windowhandles = driver.getWindowHandles();
		
		for(String str : windowhandles) {
			System.out.println("Inside popup" +str);
		}
		
	  }

}
