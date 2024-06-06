package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
    userEmailInput = $("#userEmail"),
    chooseGender = $("#genterWrapper"),
    phoneNumber = $("#userNumber"),
    calendarInput = $("#dateOfBirthInput"),
    subjectInput = $("#subjectsInput"),
    hobbieInput = $(".custom-checkbox"),
    firstHobbieResultSelection = $("#react-select-2-option-0"),
    uploadPictureInput = $("#uploadPicture"),
    addressInput = $("#currentAddress"),
    stateInput = $("#state"),
    firstSateOptionSelection = $("#react-select-3-option-0"),
    cityInput = $("#city"),
    firstCityOptionSelection = $("#react-select-4-option-0"),
    inputSubmit = $("#submit"),
    resultBoard = $(".table-responsive")
    ;

    CalendarComponent calendarComponent = new CalendarComponent();


public RegistrationPage openPage() {
    open("/automation-practice-form");
            executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage birthDate() {
        calendarInput.click();
        calendarComponent.setDate();
        return this;
    }
    public RegistrationPage setSubject () {
        subjectInput.setValue("a");
        firstHobbieResultSelection.click();
        return this;
    }
    public RegistrationPage setHobbies() {
        hobbieInput.click();
        return this;
    }
    public RegistrationPage setState() {
    stateInput.click();
    firstSateOptionSelection.click();
    return this;
    }
    public RegistrationPage setCity() {
    cityInput.click();
    firstCityOptionSelection.click();
    return this;
    }
    public RegistrationPage submitRegistration() {
    inputSubmit.click();
    return this;
    }


    public RegistrationPage setFirstName (String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName (String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setEmail (String value) {
    userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender (String value) {
        chooseGender.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setPhoneNumber (String value) {
    phoneNumber.setValue(value);
        return this;
    }
    public RegistrationPage setPicture (String value) {
    uploadPictureInput.uploadFromClasspath(value);
    return this;
    }
    public RegistrationPage setAddress (String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
    resultBoard.$(byText(key)).parent()
            .shouldHave(text(value));
    return this;
    }

    public RegistrationPage checkNotAppearingResultTable() {
    resultBoard.shouldNot(appear);
    return this;
    }
}








