package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.pages.CustomPage;
import static com.codeborne.selenide.Selenide.open;

public class CustomStep {
    public void openPageByUrl(String url) {
        open(url);
    }

    public void openDemosPage(CustomPage customPage) {
        open(customPage.getUrl());
    }
}
