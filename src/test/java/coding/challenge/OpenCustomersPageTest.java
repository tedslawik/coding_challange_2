package coding.challenge;

import coding.challenge.config.GlobalConfig;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:/features/OpenCustomers.feature"},
        glue = {"coding.challenge.steps"},
        plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}
)
public class OpenCustomersPageTest {
    @AfterClass
    public static void tearDown(){
        System.out.println("tu sobie jestem");
        GlobalConfig.quitDriver();
    }
}

