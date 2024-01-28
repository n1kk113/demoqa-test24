import data.TestData;
import org.junit.jupiter.api.Test;
import pages.RegistrationPages;
import tests.TestBase;


public class TextBoxTests extends TestBase {
RegistrationPages registrationPage = new RegistrationPages();
TestData dataTest = new TestData();
    @Test
    void fillFormTest() {
       registrationPage.openPage()
               .removeBanners()
               .setFirstNameInput(dataTest.firstName)
               .setLastNameInput(dataTest.lastName)
               .setUserEmailInput(dataTest.userEmail)
               .setGenderWrapper(dataTest.gender)
               .setNumberInput(dataTest.number)
               .setCalendarInput(dataTest.year, dataTest.mouth, dataTest.day)
               .setSubjectInput(dataTest.subject)
               .setHobbies(dataTest.hobbies)
               .loadPicture()
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
               .checkResult("Date of Birth", dataTest.day + " " + dataTest.mouth + "," + dataTest.year)
               .checkResult("Subjects", dataTest.subject)
               .checkResult("Hobbies", dataTest.hobbies)
               .checkResult("Picture", dataTest.uploadPicture)
               .checkResult("Address", dataTest.streetAddress)
               .checkResult("State and City", dataTest.state)
               .checkResult("State and City", dataTest.city);
    }
    @Test
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
    void  incorrectFormTest () {
    registrationPage.openPage()
            .removeBanners()
            .clickSubmit()
            .checkBorderColors(dataTest.borderColor, dataTest.color);
    }
}


