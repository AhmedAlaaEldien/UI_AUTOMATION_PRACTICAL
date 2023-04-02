package pages;

import helpers.GUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

/**
 * This class is used to implement Subscription Plans Page and all of its used elements and All possible actions on it.
 */
public class subscriptionPage {

    private final WebDriver driver;
    private final GUIActions guiActions;
    private final By countryCurrent = By.xpath("//div[@class='country-current']");
    private final By trialPlanCost = By.xpath("//div[@class='trial-cost']");

    private String costOfTrialPlan = "";
    private String costOfPlan = "";

    public subscriptionPage(WebDriver driver) {
        this.driver = driver;
        guiActions = new GUIActions(driver);
    }

    public subscriptionPage clickOnCountryCurrent() {
        guiActions.clickOn(countryCurrent);
        return this;
    }

    public subscriptionPage selectCountry(String country) {
        By selectedCountry = By.xpath("//span[contains(text(),' " + country + "')]");
        guiActions.clickOn(selectedCountry);
        System.out.println("Done, " + country + " Country Is Selected");
        return this;
    }

    public subscriptionPage trialCost() {
        costOfTrialPlan = guiActions.getTextFromElement(trialPlanCost);
        System.out.println("Trail Cost For The Selected Country Is: " + costOfTrialPlan);
        return this;
    }

    public String getCostOfTrialPlan() {
        return costOfTrialPlan;
    }

    public subscriptionPage planCost(String plan) {
        By planCost = By.xpath("//div[@id='currency-" + plan + "']");
        costOfPlan = guiActions.getTextFromElement(planCost);
        System.out.println("For " + plan + " Plan The Cost Is: " + costOfPlan);
        return this;
    }

    public String getCostOfPlan() {
        return costOfPlan;
    }

    public subscriptionPage validateTrialCost(String expectedTrialCost, String actualTrialCost) {

        guiActions.assertThat(String.format("Check that expected trial cost (%S) is obtained (%S)", expectedTrialCost, actualTrialCost),
                () -> assertEquals(expectedTrialCost, actualTrialCost));
        return this;
    }

    public subscriptionPage validateLitePlanCost(String expectedLitePlanCost, String actualLitePlanCost) {

        guiActions.assertThat(String.format("Check that expected Lite Plan Cost (%S) is obtained (%S)", expectedLitePlanCost, actualLitePlanCost),
                () -> assertEquals(expectedLitePlanCost, actualLitePlanCost));
        return this;
    }

    public subscriptionPage validateClassicPlanCost(String expectedClassicPlanCost, String actualClassicPlanCost) {

        guiActions.assertThat(String.format("Check that expected Classic Plan Cost (%S) is obtained (%S)", expectedClassicPlanCost, actualClassicPlanCost),
                () -> assertEquals(expectedClassicPlanCost, actualClassicPlanCost));
        return this;
    }

    public subscriptionPage validatePremiumPlanCost(String expectedPremiumPlanCost, String actualPremiumPlanCost) {

        guiActions.assertThat(String.format("Check that expected Premium Plan Cost (%S) is obtained (%S)", expectedPremiumPlanCost, actualPremiumPlanCost),
                () -> assertEquals(expectedPremiumPlanCost, actualPremiumPlanCost));
        return this;
    }
}
