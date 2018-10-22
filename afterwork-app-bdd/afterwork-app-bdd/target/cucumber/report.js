$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com\\cucumber\\Register.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#language: es"
    }
  ],
  "line": 3,
  "name": "Registro inicial de un cliente",
  "description": "\r\nYo como usuario no registrado en \u0027afterworkApp\u0027\r\nQuiero regrstrarme en la web\r\nPara poder empezar a beneficiarme de los servicios de la app",
  "id": "registro-inicial-de-un-cliente",
  "keyword": "Característica"
});
formatter.scenario({
  "line": 9,
  "name": "Registro exitoso de un cliente",
  "description": "",
  "id": "registro-inicial-de-un-cliente;registro-exitoso-de-un-cliente",
  "type": "scenario",
  "keyword": "Escenario"
});
formatter.step({
  "line": 10,
  "name": "un usuario no regristrado que entra en la web de registro",
  "keyword": "Dado "
});
formatter.step({
  "line": 11,
  "name": "ingreso los campos obligatorios correctamente: PEPE, pepe123, pepe@gmail.com y los envío",
  "keyword": "Cuando "
});
formatter.step({
  "line": 12,
  "name": "aparece un mensaje de éxito de registro",
  "keyword": "Entonces "
});
formatter.match({
  "location": "StepDefinition.que_estoy_en_la_aplicación()"
});
formatter.result({
  "duration": 619216200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "PEPE",
      "offset": 47
    },
    {
      "val": "pepe123",
      "offset": 53
    },
    {
      "val": "pepe@gmail.com",
      "offset": 62
    }
  ],
  "location": "StepDefinition.ingreso_los_campos_obligatorios(String,String,String)"
});
formatter.result({
  "duration": 573834254,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.el_registro_es_correcto()"
});
formatter.result({
  "duration": 1170588107,
  "error_message": "java.lang.AssertionError: \nExpected: is \"El usuario se ha registrado con éxito, recibirás un email para confirmar el registro\"\n     but: was \"El usuario ya existe en el sistema\"\r\n\tat org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:20)\r\n\tat org.junit.Assert.assertThat(Assert.java:865)\r\n\tat org.junit.Assert.assertThat(Assert.java:832)\r\n\tat com.cucumber.StepDefinition.el_registro_es_correcto(StepDefinition.java:53)\r\n\tat ✽.Entonces aparece un mensaje de éxito de registro(com\\cucumber\\Register.feature:12)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 14,
  "name": "Usuario con mail ya existente registrado",
  "description": "",
  "id": "registro-inicial-de-un-cliente;usuario-con-mail-ya-existente-registrado",
  "type": "scenario",
  "keyword": "Escenario"
});
formatter.step({
  "line": 15,
  "name": "un usuario no regristrado que entra en la web de registro",
  "keyword": "Dado "
});
formatter.step({
  "line": 16,
  "name": "ingreso los campos obligatorios correctamente con un mail ya registrado previamente: PEPEBIS, pepebis123, pepe@gmail.com y los envío",
  "keyword": "Cuando "
});
formatter.step({
  "line": 17,
  "name": "aparece un mensaje de error indicando tal situación",
  "keyword": "Entonces "
});
formatter.match({
  "location": "StepDefinition.que_estoy_en_la_aplicación()"
});
formatter.result({
  "duration": 506869348,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "PEPEBIS",
      "offset": 85
    },
    {
      "val": "pepebis123",
      "offset": 94
    },
    {
      "val": "pepe@gmail.com",
      "offset": 106
    }
  ],
  "location": "StepDefinition.ingreso_los_campos_obligatorios_con_mail_existente(String,String,String)"
});
formatter.result({
  "duration": 646223879,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.el_mail_ya_existe()"
});
formatter.result({
  "duration": 1306273674,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Usuario con mail incorrecto",
  "description": "",
  "id": "registro-inicial-de-un-cliente;usuario-con-mail-incorrecto",
  "type": "scenario",
  "keyword": "Escenario"
});
formatter.step({
  "line": 20,
  "name": "un usuario no regristrado que entra en la web de registro",
  "keyword": "Dado "
});
formatter.step({
  "line": 21,
  "name": "ingreso los campos obligatorios con un mail incorrecto: PEPEBIS, pepebis123, pepearrobagmail.com y los envío",
  "keyword": "Cuando "
});
formatter.step({
  "line": 22,
  "name": "aparece un mensaje de error indicando que el mail es incorrecto",
  "keyword": "Entonces "
});
formatter.match({
  "location": "StepDefinition.que_estoy_en_la_aplicación()"
});
formatter.result({
  "duration": 441563537,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "PEPEBIS",
      "offset": 56
    },
    {
      "val": "pepebis123",
      "offset": 65
    },
    {
      "val": "pepearrobagmail.com",
      "offset": 77
    }
  ],
  "location": "StepDefinition.ingreso_los_campos_obligatorios_con_mail_incorrecto(String,String,String)"
});
formatter.result({
  "duration": 518371247,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.el_mail_no_es_correcto()"
});
formatter.result({
  "duration": 1274045548,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Usuario con nombre de usuario incorrecto",
  "description": "",
  "id": "registro-inicial-de-un-cliente;usuario-con-nombre-de-usuario-incorrecto",
  "type": "scenario",
  "keyword": "Escenario"
});
formatter.step({
  "line": 25,
  "name": "un usuario no regristrado que entra en la web de registro",
  "keyword": "Dado "
});
formatter.step({
  "line": 26,
  "name": "ingreso los campos obligatorios con un usuario incorrecto: PEPEBIS, el usuário, pepe2@gmail.com y los envío",
  "keyword": "Cuando "
});
formatter.step({
  "line": 27,
  "name": "aparece un mensaje de error indicando que el usuario es incorrecto",
  "keyword": "Entonces "
});
formatter.match({
  "location": "StepDefinition.que_estoy_en_la_aplicación()"
});
formatter.result({
  "duration": 2509492409,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "PEPEBIS",
      "offset": 59
    },
    {
      "val": "el usuário",
      "offset": 68
    },
    {
      "val": "pepe2@gmail.com",
      "offset": 80
    }
  ],
  "location": "StepDefinition.ingreso_los_campos_obligatorios_con_usuario_incorrecto(String,String,String)"
});
formatter.result({
  "duration": 875869948,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.el_usuario_no_es_correcto()"
});
formatter.result({
  "duration": 1262665985,
  "status": "passed"
});
});