package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;


public class CustomPage {
    protected String url = "https://www.telerik.com/support/demos";


    public SelenideElement pricingLink = $x("//li[@class='TK-Menu-Item']/a[normalize-space()='Pricing']");

    public String getUrl() {
        return url;
    }
}
