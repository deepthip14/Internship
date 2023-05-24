package CustomerPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerDisplayVoucher {
	
	public WebDriver driver;
	
	
	@FindBy(xpath = "//h3[text()='My Bookings']")
	private WebElement titleBooking;
	
	@FindBy(xpath = "//a[text()=' View Voucher']")
	private WebElement viewVoucher;
	
	@FindBy(xpath = "//h3[text()='Booking Invoice                            ']")
	private WebElement titleofInvoice;
	
	@FindBy(xpath = "//div[@class='form-content']//child::div")
	private WebElement noResult;
	
	public CustomerDisplayVoucher(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	

	

	public String getTitleofHomePage() throws InterruptedException
	{
		String title=driver.getTitle();
		Thread.sleep(3000);
		return title;
	}

	
	
	public void clickViewVoucher() throws InterruptedException
	{
		
		viewVoucher.click();		
		Thread.sleep(4000);
	}
	
	public String getTitleOfViewVoucher() throws InterruptedException
	{
		Thread.sleep(3000);
		String title=titleofInvoice.getText();		
		return title;
	}
	
	public String getTextofNoResult() throws InterruptedException
	{
		String text=noResult.getText();
		Thread.sleep(2000);
		return text;
	}
	
	




}
