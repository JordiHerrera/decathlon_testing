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

import common.WebDriverCommon;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ProdListSteps {
	
	WebDriver driver = WebDriverCommon.getDriver();
	
			
	
	@Then("the {string} product line appears")
	public void productLineAppears(String nom)
	{
		// searchText vtmn-text-content-information double-quote vtmn-font-bold gt-tablet:vtmn-inline-block svelte-yt3w5
		String title = driver.findElement(By.cssSelector("div.searchText q")).getText();
		Assert.assertTrue(title.contains(nom));
	}

}
