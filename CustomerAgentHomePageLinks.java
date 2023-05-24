package CustomerPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerAgentHomePageLinks {

	public WebDriver driver;

	@FindBy(xpath = "(//a[text()=' My Bookings'])[2]")
	private WebElement myBookings;

	@FindBy(xpath = "(//a[text()=' Add Funds'])[2]")
	private WebElement addFunds;
	
	@FindBy(xpath = "(//a[text()=' My Profile'])[2]")
	private WebElement myProfile;

	@FindBy(xpath = "(//a[text()=' Logout'])[2]")
	private WebElement logout;

	@FindBy(xpath = "//h3[text()='My Bookings']")
	private WebElement titleBooking;
	
	@FindBy(xpath = "(//a[text()=' Logout'])[2]")
	private WebElement logoutLink;

	public CustomerAgentHomePageLinks(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String clickMyBookings() throws InterruptedException
	{

		myBookings.click();
		Thread.sleep(3000);
		String bookingTitle=driver.getTitle();
		return bookingTitle;

	}

	public String clickAddFunds() throws InterruptedException
	{

		addFunds.click();
		Thread.sleep(3000);
		String addFundsTitle=driver.getTitle();
		return addFundsTitle;

	}

	public String clickMyProfile() throws InterruptedException
	{

		myProfile.click();
		Thread.sleep(3000);		
		String myProfileTitle=driver.getTitle();
		return myProfileTitle;
	}

	public void clickLogout()
	{

		logout.click();
	}

	public void clickLogoutLink() throws InterruptedException
	{

		logoutLink.click();
		Thread.sleep(2000);
	}



}
