package demoqa.tests;

import org.junit.jupiter.api.Test;

import static demoqa.testdata.TestData.*;

public class StudentRegistrationFormTests extends TestBase {

    @Test
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
}
