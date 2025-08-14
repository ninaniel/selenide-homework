package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.pages.SearchResultsPage;

import static com.codeborne.selenide.Condition.text;

public class SearchResultsSteps {
    SearchResultsPage searchResultsPage = new SearchResultsPage();

    public SearchResultsSteps searchFor(String text) {
        searchResultsPage.searchInput.setValue(text).pressEnter();
        return this;
    }

    public void verifyAllResultsContain(String expectedText) {
        searchResultsPage.searchResults.forEach(
                e -> e.shouldHave(text(expectedText))
        );
    }
}
