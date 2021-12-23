package starter.n11.pageelements;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class N11LoginPageElements {
    public static Target FACEBOOKBTN_FIELD = Target.the("facebook button").locatedBy(".facebookBtn");
    public static Target MYACCOUNT_FIELD = Target.the("my account name").locatedBy(".menuLink.user");
    public static Target MYACCOUNTNAME_FIELD = Target.the("my profile name").locatedBy(".my_account__menu__profile__full_name");
}
