package ge.tbc.testautomation.pages.TBC;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BlogPage {
    public ElementsCollection blogCards = $$(" app-marketing-list tbcx-pw-image-card");
    public ElementsCollection freshCards = $$("app-marketing-list tbcx-pw-image-card");
    public SelenideElement dateText = $("app-textpage-header app-textpage-additional");


}
