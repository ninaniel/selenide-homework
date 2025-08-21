package ge.tbc.testautomation.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.steps.DemosSteps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class validateDemosDesign {
    WebDriver driver;
    DemosSteps demosSteps;

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;

        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
        demosSteps = new DemosSteps();
    }

    @Test
    public void validateDemosDesign() {

        demosSteps
                .openDemosPage(Constants.DEMOS_URL)
                .validateWebCardsPurpleOverlay()
                .validateKendoUIListContains(Constants.KENDO_UI_VUE_DEMOS)
                .validateMobileAvailability("Telerik UI for Xamarin", Constants.APPLE_STORE, Constants.GOOGLE_PLAY, Constants.MICROSOFT_STORE)
                .validateSectionLinksFixed()
                .validateSectionLinksActiveOnScroll()
                .validateSectionLinksNavigation();

        demosSteps.filterDesktopMicrosoftStore().forEach(System.out::println);
    }
}
