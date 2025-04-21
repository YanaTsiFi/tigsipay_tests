package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FaqPage {
    public void checkFAQHeader(String expectedText) {
        $("#for-shops > h2").shouldHave(text(expectedText));
    }
}