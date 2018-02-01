package com.rsi.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefinitions {
	private static WebDriver driver;
	
	@Before 
	public void before() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/selenium/chromedriver_2.35.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void after() {
		driver.quit();
	}
	
	@Given("^I am on the site root$")
	public void onSiteRoot() {
		driver.navigate().to("http://localhost:8080/spring-mvc-showcase/");
	}
	
	@Then("^the title should be \"([^\"]*)\"$")
	public void checkTitle(String arg1) {
		assertEquals(arg1, driver.getTitle());
	}
	
	@Then("^I should see \"([^\"]*)\"$")
	public void iShouldSee(String arg1) {
		assertTrue(driver.getPageSource().contains(arg1));
	}
}
