package testRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
        features = {"src/test/java/Feature/login.feature"},
        glue = {"steps"},
        dryRun = true,
        snippets = SnippetType.CAMELCASE,
        monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests{
}

