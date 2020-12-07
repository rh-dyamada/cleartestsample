package sample;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.impl.Events.events;
import static com.codeborne.selenide.Selenide.sleep;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;

/**
 * Simple Selenide Test with PageObjects
 */
public class ClearSampleTest {

    @Test
    public void clearError() throws Exception {

        open("https://clear-test-sample.herokuapp.com/");

        // input
        $("#input").setValue("Not Clear ###################");
        $("#input").should(value("Not Clear ###################"));
        $("#label").should(text("Not Clear ###################"));
        sleep(2000);

        // clear
        $("#input").clear();
        sleep(2000);

        // assert
        $("#input").should(Condition.empty);
        $("#label").should(Condition.empty);    // fail

    }

    @Test
    public void fireEvent() throws Exception {

        open("https://clear-test-sample.herokuapp.com/");

        // input
        $("#input").setValue("Not Clear ###################");
        $("#input").should(value("Not Clear ###################"));
        $("#label").should(text("Not Clear ###################"));
        Thread.sleep(2000);

        // clear
        $("#input").clear();
        events.fireEvent(WebDriverRunner.driver(), $("#input"), "keydown", "keypress", "input", "keyup", "change");
        Thread.sleep(2000);

        // assert
        $("#input").should(Condition.empty);
        $("#label").should(Condition.empty);

    }
}
