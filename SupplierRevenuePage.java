package SupplierPage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.io.FileUtils;

public class SupplierRevenuePage {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//h2[text()='Revenue Breakdown 2023']")
	private WebElement revenue;
	
	@FindBy(xpath = "//div[text()='Total Bookings And Payments']")
	private WebElement total;
	
	public SupplierRevenuePage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String getTextOfRevenueBreakdown() throws InterruptedException
	{
		
		String text=revenue.getText();
		Thread.sleep(3000);
		return text;
		
	}
	
	public String getTextOfTotalBookings() throws InterruptedException
	{
		
		String text=total.getText();
		Thread.sleep(3000);
		return text;
		
	}
	
	
}
