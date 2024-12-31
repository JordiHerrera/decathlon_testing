import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/sumacabac.feature", glue="steps")
public class RunSumaCabac extends AbstractTestNGCucumberTests {
	
}
