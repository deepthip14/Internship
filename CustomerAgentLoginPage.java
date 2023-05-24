package CustomerPage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerAgentLoginPage {

	public WebDriver driver;


	@FindBy(name="email")
	private WebElement email;

	@FindBy(name="password")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginbtn;

	@FindBy(xpath="(//button[@id='currency'])[2]")
	private WebElement account;

	@FindBy(xpath = "(//a[text()=' Logout'])[1]")
	private WebElement logout;

	public CustomerAgentLoginPage(WebDriver driver)
	{

		this.driver=driver;
		PageFactory.initElements(driver, this);	

	}


	public void enterEmail(String userId) throws InterruptedException
	{

		email.sendKeys(userId);
		Thread.sleep(2000);

	}

	public void enterPassword(String pswd) throws InterruptedException
	{

		password.sendKeys(pswd);
		Thread.sleep(2000);

	}

	public void clickLoginButton() throws InterruptedException
	{

		loginbtn.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
	}

	public String wrongCredentials() throws InterruptedException
	{
		String actualUrl=driver.getCurrentUrl();
		Thread.sleep(2000);
		return actualUrl;
	}	

	public boolean isElementPresent(WebDriver driver, By by)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try {
			driver.findElement(by);
			return true;
		}catch(Exception e) {

			return false;
		}
	}	


	public void clickLogout() throws InterruptedException
	{

		account.click();
		Thread.sleep(2000);
		logout.click();

	}

	public boolean isEnabledLoginButton()
	{

		boolean isEnable=loginbtn.isEnabled();
		return isEnable;
	}

	public String getTitleofHomePage() throws InterruptedException
	{
		String title=driver.getTitle();
		Thread.sleep(2000);
		return title;
	}	
	
	public String getTextofEmailTooltipMessage()
	{
		String msg=driver.findElement(By.name("email")).getAttribute("validationMessage");
		return msg;
	}
	

}
