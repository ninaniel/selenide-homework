package ge.tbc.testautomation.pages.swoop;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.steps.swoop.SportsPageSteps;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class SportsPage {
    public ElementsCollection sportsOffers = $$x("//div[@class='flex flex-col col-span-9 gap-6 laptop:gap-5 tablet:pb-10']//div[@class='relative']");

    public SelenideElement actualPrice(SelenideElement offer) {
        return offer.find("h4[weight='bold']");
    }
//    public SelenideElement actualPrice = $("h4[weight='bold']");
    public SelenideElement oldPrice(SelenideElement offer) {
        return offer.find("h4[weight='regular']");
    }
//    public SelenideElement discountAmount = $(By.tagName("p")).shouldHave(partialText("-17%"));
}
