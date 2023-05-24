package CustomerPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerUpdateAddress {
	
	public WebDriver driver; 
	
	@FindBy(name="address1")
	private WebElement address;
	
	@FindBy(xpath = "//button[text()='Update Profile']")
	private WebElement updateProfile;
	
	@FindBy(xpath = "//div[text()=' Profile updated successfully.                                ']")
	private WebElement success;
	
	@FindBy(xpath = "//button[text()='Got It']")
	private WebElement gotIt;
	
	public void clickGotIt() throws InterruptedException
	{
		
		gotIt.click();
		Thread.sleep(2000);
	}
	
	public CustomerUpdateAddress(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterAddress() throws InterruptedException
	{
		address.clear();
		address.sendKeys("Manu Villa, Ernakulam");
		Thread.sleep(2000);
		
	}
	
	public void clickUpdateProfile() throws InterruptedException
	{
		
		updateProfile.click();
		Thread.sleep(2000);
		
	}
	
	public String getTextofSuccessMessage() throws InterruptedException
	{
		String text=success.getText();
		Thread.sleep(2000);
		return text;
	}
	
	public void scrollPageDown()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

}
