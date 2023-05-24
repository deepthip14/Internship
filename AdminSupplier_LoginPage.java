package AdminPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminSupplier_LoginPage {
	
	public WebDriver driver;
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath = "//span[text()='Login']")
	private WebElement loginbtn;
	
	@FindBy(xpath = "//div[text()='Dashboard']")
	private WebElement dashboard;
	
	@FindBy(xpath="(//i[text()='person'])[1]")
	private WebElement dropdown;
	
	@FindBy(xpath = "//div[text()='Logout']")
	private WebElement logout;
	
	@FindBy(xpath = "//p[text()='The Email field is required.']")
	private WebElement emailAlert;
	
	@FindBy(xpath = "//p[text()='The Password field is required.']")
	private WebElement pswdAlert;	
	
	
	@FindBy(xpath = "//div[text()='Invalid Login Credentials']")
	private WebElement invalid;	
	
	
	
	public AdminSupplier_LoginPage(WebDriver driver)
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
	
	public void clickLogin() throws InterruptedException
	{
		loginbtn.click();
		Thread.sleep(2000);
	}
	
	public String getTitleofHomePage() throws InterruptedException
	{
		String title=dashboard.getText();
		Thread.sleep(2000);
		return title;
	}
		
	public void clickLogout() throws InterruptedException
	{
		
		dropdown.click();
		Thread.sleep(2000);
		logout.click();
		
	}
	
	public boolean isEnabledLoginButton()
	{
		
		boolean isEnable=loginbtn.isEnabled();
		return isEnable;
	}
	
	public String alertMessageEmail() throws InterruptedException
	{
		
		String emailmsg=emailAlert.getText();		
		Thread.sleep(2000);
		return emailmsg;
	}
	
	public String alertMessagePassword() throws InterruptedException
	{
		
		String pswdmsg=pswdAlert.getText();
		System.out.println(pswdmsg);
		Thread.sleep(2000);
		return pswdmsg;
	}
	
	
	public String invalidCredentials() throws InterruptedException
	{
		String invalidMsg=invalid.getText();
		Thread.sleep(2000);
		
		return invalidMsg;
	}		
	
	
	public String getTitle()
	{
		String title=driver.getTitle();
		return title;
	}

}
