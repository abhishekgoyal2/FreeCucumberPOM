package com.qa.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import org.junit.Assert;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;
public class HomePageStep extends TestBase{

	LoginPage loginpg ;
	HomePage homepg=new HomePage();
	
	@Given("^User Opens the Browser$")
	public void User_Opens_the_Browser() throws Throwable {
		
		TestBase.initialization();
		
	    // Express the Regexp above with the code you wish you had
//	    throw new PendingException();
	}

	@Then("^User is on login page$")
	public void User_is_on_login_page() throws Throwable {
		loginpg= new LoginPage();
		String title =loginpg.validateLoginPageTitle();
		System.out.println("Page title before login is " + title);
		Assert.assertEquals("#1 Free CRM software in the cloud for sales and service", title);
	    // Express the Regexp above with the code you wish you had
//	    throw new PendingException();
	}

	@Then("^User enter username and password$")
	public void User_enter_username_and_password() throws Throwable {
		
		homepg=loginpg.login(prop.getProperty("username"),prop.getProperty("password"));
	    // Express the Regexp above with the code you wish you had
//	    throw new PendingException();
	}

	
	
	

	@Then("^validate Home page title$")
	public void validate_Home_page_title() throws Throwable {
		
		String title =homepg.verifyHomePageTitle();
		System.out.println("Home page title " + title);
	Assert.assertEquals("CRMPRO", title);
	    // Express the Regexp above with the code you wish you had
//	    throw new PendingException();
	}

	@Then("^validate logged in user$")
	public void validate_logged_in_user() throws Throwable {
		Thread.sleep(3000);
		boolean flag=homepg.verifyCorrectUserName();
		Assert.assertTrue(flag);
	    // Express the Regexp above with the code you wish you had
//	    throw new PendingException();
	}

	
}
