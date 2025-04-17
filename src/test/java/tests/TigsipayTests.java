package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import helpers.Attach;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static testdata.TestData.*;

public class TigsipayTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка латышского текста на главной")
    void shouldOpenAboutPageInLatvian() {
        mainPage.switchToLatvian();
        mainPage.mainHeader.shouldHave(text(LATVIAN_MAIN_TEXT));
        Attach.screenshotAs("MainPageLatvian");
        Attach.pageSource();
        Attach.browserConsoleLogs();
    }

    @Test
    @DisplayName("Переход к FAQ")
    void shouldOpenFAQPage() {
        mainPage.clickFAQ();
        mainPage.faqHeader.shouldHave(text(FAQ_TEXT));
        Attach.screenshotAs("FAQPage");
        Attach.pageSource();
        Attach.browserConsoleLogs();
    }

    @Test
    @DisplayName("Переход на About после смены языка")
    void shouldOpenAboutPageAfterLanguageChange() {
        mainPage.switchToLatvian();
        mainPage.clickAbout();
        $("h1").shouldHave(text(LATVIAN_ABOUT_TEXT));
        Attach.screenshotAs("AboutPageAfterLanguageChange");
        Attach.pageSource();
        Attach.browserConsoleLogs();
    }

    @Test
    @DisplayName("Переход на About на английском")
    void shouldOpenAboutPageDirectly() {
        mainPage.clickAbout();
        $("h1").shouldHave(text(ENGLISH_ABOUT_TEXT));
        Attach.screenshotAs("AboutPageEnglish");
        Attach.pageSource();
        Attach.browserConsoleLogs();
    }

    @Test
    @DisplayName("Клик по Instagram")
    void shouldClickInstagramAndOpenLoginPage() {
        mainPage.clickInstagramIcon();
        switchTo().window(1);
        $("input[name='username']").shouldBe(visible);
        Attach.screenshotAs("InstagramLoginPage");
        Attach.pageSource();
        Attach.browserConsoleLogs();
    }
}
