package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.LoginUserInfo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.Response;
import tasks.LoginUser;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginUserStepDefinitions {
    private final String apiRestUrl = "https://restful-booker.herokuapp.com";
    Actor mateo;

    @Given("Mateo es un cliente previamente registrado en restful-booker")
    public void mateoEsUnClientePreviamenteRegistradoEnRestfulBooker() {
        // Write code here that turns the phrase above into concrete actions
        mateo = Actor.named("Mateo")
                .whoCan(CallAnApi.at(apiRestUrl));
    }
    @When("ingresa un usuario y contraseña correctamente")
    public void ingresaUnUsuarioYContraseñaCorrectamente() {
        // Write code here that turns the phrase above into concrete actions
        LoginUserInfo loginUserInfo = new LoginUserInfo();

        loginUserInfo.setUsername("admin");
        loginUserInfo.setPassword("password123");

        mateo.attemptsTo(
                LoginUser.withInfo(loginUserInfo)
        );
    }
    @Then("debe obtener un token de inicio de sesion")
    public void debeObtenerUnTokenDeInicioDeSesion() {
        // Write code here that turns the phrase above into concrete actions
        mateo.should(
                seeThat("el código de respuesta", Response.was(), equalTo(200))
        );
    }
}
