package starter.n11.pageelements;

import net.serenitybdd.screenplay.targets.Target;

public class N11HomePageElements {
    public static Target SIGNUP_FIELD = Target.the("sign up link").locatedBy(".btnSignUp");
    public static Target SIGNIN_FIELD = Target.the("sign in link").locatedBy(".btnSignIn");
}
