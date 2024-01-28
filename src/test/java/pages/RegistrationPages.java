package pages;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import components.TableResults;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPages {
    CalendarComponent calendarComponent = new CalendarComponent();
    TableResults tableResults = new TableResults();
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            checkboxHobbies = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            selectState = $("#react-select-3-input"),
            selectCity = $("#react-select-4-input"),
            buttonSendForm = $("#submit"),
            modalTitle = $("#example-modal-sizes-title-lg");


    public RegistrationPages openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPages removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPages setFirstNameInput(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPages setLastNameInput(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPages setUserEmailInput(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPages setGenderWrapper(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPages setNumberInput(String value) {
        numberInput.setValue(value);
        return this;
    }

    public RegistrationPages setCalendarInput(String year, String mouth, String day) {
        calendarInput.click();
        calendarComponent.setDate(year, mouth, day);
        return this;
    }

    public RegistrationPages setSubjectInput(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPages setHobbies(String value) {
        checkboxHobbies.$(byText(value)).click();
        return this;
    }

    public RegistrationPages loadPicture() {
        uploadPicture.uploadFromClasspath("ScreenCat.png");
        return this;
    }

    public RegistrationPages setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPages setSity(String value) {
        selectCity.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPages setState(String value) {
        selectState.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPages clickSubmit() {
        buttonSendForm.click();
        return this;
    }

    public RegistrationPages checkTitle(String value) {
        modalTitle.shouldHave(text(value));
        return this;
    }

    public RegistrationPages checkResult(String key, String value) {
        tableResults.tableResults(key, value);
        return this;
    }

    public void checkBorderColors(String key, String value) {
        firstNameInput.shouldHave(cssValue(key, value));
        lastNameInput.shouldHave(cssValue(key, value));
    }
}



