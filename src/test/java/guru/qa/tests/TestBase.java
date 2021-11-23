package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.RegistrationForm;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    RegistrationForm registrationForm = new RegistrationForm();

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }
}
