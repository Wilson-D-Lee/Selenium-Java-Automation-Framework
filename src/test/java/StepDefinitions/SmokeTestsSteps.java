package StepDefinitions;
import ObjectPages.PageLocators;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

//Project Object Model
public class SmokeTestsSteps {
    WebDriver driver = null;
    PageLocators PageLocators = new PageLocators(driver);

    @Before()
    public void browser_is_working() {
        PageLocators.browserSetup();
    }

    @After()
    public void close_browser() {
        PageLocators.endSession();
    }

    @Given("the user is on the index page")
    public void the_user_is_on_the_index_page() throws InterruptedException {
        PageLocators.acceptCookies();
    }

    @Given("the user navigates to the register page")
    public void the_user_is_on_the_register_page() throws InterruptedException {
        PageLocators.navigateToRegisteration();
    }

    @Given("the user navigates directly to the register page")
    public void the_user_is_now_on_the_register_page() throws InterruptedException {
        PageLocators.navigateDirectlyToRegisteration();
    }

    @Given("the user navigates directly to the a Buddy page")
    public void the_user_navigates_directly_to_the_a_buddy_page() throws InterruptedException {
        PageLocators.navigateDirectlyToBuddyPage();
    }

    @Given("the user is on the chat window")
    public void userIsNavigatedDirectlyToTheChatWindow() throws InterruptedException {
        PageLocators.navigateDirectlyToChatPage();
    }

    @When("user inputs sign-up information")
    public void user_inputs_relevant_information_for_sign_up() throws InterruptedException {
        PageLocators.registerAsUser();
    }

    @When("the user clicks Chat with button")
    public void the_user_clicks_Rachel() throws InterruptedException {
        PageLocators.chatToBuddy();
    }

    @When("the user filters area of study to {string}")
    public void the_user_filters_on_the_area_of_study(String areaOfStudy) throws InterruptedException {
        switch(areaOfStudy) {
            case "BA Comparative Literature":
                PageLocators.filterOnBAComparativeLiterature();
                break;
            case "BA Comparative Literature and Film Studies":
                PageLocators.filterOnBAComparativeLiteratureAndFilmStudies();
                break;
            case "BA Drama":
                PageLocators.filterOnBADrama();
                break;
            default:
                Thread.sleep(3000);
        }

    }

    @When("the user filters countries to {string}")
    public void the_user_filters_on_the_country(String countriesFilter) throws InterruptedException {
        switch(countriesFilter) {
            case "United Kingdom":
                PageLocators.userFiltersOnUnitedKingdom();
                break;
            case "Brazil":
                // Add the other selections for future testing.
                break;
            default:
                // code block
        }
    }

    @When("the user filters levels to {string}")
    public void the_user_filters_level_to(String levels) throws InterruptedException {
        switch(levels) {
            case "Alumni":
                PageLocators.userFiltersOnAlumni();
                break;
            case "Undergraduate":
                // Will be adding the other selections for future testing.
                break;
            default:
                // code block
        }
    }

    @And("user clicks to read more about buddy")
    public void the_buddy_cards_are_visible() throws InterruptedException {
        PageLocators.clickToReadMoreAboutBuddy();
    }

    @And("User Completes the second registration form")
    public void user_completes_second_registration_form() throws InterruptedException {
        PageLocators.stepTwoRegisteration();
    }

    @Then("Buddy's card is visible")
    public void relevant_cards_should_be_visible() throws InterruptedException {
        assert PageLocators.cardNamesIsVisible()==true;
    }

    @Then("setting tab should be visible")
    public void user_account_setting_should_be_visible() throws InterruptedException {
        assert PageLocators.settingsTabIsVisible() ==true;
    }

    @Then("a window should be visible to commence chat")
    public void a_window_should_be_visible_to_commence_chat() throws InterruptedException {
        assert PageLocators.chatReturnsPromptToRegister() == true;
    }

    @Then("user sends an introduction message to buddy")
    public void user_sends_an_introduction_message_to_buddy() throws InterruptedException {
        assert PageLocators.userSendsGreetingsToBuddy() == true;
    }
}

