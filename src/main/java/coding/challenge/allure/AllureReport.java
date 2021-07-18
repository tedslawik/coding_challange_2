package coding.challenge.allure;

//import io.qameta.allure.Allure;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//
//import static com.codeborne.selenide.Screenshots.takeScreenShotAsFile;
//import static org.apache.commons.io.FileUtils.readFileToByteArray;
//
//@Slf4j
//public class AllureReport {
//
//    public static void attachScreenshot(String screenshotTitle) {
//        try {
//            Allure.addAttachment(screenshotTitle,
//                    new ByteArrayInputStream(readFileToByteArray(takeScreenShotAsFile())));
//        } catch (IOException e) {
//            log.error(e.getMessage());
//        }
//    }
//}