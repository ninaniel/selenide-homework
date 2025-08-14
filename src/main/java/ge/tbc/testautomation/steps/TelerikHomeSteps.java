package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.pages.TelerikHomePage;

import static com.codeborne.selenide.Selenide.open;

public class TelerikHomeSteps {
    TelerikHomePage homePage = new TelerikHomePage();

    public TelerikHomeSteps openHomePage(String url) {
        open(url);
        return this;
    }

    public TelerikHomeSteps clickSearchIcon() {
        homePage.searchButton.click();
        return this;
    }
}
