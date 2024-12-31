import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/filtres.feature", glue="steps")
public class RunFiltres extends AbstractTestNGCucumberTests {
	
}
