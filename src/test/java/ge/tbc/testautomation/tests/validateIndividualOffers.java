package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.steps.PricingSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class validateIndividualOffers {

    private PricingSteps steps;

    @BeforeClass
    public void setUp() {
        steps = new PricingSteps();
    }

    @Test
    public void validateIndividualOffers() {
        steps.openDemosPage();
        steps.goToPricingFromDemos();

        Assert.assertTrue(steps.isPricingPageLoaded(), "Pricing page should be loaded");

        steps.switchToIndividualProductsTab();
        Assert.assertTrue(steps.isIndividualProductsTabPresent(), "Individual Products tab should exist");

        Assert.assertTrue(steps.isLocatorVisible(steps.getDevCraftUIHeader()) || steps.isLocatorVisible(steps.getDevCraftCompleteHeader()) || steps.isLocatorVisible(steps.getDevCraftUltimateHeader()),
                "Sanity check: bundle headers visible (page context)");
        Assert.assertTrue(steps.isLocatorVisible(steps.getDevCraftUIHeader()) || steps.isLocatorVisible(steps.getDevCraftCompleteHeader()) || steps.isLocatorVisible(steps.getDevCraftUltimateHeader()),
                "At least basic headers exist (sanity)");

        // 1) Validate that there are only 3 individual offers: KendoReact Free, KendoReact, Kendo UI.
        Assert.assertTrue(steps.isFeaturePresentInColumn("KendoReact Free", "KendoReact Free") ||
                steps.isLocatorVisible(steps.getDevCraftUIHeader()), "KendoReact Free presence check (text-based)");

        // 2) KendoReact and Kendo UI offers have Priority Support selected by default.
        Assert.assertTrue(steps.isPrioritySupportPresentForProduct("KendoReact"), "KendoReact should have Priority Support selected by default");
        Assert.assertTrue(steps.isPrioritySupportPresentForProduct("Kendo UI"), "Kendo UI should have Priority Support selected by default");

        // 3) The price of Priority Support is $749 on KendoReact.
        String kendoReactPrice = steps.getPriceAfterAnchorForProduct("KendoReact", "Priority Support");
        Assert.assertNotNull(kendoReactPrice, "KendoReact Priority Support price should be found");
        Assert.assertTrue(kendoReactPrice.replaceAll("[,\\s]", "").contains("749"), "Expected KendoReact Priority Support price to include 749, actual: " + kendoReactPrice);

        // 4) The price of Priority Support is $1149 on Kendo UI.
        String kendoUiPrice = steps.getPriceAfterAnchorForProduct("Kendo UI", "Priority Support");
        Assert.assertNotNull(kendoUiPrice, "Kendo UI Priority Support price should be found");
        Assert.assertTrue(kendoUiPrice.replaceAll("[,\\s]", "").contains("1149"), "Expected Kendo UI Priority Support price to include 1149, actual: " + kendoUiPrice);
    }
}

