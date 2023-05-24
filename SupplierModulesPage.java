package SupplierPage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupplierModulesPage {
	
	public WebDriver driver;
	
	@FindBy(xpath = "(//i[text()='expand_more'])[9]")
	private WebElement tours;
	
	@FindBy(xpath = "(//i[text()='expand_more'])[10]")
	private WebElement tours2;
	
	@FindBy(xpath = "//a[text()='Manage Tours']")
	private WebElement manageTours;
	
	@FindBy(xpath = "(//a[text()='Extras'])[2]")
	private WebElement extras;	
	
	
	public SupplierModulesPage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickToursModule() throws InterruptedException
	{
		
		tours.click();
		Thread.sleep(3000);
	}
	
	public void clickTours() throws InterruptedException
	{
		
		tours2.click();
		Thread.sleep(3000);
	}
	
	public void clickManageTours() throws InterruptedException
	{
		
		manageTours.click();
		Thread.sleep(3000);
	}
	
	public void clickExtras() throws InterruptedException
	{
		
		extras.click();
		Thread.sleep(3000);
	}
	
	public boolean isEnableToursButton() throws InterruptedException
	{
		
		boolean actual=tours.isEnabled();
		Thread.sleep(3000);
		return actual;
	}
	
	
	
}
