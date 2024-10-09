package steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем сайт")
    public void openPage() {
        open("/qa-guru/qa_guru_14_10/issues");
    }

    @Step("Проверяем название Issue")
    public void checkNameOfIssue() {
        $("#repo-content-pjax-container").shouldHave(text("Issue for Autotest"));
    }
}
