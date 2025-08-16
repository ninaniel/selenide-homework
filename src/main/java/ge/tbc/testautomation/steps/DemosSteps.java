package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.pages.DemosPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import java.util.List;
import java.util.stream.Collectors;

public class DemosSteps {
    DemosPage demosPage = new DemosPage();

    public DemosSteps openDemosPage(String url) {
        open(url);
        return this;
    }

    public DemosSteps validateWebCardsPurpleOverlay() {
        demosPage.webDemoCards.forEach(card -> {
            card.hover(); // simulate hover
            card.shouldHave(cssValue("background-color", "rgba(40, 46, 137, 0.75)"));
        });
        //card.shouldHave(cssValue("background-color")).contains("rgba(40, 46, 137");
        return this;
    }

    // 2) contains Vue Demos
    public DemosSteps validateKendoUIListContains(String expected) {
    demosPage.webDemoCards.stream()
                .flatMap(card -> card.$$x(".//li").stream())
                .anyMatch(li -> li.getText().contains(expected));

        return this;
    }

    // 3) desktop items for MS
    public List<String> filterDesktopMicrosoftStore() {
        return demosPage.desktopItems.stream()
                .filter(e -> e.getText().contains("Microsoft Store"))
                .map(e -> e.getText())
                .collect(Collectors.toList());
    }

    // 4) mobile section availability
    public DemosSteps validateMobileAvailability(String product, String... stores) {
        for (String store : stores) {
            demosPage.mobileItems.findBy(text(product)).shouldHave(text(store));
        }
        return this;
    }

    // 5) section links remain fixed on scroll
    public DemosSteps validateSectionLinksFixed() {
        demosPage.sectionNav.shouldHave(cssValue("position", "fixed"));
        $("footer").scrollIntoView(true);
        demosPage.sectionNav.shouldHave(cssValue("position", "fixed"));
        return this;
    }

    // 6) section links highlight on scroll
    public DemosSteps validateSectionLinksActiveOnScroll() {
        // pseudo-logic: scroll into Web section and check link active
        demosPage.webSection.scrollTo();
        demosPage.sectionLinks.findBy(text("Web")).shouldHave(cssClass("active"));

        demosPage.desktopSection.scrollTo();
        demosPage.sectionLinks.findBy(text("Desktop")).shouldHave(cssClass("active"));

        demosPage.mobileSection.scrollTo();
        demosPage.sectionLinks.findBy(text("Mobile")).shouldHave(cssClass("active"));

        return this;
    }
    //https://github.com/ninaniel/selenide-homework/pulls

    // 7) Validate links navigate to correct sections
    public DemosSteps validateSectionLinksNavigation() {
        demosPage.sectionLinks.forEach(link -> {
            String href = link.getAttribute("href");
            link.click();
            $(href).shouldBe(visible);
        });
        return this;
    }
}
