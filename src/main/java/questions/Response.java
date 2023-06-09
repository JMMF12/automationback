package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Response implements Question {

    public static Question<Integer> was(){
        return new Response();
    }

    @Override
    public Integer answeredBy(Actor actor) {return SerenityRest.lastResponse().statusCode();
    }
}