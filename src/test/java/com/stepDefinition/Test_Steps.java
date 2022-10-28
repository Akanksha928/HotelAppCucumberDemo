package com.stepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import pages.LoginPage;
import pages.SearchHotel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test_Steps {
	static LoginPage loginPg;
	SearchHotel searchHtl;
	public static WebDriver driver;
	public String ExpectedOutput = "Hello akanksha28!";

	@Given("User is on HotelApp homepage")
	public void user_is_on_hotel_app_homepage() {

		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://adactinhotelapp.com");
		driver.manage().window().maximize();
		loginPg = new LoginPage(driver);

	}

	@When("User enters Username")
	public void user_enters_username() {
//		WebElement uname = driver.findElement(By.id("username"));
//		uname.clear();
//		uname.sendKeys("akanksha28");
//		loginPg = new LoginPage(driver);
		loginPg.enterUsername("akanksha28");
	}

	@When("User enters Password")
	public void user_enters_password() {
//		driver.findElement(By.name("password")).clear();
//		driver.findElement(By.name("password")).sendKeys("akanksha");
		loginPg.enterPassword("akanksha");
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
//		driver.findElement(By.className("login_button")).click();
		loginPg.clickLoginBtn();
	}

	@Then("Login is successful")
	public void login_is_successful() {
		WebElement greeting = driver.findElement(By.name("username_show"));
		String actualOutput = greeting.getAttribute("value");
		assertEquals(ExpectedOutput, actualOutput);

	}

	@When("User selects location from dropdown")
	public void user_selects_location_from_dropdown() {
//		new Select(driver.findElement(By.cssSelector("#location"))).selectByVisibleText("Paris");
		searchHtl = new SearchHotel(driver);
		searchHtl.selectLocation();
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
//		driver.findElement(By.xpath("//*[@id=\"Submit\"]")).click();
		searchHtl.clickSearchBtn();
	}

	@Then("List of hotels is displayed")
	public void list_of_hotels_is_displayed() {
		String expectedTitle = "Adactin.com - Select Hotel";
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle, actualTitle);
	}

	@When("User selects a radiobutton")
	public void user_selects_a_radiobutton() {
		driver.findElement(By.cssSelector("#radiobutton_1")).click();
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		driver.findElement(By.cssSelector("#continue")).click();
	}

	@Then("book a hotel page is displayed")
	public void book_a_hotel_page_is_displayed() {
		String expectedTitle = "Adactin.com - Book A Hotel";
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle, actualTitle);
	}

	@When("User enters Username as {string}")
	public void user_enters_username_as(String string) {
		WebElement uname = driver.findElement(By.id("username"));
		uname.clear();
		uname.sendKeys(string);
	}

//
	@When("User enters Password as {string}")
	public void user_enters_password_as(String string) {
//		driver.findElement(By.name("password")).clear();
//		driver.findElement(By.name("password")).sendKeys(string);

		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(string);
	}
//	}
	@When("User enters Username as <{string}>")
	public void user_enters_username_as1(String string) {
		WebElement uname = driver.findElement(By.id("username"));
		uname.clear();
		uname.sendKeys(string);
	}

	@When("User enters Password as <{string}>")
	public void user_enters_password_as1(String string) {
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(string);
	}

	@When("User enters Username and Password")
	public void user_enters_username_and_password(io.cucumber.datatable.DataTable userCredentials) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
//		List<List<String>> data = userCredentials.asLists(String.class);
//		String userName = data.get(0).get(0);
//		String passWord = data.get(0).get(1);
//		WebElement uname = driver.findElement(By.id("username"));
//		uname.clear();
//		uname.sendKeys(userName);
//		
//		driver.findElement(By.name("password")).clear();
//		driver.findElement(By.name("password")).sendKeys(passWord);
		List<Map<String, String>> data = userCredentials.asMaps(String.class, String.class);
		for (Map<String, String> data1 : data) {
			String userName = data1.get("username");
			WebElement uname = driver.findElement(By.id("username"));
			uname.clear();
			uname.sendKeys(userName);
			String password = data1.get("password");
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(password);

		}
	}

}
