package SupplierPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupplierDashboardPage {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//i[text()='space_dashboard']")
	private WebElement dashboard;
	
	@FindBy(xpath = "//div[text()='Sales overview & summary']")
	private WebElement sales;
	
	public SupplierDashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickDashboard() throws InterruptedException
	{
		
		dashboard.click();
		Thread.sleep(3000);
		
	}
	
	public String getTextOfSalesOverviewAndSummary() throws InterruptedException
	{
		
		String text=sales.getText();
		Thread.sleep(3000);
		return text;
		
	}

}
