package coding.challenge.steps;

import coding.challenge.config.GlobalConfig;
import com.typesafe.config.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import static coding.challenge.allure.AllureReport.attachScreenshot;


public class CommonSteps{
    WebDriver driver = GlobalConfig.setUp();
    Config config = GlobalConfig.loadConfig();
    @Given("user opened customer page")
    @When("user opens customers page")
    public void userOpensMainPage() {
        driver.get(config.getString(System.getProperty("user.dir") + config.getString("challenge.baseUrl")));
    }
}
