package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
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

public class EliminarCabaçSteps {
	
	WebDriver driver = WebDriverCommon.getDriver();
	
		
	@When("the user clicks on a product2")
	public void selectProduct2()
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
	
	@When("the user adds the product to the cart2")
	public void addproduct2()
	{
		WebElement addToCartButton = driver.findElement(By.cssSelector("button.vtmn-btn.vtmn-btn_variant--conversion.vtmn-btn_size--stretched.conversion-zone__purchase-cta")); 
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", addToCartButton);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
	}

	@When("the user goes back to the homepage")
	public void homePage() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement homeLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Ir a la página de inicio']")));
	    homeLink.click();
	}
	
	@When("the user enters the cart")
	public void enterCart() {
	    // Esperar a que el contador del cabaç s'actualitzi
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    // Localitzar el contador del cabaç   
	    WebElement cartLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.cart-button.svelte-l64znc")));
	    
	    cartLink.click();
	}
	
	@When("the user clicks on the eliminate product icon")
	public void deleteCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement deleteIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.quantity-selector-button.svelte-17i25jm[aria-label='Eliminar']")));
		deleteIcon.click();
	}
	
	@Then("the product is not on the cart anymore")
	public void verifyDeleted() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Localitzar el div 
		WebElement subtotalDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='vtmn-flex-1']//span[normalize-space(text())='Subtotal']")));

		// Obtenir el text
		String subtotalText = subtotalDiv.getText().trim();

		// Verificar si només surt subtotal
		Assert.assertEquals("Subtotal", subtotalText);
	}
}
