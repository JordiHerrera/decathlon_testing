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

    @When("enters email")
    public void enterEmail() {
        new Common(driver).cercar_text_id("input-email", "tqs_uab_testing@yopmail.com");
        driver.findElement(By.id("lookup-btn")).click();
    }
    
    @When("enters password")
    public void enterPassword() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.id("input-password")));
    	passwordField.sendKeys("TQS_test_1");
    }
    
    @When("clicks login")
    public void buttonlogin() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("signin-button")));
        loginButton.click();
    }

    @Then("user dashboard appears")
    public void userDashboard() {
        String title = driver.findElement(By.className("features_items")).getText();
        assertTrue(title.contains("SEARCHED PRODUCTS"));
    }
}
