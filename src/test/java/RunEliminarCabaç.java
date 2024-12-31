import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/eliminarcabaç.feature", glue="steps")
public class RunEliminarCabaç extends AbstractTestNGCucumberTests {
	
}
