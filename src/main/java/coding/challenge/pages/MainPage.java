package coding.challenge.pages;

import coding.challenge.config.GlobalConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {
    WebDriver driver = GlobalConfig.setUp();

    public WebElement headerText() { return driver.findElement(By.cssSelector(".container > h3")); }

    public WebElement searchDropDown() {
        return driver.findElement(By.cssSelector("#search-column"));
    }

    public WebElement searchDropDownOption(String optionSelector) { return searchDropDown().findElement(By.cssSelector("option[value='" + optionSelector + "']")); }

    public WebElement searchInput() {
        return driver.findElement(By.cssSelector("#search-input"));
    }

    public List<WebElement> customersList() {
        return driver.findElements(By.cssSelector("tbody >tr"));
    }

    public WebElement resumeOfCustomerList() {
        return driver.findElement(By.cssSelector("#table-resume"));
    }

    public WebElement matchCaseCheckbox() {
        return driver.findElement(By.cssSelector("#match-case"));
    }

    public WebElement searchSloganResult() { return driver.findElement(By.cssSelector("#search-slogan")); }

    public WebElement clearButton() {
        return driver.findElement(By.cssSelector("#clear-button"));
    }}
