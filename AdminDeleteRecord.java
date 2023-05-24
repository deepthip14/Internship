package AdminPage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AdminDeleteRecord {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//div[text()='Cancelled Bookings']")
	private WebElement cancelBookings;
	
	@FindBy(xpath = "(//button[@class='btn btn-danger mdc-ripple-upgraded'])[1]")
	private WebElement deleteRecord;	
	
	@FindBy(xpath = "(((//div[@class='me-2'])[3])//child::div)[1]")
	private WebElement count;
	
	public AdminDeleteRecord(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCancelBookings() throws InterruptedException
	{
		
		cancelBookings.click();
		Thread.sleep(2000);
		
	}
	
	public void clickDeleteButton() throws InterruptedException
	{
		
		deleteRecord.click();
		Thread.sleep(2000);
	}
	
	
	public String getDataofCountCancelledBookings() throws InterruptedException
	{
		
		String countOfCancelledBookings=count.getText();
		Thread.sleep(2000);
		return countOfCancelledBookings;
	}

}

