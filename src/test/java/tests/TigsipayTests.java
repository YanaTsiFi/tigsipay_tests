package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static testdata.TestData.*;

public class TigsipayTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка латышского текста на главной")
    void shouldOpenAboutPageInLatvianTest() {
        mainPage.switchToLatvian();
        mainPage.mainHeader.shouldHave(text(LATVIAN_MAIN_TEXT));
    }

    @Test
    @DisplayName("Переход к FAQ")
    void shouldOpenFAQPageTest() {
        mainPage.clickFAQ();
        mainPage.faqHeader.shouldHave(text(FAQ_TEXT));
    }

    @Test
    @DisplayName("Переход на About после смены языка")
    void shouldOpenAboutPageAfterLanguageChangeTest() {
        mainPage.switchToLatvian();
        mainPage.clickAbout();
        $("h1").shouldHave(text(LATVIAN_ABOUT_TEXT));
    }

    @Test
    @DisplayName("Переход на About на английском")
    void shouldOpenAboutPageDirectlyTest() {
        mainPage.clickAbout();
        $("h1").shouldHave(text(ENGLISH_ABOUT_TEXT));
    }

    @Test
    @DisplayName("Клик по Instagram")
    void shouldClickInstagramAndOpenLoginPageTest() {
        mainPage.clickInstagramIcon();
        switchTo().window(1);
        $("input[name='username']").shouldBe(visible);
    }
}
