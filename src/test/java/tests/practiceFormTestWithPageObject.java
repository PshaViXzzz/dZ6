package tests;

import Utils.TestData;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.TestBase;

import static java.lang.Thread.sleep;

public class practiceFormTestWithPageObject extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();



    @Test
    void succesfulRegistrationTest() throws InterruptedException {


        registrationPage.openPage()
                .setFirstName(TestData.firstName)
                .setLastName(TestData.lastName)
                .setEmail(TestData.eMail)
                .setGender(TestData.setGender)
                .setPhoneNumber(TestData.phoneNumber)
                .birthDate(TestData.day,TestData.month,TestData.year)
                .setSubject(TestData.subject)
                .setHobbies(TestData.hobby)
                .setPicture(TestData.picture)
                .setAddress(TestData.address)
                .setStateAndCity(testData.state, testData.city)
                ;
        sleep(10000);
        registrationPage.submitRegistration();

        registrationPage.checkResult("Student Name", TestData.firstName + " " + TestData.lastName)
       .checkResult("Student Email", TestData.eMail)
       .checkResult("Gender", TestData.setGender)
       .checkResult("Mobile", TestData.phoneNumber)
       .checkResult("Date of Birth", TestData.day + " " + TestData.month + "," + TestData.year)
       .checkResult("Subjects", TestData.subject)
       .checkResult("Hobbies", TestData.hobby)
       .checkResult("Picture", TestData.picture)
       .checkResult("Address", TestData.address)
       .checkResult("State and City", TestData.state + " " + TestData.city);

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
    void nonSuccessfulRegistrationTest() {
        registrationPage.openPage()
                .setLastName("Ivanov")
                .setGender("Male")
                .setPhoneNumber("1234567890")
                .submitRegistration()
                .checkNotAppearingResultTable();
    }



}