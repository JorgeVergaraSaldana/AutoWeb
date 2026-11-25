Feature: Registrar nuevo usuario
  @RegistrarNew @HappyPath
    Scenario Outline: Registrar de manera exitosa un usuario con datos validos
    Given el usuario esta en la pagina de inicio
    And selecciona el boton de registro
    And ingresa un nombre de usuario "<username>" y contrasenia "<password>"
    When seleccion el boton registrar
    Then realizar el registro de manera exitosa

    Examples:
      | username  | password |
      | luceroooo | jor00123 |
