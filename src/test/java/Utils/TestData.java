package Utils;

import com.github.javafaker.Faker;

public class TestData {

    private static final Faker faker = new Faker();

    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String eMail = faker.internet().emailAddress();
    public static String setGender = faker.options().option("Male", "Female", "Other");
    public static String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    public static String year = String.valueOf(faker.number().numberBetween(1950, 2023));
    public static String month = faker.options().option("January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December");
    public static String day = setDay(String.valueOf(faker.number().numberBetween(1, 28)));
    public static String subject = faker.options().option("Hindi", "English", "Maths", "Physics", "Chemistry",
            "Computer Science", "Commerce", "Accounting", "Economics",
            "Arts", "Social Studies", "History", "Civics");
    public static String hobby = faker.options().option("Sports", "Reading", "Music");
    public static String picture = "cat.webp";
    public static String address = faker.address().streetAddress();
    public static String state = faker.options().option("NCR", "Utter Pradesh", "Haryana", "Rajasthan");
    public static String city = setRandomCity(state);

    public static String setDay(String day) {
        if (day.length() < 2) {
            return "0" + day;
        } else return day;

    }

    public static String setRandomCity(String state) {
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
