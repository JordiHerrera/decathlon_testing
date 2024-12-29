package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import java.time.Duration;

public class Common {
	
	WebDriver driver;

    public Common(WebDriver driver) {
        this.driver = driver;
    }
    
    public void theUserIsOnTheHomepage(String link_inici) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(link_inici);
    }

    public void cercar_text_id(String id, String terme)
    {
    	driver.findElement(By.id(id)).sendKeys(terme);
    }
    
    public void cercar_text_classe(String classe, String terme)
    {
    	driver.findElement(By.className(classe)).sendKeys(terme);
    }
}
