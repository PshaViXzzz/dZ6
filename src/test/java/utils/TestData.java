package utils;

import com.github.javafaker.Faker;

public class TestData {

    public Faker faker = new Faker();

    public  String firstName = faker.name().firstName();
    public  String lastName = faker.name().lastName();
    public  String eMail = faker.internet().emailAddress();
    public  String setGender = faker.options().option("Male", "Female", "Other");
    public  String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    public  String year = String.valueOf(faker.number().numberBetween(1950, 2023));
    public  String month = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    public  String day = setDay(String.valueOf(faker.number().numberBetween(1, 28)));
    public  String subject = faker.options().option("Hindi", "English", "Maths", "Physics", "Chemistry", "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics");
    public  String hobby = faker.options().option("Sports", "Reading", "Music");
    public String picture = "cat.webp";
    public  String address = faker.address().streetAddress();
    public  String state = faker.options().option("NCR", "Utter Pradesh", "Haryana", "Rajasthan");
    public String city = setRandomCity(state);

    public static String setDay(String day) {
        if (day.length() < 2) {
            return "0" + day;
        } else return day;

    }

    public String setRandomCity(String state) {
        switch (state) {
            case "NCR":
                city = faker.options().option("Delhi", "Gurgaon", "Noida");
                break;
            case "Uttar Pradesh":
                city = faker.options().option("Agra", "Lucknow", "Merrut");
                break;
            case "Haryana":
                city = faker.options().option("Karnal", "Panipat");
                break;
            case "Rajasthan":
                city = faker.options().option("Jaipur", "Jaiselmer");
                break;
        }
        return city;
    }
}
