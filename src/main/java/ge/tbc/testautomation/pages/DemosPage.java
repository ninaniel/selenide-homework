package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class DemosPage {
    public SelenideElement webSection = $("section#Web");
    public SelenideElement desktopSection = $("section#Desktop");
    public SelenideElement mobileSection = $("section#Mobile");

    public SelenideElement sectionNav = $x("//nav[contains(@class, 'is-fixed')]");
    public ElementsCollection sectionLinks = sectionNav.$$x(".//a");

    public ElementsCollection webDemoCards =
            $$x("//div[contains(@id,'ContentPlaceholder1_C329')]/div[@class='HoverImg u-mb1']");

    public ElementsCollection kendoUiList =
            $$x("//div[contains(@id,'ContentPlaceholder1_C329')]//li");

    public ElementsCollection desktopItems = $$("section#Desktop .demo-item");

    public ElementsCollection mobileItems = $$("section#Mobile .demo-item");
}
