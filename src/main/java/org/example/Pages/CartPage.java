package org.example.Pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {
    public static final Target CATALOGUE_CATEGORY =
            Target.the("Categoria del catalogo {0}")
                    .locatedBy("//a[@id='itemc' and text()='{0}']");

    public static final Target CATALOGUE_PRODUCTO =
            Target.the("Producto del catalogo {0}")
                    .locatedBy("//a[@class='hrefch' and text()='{0}']");

    public static final Target BTN_ADD_TO_CART =
            Target.the("Boton de agregar al carrito")
                    .located(By.xpath("//a[text()='Add to cart']"));

    public static final Target BTN_CART =
            Target.the("Boton de carrito")
                    .located(By.id("cartur"));

    public static final Target BTN_HOME =
            Target.the("Boton Home")
                    .located(By.xpath("//a[@href='index.html' and @class='nav-link']"));

    public static final Target TABLE_CARRITO =
            Target.the("Tabla del carrito de compras")
                    .located(By.cssSelector("table.table-bordered"));

    public static final Target TABLE_BODY_CARRITO =
            Target.the("Cuerpo de la tabla del carrito")
                    .located(By.id("tbodyid"));

    public static final Target FILAS_CARRITO =
            Target.the("Filas de productos del carrito")
                    .located(By.cssSelector("#tbodyid > tr"));

    public static final Target FILA_PRODUCTO =
            Target.the("Fila del producto {0}")
                    .locatedBy("//tbody[@id='tbodyid']/tr[td[2]='{0}']");

    public static final Target NAME_PRODUCTO =
            Target.the("Nombre del producto {0}")
                    .locatedBy("//tbody[@id='tbodyid']/tr[td[2]='{0}']/td[2]");

    public static final Target PRODUCT_PRECIO =
            Target.the("Precio del producto {0}")
                    .locatedBy("//tbody[@id='tbodyid']/tr[td[2]='{0}']/td[3]");

    public static final Target BTN_DELETE =
            Target.the("Boton Delete del producto {0}")
                    .locatedBy("//tbody[@id='tbodyid']/tr[td[2]='{0}']/td[4]/a");

    public static final Target PRODUCT_TOTAL =
            Target.the("Precio total del carrito")
                    .located(By.id("totalp"));

}
