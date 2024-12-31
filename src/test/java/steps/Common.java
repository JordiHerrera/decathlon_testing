package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.time.Duration;
import common.WebDriverCommon;

public class Common {
	
	WebDriver driver = WebDriverCommon.getDriver();

    public Common(WebDriver driver) {
        this.driver = driver;
    }
    
    public Common() {
    }
    
    @Given("the user is in the index page")
    public void theUserIsInTheIndexPage() {
        
        driver.navigate().to("https://www.decathlon.es/es/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement rejectButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("didomi-notice-agree-button"))
            );
            rejectButton.click();
        } catch (Exception e) {
            System.out.println("No s'ha trobat popup de Cookies, seguint");
        }
    }
    
    @When("the user adds the product to the cart")
	public void addproduct()
	{
		WebElement addToCartButton = driver.findElement(By.cssSelector("button.vtmn-btn.vtmn-btn_variant--conversion.vtmn-btn_size--stretched.conversion-zone__purchase-cta")); 
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", addToCartButton);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
	}

    public void cercar_text_id(String id, String terme)
    {
    	driver.findElement(By.id(id)).sendKeys(terme);
    }
    
    public void cercar_text_classe(String classe, String terme)
    {
    	driver.findElement(By.className(classe)).sendKeys(terme);
    }
    
    public void cercar_text_nom(String nom, String terme)
    {
    	driver.findElement(By.name(nom)).sendKeys(terme);
    }
    
    public void element_aria_label(String text)
    {
    	driver.findElement(By.xpath("//button[@aria-label='"+ text +"']")).click();
    }
}
