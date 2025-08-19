package ge.tbc.testautomation.steps.swoop;

import ge.tbc.testautomation.pages.swoop.HomePage;

public class HomePageSteps {
    HomePage homePage = new HomePage();
    public HomePageSteps exitSummerAlert(){
        homePage.exitSummerAlertButton.click();
        return this;
    }

    public HomePageSteps navigateToSports(){
        homePage.SportsIcon.click();
        return this;
    }
}
