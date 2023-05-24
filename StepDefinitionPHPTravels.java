package stepDefinition;

import java.io.IOException;

import java.util.ArrayList;

import java.util.concurrent.TimeUnit;


import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import AdminPage.AdminBookingLink;
import AdminPage.AdminChangeStatus;
import AdminPage.AdminDeleteRecord;
import AdminPage.AdminWebsiteLink;
import AgentPage.AgentLinksToDestination;
import AgentPage.AgentSearchHotel;
import AgentPage.AgentUpdateCurrency;
import CustomerPage.CustomerAgentHomePageLinks;
import CustomerPage.CustomerAgentLoginPage;
import CustomerPage.CustomerDisplayVoucher;
import CustomerPage.CustomerPaypal;
import CustomerPage.CustomerUpdateAddress;
import SupplierPage.SupplierBookingStatusPage;
import SupplierPage.SupplierDashboardPage;
import SupplierPage.SupplierModulesPage;
import SupplierPage.SupplierRevenuePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class StepDefinitionPHPTravels {

	public WebDriver driver;

	AdminPage.AdminSupplier_LoginPage adminLogin;
	AdminPage.AdminBookingLink adminBooking;
	AdminPage.AdminDeleteRecord adminDelete;
	AdminPage.AdminChangeStatus adminChangeStatus;
	AdminPage.AdminWebsiteLink adminWebsite;
	

	SupplierPage.SupplierDashboardPage supplierDashboard;
	SupplierPage.SupplierRevenuePage supplierRevenue;
	SupplierPage.SupplierBookingStatusPage supplierBooking;
	SupplierPage.SupplierModulesPage supplierModule;
	CustomerPage.CustomerAgentLoginPage customerLogin;
	CustomerPage.CustomerAgentHomePageLinks customerHome;
	CustomerPage.CustomerDisplayVoucher customerDisplay;
	CustomerPage.CustomerPaypal customerPaypal;
	CustomerPage.CustomerUpdateAddress customerUpdate;

	AgentPage.AgentLinksToDestination agentLink;
	AgentPage.AgentSearchHotel agentSearch;
	AgentPage.AgentUpdateCurrency agentCurrency;


	

	@Given("The browser is open")
	public void the_browser_is_open() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");


		driver = new ChromeDriver(options);

		adminLogin=new AdminPage.AdminSupplier_LoginPage(driver);
		adminBooking=new AdminBookingLink(driver);
		adminDelete=new AdminDeleteRecord(driver);
		adminChangeStatus=new AdminChangeStatus(driver);
		adminWebsite=new AdminWebsiteLink(driver);

		supplierDashboard=new SupplierDashboardPage(driver);
		supplierRevenue=new SupplierRevenuePage(driver);
		supplierBooking=new SupplierBookingStatusPage(driver);
		supplierModule=new SupplierModulesPage(driver);
		
		customerLogin=new CustomerAgentLoginPage(driver);
		customerHome=new CustomerAgentHomePageLinks(driver);
		customerDisplay=new CustomerDisplayVoucher(driver);
		customerPaypal=new CustomerPaypal(driver);
		customerUpdate=new CustomerUpdateAddress(driver);
		
		agentLink=new AgentLinksToDestination(driver);
		agentSearch=new AgentSearchHotel(driver);
		agentCurrency=new AgentUpdateCurrency(driver);
		
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	
	@Given("User is on login page {string}")
	public void user_is_on_login_page(String url) {

		driver.get(url);

	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) throws InterruptedException {

		adminLogin.enterEmail(email);
		adminLogin.enterPassword(password);


	}

	@When("User click login button")
	
	public void user_click_login_button() throws InterruptedException {

		boolean actual=adminLogin.isEnabledLoginButton();
		Assert.assertEquals(true, actual);

		adminLogin.clickLogin();
		

	}
	@Then("page title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {


		//Alert alert=driver.switchTo().alert();
		//alert.accept();
		String actualTitle=adminLogin.getTitleofHomePage();
		Assert.assertEquals(title, actualTitle);
		

	}
	

	@Then("click logout")
	public void click_logout() throws InterruptedException {


		adminLogin.clickLogout();

	}


	@Then("page should display a tooltip message {string}")
	public void page_should_display_a_tooltip_message(String tootipMsg) throws InterruptedException {

		String actualMessage=customerLogin.getTextofEmailTooltipMessage();
		System.out.println("MESSAGE = "+actualMessage);
		Thread.sleep(3000);
		Assert.assertEquals(tootipMsg, actualMessage);

	}



	@Then("page should display invalid login credentials")
	public void page_should_display_invalid_login_credentials() throws InterruptedException {

		String actual=adminLogin.invalidCredentials();

		System.out.println(actual);
		String expected="Invalid Login Credentials";
		Assert.assertEquals(expected, actual);

	}


	@Then("page should display The Email field is required. The Password field is required.")
	public void page_should_display_the_email_field_is_required_the_password_field_is_required() throws InterruptedException {


		String actual1=adminLogin.alertMessageEmail();
		String actual2=adminLogin.alertMessagePassword();
		String expected1="The Email field is required.";
		String expected2="The Password field is required.";		

		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);

	}

	
	
	@When("click the Booking link")
	public void click_the_booking_link() throws InterruptedException {

		adminBooking.clickBooking();
		//Alert alert=driver.switchTo().alert();
		//alert.accept();

	}

	@When("navigates to booking page")
	public void navigates_to_booking_page() {

		String actual=driver.getTitle();
		String expected="All Bookings View";
		Assert.assertEquals(expected, actual);

	}

	@When("click paid Bookings")
	public void click_paid_Bookings() throws InterruptedException {

		String count=adminBooking.getDataofCountOfPaidBookings();
		int value=Integer.parseInt(count);
		System.out.println("TOTAL PAID BOOKINGS = "+value);

		
			adminBooking.clickPaidBooking();

		
	}

	@When("click the invoice where payment is successful")
	public void click_the_invoice_where_payment_is_successful() throws InterruptedException {

		
		
		String count=adminBooking.getDataofCountOfPaidBookings();
		int value=Integer.parseInt(count);
		System.out.println("TOTAL PAID BOOKINGS = "+value);

		
			adminBooking.clickBookingStatus();
			String actual=adminBooking.getTextOfPayment();
			String expected="PAID";

			Assert.assertEquals(expected, actual);

			adminBooking.clickInvoice();
			ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			
			
		
	}

	@When("navigates to invoice page")
	public void navigates_to_invoice_page() {		

		ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		String actual=driver.getTitle();		
		String expected="Hotel Invoice - PHPTRAVELS";

		Assert.assertEquals(expected, actual);

		driver.close();

		driver.switchTo().window(tabs.get(0));		

	}

	

	@When("check the count of cancelled booking before deleted")
	public void check_the_count_of_cancelled_booking_before_deleted() throws InterruptedException {

		String actualCount=adminDelete.getDataofCountCancelledBookings();

		System.out.println("Number of cancelled Booking before deleting = "+actualCount);

		

	}

	@When("click cancelled bookings")
	public void click_cancelled_bookings() throws InterruptedException {

		adminDelete.clickCancelBookings();
		//Alert alert=driver.switchTo().alert();
		//alert.accept();

	}

	@When("click delete button")
	public void click_delete_button() throws InterruptedException {

		String count=adminDelete.getDataofCountCancelledBookings();
		int value=Integer.parseInt(count);
		System.out.println("TOTAL CANCELLED BOOKINGS = "+value);

			adminDelete.clickDeleteButton();

			Alert alert=driver.switchTo().alert();

			String alertMessage=alert.getText();
			String expectedMessage="Are you sure to delete?";

			Assert.assertEquals(expectedMessage, alertMessage);

			alert.accept();

	}

	@When("check the count of cancelled booking after deleted")
	public void check_the_count_of_cancelled_booking_after_deleted() throws InterruptedException {

		String actualCount=adminDelete.getDataofCountCancelledBookings();

		System.out.println("Number of cancelled Booking After deleting = "+actualCount);

		

	}

	@When("click pending booking")
	public void click_pending_booking() throws InterruptedException {

		adminChangeStatus.clickPendingBookings();

		boolean actual=adminChangeStatus.isEnabledPendingBookings();

		Assert.assertEquals(true, actual);

	}

	@Then("check the count of pending bookings before change status")
	public void check_the_count_of_pending_bookings_before_change_status() throws InterruptedException {

		String countOfPendingBookings1=adminChangeStatus.getTextofCount();
		
		System.out.println("Count Before Changing Status = "+countOfPendingBookings1);
		
		

	}

	@Then("change the booking status to confirmed")
	public void change_the_booking_status_to_confirmed() throws InterruptedException {

		String count=adminChangeStatus.getTextofCount();
		int value=Integer.parseInt(count);
		System.out.println("TOTAL PENDING BOOKINGS = "+value);
		
			adminChangeStatus.clickBookingStatus();
			adminChangeStatus.selectConfirmed();
		

	}

	@Then("check the count of pending bookings after change status")
	public void check_the_count_of_pending_bookings_after_change_status() throws InterruptedException {

		String countOfPendingBookings2=adminChangeStatus.getTextofCount();
		System.out.println("Count After Changing Status = "+countOfPendingBookings2);

				

	}

	

	@When("click the Website link")
	public void click_the_website_link() throws InterruptedException {

		adminWebsite.clickWebsite();
		
		boolean actualValue=adminWebsite.isEnableWebsiteLink();

		Assert.assertEquals(true, actualValue);ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		Thread.sleep(3000);

	}

	@When("navigates to website page")
	public void navigates_to_website_page() throws InterruptedException {

		ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		Thread.sleep(3000);

		String actualUrl=driver.getCurrentUrl();
		System.out.println("Actual URL = "+actualUrl);

		String actualTitle=driver.getTitle();
		System.out.println("Actual TITLE = "+actualTitle);

		Assert.assertEquals("https://phptravels.net/", actualUrl);
		Assert.assertEquals("PHPTRAVELS | Travel Technology Partner - PHPTRAVELS", actualTitle);

		driver.close();

		driver.switchTo().window(tabs.get(0));

	}

	

	@Then("click the link Dashboard")
	public void click_the_link_dashboard() throws InterruptedException {

		supplierDashboard.clickDashboard();

	}

	@Then("It navigates to dashboard page")
	public void it_navigates_to_dashboard_page() {

		String actualTitle=driver.getTitle();
		String expectedTitle="Dashboard";

		Assert.assertEquals(expectedTitle, actualTitle);


	}

	@Then("check the text {string}")
	public void check_the_text(String text) throws InterruptedException {

		String actualText=supplierDashboard.getTextOfSalesOverviewAndSummary();

		Assert.assertEquals(text, actualText);

	}

	

	@Then("The home page should display the Revenue Breakdown")
	public void the_home_page_should_display_the_revenue_breakdown() throws InterruptedException {

		String actualTextOfRevenue=supplierRevenue.getTextOfRevenueBreakdown();
		String expectedTextOfRevenue="Revenue Breakdown 2023";
		String actualTextOfTotalBookings=supplierRevenue.getTextOfTotalBookings();
		String expectedTextOfTotalBookings="Total Bookings And Payments";

		Assert.assertEquals(expectedTextOfRevenue, actualTextOfRevenue);
		Assert.assertEquals(expectedTextOfTotalBookings, actualTextOfTotalBookings);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		

	}

	

	@Then("click the link Bookings")
	public void click_the_link_Bookings() throws InterruptedException {

		supplierBooking.clickBookings();

	}

	@Then("It navigates to a page that showing an error message")
	public void it_navigates_to_Bookings_page() throws InterruptedException {

		String actual1=supplierBooking.getTextofErrorMessage();
		String actual2=supplierBooking.getTextofWarningMessage();
		String expected1="An Error Was Encountered";
		String expected2="Unable to load the requested file: admin/template.php";

		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);

		driver.navigate().back();

	}

	
	@Then("click the module Tours")
	public void click_the_module_tours() throws InterruptedException {

		supplierModule.clickToursModule();
		supplierModule.clickTours();
		supplierModule.clickManageTours();
		supplierModule.clickToursModule();
		supplierModule.clickTours();
		supplierModule.clickExtras();		
		System.out.println("There is no such modules Flight and Visa ");
		boolean actualValue=supplierModule.isEnableToursButton();

		Assert.assertEquals(true, actualValue);

	}

	@Then("It navigates to Tours page")
	public void it_navigates_to_tours_page() throws InterruptedException {

		supplierModule.clickToursModule();
		supplierModule.clickTours();
		supplierModule.clickManageTours();

		String actualTitle=driver.getTitle();

		Assert.assertEquals("Tours Management", actualTitle);
	}

	@Then("click the module Flights")
	public void click_the_module_flights() {

		System.out.println("No such module is present in the homepage");
		


	}
	
	@Then("page title is {string}")
	public void page_title_is(String title) throws InterruptedException {



		String actualTitle=driver.getTitle();

		Assert.assertEquals(title, actualTitle);

	}

	@Then("It navigates to flights page")
	public void it_navigates_to_flights_page() {

		System.out.println("No such module is present in the homepage and so doesn't navigates to other page");

	}

	@Then("click the module visa")
	public void click_the_module_visa() {

		System.out.println("No such module is present in the homepage");
		

	}

	@Then("It navigates to visa page")
	public void it_navigates_to_visa_page() {

		System.out.println("No such module is present in the homepage and so doesn't navigates to other page");


	}@When("User click the login button")
	public void user_click_the_login_button() throws InterruptedException {

		boolean actual=customerLogin.isEnabledLoginButton();
		Assert.assertEquals(true, actual);

		customerLogin.clickLoginButton();

	}
	@Then("click the logout button")
	public void click_the_logout_button() throws InterruptedException {


		customerLogin.clickLogout();

	}
	
	

		@Then("page should display Wrong credentials. try again!")
		public void page_should_display_wrong_credentials_try_again() throws InterruptedException {

			String actualUrl=customerLogin.wrongCredentials();
			String expectedUrl="https://phptravels.net/login/failed";


			Assert.assertEquals(expectedUrl, actualUrl);

		}
		

		@When("User click the Booking link")
		public void user_click_the_booking_link() throws InterruptedException {


			customerHome.clickMyBookings();

		}

		@When("User navigates to booking page")
		public void customer_navigates_to_booking_page() throws InterruptedException {

			String actual=customerHome.clickMyBookings();
			String expected="Bookings - PHPTRAVELS";

			Assert.assertEquals(actual, expected);		

		}

		@When("User click the Add Funds link")
		public void user_click_the_add_funds_link() throws InterruptedException {

			customerHome.clickAddFunds();

		}

		@When("User navigates to Add Funds page")
		public void user_navigates_to_add_funds_page() throws InterruptedException {

			String actual=customerHome.clickAddFunds();
			String expected="Add Funds - PHPTRAVELS";

			Assert.assertEquals(actual, expected);		

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");


		}

		@When("User click the My Profile link")
		public void user_click_the_my_profile_link() throws InterruptedException {

			customerHome.clickMyProfile();
			customerUpdate.clickGotIt();

		}

		@When("User navigates to My Profile page")
		public void user_navigates_to_my_profile_page() throws InterruptedException {

			String actual=customerHome.clickMyProfile();
			String expected="Profile - PHPTRAVELS";

			Assert.assertEquals(actual, expected);
		}

		@When("click view voucher")
		public void click_view_voucher() throws InterruptedException {


			customerDisplay.clickViewVoucher();
			Thread.sleep(3000);

		}

		@When("User should navigates to voucher page")
		public void user_should_navigates_to_voucher_page() throws InterruptedException {	

			ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

			String actual=driver.getTitle();		
			String expected="Hotel Invoice - PHPTRAVELS";

			Assert.assertEquals(expected, actual);

			driver.close();

			driver.switchTo().window(tabs.get(0));	

		}

		@Then("click the logout link")
		public void click_the_logout_linkn() throws InterruptedException {


			customerHome.clickLogoutLink();

		}

		

		@When("Select payment with Paypal")
		public void select_payment_with_paypal() throws InterruptedException {

			customerUpdate.clickGotIt();
			customerPaypal.clickPaymentWithPaypal();

		}
		@When("Click Pay Now button")
		public void click_pay_now_button() throws InterruptedException {

			customerPaypal.clickPayNow();
			Thread.sleep(2000);

		}
		@When("Click PayPal")
		public void click_pay_pal() throws InterruptedException {


			customerPaypal.clickPaypalButton();

			ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));

			String url=driver.getCurrentUrl();
			System.out.println("URL = "+url);
			String actual=customerPaypal.getTextofPaypalTitle();
			System.out.println(actual);
			System.out.println(driver.getCurrentUrl());
			driver.close();
			driver.switchTo().window(tabs.get(0));

			customerPaypal.clickBackToInvoice();
			customerPaypal.clickYesButton();


		}
		

		@When("enter the address")
		public void enter_the_address() throws IOException, InterruptedException {
			
			customerUpdate.scrollPageDown();
			customerUpdate.enterAddress();

		}



		@When("click update profile")
		public void click_update_profile() throws InterruptedException {



			driver.manage().window().fullscreen();
			customerUpdate.clickUpdateProfile();

		}

		@When("user gets a message {string}")
		public void user_gets_a_message(String text) throws InterruptedException {

			String actualText=customerUpdate.getTextofSuccessMessage();

			Assert.assertEquals(text, actualText);

		}

		@Then("User click the Home link")
		public void user_click_the_home_link() throws InterruptedException {

			agentLink.clickHomeLogo();

		}

		@Then("User navigates to homepage")
		public void user_navigates_to_homepage() {

			String actualUrl=driver.getCurrentUrl();

			Assert.assertEquals("https://phptravels.net/", actualUrl);

		}

		@Then("User click the Hotel link")
		public void user_click_the_hotel_link() throws InterruptedException {

			agentLink.clickHotels();
		}

		@Then("User navigates to hotel page")
		public void user_navigates_to_hotel_page() {

			String actualUrl=driver.getCurrentUrl();

			Assert.assertEquals("https://phptravels.net/hotels", actualUrl);

		}

		@Then("User click the Flights link")
		public void user_click_the_flights_link() throws InterruptedException {

			agentLink.clickFlights();

		}

		@Then("User navigates to flights page")
		public void user_navigates_to_flights_page() {

			String actualUrl=driver.getCurrentUrl();

			Assert.assertEquals("https://phptravels.net/flights", actualUrl);

		}

		@Then("User click the Tours link")
		public void user_click_the_tours_link() throws InterruptedException {

			agentLink.clickTours();

		}

		@Then("User navigates to tours page")
		public void user_navigates_to_tours_page() {

			String actualUrl=driver.getCurrentUrl();

			Assert.assertEquals("https://phptravels.net/tours", actualUrl);

		}

		@Then("User click the Visa link")
		public void user_click_the_visa_link() throws InterruptedException {

			agentLink.clickVisa();

		}

		@Then("User navigates to visa page")
		public void user_navigates_to_visa_page() {

			String actualUrl=driver.getCurrentUrl();

			Assert.assertEquals("https://phptravels.net/visa", actualUrl);
		}

		@Then("User click the Blog link")
		public void user_click_the_blog_link() throws InterruptedException {

			agentLink.clickBlogs();

		}

		@Then("User navigates to blog page")
		public void user_navigates_to_blog_page() {

			String actualUrl=driver.getCurrentUrl();

			Assert.assertEquals("https://phptravels.net/blog", actualUrl);

		}

		@Then("User click the Offers link")
		public void user_click_the_offers_link() throws InterruptedException {

			agentLink.clickOffers();

		}

		@Then("User navigates to offers page")
		public void user_navigates_to_offers_page() {

			String actualUrl=driver.getCurrentUrl();

			Assert.assertEquals("https://phptravels.net/offers", actualUrl);

		}
		@Then("enter the city name, check in date, check out date, and travellers")
		public void enter_the_city_name_check_in_date_check_out_date_and_travellers() throws InterruptedException {		

			agentSearch.clickCity();
			agentSearch.enterCityName();
			agentSearch.selectPlace();
			agentSearch.clickCheckin();
			agentSearch.selectCheckinDate();		
			agentSearch.selectCheckoutDate();
			agentSearch.clickTravellers();

		}

		@Then("click search")
		public void click_search() throws InterruptedException {

			agentSearch.clickSearch();
			

		}

		@Then("User navigates to hotels of that city page")
		public void user_navigates_to_hotels_of_that_city_page() throws InterruptedException {

			/*ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));*/
			
			String actualText=agentSearch.getTextofTitle();

			Assert.assertEquals("SEARCH HOTELS IN MUMBAI", actualText);
			//driver.close();

			//driver.switchTo().window(tabs.get(0));
			//agentSearch.clicktoBack();

		}


		@Then("click USD")
		public void click_usd() throws InterruptedException {

			agentCurrency.clickCurrency();		
		}

		@Then("select the currency as INR")
		public void select_the_currency_as_inr() throws InterruptedException {

			agentCurrency.selectINR();

		}

	
	@Then("close browser")
	public void close_browser() {

		driver.quit();

	}

}
