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

public class KallaxSteps {
	
	WebDriver driver;
	
	@Given("the user is in the index page")
	public void theUserIsInTheIndexPage()
	{
		
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.navigate().to("https://www.ikea.com/es/es/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        try {
            WebElement cookieButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("onetrust-reject-all-handler"))
            );
            cookieButton.click(); // Accept cookies
        } catch (Exception e) {
            System.out.println("Cookie popup not found or already handled: " + e.getMessage());
        }
	}
		
	@When("the user enters kallax in the search bar")
	public void theUserEntersKallaxInTheSearchBar()
	{
		//driver.findElement(By.id("ikea-search-input")).sendKeys("Kallax");
		new Common(driver).cercar_text_id("ikea-search-input", "Kallax");
		//driver.findElement(By.partialLinkText("Products")).click();
	}
	
	@When("the user clicks the search button")
	public void theUserEntersDressInTheSearchBar()
	{
		driver.findElement(By.id("search-box__searchbutton")).click();
	}
	
	@Then("the shelf list appears")
	public void theShelfListAppears()
	{
		String title = driver.findElement(By.className("search-summary")).getText();
		Assert.assertTrue(title.contains("Kallax"));
	}

}
