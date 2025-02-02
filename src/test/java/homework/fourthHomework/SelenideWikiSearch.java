package homework.fourthHomework;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SelenideWikiSearch {

    @BeforeAll
    public static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";

    }


    @Test
    public void selenideWikiSearchTest() {
        Selenide.open("/selenide/selenide");
        $("[data-content=Wiki]").click();
        $("[href='/selenide/selenide/wiki/SoftAssertions']").shouldHave(text("Soft assertions"));
        $("[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $(".markdown-body").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");

                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }"""));}


}
