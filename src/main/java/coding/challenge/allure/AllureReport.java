package coding.challenge.allure;

import coding.challenge.config.GlobalConfig;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.IOException;



@Slf4j
public class AllureReport {
static WebDriver driver = GlobalConfig.setUp();
    public static void attachScreenshot(String screenshotTitle) {
        try {
            Allure.addAttachment(screenshotTitle,
                    new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}