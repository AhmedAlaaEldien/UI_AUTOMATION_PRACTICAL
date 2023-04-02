package data_provider;

import base.BaseTests;
import helpers.Constant;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import static utilities.JSonManager.readJson;

public class PlansDataProvider extends BaseTests {

    private final WebDriver driver;

    public PlansDataProvider(WebDriver driver) {
        this.driver = driver;
    }

    @DataProvider
    public static Object[][] dataProvider() {
        return readJson("testData", "data");
    }
}
