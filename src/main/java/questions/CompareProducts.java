package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterfases.HomePage;

public class CompareProducts implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(HomePage.LBL_PRODUCT).viewedBy(actor).asString();
    }
    public static CompareProducts compare(){
        return new CompareProducts();
    }
}
