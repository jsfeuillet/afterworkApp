package com.cucumber;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class StepDefinition {

    static final String APP_URL = "http://localhost:3000/index";
    WebDriver driver;

    @Before
    public void setup() {
        this.driver = WebDriverFactory.createWebDriver();
    }

    //SCENARIO 1
    @Dado("^un usuario no regristrado que entra en la web de registro$")
    public void que_estoy_en_la_aplicación() throws Throwable {
        this.driver.get(APP_URL);
    }

    @Cuando("^ingreso los campos obligatorios correctamente: (.*), (.*), (.*) y los envío$")
    public void ingreso_los_campos_obligatorios(String nombre, String usuario, String mail) throws Throwable {
        WebElement nameField = this.driver.findElement(By.id("name"));
        WebElement userField = this.driver.findElement(By.id("user"));
        WebElement mailField = this.driver.findElement(By.id("mail"));
        
        WebElement submitButton = this.driver.findElement(By.id("register"));

        nameField.sendKeys(String.valueOf(nombre));
        userField.sendKeys(String.valueOf(usuario));
        mailField.sendKeys(String.valueOf(mail));
        
        submitButton.click();
    }

    @Entonces("^aparece un mensaje de éxito de registro$")
    public void el_registro_es_correcto() throws Throwable {
        WebElement divResultado = this.driver.findElement(By.id("register-result"));

    	new WebDriverWait(this.driver, 5).until(ExpectedConditions.visibilityOf(divResultado));
        assertThat(divResultado.getText(), is("El usuario se ha registrado con éxito, recibirás un email para confirmar el registro"));
        
        this.driver.quit();
    }
    
    //SCENARIO 2
    @Cuando("^ingreso los campos obligatorios correctamente con un mail ya registrado previamente: (.*), (.*), (.*) y los envío$")
    public void ingreso_los_campos_obligatorios_con_mail_existente(String nombre, String usuario, String mail) throws Throwable {
        ingreso_los_campos_obligatorios(nombre, usuario, mail);
    }
    
    @Entonces("^aparece un mensaje de error indicando tal situación$")
    public void el_mail_ya_existe() throws Throwable {
        WebElement divResultado = this.driver.findElement(By.id("register-result"));

    	new WebDriverWait(this.driver, 5).until(ExpectedConditions.visibilityOf(divResultado));
        assertThat(divResultado.getText(), is("El usuario ya existe en el sistema"));
        
        this.driver.quit();
    }
    
    //SCENARIO 3
    @Cuando("^ingreso los campos obligatorios con un mail incorrecto: (.*), (.*), (.*) y los envío$")
    public void ingreso_los_campos_obligatorios_con_mail_incorrecto(String nombre, String usuario, String mail) throws Throwable {
        ingreso_los_campos_obligatorios(nombre, usuario, mail);
    }
    
    @Entonces("^aparece un mensaje de error indicando que el mail es incorrecto$")
    public void el_mail_no_es_correcto() throws Throwable {
        WebElement divResultado = this.driver.findElement(By.id("register-result"));

    	new WebDriverWait(this.driver, 5).until(ExpectedConditions.visibilityOf(divResultado));
        assertThat(divResultado.getText(), is("Por favor, intoduzca un mail correcto"));
        
        this.driver.quit();
    }
    
    //SCENARIO 4
    @Cuando("^ingreso los campos obligatorios con un usuario incorrecto: (.*), (.*), (.*) y los envío$")
    public void ingreso_los_campos_obligatorios_con_usuario_incorrecto(String nombre, String usuario, String mail) throws Throwable {
        ingreso_los_campos_obligatorios(nombre, usuario, mail);
    }
    
    @Entonces("^aparece un mensaje de error indicando que el usuario es incorrecto$")
    public void el_usuario_no_es_correcto() throws Throwable {
        WebElement divResultado = this.driver.findElement(By.id("register-result"));

    	new WebDriverWait(this.driver, 5).until(ExpectedConditions.visibilityOf(divResultado));
        assertThat(divResultado.getText(), is("Por favor, intoduzca un nombre de usuario solo con múmeros y/o letras"));
        
        this.driver.quit();
    }
}
