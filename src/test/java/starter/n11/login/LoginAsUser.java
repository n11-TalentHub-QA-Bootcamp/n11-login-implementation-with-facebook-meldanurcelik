package starter.n11.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import starter.n11.pageelements.FacebookLoginPageElements;
import starter.n11.pageelements.N11HomePageElements;
import starter.n11.pageelements.N11LoginPageElements;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class LoginAsUser implements Task {

    private final String email_text;
    private final String password_text;

    @Step("{0} Login with email '#email_text' and password '#password_text'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(N11HomePageElements.SIGNIN_FIELD),
                WaitUntil.the(N11LoginPageElements.FACEBOOKBTN_FIELD, isClickable()).forNoMoreThan(2).seconds(),
                Click.on(N11LoginPageElements.FACEBOOKBTN_FIELD),
                Switch.toNewWindow(),
                Click.on(FacebookLoginPageElements.EMAIL_FIELD),
                SendKeys.of(this.email_text).into(FacebookLoginPageElements.EMAIL_FIELD),
                Click.on(FacebookLoginPageElements.PASSWORD_FIELD),
                SendKeys.of(this.password_text).into(FacebookLoginPageElements.PASSWORD_FIELD),
                Click.on(FacebookLoginPageElements.LOGINBTN_FIELD),
                //WaitUntil.the(FacebookLoginPageElements.DIALOG_TEXT, isNotVisible()).forNoMoreThan(5).seconds(),
                Switch.toNewWindow(),
                WaitUntil.the(N11LoginPageElements.MYACCOUNT_FIELD, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(N11LoginPageElements.MYACCOUNT_FIELD),
                WaitUntil.the(N11LoginPageElements.MYACCOUNTNAME_FIELD, isVisible()).forNoMoreThan(7).seconds()
        );
    }

    public LoginAsUser(String email_text, String password_text) {
        this.email_text = email_text;
        this.password_text = password_text;
    }

    public static LoginAsUser loginThePage(String email_text, String password_text) {
        return instrumented(LoginAsUser.class, email_text, password_text);
    }
}
