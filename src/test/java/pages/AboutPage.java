package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AboutPage {
    public void checkAboutHeader(String expectedText) {
        $("h1").shouldHave(text(expectedText));
    }
}