import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/netejavisites.feature", glue="steps")
public class RunNetejaVisites extends AbstractTestNGCucumberTests {
	
}
