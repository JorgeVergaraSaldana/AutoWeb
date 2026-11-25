package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Questions.LoginResponse;
import org.example.Questions.ResponseCode;
import org.example.Tasks.LoginUser;
import org.example.Utils.PreAndProsCondition;
import org.example.Utils.ScreenShot;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginUsuario {

    @And("selecciona el boton de inicio de sesion")
    public void seleccionaElBotonDeInicioDeSesion() {

        theActorInTheSpotlight().attemptsTo(
                LoginUser.abrirFormulario()
        );

        ScreenShot.captureScreenshot(
                getDriver(),
                PreAndProsCondition.screenShot,
                "Paso 2 - Formulario Login"
        );
    }

    @And("ingresa usuario {string} y contrasenia {string}")
    public void ingresaUsuarioYContrasenia(String username, String password) {

        theActorInTheSpotlight().attemptsTo(
                LoginUser.ingresarCredenciales(username, password)
        );

        ScreenShot.captureScreenshot(
                getDriver(),
                PreAndProsCondition.screenShot,
                "Paso 3 - Ingreso de usuario y password"
        );
    }

    @When("selecciona el boton Log in")
    public void seleccionaElBotonLogIn() {

        theActorInTheSpotlight().attemptsTo(
                LoginUser.iniciarSesion()
        );
    }

    @Then("ingresa a la pagina y visualiza {string}")
    public void ingresaALaPaginaYVisualiza(String mensaje) {

        theActorInTheSpotlight().should(
                seeThat(
                        LoginResponse.welcomeMessage(),
                        equalTo(mensaje)
                )
        );

        ScreenShot.captureScreenshot(
                getDriver(),
                PreAndProsCondition.screenShot,
                "Paso 4 - Login exitoso"
        );
    }

    @Then("no ingresa y se visualiza {string}")
    public void noIngresaYSeVisualiza(String mensaje) {

        theActorInTheSpotlight().should(
                seeThat(
                        ResponseCode.alertMessage(),
                        equalTo(mensaje)
                )
        );

        ScreenShot.captureScreenshot(
                getDriver(),
                PreAndProsCondition.screenShot,
                "Paso 4 - Login incorrecto"
        );
    }
}
