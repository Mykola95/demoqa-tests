package testdata;

import com.github.javafaker.Faker;

public class TestData {
    static Faker faker = new Faker();

    static String[]
            genderArray = {"Male", "Female", "Other"},
            monthArray = {"January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"},
            hobbiesArray = {"Sports", "Reading", "Music"};

    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            emailAddress = faker.internet().emailAddress(),
            gender = genderArray[faker.number().numberBetween(0, 2)],
            mobileNumber = faker.number().digits(10),
            day = String.valueOf(faker.number().numberBetween(10, 29)),
            month = monthArray[faker.number().numberBetween(0, 2)],
            year = String.valueOf(faker.number().numberBetween(1900, 2100)),
            subject = "Hindi",
            hobby = hobbiesArray[faker.number().numberBetween(0, 2)],
            path = "img/1.png",
            nameFile = "1.png",
            address = faker.address().fullAddress(),
            state = "NCR",
            city = "Noida";
}
