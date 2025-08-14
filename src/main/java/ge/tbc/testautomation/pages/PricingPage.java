package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class PricingPage extends CustomPage {

    //public String pricingUrl = "https://www.telerik.com/purchase.aspx";

    // sections / headers
    public SelenideElement productBundlesTab = $x("//*[contains(normalize-space(),'Product Bundles')]");
    public SelenideElement individualProductsTab = $x("//*[contains(normalize-space(),'Individual Products')]");

    // bundle offer headers
    public SelenideElement devCraftUIHeader = $x("//*[contains(normalize-space(),'DevCraft UI')]");
    public SelenideElement devCraftCompleteHeader = $x("//*[contains(normalize-space(),'DevCraft Complete')]");
    public SelenideElement devCraftUltimateHeader = $x("//*[contains(normalize-space(),'DevCraft Ultimate')]");

    // feature locators (text-based)
    public SelenideElement mockingFeature = $x("//*[contains(normalize-space(),'Mocking solution for rapid unit testing')]");
    public SelenideElement issueEscalationFeature = $x("//*[contains(normalize-space(),'Issue escalation')]");
    public SelenideElement endToEndReportFeature = $x("//*[contains(normalize-space(),'End-to-end report management solution')]");
    public SelenideElement testStudioDevEdition = $x("//*[contains(normalize-space(),'Test Studio Dev Edition') or contains(normalize-space(),'Telerik Test Studio Dev Edition')]");
    public SelenideElement kendoUiForJQuery = $x("//*[contains(normalize-space(),'Kendo UI for jQuery')]");
    public SelenideElement telerikReportServer = $x("//*[contains(normalize-space(),'Telerik Report Server')]");
    public SelenideElement telerikReporting = $x("//*[contains(normalize-space(),'Telerik Reporting')]");
    public SelenideElement accessOnDemandVideos = $x("//*[contains(normalize-space(),'Access to on-demand videos')]");

    // individual product headers
    public SelenideElement kendoReactFree = $x("//*[contains(normalize-space(),'KendoReact Free')]");
    public SelenideElement kendoReact = $x("//*[contains(normalize-space(),'KendoReact') and not(contains(normalize-space(),'KendoReact Free'))]");
    public SelenideElement kendoUi = $x("//*[contains(normalize-space(),'Kendo UI') and not(contains(normalize-space(),'Kendo UI for jQuery'))]");
}
