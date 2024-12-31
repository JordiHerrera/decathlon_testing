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

public class AfegirCabaçSteps {
	
	WebDriver driver = WebDriverCommon.getDriver();
	
		
	@When("the user clicks on a product")
	public void selectProduct()
	{
		
        // Esperem a que carregui
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Buscar l'espai on esta el producte
        WebElement productContainer = driver.findElement(By.cssSelector("div[data-supermodelid='d9eef34f-9d72-43ce-9b24-aa12c81d87c7']"));
        // Fer scroll cap el producte per assegurar-nos que es visible
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productContainer);
        wait.until(ExpectedConditions.elementToBeClickable(productContainer));
        productContainer.click();
	}
	
	

	@Then("the product has to be on the cart")
	public void verifyProductInCart() {
	    // Esperar a que el contador del cabaç s'actualitzi
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    // Localitzar el contador del cabaç
	    WebElement cartIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.count.badge--blue.svelte-l64znc")));
	    wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(cartIcon, "0")));
	    // Nombre de productes del cabaç
	    String cartItemCount = cartIcon.getText();
	    Assert.assertTrue(Integer.parseInt(cartItemCount) > 0, "El cabaç no conté productes.");
	}
}
