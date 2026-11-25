package org.example.Questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.Pages.CartPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CartResponse {

    public static Question<String> nombreProducto(String producto) {

        return actor -> {

            actor.attemptsTo(
                    WaitUntil.the(
                            CartPage.NAME_PRODUCTO.of(producto),
                            isVisible()
                    ).forNoMoreThan(10).seconds()
            );

            return CartPage.NAME_PRODUCTO.of(producto)
                    .resolveFor(actor)
                    .getText();
        };
    }

    public static Question<Integer> precioProducto(String producto) {

        return actor -> {

            actor.attemptsTo(
                    WaitUntil.the(
                            CartPage.PRODUCT_PRECIO.of(producto),
                            isVisible()
                    ).forNoMoreThan(10).seconds()
            );

            String precio = CartPage.PRODUCT_PRECIO.of(producto)
                    .resolveFor(actor)
                    .getText();

            return Integer.parseInt(precio.trim());
        };
    }

    public static Question<Integer> cantidadProductos() {

        return actor -> CartPage.FILAS_CARRITO
                .resolveAllFor(actor)
                .size();
    }

    public static Question<Integer> precioTotal() {

        return actor -> {

            actor.attemptsTo(
                    WaitUntil.the(
                            CartPage.PRODUCT_TOTAL,
                            isVisible()
                    ).forNoMoreThan(10).seconds()
            );

            String total = CartPage.PRODUCT_TOTAL
                    .resolveFor(actor)
                    .getText();

            return Integer.parseInt(total.trim());
        };
    }
    public static Question<Boolean> productoExiste(String producto) {

        return actor -> !CartPage.FILA_PRODUCTO.of(producto)
                .resolveAllFor(actor)
                .isEmpty();
    }
}

