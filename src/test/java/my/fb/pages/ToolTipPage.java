package my.fb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ToolTipPage {
	WebDriver driver;
	WebElement toolTipElem;
	WebElement toolTip;
	
	public ToolTipPage(WebDriver driver) {
		this.driver = driver;
				
	}
	
	public void readTextOfToolTip() {
		
		toolTipElem = driver.findElement(By.xpath("//*[@id=\"pageFooterChildren\"]/ul/li[12]/a"));
		
		Actions action =  new Actions(driver);
		action.moveToElement(toolTipElem).perform();
		System.out.println("Tooltip text: Before finding tool tip Text:---- ");
		toolTip = driver.findElement(By.xpath("//*[@id=\"pageFooterChildren\"]/ul/li[12]/a"));
		String tooltipText = toolTip.getAttribute("title");
        System.out.println("Tooltip text: " + tooltipText);
		
	}

}
