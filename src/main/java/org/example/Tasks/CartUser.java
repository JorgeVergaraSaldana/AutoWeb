package org.example.Tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.example.Pages.CartPage;
import org.example.Questions.ResponseCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.serenitybdd.screenplay.Actor;

import java.time.Duration;
import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CartUser {
    public static Performable seleccionarCategoria(String categoria) {

        return Task.where("{0} selecciona la categoria " + categoria,

                WaitUntil.the(
                        CartPage.CATALOGUE_CATEGORY.of(categoria),
                        isClickable()
                ).forNoMoreThan(10).seconds(),

                new Task() {

                    @Override
                    public <T extends Actor> void performAs(T actor) {

                        WebDriver driver =
                                BrowseTheWeb.as(actor).getDriver();

                        WebDriverWait wait =
                                new WebDriverWait(
                                        driver,
                                        Duration.ofSeconds(10)
                                );

                        By productos = By.cssSelector("#tbodyid a.hrefch");

                        WebElement productoAnterior = wait.until(
                                ExpectedConditions
                                        .presenceOfElementLocated(productos)
                        );

                        actor.attemptsTo(
                                Click.on(
                                        CartPage.CATALOGUE_CATEGORY.of(categoria)
                                )
                        );

                        wait.until(
                                ExpectedConditions.stalenessOf(productoAnterior)
                        );

                        wait.until(
                                ExpectedConditions
                                        .visibilityOfAllElementsLocatedBy(productos)
                        );
                    }
                }
        );
    }
    public static Performable seleccionarProducto(String producto) {

        return Task.where("{0} selecciona el producto " + producto,

                WaitUntil.the(
                        CartPage.CATALOGUE_PRODUCTO.of(producto),
                        isClickable()
                ).forNoMoreThan(10).seconds(),

                Click.on(
                        CartPage.CATALOGUE_PRODUCTO.of(producto)
                ),

                WaitUntil.the(
                        CartPage.BTN_ADD_TO_CART,
                        isVisible()
                ).forNoMoreThan(10).seconds()
        );
    }


    public static Performable agregarProducto() {

        return Task.where("{0} agrega el producto al carrito",

                WaitUntil.the(
                        CartPage.BTN_ADD_TO_CART,
                        isClickable()
                ).forNoMoreThan(10).seconds(),

                Click.on(CartPage.BTN_ADD_TO_CART),

                new Task() {
                    @Override
                    public <T extends Actor> void performAs(T actor) {

                        actor.should(
                                seeThat(
                                        ResponseCode.alertMessage(),
                                        equalTo("Product added")
                                )
                        );
                    }
                }
        );
    }


    public static Performable abrirCarrito() {

        return Task.where("{0} ingresa al carrito de compras",

                WaitUntil.the(
                        CartPage.BTN_CART,
                        isClickable()
                ).forNoMoreThan(10).seconds(),

                Click.on(CartPage.BTN_CART),

                WaitUntil.the(
                        CartPage.TABLE_CARRITO,
                        isVisible()
                ).forNoMoreThan(10).seconds()
        );
    }

    public static Performable retornarInicio() {

        return Task.where("{0} retorna a la pagina de inicio",

                WaitUntil.the(
                        CartPage.BTN_HOME,
                        isClickable()
                ).forNoMoreThan(10).seconds(),

                Click.on(CartPage.BTN_HOME)
        );
    }

    public static Performable eliminarProducto(String producto) {

        return Task.where("{0} elimina el producto " + producto,

                WaitUntil.the(
                        CartPage.BTN_DELETE.of(producto),
                        isClickable()
                ).forNoMoreThan(10).seconds(),

                Click.on(
                        CartPage.BTN_DELETE.of(producto)
                ),

                WaitUntil.the(
                        CartPage.FILA_PRODUCTO.of(producto),
                        isNotVisible()
                ).forNoMoreThan(10).seconds()
        );
    }


    public static Performable limpiarCarrito() {

        return Task.where("{0} limpia el carrito de compras",

                abrirCarrito(),

                new Task() {

                    @Override
                    public <T extends Actor> void performAs(T actor) {

                        WebDriver driver =
                                BrowseTheWeb.as(actor).getDriver();

                        WebDriverWait wait =
                                new WebDriverWait(
                                        driver,
                                        Duration.ofSeconds(10)
                                );

                        By filas = By.cssSelector("#tbodyid > tr");

                        List<WebElement> productos =
                                driver.findElements(filas);

                        while (!productos.isEmpty()) {

                            int cantidadAnterior = productos.size();

                            productos.get(0)
                                    .findElement(By.linkText("Delete"))
                                    .click();

                            wait.until(d ->
                                    d.findElements(filas).size()
                                            < cantidadAnterior
                            );

                            productos = driver.findElements(filas);
                        }
                    }
                },

                retornarInicio()
        );
    }

}
