package coding.challenge;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"coding.challenge.steps"},
        plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}
)
public class OpenCustomersPageTest {
}

