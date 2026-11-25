Feature: Gestion de carrito de compras

  Como usuario de Demoblaze
  Quiero gestionar los productos de mi carrito
  Para realizar mis compras

  Background: Acceder a la pagina de inicio
    Given el usuario esta en la pagina de inicio
    And tiene el carrito de compras vacio

  @Cart @CP005 @HappyPath
  Scenario Outline: Agregar un producto al carrito de compras
    And selecciona la categoria "<categoria>"
    And selecciona el producto "<producto>"
    When agrega el producto al carrito
    And selecciona el boton Cart
    Then visualiza el producto "<producto>" y su precio <precio> en el carrito

    Examples:
      | categoria | producto          | precio |
      | Phones    | Samsung galaxy s7 | 800    |
      | Monitors  | Apple monitor 24  | 400    |

  @Cart @CP006 @HappyPath
  Scenario: Agregar dos productos diferentes al carrito de compras
    And selecciona la categoria "Phones"
    And selecciona el producto "Iphone 6 32gb"
    And agrega el producto al carrito
    And retorna a la pagina de inicio
    And selecciona la categoria "Laptops"
    And selecciona el producto "MacBook air"
    When agrega el producto al carrito
    And selecciona el boton Cart
    Then visualiza el producto "Iphone 6 32gb" y su precio 790 en el carrito
    And visualiza el producto "MacBook air" y su precio 700 en el carrito

  @Cart @CP007 @HappyPath
  Scenario: Eliminar un producto de un carrito con varios productos
    And selecciona la categoria "Phones"
    And selecciona el producto "Samsung galaxy s7"
    And agrega el producto al carrito
    And retorna a la pagina de inicio
    And selecciona la categoria "Laptops"
    And selecciona el producto "MacBook air"
    And agrega el producto al carrito
    And selecciona el boton Cart
    When elimina el producto "Samsung galaxy s7" del carrito
    Then no se observa al producto "Samsung galaxy s7" en el carrito
    And visualiza el producto "MacBook air" y su precio 700 en el carrito
    And visualiza solo el producto "MacBook air" en el carrito
    And visualiza el precio total de 700 en el carrito


  @Cart @CP008 @HappyPath
  Scenario: Validar el precio total de los productos del carrito
    And selecciona la categoria "Phones"
    And selecciona el producto "Samsung galaxy s7"
    And agrega el producto al carrito
    And retorna a la pagina de inicio
    And selecciona la categoria "Laptops"
    And selecciona el producto "MacBook air"
    And agrega el producto al carrito
    When selecciona el boton Cart
    Then visualiza el producto "Samsung galaxy s7" y su precio 800 en el carrito
    And visualiza el producto "MacBook air" y su precio 700 en el carrito
    And visualiza el precio total de 1500 en el carrito

