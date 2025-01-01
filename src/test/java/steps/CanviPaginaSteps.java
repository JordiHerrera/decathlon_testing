package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.WebDriverCommon;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class CanviPaginaSteps {
	
	WebDriver driver = WebDriverCommon.getDriver();
	String textoPagina;
	
	@When("the user is on the search results")
	public void getPageNumber()
	{
		textoPagina = driver.findElement(By.cssSelector("nav[aria-label='Paginación de la página de lista de productos']")).getText();
		System.out.println("#############-" + textoPagina + "-#############");
	}
	
	@When("the user clicks the next page button")
	public void PageSelection()
	{
		driver.findElement(By.cssSelector("button.vtmn-btn.vtmn-btn_variant--primary.vtmn-btn_size--small.vtmn-btn--icon-alone.vtmn-m-3")).click();
	}
	
	@Then("the product page is updated")
	public void pageIsUpdated()
	{
		String nouText = driver.findElement(By.cssSelector("nav[aria-label='Paginación de la página de lista de productos']")).getText();
		Assert.assertEquals(textoPagina, nouText);
	}
}