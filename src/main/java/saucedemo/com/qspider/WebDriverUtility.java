package saucedemo.com.qspider;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility {
	
	WebDriver driver = null;
	
	public WebDriverUtility(WebDriver driver) {
		this.driver=driver;
	}
	public void BrowserMax() {
		driver.manage().window().maximize();
	}
	public void BrowserMin() {
		driver.manage().window().maximize();
	}
	
	
}
