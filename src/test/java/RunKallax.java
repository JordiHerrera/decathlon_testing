import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/kallax.feature", glue="steps")
public class RunKallax extends AbstractTestNGCucumberTests {
	
}
