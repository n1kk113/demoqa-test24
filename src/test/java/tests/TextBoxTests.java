package tests;

import data.TestData;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.components.RegistrationPages;


public class TextBoxTests extends TestBase {
RegistrationPages registrationPage = new RegistrationPages();
TestData dataTest = new TestData();
    @Test
    @Owner("Denis Nikitin | tg: nikk113")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Заполнение всех полей формы авторизации")
    void fillFormTest() {
       registrationPage.openPage()
               .removeBanners()
               .setFirstNameInput(dataTest.firstName)
               .setLastNameInput(dataTest.lastName)
               .setUserEmailInput(dataTest.userEmail)
               .setGenderWrapper(dataTest.gender)
               .setNumberInput(dataTest.number)
               .setCalendarInput(dataTest.year, dataTest.month, dataTest.day)
               .setSubjectInput(dataTest.subject)
               .setHobbies(dataTest.hobbies)
               .loadPicture(dataTest.uploadPicture)
               .setCurrentAddress(dataTest.streetAddress)
               .setState(dataTest.state)
               .setSity(dataTest.city)
               .clickSubmit()
               .checkTitle(dataTest.title);
       registrationPage.checkResult("Student Name", dataTest.firstName)
               .checkResult("Student Name", dataTest.lastName)
               .checkResult("Student Email", dataTest.userEmail)
               .checkResult("Gender", dataTest.gender)
               .checkResult("Mobile", dataTest.number)
               .checkResult("Date of Birth", dataTest.day + " " + dataTest.month + "," + dataTest.year)
               .checkResult("Subjects", dataTest.subject)
               .checkResult("Hobbies", dataTest.hobbies)
               .checkResult("Picture", dataTest.uploadPicture)
               .checkResult("Address", dataTest.streetAddress)
               .checkResult("State and City", dataTest.state)
               .checkResult("State and City", dataTest.city);
    }
    @Test
    @Owner("Denis Nikitin | tg: nikk113")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Минимальное заполнениие формы авторизации и проверка валидности выводимых данных")
    void minimalFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstNameInput(dataTest.firstName)
                .setLastNameInput(dataTest.lastName)
                .setUserEmailInput(dataTest.userEmail)
                .setGenderWrapper(dataTest.gender)
                .setNumberInput(dataTest.number)
                .clickSubmit();
        registrationPage.checkResult("Student Name", dataTest.firstName)
                .checkResult("Student Name", dataTest.lastName)
                .checkResult("Student Email", dataTest.userEmail)
                .checkResult("Gender", dataTest.gender)
                .checkResult("Mobile", dataTest.number);
    }
    @Test
    @Owner("Denis Nikitin | tg: nikk113")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Отправка невалидных данных на сервер через UI, проверка осуществления валидации на заполнение")
    void  incorrectFormTest () {
    registrationPage.openPage()
            .removeBanners()
            .clickSubmit()
            .checkBorderColors(dataTest.borderColor, dataTest.color);
    }
}


