package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {
    public SelenideElement searchInput = $("input[placeholder='search']");
    public ElementsCollection searchResults = $$("div.TK-Search-Results-List-Wrapper li h4 a");
}
