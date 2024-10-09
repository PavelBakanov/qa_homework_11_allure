package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.WebSteps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Owner("PavelBakanov")
@Feature("Название Issue в репозитории")
@DisplayName("Тесты на поиск определенной Issue в репозитории")
public class AllureTests extends TestBase {

    private final WebSteps steps = new WebSteps();


    @Story("Поиск названия Issue с помощью только команд Selenide")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Test_page", url = "https://github.com/qa-guru/qa_guru_14_10/issues")
    @DisplayName("Поиск названия Issue с помощью только команд Selenide")
    @Test
    void allureSelenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("/qa-guru/qa_guru_14_10/issues");

        $("#repo-content-pjax-container").shouldHave(text("Issue for Autotest"));
    }

    @Story("Поиск названия Issue с помощью метода с лямбда-выражением из библиотеки Allure")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Test_page", url = "https://github.com/qa-guru/qa_guru_14_10/issues")
    @DisplayName("Поиск названия Issue с помощью метода с лямбда-выражением из библиотеки Allure")
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

    @Story("Поиск названия Issue с помощью аннотации @Step в отдельном классе")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Test_page", url = "https://github.com/qa-guru/qa_guru_14_10/issues")
    @DisplayName("Поиск названия Issue с помощью аннотации @Step в отдельном классе")
    @Test
    void allureSelenideWithAnnotationStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        {
            steps.openPage();
            steps.checkNameOfIssue();
        }


    }
}
