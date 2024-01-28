import org.junit.jupiter.api.Test;
import pages.RegistrationPages;
import tests.TestBase;


public class TextBoxTests extends TestBase {
RegistrationPages registrationPage = new RegistrationPages();
    @Test
    void fillFormTest() {
       registrationPage.openPage()
               .removeBanners()
               .setFirstNameInput("Denis")
               .setLastNameInput("Nikitin")
               .setUserEmailInput("test@mail.ru")
               .setGenderWrapper("Other")
               .setNumberInput("8927976494")
               .setCalendarInput("2001","March","21")
               .setSubjectInput("Maths")
               .setHobbies("Sports")
               .loadPicture()
               .setCurrentAddress("Mordovia")
               .setState("Haryana")
               .setSity("Karnal")
               .clickSubmit()
               .checkTitle("Thanks for submitting the form");
       registrationPage.checkResult("Student Name","Denis Nikitin")
               .checkResult("Student Email","test@mail.ru")
               .checkResult("Gender", "Other")
               .checkResult("Mobile","8927976494")
               .checkResult("Date of Birth", "21 March,2001")
               .checkResult("Subjects","Maths")
               .checkResult("Hobbies","Sports")
               .checkResult("Picture","ScreenCat.png")
               .checkResult("Address","Mordovia")
               .checkResult("State and City","Haryana Karnal");
    }
    @Test
    void minimalFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstNameInput("Denis")
                .setLastNameInput("Nikitin")
                .setUserEmailInput("test@mail.ru")
                .setGenderWrapper("Male")
                .setNumberInput("8927976494")
                .clickSubmit();
        registrationPage.checkResult("Student Name","Denis Nikitin")
                .checkResult("Student Email","test@mail.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile","8927976494");
    }
@Test
    void  incorrectForm () {
    registrationPage.openPage()
            .removeBanners()
            .clickSubmit()
            .checkBorderColors("border-color","rgb(220, 53, 69)");
    }
}


