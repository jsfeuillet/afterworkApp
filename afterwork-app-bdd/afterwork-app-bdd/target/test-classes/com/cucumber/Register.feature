#language: es

Característica: Registro inicial de un cliente

Yo como usuario no registrado en 'afterworkApp'
Quiero regrstrarme en la web
Para poder empezar a beneficiarme de los servicios de la app

Escenario: Registro exitoso de un cliente
    Dado un usuario no regristrado que entra en la web de registro
    Cuando ingreso los campos obligatorios correctamente: PEPE, pepe123, pepe@gmail.com y los envío
    Entonces aparece un mensaje de éxito de registro 

Escenario: Usuario con mail ya existente registrado
    Dado un usuario no regristrado que entra en la web de registro
    Cuando ingreso los campos obligatorios correctamente con un mail ya registrado previamente: PEPEBIS, pepebis123, pepe@gmail.com y los envío
    Entonces aparece un mensaje de error indicando tal situación 

Escenario: Usuario con mail incorrecto
    Dado un usuario no regristrado que entra en la web de registro
    Cuando ingreso los campos obligatorios con un mail incorrecto: PEPEBIS, pepebis123, pepearrobagmail.com y los envío
    Entonces aparece un mensaje de error indicando que el mail es incorrecto
    
Escenario: Usuario con nombre de usuario incorrecto
    Dado un usuario no regristrado que entra en la web de registro
    Cuando ingreso los campos obligatorios con un usuario incorrecto: PEPEBIS, el usuário, pepe2@gmail.com y los envío
    Entonces aparece un mensaje de error indicando que el usuario es incorrecto
