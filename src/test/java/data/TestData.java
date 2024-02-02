package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("en-GB"));
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String number = faker.phoneNumber().subscriberNumber(10);
    public int day = (faker.number().numberBetween(1, 28));
    public String month = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    public String year = String.valueOf(faker.number().numberBetween(1990, 2023));
    public String subject = faker.options().option("Social Studies", "Arts", "Chemistry");
    public String hobbies = faker.options().option("Sports", "Reading", "Music");
    public String uploadPicture = faker.options().option("ScreenCat.png", "Gulag.jpg");
    public String streetAddress = faker.address().streetAddress();
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = setCity(state);
    public String title = "Thanks for submitting the form";
    public String color = "rgb(220, 53, 69)";
    public String borderColor = "border-color";

    public String setCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return null;
        }
    }
}