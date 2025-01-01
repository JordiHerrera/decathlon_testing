package steps;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

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

public class NetejaVisitesSteps {
	
	WebDriver driver = WebDriverCommon.getDriver();
	String historialInicial;
	
	@When("the user has recently seen products")
	public void hasSeenProds()
	{
		// searchText vtmn-text-content-information double-quote vtmn-font-bold gt-tablet:vtmn-inline-block svelte-yt3w5
		historialInicial = driver.findElement(
                By.xpath("//header[contains(@class, 'title-slot')]//span[text()='Últimos productos vistos']")
            ).getText();
	}
	
	@When("the user deletes product history")
	public void deleteHistory()
	{
		System.out.println("Print 1");
		driver.findElement(By.xpath("//button[text()='Borrar mi historial']")).click();
		System.out.println("Print 1b");
	}
	
	@Then("there are no products recently seen")
	public void noRecentProducts()
	{
		
		boolean trobat = false;

	    System.out.println("print 2");        
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	        List<WebElement> buttons = driver.findElements(By.xpath("//button[text()='Borrar mi historial']"));
	        
	        if (!buttons.isEmpty()) {
	            wait.until(ExpectedConditions.invisibilityOf(buttons.get(0)));
	            System.out.println("Waited for button to disappear");
	        }

	        buttons = driver.findElements(By.xpath("//button[text()='Borrar mi historial']"));
	        if (!buttons.isEmpty()) {
	            System.out.println("Button still exists");
	            trobat = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    Assert.assertFalse(trobat);

	}

}
