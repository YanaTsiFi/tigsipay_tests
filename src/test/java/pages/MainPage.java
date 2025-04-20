package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement
            langSwitcherLatvian = $("div.LangSwitcher_switcher__hY2C4 a:nth-child(1)"),
            aboutLink = $("a[href='/about']"),
            mainHeader = $("div.MainPage_body__CUwS1 h1"),
            faqLink = $("div.MainPage_item1__zuMm_ a"),
            faqHeader = $("#for-shops > h2"),
            instagramIcon = $("div.ContactForm_networks___matO a:nth-child(1) img");

    @Step("Открыть главную страницу")
    public MainPage openPage() {
        open("/");
        return this;
    }

    @Step("Переключиться на латышский язык")
    public MainPage switchToLatvian() {
        langSwitcherLatvian.click();
        return this;
    }

    @Step("Проверить заголовок главной страницы")
    public void checkMainHeader(String expectedText) {
        mainHeader.shouldHave(text(expectedText));
    }

    @Step("Перейти на страницу About")
    public MainPage clickAbout() {
        aboutLink.click();
        return this;
    }

    @Step("Проверить заголовок страницы About")
    public void checkAboutHeader(String expectedText) {
        $("h1").shouldHave(text(expectedText));
    }

    @Step("Перейти в FAQ")
    public MainPage clickFAQ() {
        executeJavaScript("arguments[0].scrollIntoView({block: 'center'});", faqLink);
        executeJavaScript("arguments[0].click();", faqLink);
        return this;
    }

    @Step("Проверить заголовок FAQ")
    public void checkFAQHeader(String expectedText) {
        faqHeader.shouldHave(text(expectedText));
    }

    @Step("Клик по иконке Instagram")
    public MainPage clickInstagramIcon() {
        executeJavaScript("arguments[0].click();", instagramIcon);
        return this;
    }

    @Step("Проверка открытия страницы Instagram")
    public void checkInstagramLoginPageOpened() {
        switchTo().window(1);
        $("input[name='username']").shouldBe(visible);
    }
}