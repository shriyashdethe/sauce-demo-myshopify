package saucedemo.com.qspider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaUtility {
static WebDriver driver = null;
	
	public JavaUtility(WebDriver driver) {
		this.driver=driver;
	}
	
public void login(String username, String password) {
    	

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);

        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);

        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }



 	public static void logout() throws InterruptedException
 	{
 		driver.findElement(By.id("react-burger-menu-btn")).click();
 		Thread.sleep(1000);
 		driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
 	}

public void standard_user(String username, String password) throws InterruptedException {
	Thread.sleep(2000);
    login(username, password);
    
    
    if (driver.getCurrentUrl().contains("saucedemo.com/inventory.html")) 
    {
    	System.out.println("Standard User : PASSED");
    } else {
        System.out.println("Standard User : FAILED");
    }
    
    driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
    
    String count = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
    
    if (count.contains("1")) {
//    	System.out.println("Product add Sucessfully");
    	
    	driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button ']")).click();
    	Thread.sleep(1000);
    	WebElement infirst = driver.findElement(By.xpath("//input[@id='first-name']"));
    	
    	infirst.click();
    	Thread.sleep(1000);
    	infirst.sendKeys("Shriyash");
    	Thread.sleep(1000);
    	
    	WebElement inlast = driver.findElement(By.xpath("//input[@id='last-name']"));
    	inlast.click();
    	Thread.sleep(1000);
    	inlast.sendKeys("Dethe");
    	Thread.sleep(1000);
    	
    	WebElement inpin = driver.findElement(By.xpath("//input[@id='postal-code']"));
    	inpin.click();
    	Thread.sleep(1000);
    	inpin.sendKeys("413310");
    	
    	driver.findElement(By.xpath("//input[@class='submit-button btn btn_primary cart_button btn_action']")).click();
    	Thread.sleep(1000);
    	
    	driver.findElement(By.xpath("//button[@id='finish']")).click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
    	Thread.sleep(1000);
//    	String thank = driver.findElement(By.xpath("Thank you for your order!")).getText();
//    	if(thank.contains("Thank you for your order!"))
//    	{
//    		System.out.println("Thank you for your order!");
//    	}
//		
	}
    logout();
    
}

public void locked_out_user(String username, String password) throws InterruptedException {
	Thread.sleep(2000);
    login(username, password);

    String errorMessage = driver.findElement(
            By.xpath("//h3[@data-test='error']")
    ).getText();

    if (errorMessage.contains("locked out")) {
        System.out.println("Locked Out User : PASSED");
    } else {
        System.out.println("Locked Out User : FAILED");
    }
}


public void problem_user(String username, String password) throws InterruptedException {

    login(username, password);
    if (driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html")) {
        System.out.println("Problem User : PASSED");
    } else {
        System.out.println("Problem User : FAILED");
    }
    logout();
}

public void performance_glitch_user(String username, String password) throws InterruptedException {

    login(username, password);

    if (driver.getCurrentUrl().contains("saucedemo.com/inventory.html")) {
        System.out.println("Performance Glitch User : PASSED");
    } else {
        System.out.println("Performance Glitch User : FAILED");
    }
    
    logout();
}

public void error_user(String username, String password) throws InterruptedException {

    login(username, password);

    if (driver.getCurrentUrl().contains("saucedemo.com/inventory.html")) {
        System.out.println("Error User : PASSED");
    } else {
        System.out.println("Error User : FAILED");
    }
    logout();
}


public void visual_user(String username, String password) {

    login(username, password);

    if (driver.getCurrentUrl().contains("saucedemo.com/inventory.html")) {
        System.out.println("Visual User : PASSED");
    } else {
        System.out.println("Visual User : FAILED");
    }
}


}
