package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static testdata.TestData.*;

public class TigsipayTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка латышского текста на главной")
    void shouldOpenAboutPageInLatvianTest() {
        mainPage.openPage()
                .switchToLatvian()
                .checkMainHeader(LATVIAN_MAIN_TEXT);
    }

    @Test
    @DisplayName("Переход к FAQ")
    void shouldOpenFAQPageTest() {
        mainPage.openPage()
                .clickFAQ()
                .checkFAQHeader(FAQ_TEXT);
    }

    @Test
    @DisplayName("Переход на About после смены языка")
    void shouldOpenAboutPageAfterLanguageChangeTest() {
        mainPage.openPage()
                .switchToLatvian()
                .clickAbout()
                .checkAboutHeader(LATVIAN_ABOUT_TEXT);
    }

    @Test
    @DisplayName("Переход на About на английском")
    void shouldOpenAboutPageDirectlyTest() {
        mainPage.openPage()
                .clickAbout()
                .checkAboutHeader(ENGLISH_ABOUT_TEXT);
    }

    @Test
    @DisplayName("Клик по Instagram")
    void shouldClickInstagramAndOpenLoginPageTest() {
        mainPage.openPage()
                .clickInstagramIcon()
                .checkInstagramLoginPageOpened();
    }
}
