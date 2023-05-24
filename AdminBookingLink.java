 package AdminPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminBookingLink {

	public WebDriver driver;	
	
	@FindBy(xpath = "(//a[text()='Bookings'])[1]")
	private WebElement booking;
	
	@FindBy(xpath = "//div[text()='Paid Bookings']")
	private WebElement paidBookings;

	@FindBy(xpath = "(//select[@id='payment_status'])[1]")
	private WebElement bookingStatus;
	
	@FindBy(xpath = "(//option[text()='paid'])[1]")
	private WebElement paid;

	@FindBy(xpath = "/html/body/div[2]/div[2]/main/div/div[2]/div/div/div[2]/div/table/tbody/tr[1]/td[14]/a")
	private WebElement invoice;	
	
	
	@FindBy(xpath = "(((//div[@class='me-2'])[4]) //child::div)[1]")
	private WebElement count;

	public AdminBookingLink(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickBooking() throws InterruptedException
	{

		booking.click();
		Thread.sleep(2000);

	}
	
	public void clickPaidBooking() throws InterruptedException
	{

		paidBookings.click();
		Thread.sleep(2000);

	}

	public void clickBookingStatus() throws InterruptedException
	{

		bookingStatus.click();	
		Thread.sleep(2000);

	}
	
	public String getTextOfPayment() throws InterruptedException
	{
		
		String actual=paid.getText();
		Thread.sleep(2000);
		return actual;
		
	}

	public void clickInvoice() throws InterruptedException
	{

		invoice.click();
		Thread.sleep(4000);

	}
	
	public String getDataofCountOfPaidBookings() throws InterruptedException
	{
		String countofPaidBookings=count.getText();
		Thread.sleep(2000);
		return countofPaidBookings;
	}

}
