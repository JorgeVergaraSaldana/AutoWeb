package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.example.Pages.HomePage;
import org.example.Questions.ResponseCode;
import org.example.Tasks.NavigateHome;
import org.example.Utils.PreAndProsCondition;
import org.example.Utils.ScreenShot;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.CoreMatchers.equalTo;

public class RegistrarUsuario {
    @Given("el {actor} esta en la pagina de inicio")
    public void elUsuarioEstaEnLaPaginaDeInicio(Actor actor) {
        actor.attemptsTo(NavigateHome.theHomePage());
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot,"Paso 1");
    }

    @And("selecciona el boton de registro")
    public void seleccionaElBotonDeRegistro() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_REGISTRAR));
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot,"Paso 2");
    }

    @And("ingresa un nombre de usuario {string} y contrasenia {string}")
    public void ingresaUnNombreDeUsuarioYContrasenia(String username, String password) {
        theActorInTheSpotlight().attemptsTo(Enter.theValue(username).into(HomePage.INP_USERNAME));
        theActorInTheSpotlight().attemptsTo(Enter.theValue(password).into(HomePage.INP_PASSWORD));
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot,"Paso 2");
    }

    @When("seleccion el boton registrar")
    public void seleccionElBotonRegistrar() {
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot,"Paso 2");
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_REGISTRAR2));
    }

    @Then("realizar el registro de manera exitosa")
    public void realizarElRegistroDeManeraExitosa() {
        theActorInTheSpotlight().should(
                seeThat(
                        ResponseCode.alertMessage(),
                        equalTo("Sign up successful.")
                )
        );
    }
}
