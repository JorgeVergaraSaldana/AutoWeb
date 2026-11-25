
# AutoWeb - Automatización de Pruebas Web

## 1. Descripción del proyecto

Proyecto de automatización de pruebas funcionales web desarrollado
sobre la plataforma Demoblaze, utilizando Serenity BDD, Selenium
WebDriver, Cucumber y el patrón de diseño Screenplay.

Se uso como base del proyecto el desarrollado en clase incorporando
las funcionalidades de LOGIN y GESTION DEL CARRITO DE COMPRAS mediante escenarios
positivos y negativos. 

**Página web:** https://www.demoblaze.com/index.html

## 2. Objetivo

Automatizar casos de prueba funcionales para verificar el correcto
comportamiento de las funcionalidades de inicio de sesión y gestión
del carrito de compras, mediante diferentes casos de prueba positivos 
y negativos.

## 3. Tecnologías utilizadas

- Java JDK 17
- Maven
- Serenity BDD
- Selenium WebDriver
- Cucumber
- Gherkin
- JUnit
- Patrón Screenplay
- IntelliJ IDEA
- Git y GitHub

## 4. Arquitectura del proyecto

El proyecto utiliza el patrón Screenplay, permitiendo separar
las responsabilidades de la automatización:

- Pages: definición de los localizadores de la interfaz web (buttons, tables, cards)
- Tasks: acciones realizadas por el usuario.
- Questions: consultas y validaciones de los resultados.
- StepDefinitions: conexión entre los escenarios Gherkin
  y las acciones automatizadas.
- Utils: métodos auxiliares y captura de evidencias.
- Features: definición de los escenarios de prueba, tanto login como Car.
- RunnerTest: configuración y ejecución de las pruebas.

## 5. Estructura del proyecto

    AutoWeb/
    ├── src/
    │   ├── main/
    │   │   └── java/
    │   │       └── org/example/
    │   │           ├── Pages/
    │   │           ├── Tasks/
    │   │           ├── Questions/
    │   │           └── Utils/
    │   └── test/
    │       ├── java/
    │       │   └── org/example/
    │       │       ├── StepDefinitions/
    │       │       └── RunnerTest.java
    │       └── resources/
    │           ├── features/
    │           │   ├── 01_registrar_new.feature
    │           │   └── 02_login.feature
    │           │   └── 03_car.feature
    │           └── serenity.conf
    ├── .gitignore
    ├── pom.xml
    └── README.md

## 6. Casos de prueba automatizados

### Funcionalidad: Inicio de sesión @LOGIN

| ID | Caso de prueba | Tipo | Ejecuciones |
|---|---|---|---:|
| CP001 | Inicio de sesión con credenciales válidas | Happy Path | 1 |
| CP002 | Inicio de sesión con contraseña incorrecta | Unhappy Path | 1 |
| CP003 | Inicio de sesión con usuario inexistente | Unhappy Path | 1 |
| CP004 | Inicio de sesión con campos obligatorios vacíos | Unhappy Path | 3 |

### Funcionalidad: Carrito de compras @CAR

| ID | Caso de prueba | Tipo | Ejecuciones |
|---|---|---|---:|
| CP005 | Agregar un producto al carrito | Happy Path | 2 |
| CP006 | Agregar dos productos diferentes al carrito | Happy Path | 1 |
| CP007 | Eliminar un producto de un carrito con varios productos | Happy Path | 1 |
| CP008 | Validar el precio total de los productos del carrito | Happy Path | 1 |

## 7. Validaciones implementadas

### Inicio de sesión

- Inicio de sesión exitoso.
- Visualización del mensaje de bienvenida.
- Validación de contraseña incorrecta.
- Validación de usuario inexistente.
- Validación de campos obligatorios vacíos.

### Carrito de compras

- Validación de carrito vacio.
- Selección dinámica de categorías y productos.
- Confirmación de productos agregados al carrito.
- Validación del nombre y precio de los productos.
- Validación de múltiples productos en el carrito.
- Eliminación individual de productos.
- Validación de la cantidad de productos restantes.
- Validación del cálculo y actualización del precio total.

## 8. Instrucciones de ejecución

### Ejecutar todos los casos de prueba

Desde la terminal de maven, ejecutar:

    mvn clean verify
    mvn verify

El Runner está configurado para ejecutar las funcionalidades
de inicio de sesión y carrito de compras, el caso de registro
de usuario ya no se esta evaluando ya que fue un caso trabajado 
en clase.

### Ejecutar una funcionalidad específica

Modificar la propiedad tags del archivo RunnerTest.java.

Para ejecutar únicamente Login:

    tags = "@Login"

Para ejecutar únicamente Shopping Cart:

    tags = "@Cart"

Para ejecutar ambas funcionalidades:

    tags = "@Login or @Cart"

### Ejecutar un caso de prueba específico

Por ejemplo, para ejecutar el CP007:

    tags = "@Cart and @CP007"

## 9. Reporte de ejecución Serenity BDD

Después de ejecutar las pruebas, Serenity BDD genera un reporte
HTML que contiene:

- Resumen de la ejecución.
- Escenarios ejecutados.
- Resultados de las pruebas.
- Detalle de los pasos automatizados.
- Validaciones realizadas.
- Evidencias disponibles de la ejecución.

El reporte se encuentra en la siguiente ruta:

    target/site/serenity/index.html

O tambien es posible visualizarlo, ejecutando desde la 
terminal de maven el siguiente comando:

    mvn serenity:aggregate

## 10. Evidencias de ejecución

El proyecto incorpora capturas de pantalla durante los pasos
principales de la automatización, permitiendo evidenciar:

- Inicio de sesión.
- Selección de categorías.
- Selección de productos.
- Incorporación de productos al carrito.
- Eliminación de productos.
- Validación de precios y cantidades.
- Resultados esperados de los escenarios.

## AUTOR: JORGE LUIS VERGARA SALDAÑA

