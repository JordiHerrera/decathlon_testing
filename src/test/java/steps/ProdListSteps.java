package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ProdListSteps {
	
	WebDriver driver;
	
	@Given("the user is in the index page")
	public void theUserIsInTheIndexPage()
	{
		
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.navigate().to("https://www.decathlon.es/es/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		try {
	        WebElement rejectButton = wait.until(
	            ExpectedConditions.elementToBeClickable(By.id("didomi-notice-agree-button"))
	        );
	        rejectButton.click(); 
	    } catch (Exception e) {
	        System.out.println("No se ha encontrado el popup de cookies: " + e.getMessage());
	    }
	}
		
	@When("the user enters {string} in the search bar")
	public void theUserEntersTextInTheSearchBar(String nom)
	{
		new Common(driver).cercar_text_nom("Ntt", nom);
	}
	
	@When("the user clicks the search button")
	public void theClicksTheSearchButton()
	{
		driver.findElement(By.xpath("//button[@aria-label='Busca producto, deporte...']")).click();

	}
	
	@Then("the {string} product line appears")
	public void productLineAppears(String nom)
	{
		// searchText vtmn-text-content-information double-quote vtmn-font-bold gt-tablet:vtmn-inline-block svelte-yt3w5
		String title = driver.findElement(By.cssSelector("div.searchText q")).getText();
		Assert.assertTrue(title.contains(nom));
	}

}
