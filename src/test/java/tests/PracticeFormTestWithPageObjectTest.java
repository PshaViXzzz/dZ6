package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;

public class PracticeFormTestWithPageObjectTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();


    @Test
     void successfulRegistrationTest() throws InterruptedException {

        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.eMail)
                .setGender(testData.setGender)
                .setPhoneNumber(testData.phoneNumber)
                .birthDate(testData.day, testData.month, testData.year)
                .setSubject(testData.subject)
                .setHobbies(testData.hobby)
                .setPicture(testData.picture)
                .setAddress(testData.address)
                .setStateAndCity(testData.state, testData.city)
        ;

        registrationPage.submitRegistration();

        registrationPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.eMail)
                .checkResult("Gender", testData.setGender)
                .checkResult("Mobile", testData.phoneNumber)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobby)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.address)
                .checkResult("State and City", testData.state + " " + testData.city);

    }

    @Test
    void minSuccessfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setGender("Male")
                .setPhoneNumber("1234567890")
                .submitRegistration();

        registrationPage.checkResult("Student Name", "Ivan Ivanov");
        registrationPage.checkResult("Gender", "Male");
        registrationPage.checkResult("Mobile", "1234567890");
        registrationPage.checkResult("Date of Birth", "06 June,2024");
    }

    @Test
    void nonSuccessfulRegistrationTest() {
        registrationPage.openPage()
                .setLastName("Ivanov")
                .setGender("Male")
                .setPhoneNumber("1234567890")
                .submitRegistration()
                .checkNotAppearingResultTable();
    }


}