package tasks;

import interactions.Post;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginUser implements Task {

    private final Object userInfo;

    public LoginUser(Object userInfo) {
        this.userInfo = userInfo;
    }

    public static Performable withInfo(Object userInfo) {
        return instrumented(LoginUser.class, userInfo);
    }

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/auth").with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .body(userInfo)
                )
        );
    }
}
