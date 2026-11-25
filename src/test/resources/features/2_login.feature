Feature: Inicio de sesion de usuario

  Como usuario de Demoblaze
  Quiero iniciar sesion
  Para acceder dentro de la pagina

  Background: Acceder a la ventana de inicio de sesion
    Given el usuario esta en la pagina de inicio
    And selecciona el boton de inicio de sesion

  @Login @CP001 @HappyPath
  Scenario Outline: Iniciar sesion de manera exitosa con usuario y contraseña validos
    And ingresa usuario "<username>" y contrasenia "<password>"
    When selecciona el boton Log in
    Then ingresa a la pagina y visualiza "Welcome <username>"

    Examples:
      | username | password |
      | luceroo  | jor00123 |

  @Login @CP002 @UnhappyPath
  Scenario: Iniciar sesion con una contrasenia incorrecta
    And ingresa usuario "luceroo" y contrasenia "incorrecta123"
    When selecciona el boton Log in
    Then no ingresa y se visualiza "Wrong password."

  @Login @CP003 @UnhappyPath
  Scenario: Iniciar sesion con un usuario inexistente
    And ingresa usuario "usuario_inexistente_987654321" y contrasenia "prueba123"
    When selecciona el boton Log in
    Then no ingresa y se visualiza "User does not exist."

  @Login @CP004 @UnhappyPath
  Scenario Outline: Iniciar sesion con campos obligatorios vacios
    And ingresa usuario "<username>" y contrasenia "<password>"
    When selecciona el boton Log in
    Then no ingresa y se visualiza "Please fill out Username and Password."

    Examples:
      | username | password |
      |          |          |
      | luceroo  |          |
      |          | jor00123 |
