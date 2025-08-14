package ge.tbc.testautomation.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbc.testautomation.steps.SearchResultsSteps;
import ge.tbc.testautomation.steps.TelerikHomeSteps;
import ge.tbc.testautomation.data.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TelerikSearchTest {
    WebDriver driver;
    TelerikHomeSteps telerikHomeSteps;
    SearchResultsSteps searchResultsSteps;

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        telerikHomeSteps = new TelerikHomeSteps();
        searchResultsSteps = new SearchResultsSteps();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);

    }

    @Test(description="ძებნის ფუნქციონალის შემოწმება Telerik-ის მთავარ გვერდზე [SCRUM-T28]")
    public void searchForKendoUI() {
        telerikHomeSteps
                .openHomePage(Constants.BASE_TELERIK_URL)
                .clickSearchIcon();

        searchResultsSteps
                .searchFor(Constants.SEARCH_INPUT)
                .verifyAllResultsContain(Constants.SEARCH_INPUT);
    }

}
