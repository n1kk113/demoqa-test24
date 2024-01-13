import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

@BeforeAll
static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.pageLoadStrategy = "eager";
}

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Denis");
        $("#lastName").setValue("Nikitin");
        $("#userEmail").setValue("den.kennys@mail.ru");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("89279797979");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(byValue("2001")).click();
        $(".react-datepicker__month-select").selectOption("March");
        $("[aria-label ='Choose Wednesday, March 21st, 2001']").click();
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("ScreenCat.png");
        $("#currentAddress").val("Mordovia");
        $("#state").click();
        $("#state input").val("Haryana").pressEnter();
        $("#city").click();
        $("#city input").val("Karnal").pressEnter();
        $("#subjectsInput").setValue ("Arts").pressEnter();;
        $("#submit").pressEnter();


        $(".table-responsive").shouldHave(text("Denis Nikitin"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("21 March,2001"));
        $(".table-responsive").shouldHave(text("ScreenCat.png"));
        $(".table-responsive").shouldHave(text("Haryana"));
        $(".table-responsive").shouldHave(text("Karnal"));
        $(".table-responsive").shouldHave(text("Arts"));


    }
}
