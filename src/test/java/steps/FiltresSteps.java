package steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.WebDriverCommon;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class FiltresSteps {
	
	WebDriver driver = WebDriverCommon.getDriver();
	
		
	@When("the user enters {string} in the search bar2")
	public void theUserEntersTextInTheSearchBar2(String nom)
	{
		//WebDriver driver = WebDriverCommon.getDriver();
		new Common(driver).cercar_text_nom("Ntt", nom);
	}
	
	@When("the user clicks on the search button")
	public void theClicksTheSearchButton2()
	{
		driver.findElement(By.xpath("//button[@aria-label='Busca producto, deporte...']")).click();

	}

	@When("the user selects the filter of ascending price")
	public void filter() {

	    WebElement sortSelect = driver.findElement(By.id("list-sort-select"));

	    Select select = new Select(sortSelect);

	    select.selectByValue("1");

	}
	
	
	@Then("the products of the page have reordered")
	public void verifyOrder() throws InterruptedException {	    
		Thread.sleep(5000);
		List<WebElement> productPricesAfter = driver.findElements(By.cssSelector(".dpb-holder"));

	    double previousPrice = -1;  
	    int count = 0;

	    for (WebElement product : productPricesAfter) {

	        WebElement priceElement = product.findElement(By.cssSelector(".vtmn-price"));

	        String priceText = priceElement.getText().replace("€", "").replace(",", ".").trim();

	        double currentPrice = Double.parseDouble(priceText);

	        if (currentPrice < previousPrice) {
	            Assert.fail("Els productes no estan endreçats.");
	        }

	        previousPrice = currentPrice;

	        count++;

	        if (count == 5) {
	            break;
	        }
	    }
	}

}

