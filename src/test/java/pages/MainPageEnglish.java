package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MainPageEnglish {

    private final SelenideElement
            langSwitcherLatvian = $("div.LangSwitcher_switcher__hY2C4 a:nth-child(1)"),
            aboutLink = $("a[href='/about']"),
            faqLink = $("div.MainPage_item1__zuMm_ a"),
            instagramIcon = $("div.ContactForm_networks___matO a:nth-child(1) img");

    @Step("Открыть главную страницу")
    public MainPageEnglish openPage() {
        open("/");
        return this;
    }

    @Step("Переключиться на латышский язык")
    public MainPageLatvian switchToLatvian() {
        langSwitcherLatvian.click();
        return new MainPageLatvian();
    }

    @Step("Переход на страницу About")
    public AboutPage clickAbout() {
        aboutLink.click();
        return new AboutPage();
    }

    @Step("Переход к блоку FAQ")
    public FaqPage clickFAQ() {
        executeJavaScript("arguments[0].scrollIntoView({block: 'center'});", faqLink);
        executeJavaScript("arguments[0].click();", faqLink);
        return new FaqPage();
    }

    @Step("Клик по иконке Instagram")
    public InstagramPage clickInstagramIcon() {
        executeJavaScript("arguments[0].click();", instagramIcon);
        return new InstagramPage();
    }
}