package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
                   glue= {"stepdefinations","hooks"},
                   publish=true,
                   plugin={"pretty","html:target/CucumberReport/CucumberReport.html"})

public class TestRunner {

}
