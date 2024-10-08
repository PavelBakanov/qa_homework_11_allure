package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "800x600";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
    }

    @AfterEach
    protected void tearDown() {
        Selenide.closeWebDriver();
    }
}
