package stepsdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import questions.CompareProducts;
import tasks.Login;


public class LoginStepDefinition {
    //1.Definir el navegador
    @Managed
    WebDriver hisBroser;
    //2.Ejecutar los pasos de este metodo antes que las demas
    @Before
    public void setUp(){
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("user");
        //3.Dar habilidades
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(hisBroser));
    }

    @Given("the user enter to web page")
    public void theUserEnterToWebPage() {
        //4.Agregar Url
     OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://www.saucedemo.com/"));
    }
    @When("the user entre the credentials")
    public void theUserEntreTheCredentials() {
     OnStage.theActorInTheSpotlight().attemptsTo(Login.enter());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("the user his log successful")
    public void theUserHisLogSuccessful() {
OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(CompareProducts.compare(), Matchers.is("Sauce Labs Backpack")));
    }
}
