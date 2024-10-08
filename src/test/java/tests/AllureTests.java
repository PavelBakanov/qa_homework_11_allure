package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AllureTests extends TestBase {


    @Test
    void allureSelenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("/qa-guru/qa_guru_14_10/issues");

        $("#repo-content-pjax-container").shouldHave(text("Issue for Autotest"));



    }
}
