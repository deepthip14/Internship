package AdminPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminWebsiteLink {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//a[text()='Website']")
	private WebElement website;
	
	@FindBy(xpath = "System.out.println(url);")
	private WebElement heading;
	
	public AdminWebsiteLink(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickWebsite() throws InterruptedException
	{
		
		website.click();
		Thread.sleep(2000);
	}
	
	public boolean isEnableWebsiteLink() throws InterruptedException
	{
		
		boolean actual=website.isEnabled();
		Thread.sleep(2000);
		return actual;
	}
	
	

}
