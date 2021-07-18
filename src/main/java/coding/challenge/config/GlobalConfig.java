package coding.challenge.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

@Slf4j
public class GlobalConfig {

    private static GlobalConfig INSTANCE;
    public static WebDriver driver = null;


    private GlobalConfig() {
    }

    public static WebDriver setUp() {

        if (INSTANCE == null) {
            log.info("Setting up Global framework config for coding challenge ");
            Config config = loadConfig();

            if (config.getString("challenge.browser").equalsIgnoreCase("chrome")) {
                log.info("Running chrome");
                System.setProperty("webdriver.chrome.driver", "C:\\Plugins\\chromedriver.exe");
                INSTANCE = new GlobalConfig();
                driver = new ChromeDriver();



            } else if (config.getString("challenge.browser").equalsIgnoreCase("firefox")) {
                log.info("Running Firefox");
                INSTANCE = new GlobalConfig();
                driver = new FirefoxDriver();
            } else if (config.getString("challenge.browser").equalsIgnoreCase("edge")) {
                log.info("Running edge");
                INSTANCE = new GlobalConfig();
                driver = new EdgeDriver();
            }
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        }
        return driver;

    }

    public static Config loadConfig() {

        Config appConfig = ConfigFactory.parseResources("config/default.conf");
        return ConfigFactory.load().withFallback(appConfig);
    }

    public static void quitDriver(){
        driver.quit();
    }

}
