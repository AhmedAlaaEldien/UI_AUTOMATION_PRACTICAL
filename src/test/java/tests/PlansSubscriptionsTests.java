package tests;

import base.BaseTests;
import data_provider.PlansDataProvider;
import utilities.JSonManager;
import helpers.TestngListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.subscriptionPage;

import java.util.HashMap;

@Listeners(TestngListener.class)
public class PlansSubscriptionsTests extends BaseTests {
    /**
     * This Method is used to implement Test Scenario which is needed.
     * We take an instance from subscription Page and try to get all possible plans for each country we have.
     * Finally, we do the Assertion, on the subscription plans.
     */
    @Test(dataProviderClass = PlansDataProvider.class, dataProvider = "dataProvider")
    public void GoogleSearch(HashMap<String, String> hashMap) {
        var subscriptionPage  = new subscriptionPage(getDriver());
        subscriptionPage
                .clickOnCountryCurrent()
                .selectCountry(hashMap.get("country"))

                .trialCost()
                .validateTrialCost(hashMap.get("trialCost"), subscriptionPage.getCostOfTrialPlan())

                .planCost(hashMap.get("litePlan"))
                .validateLitePlanCost(hashMap.get("litePlanCost"), subscriptionPage.getCostOfPlan())

                .planCost(hashMap.get("classicPlan"))
                .validateClassicPlanCost(hashMap.get("classicPlanCost"), subscriptionPage.getCostOfPlan())

                .planCost(hashMap.get("premiumPlan"))
                .validatePremiumPlanCost(hashMap.get("premiumPlanCost"), subscriptionPage.getCostOfPlan());



    }



}
