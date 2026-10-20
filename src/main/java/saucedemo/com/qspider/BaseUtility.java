package saucedemo.com.qspider;

import org.testng.annotations.Test;


public class BaseUtility {
	
	
	@Test
	public void login() {
		System.out.println("login");
	}
	
	
	
	@Test
	public void SearchProduct() {
		System.out.println("SearchProduct");
	}
	
	@Test
	public void AddToCart() {
		System.out.println("AddToCart");
	}
	
	@Test
	public void CreateInvoice() {
		System.out.println("CreateInvoice");
	}
	
	@Test
	public void logout() {
		System.out.println("logout");
	}
	
}
