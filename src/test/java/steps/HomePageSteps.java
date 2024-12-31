package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.WebDriverCommon;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class HomePageSteps {
	
	WebDriver driver = WebDriverCommon.getDriver();
	
		
	@When("the user clicks on a product of the home page")
	public void selectProductHome()
	{
		
        // Esperem a que carregui
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Buscar l'espai on esta el producte
        WebElement productContainer = driver.findElement(By.cssSelector("div[data-supermodelid='7e86608f-5d01-4c02-9552-d958d430c70a']"));
        // Fer scroll cap el producte per assegurar-nos que es visible
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productContainer);
        wait.until(ExpectedConditions.elementToBeClickable(productContainer));
        productContainer.click();
	}
	
	@Then("the product is shown on screen")
	public void productUrl()
	{
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/p/"));
	}

}
