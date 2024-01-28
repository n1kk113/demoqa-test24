package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("en-GB"));
    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            number = faker.phoneNumber().subscriberNumber(10),
            day = String.valueOf(faker.number().numberBetween(1, 28)),
            mouth = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"),
            year = String.valueOf(faker.number().numberBetween(1990, 2023)),
            subject = faker.options().option("Social Studies", "Arts", "Chemistry"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            uploadPicture = faker.options().option("ScreenCat.png", "Gulag.jpg"),
            streetAddress = faker.address().streetAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = setCity(state),
            title =  "Thanks for submitting the form",
            color = "rgb(220, 53, 69)",
            borderColor = "border-color";

    public String setCity(String state) {
        switch (state){
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
