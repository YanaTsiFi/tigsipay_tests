package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;

public class MainPageLatvian {

    private final SelenideElement mainHeader = $("div.MainPage_body__CUwS1 h1");
    private final SelenideElement aboutLink = $("a[href='/about']");

    public void checkMainHeader(String expectedText) {
        mainHeader.shouldHave(text(expectedText));
    }

    public AboutPage clickAbout() {
        aboutLink.click();
        return new AboutPage();
    }
}
