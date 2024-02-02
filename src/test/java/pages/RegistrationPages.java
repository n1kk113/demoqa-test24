package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResults;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPages {
    CalendarComponent calendarComponent = new CalendarComponent();
    TableResults tableResults = new TableResults();
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement numberInput = $("#userNumber");
    private final SelenideElement calendarInput = $("#dateOfBirthInput");
    private final SelenideElement subjectInput = $("#subjectsInput");
    private final SelenideElement checkboxHobbies = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement selectState = $("#react-select-3-input");
    private final SelenideElement selectCity = $("#react-select-4-input");
    private final SelenideElement buttonSendForm = $("#submit");
    private final SelenideElement modalTitle = $("#example-modal-sizes-title-lg");


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

    public RegistrationPages setCalendarInput(String year, String month, int day) {
        calendarInput.click();
        calendarComponent.setDate(year, month, day);
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

    public RegistrationPages loadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
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



