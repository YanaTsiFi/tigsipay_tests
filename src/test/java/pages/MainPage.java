package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public SelenideElement
            langSwitcherLatvian = $("div.LangSwitcher_switcher__hY2C4 a:nth-child(1)"),
            aboutLink = $("a[href='/about']"),
            mainHeader = $("div.MainPage_body__CUwS1 h1"),
            faqLink = $("div.MainPage_item1__zuMm_ a"),
            faqHeader = $("#for-shops > h2"),
            instagramIcon = $("div.ContactForm_networks___matO a:nth-child(1) img");

    @Step("Переключиться на латышский язык")
    public void switchToLatvian() {
        langSwitcherLatvian.click();
    }

    @Step("Перейти в FAQ")
    public void clickFAQ() {
        executeJavaScript("arguments[0].scrollIntoView({block: 'center'});", faqLink);
        executeJavaScript("arguments[0].click();", faqLink);
    }

    @Step("Перейти на страницу About")
    public void clickAbout() {
        aboutLink.click();
    }

    @Step("Клик по иконке Instagram")
    public void clickInstagramIcon() {
        executeJavaScript("arguments[0].click();", instagramIcon);
    }
}

