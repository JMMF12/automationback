import io.cucumber.junit.CucumberOptions;
import models.LoginUserInfo;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import questions.Response;
import tasks.LoginUser;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(value = SerenityRunner.class)
/*@RunWith(value = CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/login_de_usuario.feature",
        glue = {"main.stepdefinitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)*/
public class Tests {

    private final String restApiUrl = "https://restful-booker.herokuapp.com";

    @Test
    public void LoginExitoso() {
        Actor mateo = Actor.named("Mateo")
                .whoCan(CallAnApi.at(restApiUrl));

        LoginUserInfo loginUserInfo = new LoginUserInfo();

        loginUserInfo.setUsername("admin");
        loginUserInfo.setPassword("password123");

        mateo.attemptsTo(
                LoginUser.withInfo(loginUserInfo)
        );

        mateo.should(
                seeThat("el código de respuesta", Response.was(), equalTo(200))
        );
    }
}