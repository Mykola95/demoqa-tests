package demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private String
            formTitleText = "Student Registration Form",
            formSubmittingText = "Thanks for submitting the form";

    private final SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailAddressInput = $("#userEmail"),
            genderRadioButton = $("#genterWrapper"),
            mobileNumberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbyCheckBox = $("#hobbiesWrapper"),
            pictureUploadFile = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateDropDown = $("#state"),
            stateAndCityElement = $("#stateCity-wrapper"),
            cityDropDown = $("#city"),
            submitButton = $("#submit"),
            titleSubmittingForm = $("#example-modal-sizes-title-lg"),
            resultsTable = $(".table-responsive");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(formTitleText));
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeEmail(String value) {
        emailAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage selectRadioButton(String value) {
        genderRadioButton.$(byText(value)).click();
        return this;
    }

    public RegistrationPage typeMobileNumber(String value) {
        mobileNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        CalendarComponent calendarComponent = new CalendarComponent();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage typeSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage selectCheckBox(String value) {
        hobbyCheckBox.$(byText(value)).click();
        return this;
    }

    public RegistrationPage selectPicture(String path) {
        pictureUploadFile.uploadFromClasspath(path);
        return this;
    }

    public RegistrationPage typeAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage selectState(String value) {
        stateDropDown.scrollTo().click();
        stateAndCityElement.$(byText(value)).click();
        return this;
    }

    public RegistrationPage selectCity(String value) {
        cityDropDown.click();
        stateAndCityElement.$(byText(value)).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkTitleSubmittingForm() {
        titleSubmittingForm.shouldHave(text(formSubmittingText));
        return this;
    }

    public RegistrationPage checkResultsValue(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}
