package coding.challenge.steps;

import coding.challenge.domain.WorldProperPrompt;
import coding.challenge.pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MainSteps {

    private WorldProperPrompt worldProperPrompt;

    public MainSteps(WorldProperPrompt worldProperPrompt) {
        this.worldProperPrompt = worldProperPrompt;
    }

    MainPage mainPage = new MainPage();

    @Then("user should see {string} header")
    public void userShouldSeeCustomerHeader(String headerText) {
        assertThat(mainPage.headerText().getText()).isEqualTo(headerText);
    }

    @When("user selects {string} in search dropdown")
    public void userSelectsIdInSearchDropdown(String column) {
        worldProperPrompt.setAllElements(mainPage.customersList().size());
        worldProperPrompt.setColumnSearch(column);
        mainPage.searchDropDown().click();
        mainPage.searchDropDownOption(column).click();
    }

    @When("user enters {string} into search bar")
    public void userEntersSearchIntoSearchBar(String search) {
        worldProperPrompt.setTerm(search);
        mainPage.searchInput().sendKeys(search);
        worldProperPrompt.setElementsAfterSearch(mainPage.customersList().size());
    }


    @When("user should see customer List")
    public void userShouldSeeCustomerList(List<String> users) {
        assertThat(mainPage.customersList().size()).isEqualTo(1);
        assertThat(textOfElementsList(mainPage.customersList())).isEqualTo(users.get(0));
    }


    @Then("user should see proper prompt with numbers of customers on the list")
    public void userShouldSeeProperPromptWithNumbersOfCustomersOnTheList(){
        int noOfElements = mainPage.customersList().size();
        String properPrompt = "Showing " + noOfElements + " of " + noOfElements + " customers";
        //Showing x of x customers
        assertThat(mainPage.resumeOfCustomerList().getText()).isEqualTo(properPrompt);

    }

    @Then("user should see proper prompt")
    public void userShouldSeeProperPrompt() {
        String actualPrompt = mainPage.resumeOfCustomerList().getText() + " " + mainPage.searchSloganResult().getText().replace("click to clear filters", "").replace("\n", "");
        assertThat(worldProperPrompt.properPrompt()).isEqualTo(actualPrompt);

    }

    @When("user activates Match case")
    public void userActivatesMatchCase() {
        worldProperPrompt.setMatchCase(true);
        mainPage.matchCaseCheckbox().click();
    }

    @When("user searches by value")
    public void userSearchesByValue(Map<String, String> data) {
        worldProperPrompt.setAllElements(mainPage.customersList().size());
        worldProperPrompt.setTerm(data.get("value"));
        worldProperPrompt.setColumnSearch(data.get("column"));

        mainPage.searchInput().sendKeys(data.get("value"));
        mainPage.searchDropDown().click();
        mainPage.searchDropDownOption(data.get("column")).click();
    }

    @When("user clears filters")
    public void userClearsFilters() {
        mainPage.clearButton().click();
    }

    @Then("user should see full list of customers")
    public void userShouldSeeFullListOfCustomers() {
        assertThat(mainPage.customersList().size()).isEqualTo(worldProperPrompt.getAllElements());
    }

    public String textOfElementsList(List<WebElement> listOfElements){
        String list="";
        for(WebElement element : listOfElements){
            list += element.getText();
        }
        return  list;
    }

}
