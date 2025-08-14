package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TelerikHomePage {
    public SelenideElement searchButton = $x("//ul[@class='TK-Aside-Menu']/li/a[@title='Search']");

}
