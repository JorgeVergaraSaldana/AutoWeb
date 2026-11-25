package org.example.Pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target BTN_INICIO_SESION =
            Target.the("Boton de inicio de sesion")
                    .located(By.id("login2"));

    public static final Target TXT_USERNAME =
            Target.the("Input para ingresar username")
                    .located(By.id("loginusername"));

    public static final Target TXT_PASSWORD =
            Target.the("Input para ingresar password")
                    .located(By.id("loginpassword"));

    public static final Target BTN_LOGIN =
            Target.the("Boton de inicio de sesion")
                    .located(By.xpath("//button[@onclick='logIn()']"));

    public static final Target BTN_CLOSE =
            Target.the("Boton para cerrar formulario ")
                    .located(By.xpath("//div[@id='logInModal']//button[text()='Close']"));

    public static final Target LBL_WELCOME =
            Target.the("Card de Mensaje de bienvenida")
                    .located(By.id("nameofuser"));

}

