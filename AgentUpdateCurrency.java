package AgentPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentUpdateCurrency {
	
	public WebDriver driver;
	
	@FindBy(id = "currency")
	private WebElement currency;
	
	@FindBy(xpath = "//a[text()=' INR']")
	private WebElement INR;
	
	public AgentUpdateCurrency(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCurrency() throws InterruptedException
	{
		currency.click();
		Thread.sleep(2000);
	}
	
	public void selectINR() throws InterruptedException
	{
		INR.click();
		Thread.sleep(2000);
	}

}
