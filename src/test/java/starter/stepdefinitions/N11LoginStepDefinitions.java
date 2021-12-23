package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import starter.n11.login.LoginAsUser;
import starter.n11.pageelements.N11LoginPageElements;
import starter.n11.tasks.NavigateTo;

import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class N11LoginStepDefinitions {

    Actor actor = Actor.named("patikabootcampers");

    @Managed
    WebDriver webDriver;

    @Given("user launch browser and open the main page")
    public void userLaunchBrowserAndOpenTheMainPage() {
        actor.can(BrowseTheWeb.with(webDriver));
        actor.wasAbleTo(NavigateTo.theN11HomePage());
    }

    @When("user logged in with facebook")
    public void userLoggedInWithFacebook() {
        actor.attemptsTo(LoginAsUser.loginThePage("lespazalte@vusra.com","user1234"));
    }

    @Then("user logged in successfully")
    public void userLoggedInSuccessfully() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Lespazalte Lespazalte
        actor.attemptsTo(
                Ensure.that(N11LoginPageElements.MYACCOUNTNAME_FIELD).isDisplayed(),
                Ensure.that(N11LoginPageElements.MYACCOUNTNAME_FIELD).value().startsWith("Lespazalte")
        );

    }
}
