package ge.tbc.testautomation.tests.swoop;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.data.DataSupplier;
import ge.tbc.testautomation.pages.swoop.SportsPage;
import ge.tbc.testautomation.steps.swoop.HomePageSteps;
import ge.tbc.testautomation.steps.swoop.SportsPageSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class ParametrizedSwoopTests {
    WebDriver driver;
    HomePageSteps homePageSteps;
    SportsPageSteps sportsPageSteps;
    SportsPage sportsPage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
//        Configuration.timeout = 10000;
//        Configuration.browser = "chrome";

        homePageSteps = new HomePageSteps();
        sportsPageSteps = new SportsPageSteps();
        sportsPage = new SportsPage();

        open(Constants.SWOOP_BASE_URL);
        homePageSteps.exitSummerAlert();
        Configuration.holdBrowserOpen = true;
    }

    @Test(dataProviderClass = DataSupplier.class, dataProvider = "sportsOfferIndexes")
    public void checkSaleValuesTest(int index) {
        homePageSteps.navigateToSports();

        SelenideElement offer = sportsPage.sportsOffers.get(index);
        System.out.println(offer);
        System.out.println(sportsPage.actualPrice(offer).getText());
        System.out.println(sportsPage.oldPrice(offer).getText());


    }


}
