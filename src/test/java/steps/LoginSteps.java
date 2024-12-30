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

import common.WebDriverCommon;

public class LoginSteps{
	
	public WebDriver driver = WebDriverCommon.getDriver(); 
    
    
    @When("clicks login button")
    public void clicksLoginButton() {
    	WebDriver driver = WebDriverCommon.getDriver();
    	WebElement accountLink = driver.findElement(By.xpath("//a[contains(@class, 'tool-link') and @aria-label='Mi cuenta']"));
    
        // Click the element
        accountLink.click();
    }

    @When("enters email {string}")
    public void enterEmail(String email) {
        new Common(driver).cercar_text_id("input-email", email);
        driver.findElement(By.id("lookup-btn")).click();
    }
    
    @When("enters password")
    public void enterPassword() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.id("input-password")));
    	passwordField.sendKeys("TQS_test_1");
    }
    
    @When("clicks forgot password")
    public void buttonlogin() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement forgotPasswordLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='¿Has olvidado la contraseña?']")));
    	forgotPasswordLink.click();
    }

    @Then("forgotten password page appears with email {string}")
    public void userDashboard(String email) {
        String title = driver.findElement(By.className("account-editor-contact")).getText();
        assertTrue(title.contains(email));
    }
}
