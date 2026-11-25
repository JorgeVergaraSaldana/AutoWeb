package org.example.Tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.Pages.LoginPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class LoginUser {

    public static Performable abrirFormulario() {
        return Task.where("{0} abre el formulario de inicio de sesion",
                WaitUntil.the(LoginPage.BTN_INICIO_SESION, isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(LoginPage.BTN_INICIO_SESION),
                WaitUntil.the(LoginPage.TXT_USERNAME, isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }

    public static Performable ingresarCredenciales(String username, String password) {
        return Task.where("{0} ingresa sus credenciales de acceso",
                Enter.theValue(username).into(LoginPage.TXT_USERNAME),
                Enter.theValue(password).into(LoginPage.TXT_PASSWORD)
        );
    }

    public static Performable iniciarSesion() {
        return Task.where("{0} selecciona el boton Log in",
                WaitUntil.the(LoginPage.BTN_LOGIN, isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(LoginPage.BTN_LOGIN)
        );
    }

}
