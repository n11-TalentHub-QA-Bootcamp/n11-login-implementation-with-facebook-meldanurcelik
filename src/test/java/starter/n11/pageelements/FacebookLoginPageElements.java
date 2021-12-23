package starter.n11.pageelements;

import net.serenitybdd.screenplay.targets.Target;

public class FacebookLoginPageElements {
    public static Target EMAIL_FIELD = Target.the("email link").locatedBy("#email");
    public static Target PASSWORD_FIELD = Target.the("password link").locatedBy("#pass");
    public static Target LOGINBTN_FIELD = Target.the("login button").locatedBy("#loginbutton");
    public static Target DIALOG_TEXT = Target.the("login button").locatedBy("div.dialogText>div");
}
//İşleminiz gerçekleştiriliyor div.dialogText>div
