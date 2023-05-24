package AdminPage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminChangeStatus {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//div[text()='Pending Bookings']")
	private WebElement pendingBookings;
	
	@FindBy(xpath = "((//div[@class='me-2'])[2])//child::div")
	private WebElement count;
	
	@FindBy(xpath = "(//select[@id='booking_status'])[1]")
	private WebElement bookingStatus;
	
	@FindBy(xpath = "(//option[text()='Confirmed'])[1]")
	private WebElement confirmed;
	
	public AdminChangeStatus(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickBookingStatus() throws InterruptedException
	{
		
		bookingStatus.click();
		Thread.sleep(2000);
		
	}
	
	public String getTextofCount() throws InterruptedException
	{
		
		String actualCount=count.getText();
		Thread.sleep(2000);
		return actualCount;
	}
	
	public void clickPendingBookings() throws InterruptedException
	{
		
		pendingBookings.click();
		Thread.sleep(2000);
		
	}
	
	public void selectConfirmed() throws InterruptedException
	{
		
		confirmed.click();
		Thread.sleep(2000);
		
	}
	
	public boolean isEnabledPendingBookings()
	{
		
		boolean actual=pendingBookings.isEnabled();
		return actual;
	}
	
	
}
