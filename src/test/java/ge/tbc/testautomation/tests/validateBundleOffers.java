package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.steps.PricingSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

public class validateBundleOffers {
    private PricingSteps steps;

    @BeforeClass
    public void setUp() {
        steps = new PricingSteps();
    }

    @Test
    public void validateBundleOffers() {

        steps.openDemosPage();
        steps.goToPricingFromDemos();

        Assert.assertTrue(steps.isPricingPageLoaded(), "Pricing page should be loaded after clicking Pricing link");


        // 1) 'Mocking solution for rapid unit testing' feature is not included in DevCraft UI.
        Assert.assertFalse(steps.isFeaturePresentInColumn("DevCraft UI", "Mocking solution for rapid unit testing"));

        // 2) 'Issue escalation' is supported only in DevCraft Ultimate.
        Assert.assertTrue(steps.isFeaturePresentInColumn("DevCraft Ultimate", "Issue escalation"));
        Assert.assertFalse(steps.isFeaturePresentInColumn("DevCraft UI", "Issue escalation"));
        Assert.assertFalse(steps.isFeaturePresentInColumn("DevCraft Complete", "Issue escalation"));

        // 3) 'End-to-end report management solution' is supported only in DevCraft Ultimate.
        Assert.assertTrue(steps.isFeaturePresentInColumn("DevCraft Ultimate", "End-to-end report management solution"));
        Assert.assertFalse(steps.isFeaturePresentInColumn("DevCraft UI", "End-to-end report management solution"));
        Assert.assertFalse(steps.isFeaturePresentInColumn("DevCraft Complete", "End-to-end report management solution"));

        // 4) 'Telerik Test Studio Dev Edition' is supported only in DevCraft Ultimate.
        Assert.assertTrue(steps.isFeaturePresentInColumn("DevCraft Ultimate", "Test Studio Dev Edition") ||
                steps.isFeaturePresentInColumn("DevCraft Ultimate", "Test Studio"));

        // 5) 'Kendo UI for jQuery' is supported on all offers.
        Assert.assertTrue(steps.isLocatorVisible(steps.getKendoUiForJQueryLocator()));

        // 6) DevCraft Ultimate supports 1 instance of 'Telerik Report Server' with 15 users .
        boolean reportServerHasInstanceAndUsers = $x("//*[contains(normalize-space(), 'Telerik Report Server')]/ancestor::div[1]//*[contains(., '1 instance') and contains(., '15 users')]").exists();
        Assert.assertTrue(reportServerHasInstanceAndUsers, "Expected 'Telerik Report Server' text with '1 instance' and '15 users'.");

        // 7) 'Telerik Reporting' is supported by only DevCraft Complete and DevCraft Ultimate.
        Assert.assertTrue(steps.isFeaturePresentInColumn("DevCraft Complete", "Telerik Reporting") ||
                steps.isFeaturePresentInColumn("DevCraft Complete", "Reporting"));
        Assert.assertTrue(steps.isFeaturePresentInColumn("DevCraft Ultimate", "Telerik Reporting"));
        Assert.assertFalse(steps.isFeaturePresentInColumn("DevCraft UI", "Telerik Reporting"));

        // 8) 'Access to on-demand videos' is supported by all offers.
        Assert.assertTrue(steps.isLocatorVisible(steps.getAccessOnDemandVideosLocator()));


        steps.scrollToBottom();
        // headers should still be visible
        Assert.assertTrue(steps.isHeaderVisible(steps.getDevCraftUIHeader()), "DevCraft UI header should remain visible after scrolling");
        Assert.assertTrue(steps.isHeaderVisible(steps.getDevCraftCompleteHeader()), "DevCraft Complete header should remain visible after scrolling");
        Assert.assertTrue(steps.isHeaderVisible(steps.getDevCraftUltimateHeader()), "DevCraft Ultimate header should remain visible after scrolling");

        String pos = steps.getHeaderCssPosition(steps.getDevCraftUIHeader());
        Assert.assertTrue("sticky".equals(pos) || "fixed".equals(pos), "Expected header position to be 'sticky' or 'fixed', actual: " + pos);
    }
}

