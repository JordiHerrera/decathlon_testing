package steps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertTrue;

import dev.failsafe.internal.util.Assert;

import org.openqa.selenium.WebDriver;
import java.time.Duration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps{
	
	WebDriver driver;

    @Given("the user is in the starting page")
    public void theUserIsInTheStartingPage() {
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
    

    @When("clicks login button")
    public void clicksLoginButton() {
    	WebElement accountLink = driver.findElement(By.xpath("//a[contains(@class, 'tool-link') and @aria-label='Mi cuenta']"));

        // Click the element
        accountLink.click();
    }

    @When("enters email")
    public void enterEmail() {
        new Common(driver).cercar_text_id("input-email", "aqui_email");
        driver.findElement(By.id("lookup-btn")).click();
    }

    @When("enters password")
    public void enterPassword() {
        new Common(driver).cercar_text_id("input-password", "aqui_contrasenya");
    }

    @When("clicks login")
    public void buttonlogin() {
        driver.findElement(By.id("signin-button")).click();
    }

    @Then("user dashboard appears")
    public void userDashboard() {
        String title = driver.findElement(By.className("features_items")).getText();
        assertTrue(title.contains("SEARCHED PRODUCTS"));
    }
}
