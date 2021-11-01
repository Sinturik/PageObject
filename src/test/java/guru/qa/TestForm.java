package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestForm {

   @BeforeAll
    static void beforeAll () {
       Configuration.startMaximized = true;
   }


    @Test
    void testForm () {
        //открыть страницу с формой
        open ("https://demoqa.com/automation-practice-form");

        //заполнить поле "First Name"
        $("[id=firstName]").setValue("Kot");

        //заполнить поле "Last Name"
        $("[id=lastName]").setValue("Kotov");

        //заполнить поле "Email"
        $("[id=userEmail]").setValue("kot@gmail.com");

        //установить значение на радиобаттоне
        $(".custom-control-label").click();

        //заполнить поле "Mobile"
        $("[id=userNumber]").setValue("9235696703");

        //установить дату рождения в датапикере "Date of Birth"
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1989");
        $(".react-datepicker__day--018:not(.react-datepicker__day--outside-month)").click();

        //заполнить поле Subjects
        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Maths").pressEnter();

        //выбрать чекбоксы в разделе "Hobbies"
        $("[id=hobbiesWrapper]").$(byText("Reading")).click();
        $("[id=hobbiesWrapper]").$(byText("Music")).click();

        //загрузить картинку в разделе Picture
        $("[id=uploadPicture]").uploadFile(new File("src/test/resources/picture/1.png"));
        $("[id=uploadPicture]").uploadFromClasspath("picture/1.png");

        //заполнить поле Current Address
        $("[id=currentAddress]").setValue("Marksa").scrollTo();

        //выбрать State в разделе "State and City"
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();

        //выбрать City в разделе "State and City"
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();

        //кликнуть кнопку "Submit"
        $("[id=submit]").click();

        //проверка
        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));

     }


}
