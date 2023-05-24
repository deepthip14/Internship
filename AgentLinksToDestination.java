package AgentPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentLinksToDestination {

	public WebDriver driver;
	
	@FindBy(xpath = "(//img[@src='https://phptravels.net/api/uploads/global/logo.png'])[1]")
	private WebElement homeLogo;
	
	@FindBy(xpath = "//a[text()='Hotels']")
	private WebElement hotels;
	
	@FindBy(xpath = "//a[text()='flights']")
	private WebElement flights;
	
	@FindBy(xpath = "//a[text()='Tours']")
	private WebElement tours;
	
	@FindBy(xpath = "//a[text()='visa']")
	private WebElement visa;
	
	@FindBy(xpath = "//a[text()='Blog']")
	private WebElement blog;

	@FindBy(xpath = "//a[text()='Offers']")
	private WebElement offers;
	
	public AgentLinksToDestination(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickHomeLogo() throws InterruptedException
	{
		homeLogo.click();
		Thread.sleep(2000);
	}
	
	public void clickHotels() throws InterruptedException
	{
		hotels.click();
		Thread.sleep(2000);
	}
	
	public void clickFlights() throws InterruptedException
	{
		flights.click();
		Thread.sleep(2000);
	}
	
	public void clickTours() throws InterruptedException
	{
		tours.click();
		Thread.sleep(2000);
	}
	
	public void clickVisa() throws InterruptedException
	{
		visa.click();
		Thread.sleep(2000);
	}
	
	public void clickBlogs() throws InterruptedException
	{
		blog.click();
		Thread.sleep(2000);
	}
	
	public void clickOffers() throws InterruptedException
	{
		offers.click();
		Thread.sleep(2000);
	}
}
