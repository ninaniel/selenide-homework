package ge.tbc.testautomation.tests;

import com.codeborne.selenide.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class TestNGPracticing {
    WebDriver driver;

    //class- Login and logout of the e-commerce application.
    @BeforeClass
    public void login() {
        open("https://www.saucedemo.com/");
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
    }

    @AfterClass
    public void logout() {
        $("#react-burger-menu-btn").click();
        $("a#logout_sidebar_link").click();
        closeWebDriver();
    }



    @Test(invocationCount = 5, successPercentage = 60)
    public void testFlakyDiscountCode() {
        boolean success = new Random().nextBoolean(); // randomly pass/fail
        System.out.println(success ? "PASS" : "FAIL");
        Assert.assertTrue(success);
    }

    @Test
    public void addToCartTest() {
        $("button.btn_inventory").click();
        $(".shopping_cart_link").click();

        $(".cart_item").shouldBe(Condition.visible);
    }

    @Test(dependsOnMethods = "addToCartTest")
    public void proceedToCheckoutTest() {
        $("#checkout").click();
        $("#first-name").setValue("Test");
        $("#last-name").setValue("User");
        $("#postal-code").setValue("12345");
        $("#continue").click();

        $(".summary_info").shouldBe(Condition.visible);
    }

    @Test(dependsOnMethods = "proceedToCheckoutTest")
    public void makePaymentTest() {
        $("#finish").click();
        $(".complete-header").shouldHave(Condition.text("THANK YOU FOR YOUR ORDER"));
        Assert.assertTrue($(".complete-header").isDisplayed());
    }


    @Test(priority = 2)
    public void validateImageSizes() {
        ElementsCollection images = $$("img.inventory_item_img");
        for (SelenideElement img : images) {
            int width = img.getSize().getWidth();
            int height = img.getSize().getHeight();

            Assert.assertEquals(width, 159);
            Assert.assertEquals(height, 238);
        }
    }

    @Test(priority = 1)
    public void sortOffers() {
        // low to high
        $("select.product_sort_container").selectOptionByValue("lohi");

        List<Double> prices = $$("div.inventory_item_price").texts().stream()
                .map(text -> Double.parseDouble(text.replace("$", "")))
                .toList();

        List<Double> sorted = prices.stream().sorted().toList();
        Assert.assertEquals(prices, sorted);
    }

    @Test(priority = 3)
    public void validateBurgerMenu() {
        $("#react-burger-menu-btn").click();

        $("div.bm-menu").shouldBe(Condition.visible);

        $("button#react-burger-cross-btn").click();
    }

    //suite - Initialize and close a dummy database connection (ვითომ).
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("connecting to dummy database..");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("closing dummy database connection..");
    }

    //test - Launch and close the browser (ვითომ).
    @BeforeClass
    @Parameters({"browserType"})
    public void setUp(String browserType){
        if (browserType.equals("chrome")){
            driver = new ChromeDriver();
            WebDriverRunner.setWebDriver(driver);
        } else if (browserType.equals("firefox")) {
            driver = new FirefoxDriver();
            WebDriverRunner.setWebDriver(driver);
        }
        Configuration.timeout = 10000;
    }

    @AfterTest
    public void afterTest() {
        closeWebDriver();
    }

    //method - Navigate to the home page before each test and return to the home page after each test.
    @BeforeMethod
    public void beforeMethod() {
        open("https://www.saucedemo.com/inventory.html");
    }

    @AfterMethod
    public void afterMethod() {
        open("https://www.saucedemo.com/inventory.html");
    }

}
