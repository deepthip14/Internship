package CustomerPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPaypal {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//strong[text()='paypal']")
	private WebElement paypal;
	
	@FindBy(xpath = "//button[text()='Pay Now ']")
	private WebElement payNow;	
	
	@FindBy(xpath = "/html/body/div/div/div/div/div[1]")
	private WebElement paypalButton;
	
	@FindBy(xpath = "//h1[text()='Pay with PayPal']")
	private WebElement title;
	
	@FindBy(xpath = "//div[@class='btn-front']")
	private WebElement backToInvoice;
	
	@FindBy(xpath = "//a[text()='Yes']")
	private WebElement yesButton;	
	
	@FindBy(xpath = "(//div[@class='paypal-checkout-sandbox'])")
	private WebElement close;
	
	public CustomerPaypal(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickPaymentWithPaypal() throws InterruptedException

	{
		
		paypal.click();
		Thread.sleep(2000);
	}
		
	
	public void clickPayNow() throws InterruptedException
	{
		
		payNow.click();
		Thread.sleep(2000);
	}
	
	public void clickPaypalButton() throws InterruptedException
	{
		
		
		paypalButton.click();		
		Thread.sleep(2000);
	}

	
	public String getTextofPaypalTitle() throws InterruptedException
	{
		
		String actualTitle=title.getText();
		Thread.sleep(2000);
		
		return actualTitle;
	}
	
	public void clickBackToInvoice() throws InterruptedException
	{
		
		backToInvoice.click();		
		Thread.sleep(2000);
		
	}
	
	public void clickYesButton() throws InterruptedException
	{
		
		yesButton.click();		
		Thread.sleep(2000);
		
	}
	
	public void closePaypalWindow() throws InterruptedException
	{
		close.click();
		Thread.sleep(1000);
	}

}
