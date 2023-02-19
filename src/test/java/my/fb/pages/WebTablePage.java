package my.fb.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTablePage {
	WebDriver driver;
	List<WebElement> rows;
	List<WebElement> cells;
	
	public WebTablePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fetchWebTableData() {
	
		driver.get("file:///C:/Users/vijaypar/Desktop/table.html");
		driver.findElement(By.id("table-id"));
		
		rows = driver.findElements(By.tagName("tr"));
		for(WebElement row : rows) {
			cells = row.findElements(By.tagName("td"));
			
			for(WebElement cell : cells) {
				System.out.println(cell.getText()+"\t");
			}
			
		}
	
		
	}
}
