package userinterfases;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    public static final Target TXT_USERNAME=Target.the("Caja para el username").locatedBy("//input[@id=\"user-name\"]");
    public static final Target TXT_PASS=Target.the("Caja para la contraseña").locatedBy("//input[@id=\"password\"]");
    public static final Target BTN_SUBMMIT=Target.the("Boton para login").locatedBy("//input[@id=\"login-button\"]");
}
