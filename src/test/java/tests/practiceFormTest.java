package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class practiceFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanov@mail.com");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(".react-datepicker__year-select").selectOptionByValue("1999");
        $(byText("15")).click();
        $("#subjectsInput").setValue("a");
        $("#react-select-2-option-0").click();
        $(".custom-checkbox").click();
        $("#uploadPicture").uploadFromClasspath("img/c2d491ce44016a9fcdb98a909d048.jpeg");
        $("#currentAddress").setValue("qwerty qwerty");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").scrollIntoView(false).click();


        $(".modal-body tr:nth-child(1) td:nth-child(2)").shouldHave(text("Ivan Ivanov"));
        $(".modal-body tr:nth-child(2) td:nth-child(2)").shouldHave(text("ivanov@mail.com"));
        $(".modal-body tr:nth-child(3) td:nth-child(2)").shouldHave(text("Male"));
        $(".modal-body tr:nth-child(4) td:nth-child(2)").shouldHave(text("1234567890"));
        $(".modal-body tr:nth-child(5) td:nth-child(2)").shouldHave(text("15 March,1999"));
        $(".modal-body tr:nth-child(6) td:nth-child(2)").shouldHave(text("Maths"));
        $(".modal-body tr:nth-child(7) td:nth-child(2)").shouldHave(text("Sports"));
        $(".modal-body tr:nth-child(8) td:nth-child(2)").shouldHave(text("c2d491ce44016a9fcdb98a909d048.jpeg"));
        $(".modal-body tr:nth-child(9) td:nth-child(2)").shouldHave(text("qwerty qwerty"));
        $(".modal-body tr:nth-child(10) td:nth-child(2)").shouldHave(text("NCR Delhi"));
    }
}