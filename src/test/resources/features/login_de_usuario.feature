Feature: Login de usuario
  Mateo como usuario quiere poder ingresar a la página
  Para poder gestionar su cuenta

  Scenario: Login de usuario exitoso
    Given Mateo es un cliente previamente registrado en restful-booker
    When ingresa un usuario y contraseña correctamente
    Then debe obtener un token de inicio de sesion