package org.example.Questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.Pages.LoginPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginResponse {

    public static Question<String> welcomeMessage() {
        return actor -> {

            actor.attemptsTo(
                    WaitUntil.the(LoginPage.LBL_WELCOME, isVisible())
                            .forNoMoreThan(10).seconds()
            );

            return LoginPage.LBL_WELCOME
                    .resolveFor(actor)
                    .getText();
        };
    }
}
