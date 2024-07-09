package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

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

    @Step("Открыть страницу")
    public RegistrationPages openPage() {
        open("/automation-practice-form");
        return this;
    }
    @Step("Удалить баннер и футер")
    public RegistrationPages removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    @Step("Вставить имя пользователя в инпут")
    public RegistrationPages setFirstNameInput(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    @Step("Вставить фамилию пользователя в инпут")
    public RegistrationPages setLastNameInput(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    @Step("Вставить Email пользователя в инпут")
    public RegistrationPages setUserEmailInput(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    @Step("Выбрать гендер пользователя")
    public RegistrationPages setGenderWrapper(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    @Step("Вставить номер пользователя в инпут")
    public RegistrationPages setNumberInput(String value) {
        numberInput.setValue(value);
        return this;
    }
    @Step("Вставить дату календаря")
    public RegistrationPages setCalendarInput(String year, String month, int day) {
        calendarInput.click();
        calendarComponent.setDate(year, month, day);
        return this;
    }
    @Step("Вставить субъект")
    public RegistrationPages setSubjectInput(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }
    @Step("Вставить хобби")
    public RegistrationPages setHobbies(String value) {
        checkboxHobbies.$(byText(value)).click();
        return this;
    }
    @Step("Загрузить картинку")
    public RegistrationPages loadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }
    @Step("Ввести адрес")
    public RegistrationPages setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    @Step("Выбрать город")
    public RegistrationPages setSity(String value) {
        selectCity.setValue(value).pressEnter();
        return this;
    }
    @Step("Выбрать штат")
    public RegistrationPages setState(String value) {
        selectState.setValue(value).pressEnter();
        return this;
    }
    @Step("Нажать кнопку Submit")
    public RegistrationPages clickSubmit() {
        buttonSendForm.click();
        return this;
    }
    @Step("Проверить титлы {value}")
    public RegistrationPages checkTitle(String value) {
        modalTitle.shouldHave(text(value));
        return this;
    }
    @Step("Проверить результаты")
    public RegistrationPages checkResult(String key, String value) {
        tableResults.tableResults(key, value);
        return this;
    }
    @Step("Проверить обводку полей при валидации")
    public void checkBorderColors(String key, String value) {
        firstNameInput.shouldHave(cssValue(key, value));
        lastNameInput.shouldHave(cssValue(key, value));
    }
}



