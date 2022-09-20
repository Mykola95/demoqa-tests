package demoqa.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static demoqa.testdata.TestData.*;

public class StudentRegistrationFormTests extends TestBase {

    @Test
    @Tag("demoqa")
    void fillFormTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(emailAddress)
                .selectRadioButton(gender)
                .typeMobileNumber(mobileNumber)
                .setBirthDate(day, month, year)
                .typeSubject(subject)
                .selectCheckBox(hobby)
                .selectPicture(path)
                .typeAddress(address)
                .selectState(state)
                .selectCity(city)
                .clickSubmit();

        registrationPage.checkTitleSubmittingForm()
                .checkResultsValue("Label", "Label")
                .checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", emailAddress)
                .checkResultsValue("Gender", gender)
                .checkResultsValue("Mobile", mobileNumber)
                .checkResultsValue("Date of Birth", day + " " + month + "," + year)
                .checkResultsValue("Subjects", subject)
                .checkResultsValue("Hobbies", hobby)
                .checkResultsValue("Picture", nameFile)
                .checkResultsValue("Address", address)
                .checkResultsValue("State and City", state + " " + city);
    }

    @Test
    @Tag("google")
    void open(){
        Selenide.open("https://www.youtube.com");
    }

    @Test
    void open1(){
        Selenide.open("https://www.youtube.com");
    }
}
