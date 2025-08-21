package ge.tbc.testautomation.data;

import org.testng.annotations.DataProvider;

public class DataSupplier {
    @DataProvider(name = "sportsOfferIndexes")
    public static Object[][] sportsOfferIndexes(){
        return new Object[][] {
                {0}, {1}, {2}, {3}, {4},
                {5}, {6}, {7}, {8}, {9}
        };
    }
}
