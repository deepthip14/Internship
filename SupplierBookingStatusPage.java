package SupplierPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupplierBookingStatusPage {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//a[text()='Bookings']")
	private WebElement bookings;
	
	@FindBy(xpath = "//h1[text()='An Error Was Encountered']")
	private WebElement error1;
	
	@FindBy(xpath = "//p[text()='Unable to load the requested file: admin/template.php']")
	private WebElement error2;
	
	public SupplierBookingStatusPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickBookings() throws InterruptedException
	{
		
		bookings.click();
		Thread.sleep(3000);
		
	}

	public String getTextofErrorMessage() throws InterruptedException
	{
		String text=error1.getText();
		Thread.sleep(3000);
		return text;
	}
	
	public String getTextofWarningMessage() throws InterruptedException
	{
		String text=error2.getText();
		Thread.sleep(3000);
		return text;
	}


}
