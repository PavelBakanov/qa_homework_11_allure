package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import steps.WebSteps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AllureTests extends TestBase {

    private final WebSteps steps = new WebSteps();

    @Test
    void allureSelenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("/qa-guru/qa_guru_14_10/issues");

        $("#repo-content-pjax-container").shouldHave(text("Issue for Autotest"));
    }

    @Test
    void allureSelenideWithLambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем сайт", ()
                -> {
            open("/qa-guru/qa_guru_14_10/issues");
        });


        step("Проверяем название Issue", ()
                -> {
            $("#repo-content-pjax-container").shouldHave(text("Issue for Autotest"));
        });
    }

    @Test
    void allureSelenideWithAnnotationStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        {
            steps.openPage();
            steps.CheckNameOfIssue();
        }


    }
}
