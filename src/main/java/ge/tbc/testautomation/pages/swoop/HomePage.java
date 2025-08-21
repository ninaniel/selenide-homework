package ge.tbc.testautomation.pages.swoop;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    public SelenideElement exitSummerAlertButton = $x("//img[@alt='summer']//following-sibling::button");
    public SelenideElement SportsIcon = $("img[alt='სპორტი ']");
}
