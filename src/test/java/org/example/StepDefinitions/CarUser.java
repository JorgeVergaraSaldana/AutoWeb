package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.example.Tasks.CartUser;
import org.example.Questions.CartResponse;
import org.example.Utils.PreAndProsCondition;
import org.example.Utils.ScreenShot;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.CoreMatchers.equalTo;

public class CarUser {

    @And("tiene el carrito de compras vacio")
    public void tieneElCarritoDeComprasVacio() {

        theActorInTheSpotlight().attemptsTo(
                CartUser.limpiarCarrito()
        );

        ScreenShot.captureScreenshot(
                getDriver(),
                PreAndProsCondition.screenShot,
                "Preparacion del carrito"
        );
    }

    @And("selecciona la categoria {string}")
    public void seleccionaLaCategoria(String categoria) {

        theActorInTheSpotlight().attemptsTo(
                CartUser.seleccionarCategoria(categoria)
        );

        ScreenShot.captureScreenshot(
                getDriver(),
                PreAndProsCondition.screenShot,
                "Seleccion de la categoria " + categoria
        );
    }

    @And("selecciona el producto {string}")
    public void seleccionaElProducto(String producto) {

        theActorInTheSpotlight().attemptsTo(
                CartUser.seleccionarProducto(producto)
        );

        ScreenShot.captureScreenshot(
                getDriver(),
                PreAndProsCondition.screenShot,
                "Seleccion del producto"
        );
    }

    @When("agrega el producto al carrito")
    public void agregaElProductoAlCarrito() {

        theActorInTheSpotlight().attemptsTo(
                CartUser.agregarProducto()
        );

        ScreenShot.captureScreenshot(
                getDriver(),
                PreAndProsCondition.screenShot,
                "Producto agregado"
        );
    }

    @And("selecciona el boton Cart")
    public void seleccionaElBotonCart() {

        theActorInTheSpotlight().attemptsTo(
                CartUser.abrirCarrito()
        );
    }

    @And("retorna a la pagina de inicio")
    public void retornaALaPaginaDeInicio() {

        theActorInTheSpotlight().attemptsTo(
                CartUser.retornarInicio()
        );
    }

    @When("elimina el producto {string} del carrito")
    public void eliminaElProductoDelCarrito(String producto) {

        theActorInTheSpotlight().attemptsTo(
                CartUser.eliminarProducto(producto)
        );

        ScreenShot.captureScreenshot(
                getDriver(),
                PreAndProsCondition.screenShot,
                "Producto eliminado"
        );
    }

    @Then("visualiza el producto {string} y su precio {int} en el carrito")
    public void visualizaElProductoYSuPrecio(
            String producto, int precio) {

        theActorInTheSpotlight().should(

                seeThat(
                        CartResponse.nombreProducto(producto),
                        equalTo(producto)
                ),

                seeThat(
                        CartResponse.precioProducto(producto),
                        equalTo(precio)
                )
        );

        ScreenShot.captureScreenshot(
                getDriver(),
                PreAndProsCondition.screenShot,
                "Validacion del producto y precio"
        );
    }

    @Then("no se observa al producto {string} en el carrito")
    public void noSeObservaElProducto(String producto) {

        theActorInTheSpotlight().should(
                seeThat(
                        CartResponse.productoExiste(producto),
                        equalTo(false)
                )
        );

        ScreenShot.captureScreenshot(
                getDriver(),
                PreAndProsCondition.screenShot,
                "Validacion del producto eliminado"
        );
    }

    @And("visualiza solo el producto {string} en el carrito")
    public void visualizaSoloElProducto(String producto) {

        theActorInTheSpotlight().should(

                seeThat(
                        CartResponse.nombreProducto(producto),
                        equalTo(producto)
                ),

                seeThat(
                        CartResponse.cantidadProductos(),
                        equalTo(1)
                )
        );

        ScreenShot.captureScreenshot(
                getDriver(),
                PreAndProsCondition.screenShot,
                "Validacion del unico producto restante"
        );
    }

    @Then("visualiza el precio total de {int} en el carrito")
    public void visualizaElPrecioTotal(int precioTotal) {

        theActorInTheSpotlight().should(
                seeThat(
                        CartResponse.precioTotal(),
                        equalTo(precioTotal)
                )
        );

        ScreenShot.captureScreenshot(
                getDriver(),
                PreAndProsCondition.screenShot,
                "Validacion del precio total"
        );
    }
}

