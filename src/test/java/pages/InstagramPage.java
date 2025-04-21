package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class InstagramPage {
    public void checkInstagramLoginPageOpened() {
        switchTo().window(1);
        $("input[name='username']").shouldBe(visible);
    }
}