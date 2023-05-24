package AgentPage;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentSearchHotel {
	
	public WebDriver driver;
	
	@FindBy(xpath = "/html/body/section[1]/section/div/div/form/div/div/div[1]/div/div/div/span/span[1]/span/span[1]")
	private WebElement city;
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement cityName;
	
	@FindBy(xpath = "//input[@name='checkin']")
	private WebElement checkin;
	
	@FindBy(xpath = "(//td[text()='20'])[1]")
	private WebElement checkinDate;
	
	@FindBy(xpath = "//input[@name='checkout']")
	private WebElement checkout;	
	
	@FindBy(xpath = "(//td[text()='31'])[2]")
	private WebElement checkoutDate;
	
	@FindBy(xpath = "//p[text()='Travellers ']")
	private WebElement travellers;
	
	@FindBy(xpath = "//span[@class='ladda-label']")
	private WebElement search;
	
	@FindBy(xpath = "//h2[text()='Search Hotels in mumbai']")
	private WebElement text;
	
	@FindBy(xpath = "//li[text()='Mumbai,India']")		
	private WebElement place;	
	
	@FindBy(xpath="//strong[text()='Back To Search']")
	private WebElement Back;
		
	
	public AgentSearchHotel(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickCity() throws InterruptedException
	{

		city.click();
		
	}
	
	public void enterCityName() throws InterruptedException
	{
		cityName.sendKeys("Mumb");
		Thread.sleep(1000);
	}
	
	public void selectPlace() throws InterruptedException
	{
		
		place.click();
		Thread.sleep(1000);
		
	}
	
	public void clickCheckin() throws InterruptedException
	{
		checkin.click();
		Thread.sleep(1000);
	}
	
	public void selectCheckinDate() throws InterruptedException
	{
		
		checkinDate.click();
		Thread.sleep(1000);
	}
	
	public void clickCheckout() throws InterruptedException
	{
		checkout.click();
		Thread.sleep(1000);
	}
	
	public void selectCheckoutDate() throws InterruptedException
	{
		
		checkoutDate.click();
		Thread.sleep(1000);
	}
	
	public void clickTravellers() throws InterruptedException
	{
		travellers.click();
		Thread.sleep(1000);
	}
	
	public void clickSearch() throws InterruptedException
	{
		search.click();
		Thread.sleep(1000);
	}
	
	public String getTextofTitle() throws InterruptedException
	{
		
		String actual=text.getText();
		Thread.sleep(1000);
		return actual;
	}
	
	public void clicktoBack() throws InterruptedException
	{
		Back.click();
		Thread.sleep(1000);
	}
	
}
