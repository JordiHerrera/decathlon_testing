package steps;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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

public class SumaCabacSteps {
	
	WebDriver driver = WebDriverCommon.getDriver();
	
		
	
	
	@When("the user goes to the cart page")
	public void cartPageAmbLinkDirecte()
	{
		driver.get("https://www.decathlon.es/es/checkout/cart");
	}
	
	@Then("the total adds up to the prices of the items")
	public void theTotalAddsUp()
	{
		List<WebElement> elements = driver.findElements(By.cssSelector("span.vtmn-font-bold.vtmn-typo_text-1"));
		boolean trobat = false;

        for (WebElement element : elements) {
            if (element.getText().contains("31,98 €")) {
                System.out.println("Trobat!");
                trobat = true;
                break;
            }
        }
        
        if(!trobat)
        {
        	Assert.fail("El preu final no suma");
        }
        
    }
	
		
}