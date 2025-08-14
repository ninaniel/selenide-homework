package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.pages.CustomPage;
import ge.tbc.testautomation.pages.PricingPage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PricingSteps extends CustomStep {

    private final CustomPage customPage = new CustomPage();
    private final PricingPage pricingPage = new PricingPage();

    // navigation actions (steps)

    /** Open the demos page (base) */
    public void openDemosPage() {
        openDemosPage(customPage); // from CustomStep
    }

    /** Click Pricing link on demos -> navigate to pricing page (no assertions here) */
    public void goToPricingFromDemos() {
        customPage.pricingLink.click();
    }


//    public void openPricingDirectly() {
//        open(pricingPage.pricingUrl);
//    }

    /** Click the Individual Products tab (if present) */
    public void switchToIndividualProductsTab() {
        pricingPage.individualProductsTab.click();
    }


    public boolean isPricingPageLoaded() {
        return pricingPage.productBundlesTab.exists();
    }

    public boolean isIndividualProductsTabPresent() {
        return pricingPage.individualProductsTab.exists();
    }

    // feature text within the column that contains columnHeader txt
    public boolean isFeaturePresentInColumn(String columnHeader, String featureText) {
        String xpath = format("//*[contains(normalize-space(), '%s')]/ancestor::div[1]//*[contains(normalize-space(), '%s')]", columnHeader, featureText);
        return $x(xpath).exists();
    }

    // PricingPage locator's visibility
    public boolean isLocatorVisible(SelenideElement locator) {
        return locator.exists() && locator.isDisplayed();
    }

    public void scrollToBottom() {
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public String getHeaderCssPosition(SelenideElement header) {
        return header.exists() ? header.getCssValue("position") : "";
    }

    //after scroll
    public boolean isHeaderVisible(SelenideElement header) {
        return header.exists() && header.isDisplayed();
    }

    public String getPriceAfterAnchorForProduct(String productName, String anchorText) {
        String body = $("body").getText();
        int start = body.indexOf(productName);
        if (start < 0) return null;
        int anchorIndex = body.indexOf(anchorText, start);
        if (anchorIndex < 0) {
            anchorIndex = body.indexOf(anchorText);
            if (anchorIndex < 0) return null;
        }
        String fragment = body.substring(anchorIndex, Math.min(body.length(), anchorIndex + 300));
        Pattern p = Pattern.compile("\\$?\\s?(\\d{1,3}(?:[\\,\\s]\\d{3})*)");
        Matcher m = p.matcher(fragment);
        if (m.find()) return m.group(1).trim();
        return null;
    }

    public boolean isPrioritySupportPresentForProduct(String productName) {
        String xpath = format("//*[contains(normalize-space(), '%s')]/ancestor::div[1]//*[contains(normalize-space(),'Priority Support')]", productName);
        return $x(xpath).exists();
    }


    // getters
    public SelenideElement getDevCraftUIHeader() { return pricingPage.devCraftUIHeader; }
    public SelenideElement getDevCraftCompleteHeader() { return pricingPage.devCraftCompleteHeader; }
    public SelenideElement getDevCraftUltimateHeader() { return pricingPage.devCraftUltimateHeader; }
    public SelenideElement getKendoUiForJQueryLocator() { return pricingPage.kendoUiForJQuery; }
    public SelenideElement getAccessOnDemandVideosLocator() { return pricingPage.accessOnDemandVideos; }
    public SelenideElement getTelerikReportServerLocator() { return pricingPage.telerikReportServer; }
    public SelenideElement getTelerikReportingLocator() { return pricingPage.telerikReporting; }
    public SelenideElement getMockingFeatureLocator() { return pricingPage.mockingFeature; }
}
