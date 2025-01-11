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

public class CategoriesSteps {
	
	WebDriver driver = WebDriverCommon.getDriver();
	
		
	@When("the user is on top a category")
	public void selectcategory()
	{

	    WebElement category = driver.findElement(By.cssSelector("li.menubar--nav-item[data-name-original='deportes']"));  
	    Actions actions = new Actions(driver);
	    actions.moveToElement(category).perform();  // Moviment del mouse per les subcategories

	}
	
	@When("clicks in a subcategory")
	public void clickSubcategory()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            WebElement subcategory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Judo')]")));            
            subcategory.click();
        } catch (Exception e) {
            System.out.println("Element not found or not clickable: " + e.getMessage());
        }
	}

	@Then("the subcategory is shown on screen")
	public void verifyCategory() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    try {

	        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Tienda de judo')]")));
	        Assert.assertTrue(heading.isDisplayed(), "No estem a 'Tienda de judo'.");
	    } catch (TimeoutException e) {
	        Assert.fail("No estem a 'Tienda de judo'.");
	    }
    }
	
}
