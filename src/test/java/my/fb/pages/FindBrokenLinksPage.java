package my.fb.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindBrokenLinksPage {
	WebDriver driver;
	List<WebElement> links;
	
	public FindBrokenLinksPage(WebDriver driver) {
		this.driver =  driver;
	}
	
	public void findBrokenLinks() throws IOException {
	links =	driver.findElements(By.tagName("a"));
	for (WebElement link : links) {
		String linkurl = link.getAttribute("href");
		
		URL url = new URL(linkurl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("HEAD");
		if(connection.getResponseCode()!=200){
			System.out.println("Broken URL:  "+url);
		}
		System.out.println("NO Broken URL:  "+url);
	}
	}
}
