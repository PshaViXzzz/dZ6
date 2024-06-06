import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTestWithPageObject extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void succesfulRegistrationTest() {

        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("ivanov@mail.com")
                .setGender("Male")
                .setPhoneNumber("1234567890")
                .birthDate()
                .setSubject()
                .setHobbies()
                .setPicture("img/c2d491ce44016a9fcdb98a909d048.jpeg")
                .setAddress("qwerty qwerty")
                .setState()
                .setCity()
                .submitRegistration();

        registrationPage.checkResult("Student Name","Ivan Ivanov");
        registrationPage.checkResult("Student Email","ivanov@mail.com");
        registrationPage.checkResult("Gender","Male");
        registrationPage.checkResult("Mobile","1234567890");
        registrationPage.checkResult("Date of Birth","15 March,1999");
        registrationPage.checkResult("Subjects","Maths");
        registrationPage.checkResult("Hobbies","Sports");
        registrationPage.checkResult("Picture","c2d491ce44016a9fcdb98a909d048.jpeg");
        registrationPage.checkResult("Address","qwerty qwerty");
        registrationPage.checkResult("State and City","NCR Delhi");

    }
    @Test
    void minSuccesfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setGender("Male")
                .setPhoneNumber("1234567890")
                .submitRegistration();

        registrationPage.checkResult("Student Name","Ivan Ivanov");
        registrationPage.checkResult("Gender","Male");
        registrationPage.checkResult("Mobile","1234567890");
        registrationPage.checkResult("Date of Birth","06 June,2024");
    }

    @Test
    void nonSuccesfulRegistrationTest() {
        registrationPage.openPage()
                .setLastName("Ivanov")
                .setGender("Male")
                .setPhoneNumber("1234567890")
                .submitRegistration()
                .checkNotAppearingResultTable();
    }



}