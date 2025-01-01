import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/canvipagina.feature", glue="steps")
public class RunCanviPagina extends AbstractTestNGCucumberTests {
	
}
